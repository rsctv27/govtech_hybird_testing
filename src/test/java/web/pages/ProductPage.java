package web.pages;

import org.junit.Assert;
import web.data.Buyer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement productName;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement productPrice;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement productDesc;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void getProductInfo() {
        productName.isDisplayed();
        productPrice.isDisplayed();
    }

    public void verifyProductPage() {
        getProductInfo();
        Assert.assertEquals("product name is not same!", productName.getText(), Buyer.getProductName());
        Assert.assertEquals("product price is not same!", productPrice.getText(), Buyer.getProductPrice());
        Assert.assertEquals("product desc is not same!", productDesc.getText(), Buyer.getProductDescription());
    }

    public void clickAddToCartButton() {
        addToCartButton.isDisplayed();
        addToCartButton.click();
    }

}
