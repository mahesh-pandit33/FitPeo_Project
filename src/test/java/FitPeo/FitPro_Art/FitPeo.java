package FitPeo.FitPro_Art;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeo {
	
	public static void main(String[] args) throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
	 driver.get("https://www.fitpeo.com");
	 driver.manage().window().maximize();
	 Thread.sleep(2);
	 
	 WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));
    revenueCalculatorLink.click();
    
     //Scroll To SLider Scetiopn
     //WebElement sliderSection = driver.findElement(By.className("MuiSlider-rail css-3ndvyc")); // Replace with the actual ID
     
    
     
     WebElement sliderSectionxpath = driver.findElement(By.xpath("MuiBox-root css-j7qwjs"));
     JavascriptExecutor js= (JavascriptExecutor)driver;	 
     js.executeScript("window.scrollBy(0,503)");
     
     js.executeScript("arguments[0].scrollIntoView();", sliderSectionxpath);
     
     
     WebElement sliderSections = driver.findElement(By.className("MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p")); // Replace with the actual ID
     Actions moveSlider = new Actions(driver);
     moveSlider.clickAndHold(sliderSections).moveByOffset(1000, 0).release().perform();
     
     
     WebElement textField = driver.findElement(By.id(":R57alklff9da:")); 
     if (textField.getAttribute("value").equals("1000")) {
         System.out.println("Slider is set to 1000 successfully.");
     }
     
     
     // Select checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474
     driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']//div[1]//label[1]//span[1]//input[1]")).click(); 
     driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div[2]//label[1]//span[1]//input[1]")).click(); 
     driver.findElement(By.xpath("//div[3]//label[1]//span[1]//input[1]")).click();
     driver.findElement(By.xpath("//div[8]//label[1]//span[1]//input[1]")).click(); 
     
     // Validate Total Recurring Reimbursement
     WebElement totalReimbursement = driver.findElement(By.xpath("//div[@class='MuiBox-root css-rfiegf']")); 
     if (totalReimbursement.getText().equals("$110700")) {
         System.out.println("Total Recurring Reimbursement is correct.");
     }
     else 
     	System.out.print("Incorrect Data");
     
     
    
}
}