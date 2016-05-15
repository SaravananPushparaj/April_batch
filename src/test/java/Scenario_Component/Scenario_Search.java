package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	
	@Test(dataProvider="dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"smoke"})
	public void testInavalidSearch(String TC_ID, String Order,String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Test case " +TC_ID + " Order is  "+Order);
		Start_Appiumserver();
		InitApp();
		
		PageObject_Search BS_pob= new PageObject_Search(driver);
		Explicit_wait(BS_pob.search_btn,25);
		BS_pob.Click_btn();
		Explicit_wait(BS_pob.Search_txtbox,25);
		BS_pob.Enter_Search(Search_Item);
		Explicit_wait(BS_pob.Invalid_msg,25);
		String Actual_Result = BS_pob.getInvalidmsg();
		
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
	
	@Test(dataProvider="dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups="regression")
	public void testValidSearch(String TC_ID, String Order,String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Test case " +TC_ID + " Order is  "+Order);
		Start_Appiumserver();
		InitApp();
		
		PageObject_Search BS_pob= new PageObject_Search(driver);
		BS_pob.Click_btn();
		Explicit_wait(BS_pob.Search_txtbox,25);
		BS_pob.Enter_Search(Search_Item);
		Explicit_wait(BS_pob.Valid_msg,25);
		String Result = BS_pob.getValidmsg();
		String Actual_Result = Result.replace(" products", "");
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
		}
		else
		{
			log.info("Failed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
			sAssert.fail("Failed as Expected  is  " + Exp_Result +" Actual Result is  " +Actual_Result);
		}
		
		
		StopAppiumServer();
		sAssert.assertAll();
		
	}
	

}
