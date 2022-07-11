package week4.home.assignments.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.firefoxdriver().setup(); //driver setup for Firefox Browser
		FirefoxDriver driver = new FirefoxDriver();


		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//To maximize the open browser
		driver.manage().window().maximize();

		// handle Notification
		driver.findElement(By.id("pushDenied")).click();

		//2. Search on  Training Shoes
		WebElement searchElement = driver.findElement(By.xpath("//input[@name='keyword' and @placeholder='Search products & brands']"));
		searchElement.click();
		searchElement.sendKeys("Training Shoes",Keys.ENTER);

		//3. Get the count of the Training Shoes
		Thread.sleep(10000);
		List<WebElement> trainingshoes = driver.findElements(By.xpath("//*[@class='product-image']"));
		System.out.println("Count of Training Shoes is: "+ trainingshoes.size());

		//4. Click on Sort by  and select Low to High
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[2]")).click();


		//5. Check if the items displayed are sorted correctly
		

		int startNum=0;
		boolean flag=true;
		List<Integer> sortCheck = new ArrayList<Integer>();
		Thread.sleep(5000);
		List<WebElement> sortElements = driver.findElements(By.xpath("//*[@class='lfloat product-price']"));

		for (WebElement eachItem:sortElements) {
			String name= eachItem.getAttribute("display-price");
			int price=Integer.parseInt(name);  
			sortCheck.add(price);
		}

		for (int i=0;i<sortCheck.size();i++) {
			if (sortCheck.get(i)>=startNum) 
				startNum=sortCheck.get(i);

			else {
				flag=false;
				break;
			}
		}
		if (flag==true)
			System.out.println("List is sorted from Low to High");
		else
			System.out.println("List is not sorted from Low to High");

		//6. Enter the price range (900-1500)
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900",Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1500",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();

		//7. Filter with color Blue 
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[@class='filter-color-tile Blue ']")).click();

		//8. Verify the Blue check box is enabled
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='Color_s-Blue']"));
		String check = checkBox.getAttribute("checked");
		System.out.println(check);

		//9.Click on first resulting Training shoes
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@title='Force 10 By Liberty Blue Sports Shoes']")).click();

		//10. Print the cost and the discount percentage
		Thread.sleep(5000);

		// click action creates new window , so window handling initiated
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("all windows");
		System.out.println(allWindows);

		//switch to new window
		List<String> list = new ArrayList<>(allWindows);
		driver.switchTo().window(list.get(1));

		// get the final price
		String finalPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("The final price of the selected product is: Rs "+ finalPrice);
		// get the discount percentage
		String discountPercentage = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
		System.out.println("Discount percentage is: "+ discountPercentage);

		//11. Take the snapshot of the last page.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/SS001.png");
		FileUtils.copyFile(source, dest);
		Thread.sleep(5000);
		// get the screenshot of the shoe only
		WebElement logo = driver.findElement(By.xpath("(//ul[@id='bx-slider-left-image-panel']/li)[1]"));
		File source1 = logo.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./snap/SS002.png");
		FileUtils.copyFile(source1, dest1);

		//12. Close the  window
		Thread.sleep(5000);
		driver.quit();


	}

}
