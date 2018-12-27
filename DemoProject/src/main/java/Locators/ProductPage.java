package Locators;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Thread.sleep;
import org.openqa.selenium.By;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.WebElementSource;
import com.codoid.products.fillo.Select;

import BrowserInstance.CommonMethods;

public class ProductPage {

	CommonMethods commonLocators = new CommonMethods();
	public static By icixprdctPage = By.xpath("//span[@class='slds-truncate'][text()='ICIX Products']");
	public static By newprdBtn = By.xpath("//div[text()='New']");
	public static By prdheading = By
			.xpath("//li[@class='slds-breadcrumb__item slds-line-height--reset']/span[text()='ICIX Products']");
	public static By newprdbtn = By.xpath(
			"//ul[@class='branding-actions slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']/li/a/div[text()='New']");
	public static By searchTPbox = By.xpath(
			"//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon--right ng-scope']/input[@role='combobox']");
	public static By frame = By.tagName("iframe");
	public static By selectTPName = By.xpath("//span[@class='clickable ng-binding']");
	public static By searchBtn = By.xpath("//button[@id='btnProductSearch'][text()='Search']");
	public static By createPrd = By.xpath("//button[@id='btnCreateProduct'][text()='Create Product']");
	public static By prdName = By.xpath("//input[@id='ProductName']");
	public static By selectPrdID = By
			.xpath("//select[@class='slds-select ng-pristine ng-untouched ng-valid ng-scope ng-empty']");

	public void openPrdPage() throws Exception {
		commonLocators.waitForElementToBeClickable(icixprdctPage);
		$(icixprdctPage).click();
	}

	public String getTitle() {
		return $(prdheading).getText();
	}

	public void clickNewBtn() throws Exception {
		commonLocators.waitForElementToBeClickable(newprdbtn);
		$(newprdbtn).click();
	}

	public void searchTP() throws Exception {
		try {
			int size = $$(frame).size();
			System.out.println("Size of frames" + size);
			WebDriverRunner.getWebDriver().switchTo().frame(0);
			$(searchTPbox).setValue("QA Org 2 Automation Res Pkg Stg");
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}

	public void selectTPName() {
		try {
			sleep(4000);
			commonLocators.waitForElementToBeClickable(selectTPName);
			$(selectTPName).click();
		} catch (Exception e) {
			System.out.println("TP Name is not find/ clickable");
		}
	}

	public void clickSearchBtn() throws Exception {
		commonLocators.waitForElementToBeClickable(searchBtn);
		$(searchBtn).click();
	}

	public boolean enableSearchBtn() {
		return $(searchBtn).isEnabled();
	}

	public void SelectTPName() throws Exception {
		this.searchTP();
		this.selectTPName();
	}

	public void clickcreateProduct() {
		try {
			commonLocators.waitForElementToBeClickable(createPrd);
			$(createPrd).click();
		} catch (Exception e) {
			System.out.println("Create Product button is not visible/ clickable");
		}
	}

	public void enterPrdName() {
		try {
			$(prdName).setValue("Test");
		} catch (Exception e) {
			System.out.println("Product name Input box is not visible");
		}
	}

	public void selectID(WebElementSource selectField, String texts) {
		Select sel = new Select(selectField.getWebElement(), texts);
		
		}

	public void createProduct() {
		this.clickcreateProduct();
		this.enterPrdName();
	}
}
