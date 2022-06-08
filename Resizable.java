package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		//		inside  frame
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameEle);
		WebElement ele = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));


		// handling resizable
		Thread.sleep(2000);
		Actions builder=new Actions(driver);
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		builder.clickAndHold(ele).moveByOffset(100,50).release(ele).build().perform();




	}

}
