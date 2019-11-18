package com.automation.testscripts.DataDriven;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelDataHelper;

public class TC_01_CreateEmployee extends FrameworkScript

{
	
	@Test(dataProvider = "getTestData",dataProviderClass = ExcelDataHelper.class)
	public void createEmployee(String userName,String Password,String firstName,String lastName) throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}	
	
}
