package week4.home.assignments.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML1 {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup(); //Get Driver for execution
		
		// To open Chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch https://www.snapdeal.com/
		driver.get("https://html.com/tags/table/");
		
		//To maximize the open browser
		driver.manage().window().maximize();
		
	// first table	
   List<WebElement> table1Row = driver.findElements(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//tr"));
   List<WebElement> table1Column = driver.findElements(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//tr[2]/td"));
   System.out.print("Total row count in table1: ");
   System.out.println(table1Row.size());
   System.out.print("Total column count in table1: ");
   System.out.println(table1Column.size());
		
   //second table
    List<WebElement> table2Row = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
    List<WebElement> table2Column = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[last()]/td"));
    System.out.print("Total row count in table2: ");
	System.out.println(table2Row.size());
	System.out.print("Total column count in table2: ");
	System.out.println(table2Column.size());	

	}

}
