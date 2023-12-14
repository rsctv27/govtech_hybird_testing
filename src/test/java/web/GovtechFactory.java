package web;

import org.openqa.selenium.WebDriver;
import web.pages.*;

public class GovtechFactory {
    private WebDriver driver;

    public GovtechFactory(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage basePage() {
        return new BasePage(this.driver);
    }

    public LoginPage loginPage() { return new LoginPage(this.driver); }

    public SearchPage searchPage() { return new SearchPage(this.driver); }

    public ProductPage productPage() {return new ProductPage(this.driver);}

    public CartPage cartPage() {return new CartPage(this.driver);}

    public CheckoutPage checkoutPage() {return new CheckoutPage(this.driver);}

}
