package practiseDemo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass1 {

	public static WebDriver driver;
	public static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get(
				"https://applyonline.hdfcbank.com/personal-loans.html?mc_id=website_organic_PLpp_stickyfooter&icid=website_organic_PLpp_stickyfooter");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		Set<String> child_window = driver.getWindowHandles();
		
		Iterator<String> it=child_window.iterator();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < checkboxes.size(); i++) 
		{
			if (checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled()) 
			{
				System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");
				checkboxes.get(i).click();
				
				
				while(it.hasNext())
				{
					String child=it.next();
					driver.switchTo().window(child);
					
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					//jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
					jse.executeScript("window.scrollBy(40,3000)");
					driver.findElement(By.xpath("//button[@id='guideContainer-rootPanel-panel-panel_1217921619-panel_796789382-panel-panel_1749960847_cop-panel_759844051-panel_210571971-panel-guidebutton___widget']"))
							.click();
				}

				

			}
		}

		/*
		 * while(iter.hasNext()) { String child_wind=iter.next();
		 * driver.switchTo().window(child_wind); driver.findElement(By.xpath(
		 * "//button[@id='guideContainer-rootPanel-panel-panel_1217921619-panel_796789382-panel-panel_1749960847_cop-panel_759844051-panel_210571971-panel-guidebutton___widget']"
		 * )).click(); }
		 */

	}

}

//guideContainer-rootPanel-panel-panel_1217921619-panel_796789382-panel-panel_1749960847_cop-panel_759844051-panel_210571971-panel-guidebutton___jqName