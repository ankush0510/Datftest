package Pages;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.testfilters;

public class HomePage extends testfilters {

	public void privacymessage() {

		WebElement Acceptprivacy = driver
				.findElement(By.xpath("//*[@id=\"js-cookie-modal-level-one\"]/div/main/div/button[2]"));
		Acceptprivacy.click();
	}

	public void entercounty(String countyname) {
		WebElement Searchbox = driver.findElement(By.xpath("//*[@id=\"search-box-input\"]"));
		Searchbox.sendKeys(countyname);
System.out.println("Test");
		
		
	}

	public void selectcounty() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-box-item-1\"]")));

		WebElement county = driver.findElement(By.xpath("//*[@id=\"search-box-item-1\"]"));
		WebElement allsearchresults = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].parentNode;", county);

		List<WebElement> options = allsearchresults.findElements(By.tagName("li"));
		for (WebElement option1 : options) {
			if (option1.getText().contains("Dublin (County)")) {
				System.out.println("Trying to select: " + option1.getText());
				option1.click();
				break;
			}

		}
	}

}
