package BrowserInstance;

import static com.codeborne.selenide.Selenide.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Condition.*;

public class CommonMethods {
	public static final long DEFAULT_WAIT = 10000;

	public void visiblewait(By icixprdctPage) {
		$(icixprdctPage).shouldNotBe(visible);
	}

	public void waitForElementToBeClickable(By element) throws Exception {
		try {
			WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (DEFAULT_WAIT));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("Element is not visible");
		}

	}

	public void waitForElementToBeVisible(By element) throws Exception {
		try {
			WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), (DEFAULT_WAIT));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			System.out.println("Element is not visible");
		}
	}

	public void acceptAlert() {

	}

}
