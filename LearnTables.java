package week4.day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class LearnTables {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement tables = driver.findElement(By.tagName("table"));
			    
		List<WebElement> rows = tables.findElements(By.tagName("tr"));	
		System.out.println("No.of rows:" +rows.size());
		List<WebElement> trcolums = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int countColms = trcolums.size();
		System.out.println("No.of colums:" +countColms);

		
		for(int i=2;i<rows.size();i++)
		{  
		    WebElement eachRow = rows.get(i);
			List<WebElement> colms = eachRow.findElements(By.tagName("td"));
			
			for(int j=1;j<colms.size();j++)
			{   
				
				String rowPath = "//*[@id=\'contentblock\']/section/div[1]/table/tbody/tr[";
				String columnPath = "]/td[";
				String columnPathFinal = "]";
				String finalPath = rowPath+i+columnPath+j+columnPathFinal;
				
			WebElement element  = driver.findElement(By.xpath(finalPath));
				//System.out.println("element:" +element.getText());
				if(element.getText().equals("Learn to interact with Elements"))
				{		 
					//print rows 
//					String progressRow = "//*[@id=\'contentblock\']/section/div[1]/table/tbody/tr["+i+"]";
//					WebElement elementsRow = driver.findElement(By.xpath(progressRow));
//					System.out.print(elementsRow.getText());
//					System.out.println();
					
			        String progressColumn = "//*[@id=\'contentblock\']/section/div[1]/table/tbody/tr["+i+"]/td["+(j+1)+"]";
			        WebElement elements  = driver.findElement(By.xpath(progressColumn));
					//printing only Value of Progress
					System.out.println(elements.getText());
				
				}
								
			}		
						
			}
		
		System.out.println("Least Vital Check Task");
		
		for(int k=2;k<=rows.size();k++)
			
		{   //WebElement eachRow = rows.get(k);
//		   List<WebElement> colms = eachRow.findElements(By.tagName("td"));
//			for(int m=1;m<=colms.size();m++)
//		
//		{  
		
		String leastVitalFirstPath = "//*[@id=\'contentblock\']/section/div[1]/table/tbody/tr[";
		String leastVitalSecondPath = "]/td[2]";
		String leastVitalFinalPath = leastVitalFirstPath+k+leastVitalSecondPath;
		
		WebElement leastVitalElement = driver.findElement(By.xpath(leastVitalFinalPath));
		System.out.println(leastVitalElement.getText());
		
		if(leastVitalElement.getText().equals("20%"))
		{
			String leastVitalClick = "//*[@id='contentblock']/section/div[1]/table/tbody/tr[";
			String getKvalue = "]/td[3]";
			String clickLeastVital = leastVitalClick+k+getKvalue;
			
			WebElement clickVital = driver.findElement(By.xpath(clickLeastVital));
			clickVital.click();
			if(clickVital.isEnabled())
			{
				System.out.println("Vital is Enabled");
			}
			else
			{
				System.out.println("Vital is not Enabled");
			}
			
	
		}
		}			
		//}
}
				
	}			
		
	

