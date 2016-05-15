package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<String[]> getAddCart() throws IOException
	{
		List<String[]> Obj = flagRowCount("AddCart");
		return Obj.iterator();
	}
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<String[]> getDeleteCart() throws IOException
	{
		List<String[]> Obj = flagRowCount("DeleteCart");
		return Obj.iterator();
	}
	
	
	public static List<String[]> flagRowCount(String scriptname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\BB_Project\\Test_Data\\Test_Data.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int RowCount = xl.getrowcount(Scenario_Cart);
		
		//Create a list
		
		List<String []> lst_Cart= new ArrayList<String []>();
		
		for(int xlRow=1;xlRow<=RowCount;xlRow++)
		{
		
			String Execute_Flag = xl.Readvalue(Scenario_Cart, xlRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Cart, xlRow, "Script_name");
			
			if((Execute_Flag.equals("Y")) && (Script_name.equals(scriptname)))
			{
				String [] arr_Cart= new String [5];
				
				arr_Cart[0]=xl.Readvalue(Scenario_Cart, xlRow, "TC_ID");
				arr_Cart[1]=xl.Readvalue(Scenario_Cart, xlRow, "Order");
				arr_Cart[2]=xl.Readvalue(Scenario_Cart, xlRow, "Search_Item");
				arr_Cart[3]=xl.Readvalue(Scenario_Cart, xlRow, "Quantity");
				arr_Cart[4]=xl.Readvalue(Scenario_Cart, xlRow, "Exp_Result");
				
				lst_Cart.add(arr_Cart);
			}
			
			}
		
			return lst_Cart;
		
	}
	
	
	

}
