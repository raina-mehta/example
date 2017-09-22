package com.practice.macys;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResultPage //using ObjectRepo
{
	WebDriver driver;

	
	
	public int expectedItemCount(WebDriver driver) throws NumberFormatException, IOException
	{
		WebDriverWait wait= new WebDriverWait(driver, 15);
		int expectedCount= Integer.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productCount"))).getText());
		return expectedCount;
	}

	public boolean checkIf200(int expectedCount){
		
			if(expectedCount>200)
				return true;	
			else
				return false;
	}
	public  int[] resultItemCount(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		boolean newPage=true;
		int pageNo=1;
		int actualCount=0;
		HashMap<Integer, Integer> itemsPerPage= new HashMap<Integer, Integer>();
		//loop for counting items/pages
		while(newPage)
		{
			//List<WebElement> pageItems=  wait.until(ExpectedConditions.visibilityOf(objr.findEle("page_items")));
			List<WebElement> pageItems= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".textWrapper")));
			itemsPerPage.put(pageNo, pageItems.size());// save per page and items in hashmap
			actualCount=actualCount+ pageItems.size();	
			pageNo++;

			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".arrowRight.arrowButton.paginationSpacer"))).click();
			}
			catch (Exception e) 
			{	newPage=false;	
			}

		}

		//store the result in an array
		int [] resultArray= new int [2];
		resultArray[0]=pageNo;
		resultArray[1]= actualCount;
		//print hashmap
		for(int i=1;i<resultArray[0];i++)
			System.out.println("Page "+i+" : "+itemsPerPage.get(i));
		return resultArray;

	}

	public void clickOnItem(WebDriver driver) throws IOException
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xpath://ul[@id='thumbnails']/li[not(contains(@id,'grid'))][1]"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='thumbnails']/li[not(contains(@id,'grid'))][2]"))).click();
	}

	public  ResultPage(WebDriver wd) throws IOException
	{
		
		driver=wd;
		
	}




}
