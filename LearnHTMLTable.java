package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHTMLTable {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		WebElement tables = driver.findElement(By.xpath("//div[@class='render']/table"));
		List <WebElement> rows= tables.findElements(By.tagName("tr"));
		int rowSize = rows.size();
		System.out.println("No of rows:" +rowSize);
		
		List <WebElement> colums= tables.findElements(By.tagName("th"));
		int columSize = colums.size();
		System.out.println("No of colums:" +columSize);
	
		for(int i=1;i<rowSize-1;i++)
		{  
		    WebElement eachRow = rows.get(i);
			List<WebElement> colms = eachRow.findElements(By.tagName("td"));
			
			for(int j=1;j<columSize;j++)
			{   
				String firstPath = "//*[@id=\'post-315\']/div/div[2]/table/tbody/tr[";
			    String rowPath = "]/td[";
				String secondPath =  "]";
				String finalPath = firstPath+i+rowPath+j+secondPath;
				WebElement abosluteColumnElement = driver.findElement(By.xpath(finalPath));
				
			 if(abosluteColumnElement.getText().contains("Absolute Usage"))
			{
				    
			        String abosluteColumnValues = abosluteColumnElement.getText();
			        System.out.println(abosluteColumnValues+ " values are: ");
			        for(int k=2;k<=columSize;k++)
					 {
					    String firstPathValues = "//*[@id=\'post-315\']/div/div[2]/table/tbody/tr[2]/td[";
					    String secondPathValues =  "]";
						String finalPathValues = firstPathValues+k+secondPathValues;
						WebElement abosluteC = driver.findElement(By.xpath(finalPathValues));
						System.out.println(abosluteC.getText());
					 }
			       
				}
			 
			
			}
			}
	}

}
