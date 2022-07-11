package week4.home.assignments.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup(); //Get Driver for execution
		
		// To open Chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch https://www.snapdeal.com/
		driver.get("http://www.leafground.com/pages/table.html");
		
		//To maximize the open browser
		driver.manage().window().maximize();
		

//Get the count of number of columns
		List<WebElement> tableColumns = driver.findElements(By.xpath("//table//tr[last()]/td"));
		int columnCount= tableColumns.size();
		System.out.println("Number of rows in the table is: "+ columnCount);

//Get the count of number of rows
		List<WebElement> tableRows = driver.findElements(By.xpath("//table//tr"));
		int rowCount= tableRows.size();
		System.out.println("Number of rows in the table is: "+ rowCount);
		
//Get the progress value of 'Learn to interact with Elements'
		String progressValue = driver.findElement(By.xpath("//table//tbody/tr[5]/td[2]")).getText();
		System.out.println("Progress value for 'Learn to interact with Elements' : "+ progressValue);

//Check the vital task for the least completed progress.
		
		String leastCompletedProgress = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
		System.out.println("Least completed progress value is  : "+ leastCompletedProgress);

	}

}
