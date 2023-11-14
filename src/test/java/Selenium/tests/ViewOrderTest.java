package Selenium.tests;

import Selenium.pages.ProductDetails;
import Selenium.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponent.BaseTest;

import java.io.IOException;

public class ViewOrderTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void Check_viewOrder(String email, String password, String productName) throws InterruptedException {
        ProductsPage productsPage = landingPage.LoginToApplication(email, password);
        productsPage.viewProductToCart(productName);
        ProductDetails ProductDetails = new ProductDetails(driver);
        Assert.assertEquals(ProductDetails.getProductTitle(),productName);
    }



    @DataProvider
    public Object[][] getData() {
        return new Object[][]
                {
                        {"dexcomnew98@gmail.com", "User123#" , "ZARA COAT 3"}
                };
    }
}
