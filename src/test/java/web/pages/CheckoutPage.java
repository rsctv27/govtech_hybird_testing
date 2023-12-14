package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.data.Buyer;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(),'Checkout: Your Information')]")
    WebElement checkoutSummary;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCodeInput;

    @FindBy(xpath = "//input[@data-test='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//*[contains(text(),'Payment Information')]/following-sibling::div[1]")
    WebElement paymentInformation;

    @FindBy(xpath = "//*[contains(text(),'Shipping Information')]/following-sibling::div[1]")
    WebElement shippingInformation;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement subTotalAmount;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    WebElement taxAmount;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    WebElement totalAmount;

    @FindBy(xpath = "//button[@data-test='finish']")
    WebElement finishButton;

    @FindBy(xpath = "//button[@data-test='back-to-products']")
    WebElement backHomeButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void isRedirectedToCheckout() {
        Assert.assertTrue("not redirected to checkout page", checkoutSummary.isDisplayed());
    }

    public void fill_data_on_checkout_page() throws InterruptedException {
        firstNameInput.clear();
        firstNameInput.sendKeys(Buyer.getFirstName());
        lastNameInput.clear();
        lastNameInput.sendKeys(Buyer.getLastName());
        postalCodeInput.clear();
        postalCodeInput.sendKeys(Buyer.getPostalCode());
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void verifyProductCheckoutPage() {
        paymentInformation.isDisplayed();
        shippingInformation.isDisplayed();
        subTotalAmount.isDisplayed();
        taxAmount.isDisplayed();
        totalAmount.isDisplayed();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public void verifyOrder() {
        waitElementVisibleXpath("//h2[contains(text(),'Thank you for your order!')]", 60);
        waitElementVisibleXpath("//div[contains(text(),'Your order has been dispatched, and will arrive just as fast as the pony can get there!')]", 60);
        if (backHomeButton.isDisplayed()) {
            backHomeButton.click();
        }
    }
}
