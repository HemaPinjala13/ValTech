package com.test.qaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;

public class Valtech {

	
	private WebDriver driver;
	private String exePath; 
		
	@Before
	public void setUp() {
		//driver = new FirefoxDriver();		
		exePath = "C:\\devtools\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.get("https://www.valtech.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}

	@Test
	public void testValtech(){
		int count = 0;
		List<WebElement> officesList = new ArrayList<WebElement>();
		String newsStr = driver.findElement(By.xpath("//*[@id='container']/div[2]/div[3]/div[1]/header/h2")).getText();
        Assert.assertEquals("LATEST NEWS", newsStr);
        driver.findElement(By.linkText("ABOUT")).click();
        String aboutStr = driver.findElement(By.xpath("//*[@id='container']/div[1]/h1")).getText();
        Assert.assertEquals("About", aboutStr);
        driver.findElement(By.linkText("SERVICES")).click();
        String serviceStr = driver.findElement(By.xpath("//*[@id='container']/section/header/h1")).getText();
        Assert.assertEquals("Services", serviceStr);	
        driver.findElement(By.linkText("WORK")).click();
        String workStr = driver.findElement(By.xpath("//*[@id='container']/header/h1")).getText();
        Assert.assertEquals("Work", workStr);
        
        driver.findElement(By.xpath("//*[@id='contacticon']/div/div/div[1]/i")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='contactbox']/div/div"));
       
        for(int i=1; i<=list.size(); i++) {        	
        	officesList = driver.findElements(By.xpath("//*[@id='contactbox']/div/div["+i+"]/ul/li"));
        	count = count + officesList.size();
        }
        System.out.println(count);
	}
		
	@After
	public void tearDown() {
		driver.close();
		
	}
		
	
}
