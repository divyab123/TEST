package ProductTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Locators.ProductPage;

public class ProductTest {
	ProductPage objPrdPage = new ProductPage();
	SoftAssert asserts = new SoftAssert();

	@Test
	public void goToICIXPrd() throws Exception {
		objPrdPage.openPrdPage();
		String ActualHeading = objPrdPage.getTitle();
		asserts.assertEquals(ActualHeading, "ICIX Products");
	}

	@Test
	public void searchForTP() throws Exception {
		objPrdPage.clickNewBtn();
		objPrdPage.SelectTPName();
		boolean actualvalue = objPrdPage.enableSearchBtn();
		asserts.assertEquals(actualvalue, true);
		asserts.assertAll();
		objPrdPage.clickSearchBtn();
	}

	@Test
	public void CreateICIXProduct() {
		objPrdPage.createProduct();
	}

	/*
	 * @Test public void SelectTP() { objPrdPage.selectTPName(); }
	 */
}
