package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSeleniumChittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		
		WebElement stockMarket = driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']"));
		stockMarket.click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		//Getting table 
		WebElement tables = driver.findElement(By.xpath("//div[@class='table-responsive']/table"));
		//Getting Rows from tables
		List<WebElement> rows = tables.findElements(By.tagName("tr"));	
		System.out.println("No.of rows:" +rows.size());
		List<WebElement> columns = tables.findElements(By.tagName("th"));	
		System.out.println("No.of rows:" +columns.size());
		String firstPartPath = "//*[@id='main']/div[2]/div/div/table/tbody/tr[";
		String secondPartPath = "]/td[3]";
		List<String> list = new ArrayList<String>();
		Set<String> storeInSet = new LinkedHashSet<String>();
		Set<String> findDuplicates = new LinkedHashSet<String>();
		String securityNameDetails="";
	    
				//*[@id="main"]/div[2]/div/div/table/tbody/tr[1]/td[4]
		for(int i=1;i<rows.size();i++)
		{
			String finalPath = firstPartPath+i+secondPartPath;
			WebElement securityColumns  = driver.findElement(By.xpath(finalPath));
			securityNameDetails = securityColumns.getText();
			System.out.println(securityNameDetails);
			list.add(securityNameDetails);
			
			
		}
		
		
		System.out.println("****");
		
		for(String securityNames : list )
		{
			if(findDuplicates.add(securityNames)==false)
			{
				System.out.println("Yes we have duplicates Names in Security Names");
				break;
				
			}
			
			
		}
		
		
		
	}
	

}
