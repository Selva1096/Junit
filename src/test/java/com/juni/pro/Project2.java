package com.juni.pro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project2 {
	static WebDriver driver;
	static long st;
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
		WebElement srch = driver.findElement(By.name("q"));
		srch.sendKeys("realme",Keys.ENTER);
	}
	@Test
	public void method3() throws Exception{
		WebElement e1 = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[1]"));
		e1.click();
		Thread.sleep(2000);
		WebElement e2 = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[2]"));
		e2.click();
		Thread.sleep(2000);
	    WebElement e3 = driver.findElement(By.xpath("(//div[contains(text(),'realme')])[3]"));
		e3.click();
		Thread.sleep(2000);

	}
	@Test
	public void method4() {
		Set<String> cw = driver.getWindowHandles();
		List<String> x = new ArrayList<String>(cw);
		String text = x.get(2);
		driver.switchTo().window(text);
		System.out.println(text);
	}
	@Test
	public void method5() {
		WebElement atc = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		atc.click();
		
	}


}
