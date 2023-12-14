package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.data.Buyer;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement productName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    WebElement productPrice;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    WebElement productDesc;

    @FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button ']")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void onCartPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void verifyProductCartPage() {
        Assert.assertEquals("product name is not same!", productName.getText(), Buyer.getProductName());
        Assert.assertEquals("product price is not same!", productPrice.getText(), Buyer.getProductPrice());
        Assert.assertEquals("product desc is not same!", productDesc.getText(), Buyer.getProductDescription());
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
