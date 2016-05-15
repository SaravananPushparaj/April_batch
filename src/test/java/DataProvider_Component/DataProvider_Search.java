package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Search {
	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<String[]> getInvalidsearchdata() throws IOException
	{
		List<String[]> Obj = flagRowCount("Invalid_Search");
		return Obj.iterator();
	}
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<String[]> getValidsearchdata() throws IOException
	{
		List<String[]> Obj = flagRowCount("Valid_Search");
		return Obj.iterator();
	}
	
	
	public static List<String[]> flagRowCount(String scriptname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\BB_Project\\Test_Data\\Test_Data.xls");
		HSSFSheet Scenario_Search = xl.Setsheet("Scenario_Search");
		
		int RowCount = xl.getrowcount(Scenario_Search);
		
		//Create a list
		
		List<String []> lst_Search= new ArrayList<String []>();
		
		for(int xlRow=1;xlRow<=RowCount;xlRow++)
		{
		
			String Execute_Flag = xl.Readvalue(Scenario_Search, xlRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Search, xlRow, "Script_name");
			
			if((Execute_Flag.equals("Y")) && (Script_name.equals(scriptname)))
			{
				String [] arr_search= new String [4];
				
				arr_search[0]=xl.Readvalue(Scenario_Search, xlRow, "TC_ID");
				arr_search[1]=xl.Readvalue(Scenario_Search, xlRow, "Order");
				arr_search[2]=xl.Readvalue(Scenario_Search, xlRow, "Search_Item");
				arr_search[3]=xl.Readvalue(Scenario_Search, xlRow, "Exp_Result");
				arr_search[3]=arr_search[3].replace(".0", "");
				lst_Search.add(arr_search);
			}
			
			}
		
			return lst_Search;
		
	}
	
	
	
	

}
