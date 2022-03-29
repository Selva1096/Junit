package com.juni.pro;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project1 {
	static WebDriver driver;
	static long st;
	static String name1;
	
	@BeforeClass
	public static void BeforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@AfterClass
	public static void AfterClass() {
	    driver.quit();
	}
	@Before
	public void Before() {
		st = System.currentTimeMillis();
	}
	@After
	public void After() {
		long et = System.currentTimeMillis();
		System.out.println("Time Taken:" +(et-st));
	}
	@Test
	public void method1() {
		WebElement close = driver.findElement(By.xpath("//button[contains(@class,'2doB4z')]"));
		close.click();
	}
	@Test
	public void method2() {
		WebElement fash = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions a = new Actions(driver);
		a.moveToElement(fash).perform();
		WebElement eth = driver.findElement(By.xpath("//a[contains(text(),'Ethnic')]"));
		a.moveToElement(eth).perform();
		WebElement kurt = driver.findElement(By.xpath("//a[contains(text(),'Kurtas')]"));
		kurt.click();	
	}
	@Test
	public void method3() throws Exception {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\HP\\eclipse-workspace\\Junit\\screenshots\\Flipkart1.png");
		FileUtils.copyFile(source, target);	
	}
	@Test
	public void method4() {
		WebElement kurta1 = driver.findElement(By.xpath("(//a[contains(text(),'Embroidered')])[1]"));
		name1 = kurta1.getText();
		System.out.println(name1);
		kurta1.click();	
	}
	@Test
	public void method5() {
		String p = driver.getWindowHandle();
		Set<String> c = driver.getWindowHandles();
		for(String x: c) {
			if(!p.equals(x)) {
				driver.switchTo().window(x);
				
			}
		}
	}
	@Test
	public void method6() throws Exception {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\HP\\eclipse-workspace\\Junit\\screenshots\\Flipkart2.png");
		FileUtils.copyFile(source, target);
	}
	@Test
	public void method7() {
		WebElement kurta2 = driver.findElement(By.xpath("//span[contains(text(),'Embroidered')]"));
		String name2 = kurta2.getText();
		System.out.println(name2);
		if(name1.equals(name2)) {
			System.out.println("PASS");
		    }else {
				System.out.println("FAIL");
			}
		}
	}
	
	


