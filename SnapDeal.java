package week4.day2;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	private static final String Duration = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		//		2. Go to Mens Fashion

		WebElement mensFashion=driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mensFashion).perform();

		//		3. Go to Sports Shoes

		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(2000);

		//		4. Get the count of the sports shoes

		WebElement shoesCount=driver.findElement(By.xpath("//span[contains(text(),'Items')]"));
		System.out.println("no of sports shoes:"+shoesCount.getText());

		//		5. Click Training shoes

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		//		6. Sort by Low to High

		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();

		//        7. Check if the items displayed are sorted correctly


		Thread.sleep(2000);		
		List<WebElement> sortedPrice=driver.findElements(By.xpath("//div[@class='product-desc-rating ']//div[@class='product-price-row clearfix']"));
		for(WebElement w:sortedPrice)
		{
			System.out.println(w.getText());
		
		}

		//		8.Select the price range (900-1200)

		WebElement from=driver.findElement(By.xpath("(//input[@name='fromVal'])[1]"));
		from.clear();
		from.sendKeys("900");
		WebElement to=driver.findElement(By.xpath("(//input[@name='toVal'])[1]"));
		to.clear();
		to.sendKeys("1200",Keys.ENTER);
		Thread.sleep(2000);

		//		 9.Filter with color Navy 
		//		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-plus'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='View More '])[1]")).click();
		WebElement color=driver.findElement(By.xpath("//a[text()=' Navy']"));
		//		 10 verify the all applied filters 
		System.out.println("the navy color filter is enabled: "+color.isSelected());
		Thread.sleep(2000);
		WebElement priceFilter=driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]"));
		String price=priceFilter.getText();
		System.out.println("the product price is from:"+price);
		Thread.sleep(2000);

		//		 11. Mouse Hover on first resulting Training shoes
		WebElement firstShoe=driver.findElement(By.xpath("//p[@class='product-title']"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(firstShoe).perform();
		//			12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();


		//			13. Print the cost and the discount percentage
		Thread.sleep(2000);
		WebElement c=driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String cost=c.getText();
		System.out.println("the cost of the product is: "+cost);
		WebElement p=driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String discountPercentage=p.getText();
		System.out.println("the discount percentage is: "+discountPercentage);
		//			14. Take the snapshot of the shoes.
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshots/img2.png");
		FileUtils.copyFile(source, destination);
		//			16. Close the main window
		driver.close();


	}

}
