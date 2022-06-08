package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
//		2) Mouseover on Brands and Search L'Oreal Paris
		
		WebElement brands=driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		
		
//		3) Click L'Oreal Paris
		
		driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]")).click();
		
//		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		
		System.out.println("the title is:"+driver.getTitle());
		Thread.sleep(2000);
		
//		5) Click sort By and select customer top rated
		
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
//		6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
//		7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
//		8)check whether the Filter is applied with Shampoo
		
	WebElement filterValue=driver.findElement(By.xpath("(//span[@class='filter-value'])[1]"));
	if(filterValue.getText().contains("Shampoo"))
		
		{
			System.out.println("filter is applied with shampoo");
		}
	else
	{
		System.out.println("filter is not applied with shampoo");
	}
	Thread.sleep(2000);
//	9) Click on L'Oreal Paris Colour Protect Shampoo
	driver.findElement(By.xpath("//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
	
//	10) GO to the new window and select size as 175ml
	Set<String> windowHandles= driver.getWindowHandles();
	List<String> newWindow = new ArrayList<String>(windowHandles);
	driver.switchTo().window(newWindow.get(1));
	WebElement size=driver.findElement(By.xpath("//select[@title='SIZE']"));
	Select dd=new Select(size);
	dd.selectByVisibleText("175ml");
	Thread.sleep(2000);
//	11) Print the MRP of the product
	WebElement MRP=driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
	System.out.println("the MRP of the product is : "+MRP.getText());
//	12) Click on ADD to BAG
	driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
//	13) Go to Shopping Bag 
	driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
	Thread.sleep(2000);
//	inside frame1
	driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")).click();
	driver.switchTo().frame(0);
//	14) Print the Grand Total amount
	WebElement GrandTotal=driver.findElement(By.xpath("//div[@class='value medium-strong']"));
	String gt=GrandTotal.getText();
	System.out.println("the grand total is:"+gt);
//	15) Click Proceed
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
//	new window
	Set<String> windowHandles1= driver.getWindowHandles();
	List<String> newWindow1 = new ArrayList<String>(windowHandles1);
	driver.switchTo().window(newWindow1.get(1));
	
//	16) Click on Continue as Guest
	driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
//	17) Check if this grand total is the same in step 14
	WebElement finalGrandTotal=driver.findElement(By.xpath("(//div[@class='value'])[2]"));
	String finalGT=finalGrandTotal.getText();
	System.out.println("final grand total:"+finalGT);
	
	if(finalGT.equals(gt))
	{
		System.out.println("grand total is same as above");
	}
	else
	{
		System.out.println("grand total is not equal");
	}
	driver.quit();
	}
	
	}


