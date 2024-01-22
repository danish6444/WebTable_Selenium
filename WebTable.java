package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		// Setting the property of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver","D:\\Training Materials\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers");
		
		// Create List - all companies
		List<WebElement> allCompanies = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		System.out.println("Total Companies : " + allCompanies.size());
		
		
		//create list current price
		List<WebElement> currentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println("Total Current price : " + currentPrice.size());
		
		String expCompanyName = "Ecoplast L";
		
		for (int i = 0; i < allCompanies.size(); i++) {
		if (allCompanies.get(i).getText().equalsIgnoreCase(expCompanyName)) {
			System.out.println(allCompanies.get(i).getText() + " === " + currentPrice.get(i).getText());
			allCompanies.get(i).click();
			break;
		}			
		}
		}
	}


