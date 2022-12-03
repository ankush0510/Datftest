package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tests.testfilters;

public class ListingPage extends testfilters {

	public void closepopup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"attraction-modal-create-buying-budget\"]/div/button")));
		WebElement Listingpopup = driver
				.findElement(By.xpath("//*[@id=\"attraction-modal-create-buying-budget\"]/div/button"));

		Listingpopup.click();
	}

	public void selectfilter() {
		WebElement FiltersButton = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div/div[2]/div[3]/div/button"));
		FiltersButton.click();
	}

	public void enterkeyword(String keyword) {
		WebElement FilterKeyword = driver.findElement(By.xpath("//*[@id=\"keywordtermsModal\"]"));
		FilterKeyword.sendKeys(keyword);
	}

	public void clickresult() {

		WebElement ResultButton = driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/div/button/span"));

		ResultButton.click();

		WebElement ResultButton1 = driver
				.findElement(By.xpath("//*[@class='styles__MainFlexWrapper-sc-1t5gb6v-0 hYOJgn']/div/ul/li[1]"));
		synchronized (ResultButton1) {
			try {
				ResultButton1.wait(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public void openproperty() {

		List<WebElement> Properties = driver
				.findElements(By.xpath("//*[@class='Cardstyled__Content-nngi4q-10 cFWTcP']"));
		for (WebElement option1 : Properties) {
			option1.click();
			break;
		}

	}

	public void verifykeyword() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/ul")));

		String PropertyFeatures = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[2]/div[3]/ul"))
				.getText();
		Assert.assertTrue(PropertyFeatures.contains("garage"));
		System.out.println("Garage keyword is displayed");

	}

}
