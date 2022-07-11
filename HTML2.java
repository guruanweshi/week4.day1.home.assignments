package week4.home.assignments.day1;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML2 {

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
   List<WebElement> table1Heading = driver.findElements(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//th//td"));
   List<WebElement> table1Column = driver.findElements(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//tr//td"));
   
// print Market share & absolute usage values for individual libraries
for (int i=2;i<=4;i++) {
	
	System.out.println(driver.findElement(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//th["+i+"]")).getText());
	System.out.print(driver.findElement(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//td[1]")).getText());
	System.out.print(": ");
	System.out.println(driver.findElement(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']//td["+i+"]")).getText());
	System.out.print(driver.findElement(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']/tbody/tr[2]/td[1]")).getText());
	System.out.print(": ");
	System.out.println(driver.findElement(By.xpath("//table[.//caption='The Three Most Popular JavaScript Libraries']/tbody/tr[2]/td["+i+"]")).getText());
	System.out.println();
}

	}

}
