package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();

		WebElement dragEle = driver.findElement(By.id("draggable"));

		WebElement dropEle = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);

		builder.dragAndDrop(dragEle, dropEle).perform();

		int x = dropEle.getLocation().getX();
		int y = dropEle.getLocation().getY();
	

		builder.dragAndDropBy(dragEle, 40, 40).perform();;

	}

}
