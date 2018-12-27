package BrowserInstance;

import static com.codeborne.selenide.Selenide.open;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class BrowserInstance {
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		Configuration.browser = "chrome";
		open("https://login.salesforce.com");
		WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		$(By.id("username")).setValue("rupeshk302182@icix.icix");
		$(By.id("password")).setValue("sd_test@001");
		$(By.id("Login")).click();
		try {
			Selenide.switchTo().alert().accept();
			// com.codeborne.selenide.Selenide.confirm();
		} catch (Exception e) {
			System.out.println("No alert found");
		}

		sleep(9000);
	}
}
