package web.steps;

import io.cucumber.datatable.DataTable;
import web.TestFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import web.data.Buyer;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class StepDefintionsWeb extends TestFactory implements En {

    @Given("^user logged in with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_with(String email, String password) {
        govtech.loginPage().goToLoginPage(email, password);
    }

    @When("^user navigate to search product page$")
    public void user_navigate_to_search_product_page() throws InterruptedException {
        govtech.searchPage().onSearchPage();
    }

    @When("^user set filter \"([^\"]*)\" on search product page$")
    public void user_set_filter(String filterType) throws InterruptedException {
        govtech.searchPage().filterSearchPage(filterType);
    }

    @When("^user verify product price from highest price on search product page$")
    public void user_verify_product_price_is_sorted_from_highest_price() throws ParseException {
        govtech.searchPage().verifyProductPriceIsSortedFromHighestPrice();
    }

    @When("^user click product page with index \"([^\"]*)\"$")
    public void user_click_product(String index) {
        govtech.searchPage().clickProduct(index);
    }

    @When("^user click add to cart button$")
    public void user_click_add_to_cart_button() {
        govtech.productPage().clickAddToCartButton();
    }

    @Then("^user verify product page from search product page$")
    public void user_verify_product_page() {
        govtech.productPage().verifyProductPage();
    }

    @When("^user navigate to cart page$")
    public void user_navigate_to_cart_page() throws InterruptedException {
        govtech.cartPage().onCartPage();
    }

    @Then("^user verify product cart page from product page$")
    public void user_verify_product_cart_page() {
        govtech.cartPage().verifyProductCartPage();
    }

    @When("^user navigate to checkout page$")
    public void user_navigate_to_checkout_page() {
        govtech.cartPage().clickCheckoutButton();
        govtech.checkoutPage().isRedirectedToCheckout();
    }

    @Given("^User fill data on checkout page:$")
    public void user_fill_data_on_checkout_page(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> data : dataList) {
            Buyer.setFirstName(data.get("First Name"));
            Buyer.setLastName(data.get("Last Name"));
            Buyer.setPostalCode(data.get("Postal Code"));
        }

        govtech.checkoutPage().fill_data_on_checkout_page();
    }

    @When("^user click continue button on checkout page$")
    public void user_click_continue_button() {
        govtech.checkoutPage().clickContinueButton();
    }

    @Then("^user verify product checkout page from cart page$")
    public void user_redirected_to_checkout() {
        govtech.checkoutPage().verifyProductCheckoutPage();
    }

    @When("^user click finish button after checkout page$")
    public void user_click_finish_button() {
        govtech.checkoutPage().clickFinishButton();
    }

    @When("^user should see order successfully$")
    public void user_should_see_order_successfully() {
        govtech.checkoutPage().verifyOrder();
    }

}
