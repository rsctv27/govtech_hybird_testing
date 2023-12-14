package web.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.data.Buyer;
import web.util.Helper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//img[@class='inventory_item_img']")
    List<WebElement> productImage;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    List<WebElement> productName;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    List<WebElement> productDescription;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> productPrice;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> addToCartButton;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement searchPageHeader;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement product_sort_container;

    @FindBy(xpath = "//option[@value='za']")
    WebElement sort_name_descending;

    @FindBy(xpath = "//option[@value='az']")
    WebElement sort_name_ascending;

    @FindBy(xpath = "//option[@value='hilo']")
    WebElement sort_price_descending;

    @FindBy(xpath = "//option[@value='lohi']")
    WebElement sort_price_ascending;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void onSearchPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue("not redirected to search page", searchPageHeader.isDisplayed());
    }

    public void filterSearchPage(String filter) throws InterruptedException {
        product_sort_container.click();
        Thread.sleep(2000);
        switch (filter) {
            case "sort price descending":
                sort_price_descending.click();
                break;
            case "sort price ascending":
                sort_price_ascending.click();
                break;
            case "sort name descending":
                sort_name_descending.click();
                break;
            case "sort name ascending":
                sort_name_ascending.click();
                break;
            default:
                Assert.fail("Unimplemented filter");
        }
    }

    public void verifyProductPriceIsSortedFromHighestPrice() throws ParseException {
        ArrayList<BigDecimal> arrayList = new ArrayList<>();
        for (WebElement element : productPrice) {
            BigDecimal price = Helper.parse(element.getText(), Locale.US);
            arrayList.add(price);
        }
        Assert.assertTrue("product is not sorted from highest price", Helper.isSorted(arrayList));
    }


    public void clickProduct(String index) {
        scrollToTop();
        Assert.assertTrue("product list is empty!!", productImage.get(0).isDisplayed());
        Assert.assertTrue("product cart icon is missing!!", addToCartButton.get(0).isDisplayed());
        verifyProductAtIndex(Integer.parseInt(index));
        productName.get(Integer.parseInt(index)).click();
    }

    public void verifyProductAtIndex(int index) {
        Buyer.setProductName(productName.get(index).getText());
        Buyer.setProductPrice(productPrice.get(index).getText());
        Buyer.setProductDescription(productDescription.get(index).getText());
    }
}
