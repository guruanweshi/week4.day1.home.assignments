package week4.home.assignments.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
 
		WebDriverManager.chromedriver().setup(); //Get Driver for execution
		
		// To open Chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.chittorgarh.com/");
		
		//To maximize the open browser
		driver.manage().window().maximize();
		
		
		//2. Click on stock market
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		
		//3. Click on NSE bulk Deals
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		
		//4. Get all the Security names
		Set<String> set = new HashSet();
		List<WebElement> securityName = driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[3]"));
		
		for (WebElement eachSecurity:securityName) {
			String name= eachSecurity.getText();
			set.add(name);
		}
		
		//5. Ensure whether there are duplicate Security names
		
		System.out.println(set);

	}


}
