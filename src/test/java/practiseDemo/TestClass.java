package practiseDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass 
{
	
	public static WebDriver driver;
	public static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver=new ChromeDriver();
		driver.get("https://applyonline.hdfcbank.com/personal-loans.html?mc_id=website_organic_PLpp_stickyfooter&icid=website_organic_PLpp_stickyfooter");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("21313211");
		driver.findElement(By.xpath("//input[@placeHolder='MM']")).sendKeys("11");
		driver.findElement(By.xpath("//input[@placeHolder='DD']")).sendKeys("03");
		driver.findElement(By.xpath("//input[@placeHolder='YYYY']")).sendKeys("2000");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		//driver.switchTo().frame(0);
		
		String parent_window1=driver.getWindowHandle();
				
		driver.switchTo().window(parent_window1);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("//button[@id='guideContainer-rootPanel-panel-panel_1217921619-panel_796789382-panel-panel_1749960847_cop-panel_759844051-panel_210571971-panel-guidebutton___widget']")).click();
		
		driver.findElement(By.xpath("//input[@name='guideContainer-rootPanel-panel-panel_1217921619-panel_796789382-panel-panel_1749960847_cop-panel_2126142822-panel-guidecheckbox_copy___jqName']")).click();
		
		Thread.sleep(3000);
		
		 String parent_window2=driver.getWindowHandle();
		 driver.switchTo().window(parent_window2);
		 
		
		JavascriptExecutor jse1=(JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//button[@id='guideContainer-rootPanel-panel-panel_1217921619-panel_796789382-panel-panel_1749960847_cop-panel_759844051-panel_210571971-panel-guidebutton___widget']")).click();
		
	}

}
