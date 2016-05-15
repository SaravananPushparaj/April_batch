package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Cart {
	
public AppiumDriver driver;
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement search_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgAddToBasket")
	public WebElement Add_ele;
	
	@FindBy(id="com.bigbasket.mobileapp:id/img")
	public WebElement Img_ele;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement Product_ele;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Remove_ele;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;
	
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Click_btn()
	{
		search_btn.click();
	}
	
	public void Enter_Search(String Value)
	{
		Search_txtbox.sendKeys(Value + "\n");
	}
	
	
	public void Click_Add()
	{
		Add_ele.click();
	}
	

	public void Click_Cartimg()
	{
		Img_ele.click();
	}
	
	public String getProductname()
	{
		return Product_ele.getAttribute("text");
	}
	
	public void Click_Remove()
	{
		Remove_ele.click();
	}

	public String getDeletemsg()
	{
		return Delete_msg.getAttribute("text");
	}
}
