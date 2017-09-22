package com.practice.macys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage //using PageFactory:: hover
{

	WebDriver driver;
	//@FindBy(how=How.XPATH,using=".//*[starts-with(@id,'flexid')]/a[text()='JUNIORS']") WebElement junior_link; //hover on juniors
	//@FindBy(how=How.XPATH,using= ".//*[@id='flexid_16904']/div/div[1]/ul/li[8]/a") WebElement jeans_link;
	
	public void navToJuniorJeans()
	{	WebDriverWait wait= new WebDriverWait(driver,30);
		driver.findElement(By.xpath(".//*[starts-with(@id,'flexid')]/a[text()='JUNIORS']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='firstNavSubCat']/li[3]/ul/li[7]/a"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='flexid_16904']/div/div[1]/ul/li[8]/a"))).click();
	}

	public  HomePage(WebDriver wd)
	{
		driver = wd;
		PageFactory.initElements( driver, this);
	}


}



