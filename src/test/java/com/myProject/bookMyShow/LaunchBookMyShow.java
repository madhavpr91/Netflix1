package com.myProject.bookMyShow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LaunchBookMyShow {

	@Test
	public void launchApplication() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.netflix.com/in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement drpDown = driver.findElement(By.xpath("//select[@id = ':R5ajalalbd:']"));
		wait.until(ExpectedConditions.elementToBeClickable(drpDown));
		Select select = new Select(drpDown);
		select.selectByVisibleText("हिन्दी");
		Thread.sleep(5000);
//		select.deselectByVisibleText("हिन्दी");
//		Thread.sleep(5000);
		try {
			select.selectByValue("en-IN");
		} catch (StaleElementReferenceException e) {
			 drpDown = driver.findElement(By.xpath("//select[@id = ':R5ajalalbd:']"));
			Select select1 = new Select(drpDown);
			select1.selectByValue("en-IN");
		}
		Thread.sleep(5000);
		driver.quit();
		}
	
}
