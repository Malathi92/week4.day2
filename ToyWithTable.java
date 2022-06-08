package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//		1. Launch the URL 
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();

		//Get the count of number of columns
		List<WebElement> columns=driver.findElements(By.tagName("th"));
		int colCount=columns.size();
		System.out.println("the no of columns: "+colCount);

		//Get the count of number of rows
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		int rowCount=rows.size();
		System.out.println("the no of columns: "+rowCount);


		//Get the progress value of 'Learn to interact with Elements'
		WebElement progress=driver.findElement(By.xpath("(//td[normalize-space()='Learn to interact with Elements']//following::td)[1]"));
		String ProValue=progress.getText();
		System.out.println(ProValue);

		//		Check the vital task for the least completed progress.
		List<WebElement> listprog=driver.findElements(By.xpath("//td[2]"));
		List<Integer> eleList=new ArrayList<Integer>();
		for(WebElement w:listprog)
		{
			String s=w.getText().replace("%","");
			eleList.add(Integer.parseInt(s));
		}
		System.out.println("the list:"+eleList);

		int leastVal=Collections.min(eleList);
		System.out.println("least value:"+leastVal);
		String levalue=Integer.toString(leastVal);
		if(levalue.equals("20"))
		{
			WebElement input=rows.get(5).findElement(By.tagName("input"));
			input.click();

		}



	}


}