package com.test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonTest {
		
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NITIN\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in/");
			
			
			
			WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
			
			
			
			searchbox.sendKeys("Realme c35");
			searchbox.submit();
			
			driver.findElement(By.linkText("realme C35 (Glowing Green, 4GB RAM, 64GB Storage)")).click();
			
			//Select quantity = new Select(driver.findElement(By.id("quantity")));
			Select quantity = new Select(driver.findElement(By.cssSelector("#selectQuantity #quantity")));
			
			//quantity.selectByIndex(2);
			
			
			
			
			
		}
}
