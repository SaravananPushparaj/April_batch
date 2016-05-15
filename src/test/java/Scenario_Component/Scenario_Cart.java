package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;
import PageObject_Component.PageObject_Search;

public class Scenario_Cart extends Base_Class {
	
	static Logger log= Logger.getLogger(Scenario_Cart.class);
	SoftAssert sAssert= new SoftAssert();
	
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class,groups={"smoke"})
	public void testAddCart(String TC_ID, String Order,String Search_Item,String Quantity, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Test case " +TC_ID + " Order is  "+Order);
		Start_Appiumserver();
		InitApp();
		
		PageObject_Cart BC_pob= new PageObject_Cart(driver);
		Explicit_wait(BC_pob.search_btn,25);
		BC_pob.Click_btn();
		Explicit_wait(BC_pob.Search_txtbox,25);
		BC_pob.Enter_Search(Search_Item);
		Explicit_wait(BC_pob.Add_ele,25);
		BC_pob.Click_Add();
		Explicit_wait(BC_pob.Img_ele,25);
		BC_pob.Click_Cartimg();
		Explicit_wait(BC_pob.Product_ele,25);
		String Actual_Result = BC_pob.getProductname();		
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
			Snapshot(TC_ID,Order);
		}
		else
		{
			log.info("Failed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
			Snapshot(TC_ID,Order);
			sAssert.fail("Failed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
		}
		
		
		StopAppiumServer();
		sAssert.assertAll();
		
	}
	
	
	@Test(dataProvider="dp_DeleteCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class,groups={"smoke"})
	public void testDeleteCart(String TC_ID, String Order,String Search_Item,String Quantity, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Test case " +TC_ID + " Order is  "+Order);
		Start_Appiumserver();
		InitApp();
		
		PageObject_Cart BC_pob= new PageObject_Cart(driver);
		Explicit_wait(BC_pob.search_btn,25);
		BC_pob.Click_btn();
		Explicit_wait(BC_pob.Search_txtbox,25);
		BC_pob.Enter_Search(Search_Item);
		Explicit_wait(BC_pob.Add_ele,25);
		BC_pob.Click_Add();
		Explicit_wait(BC_pob.Img_ele,25);
		BC_pob.Click_Cartimg();
		Explicit_wait(BC_pob.Product_ele,25);
		BC_pob.Click_Remove();	
		Explicit_wait(BC_pob.Delete_msg,25);
		String Actual_Result = BC_pob.getDeletemsg();
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
			Snapshot(TC_ID,Order);
		}
		else
		{
			log.info("Failed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
			Snapshot(TC_ID,Order);
			sAssert.fail("Failed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
		}
		
		
		StopAppiumServer();
		sAssert.assertAll();
		
	}

}
