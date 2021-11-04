package cucumberTest.steps;

import dto.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CheckOutAttributesPage;
import pages.HomePage;
import pages.SearchAttributesPage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DesktopCheckoutForGuestUser {
    private HomePage homePage = new HomePage();
    private SearchAttributesPage searchAttributesPage = new SearchAttributesPage();
    private CheckOutAttributesPage checkOutAttributesPage = new CheckOutAttributesPage();

    @DataTableType
    public DeliveryAddressForm deliveryAddress(Map<String, String> entry) {
        return new DeliveryAddressForm(
                entry.get("fullName"),
                entry.get("addressLine1"),
                entry.get("addressLine2"),
                entry.get("townCity"),
                entry.get("countryState"),
                entry.get("postcode"));
    }

    @DataTableType
    public CreditCardDetails creditCardDetails(Map<String, String> entry) {
        return new CreditCardDetails(
                entry.get("cardNumber"),
                entry.get("expiryDate"),
                entry.get("cvv"));

    }

    @DataTableType
    public BasketOrderSummary basketOrderSummary(Map<String, String> entry) {
        return new BasketOrderSummary(
                entry.get("delivery"),
                entry.get("total"));
    }

    @DataTableType
    public CheckoutOrderSummary checkoutOrderSummary(Map<String, String> entry) {
        return new CheckoutOrderSummary(
                entry.get("subTotal"),
                entry.get("delivery"),
                entry.get("vat"),
                entry.get("total"));
    }

    @DataTableType
    public ErrorMessagesDeliveryAddressForm errorMessagesDeliveryAddressForm(Map<String, String> entry) {
        return new ErrorMessagesDeliveryAddressForm(
                entry.get("fieldName"),
                entry.get("errorMsg"));
    }

    @DataTableType
    public CreditCardErrorMessages creditCardErrorMessages(Map<String, String> entry) {
        return new CreditCardErrorMessages(
                entry.get("creditCardErrorMessages"));
    }

    @Given("I am an anonymous customer with clear cookies")
    public void anonymousCustomerWithClearCookies() {
    }

    @And("I open the {string}")
    public void openBookdepositoryWebsite(String bookDepositoryURL) {
        homePage.openBookdepository();
    }

    @And("I search for {string}")
    public void executeSearchFor(String searchTerm) {
        searchAttributesPage.performSearch(searchTerm);
    }

    @And("I am redirected to a {string}")
    public void redirectedSearchResultsPage(String searchResultsPage) {
        Assert.assertEquals("Incorrect page redirect after performing search!", searchAttributesPage.getExpectedRedirectURLSearchResults(), searchAttributesPage.getSearchResultsPage());
    }

    @And("Search results contain the following products")
    public void searchResultsContainFollowingProducts(DataTable table) {
        Assert.assertTrue("The search results do not contain the required books!", searchAttributesPage.checkBookByTitle(Arrays.asList("Thinking in Java", "Thinking Java Part I", "Core Java Professional")));

    }

    @And("I apply the following search filters")
    public void applySearchFilters(DataTable table) {
        searchAttributesPage.selectPriceRange("high");
        searchAttributesPage.selectAvailability("1");
        searchAttributesPage.selectLanguage("123");
        searchAttributesPage.selectFormat("1");
        searchAttributesPage.clickOnRefineResults();
    }

    @And("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(DataTable table) {
        boolean isExpectedResult = searchAttributesPage.countSearchResults() == searchAttributesPage.getSearchResultsAfterAppliedFilters();
        Assert.assertTrue("Search result is unexpected!", isExpectedResult);
    }

    @And("I click {string} button for product with name {string}")
    public void clickAddToBasketButtonForProductWithName(String addToBasketBtn, String productName) {
        searchAttributesPage.clickOnAddToBasketBtnThinkingInJavaBook();
    }

    @And("I select {string} in basket pop-up")
    public void selectBasketCheckoutInBasketPopUp(String basketCheckoutBtn) {
        checkOutAttributesPage.clickOnBasketCheckoutBtnOnPopUp();
    }

    @Then("I am redirected to the {string}")
    public void redirectedToBasketPage(String yourBasketPageTitle) {
        Assert.assertEquals("Incorrect Title of Your Basket page!", checkOutAttributesPage.getExpectedYourBasketTitle(), checkOutAttributesPage.getYourBasketPageTitle());
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummary(List<BasketOrderSummary> basketOrderSummary) {
        Assert.assertEquals("Incorrect Basket Delivery value!", basketOrderSummary.get(0).getDelivery(), checkOutAttributesPage.getBasketOrderDeliveryCost());
        Assert.assertEquals("Incorrect Basket Total value!", basketOrderSummary.get(0).getTotal(), checkOutAttributesPage.getBasketOrderTotal());
    }


    @And("I click {string} button on {string} page")
    public void clickCheckoutButtonOnBasketPage(String checkoutBtn, String basketPage) {
        checkOutAttributesPage.clickOnCheckoutBtn();
    }

    @Then("I am redirected to the {string} page")
    public void redirectedToCheckoutPage(String checkoutPageText) {
        Assert.assertEquals("Incorrect redirect after Basket page!", checkOutAttributesPage.getExpectedCheckoutPageTxt(), checkOutAttributesPage.getCheckoutPageTxt());
    }

    @When("I click {string} button")
    public void clickBuyNowButton(String buyNowBtn) {
        checkOutAttributesPage.clickOnBuyNowBtn();
    }

    @Then("the following validation error messages are displayed on Delivery Address form:")
    public void validationErrorMessagesAreDisplayedOnDeliveryAddressForm(List<ErrorMessagesDeliveryAddressForm> errorMessagesDeliveryAddressForm) {
        Assert.assertEquals("Incorrect Email Address error message!", errorMessagesDeliveryAddressForm.get(0).getErrorMsg(), checkOutAttributesPage.getEmailAddressErrorMsg());
        Assert.assertEquals("Incorrect Full Name error message!", errorMessagesDeliveryAddressForm.get(1).getErrorMsg(), checkOutAttributesPage.getFullNameErrorMsg());
        Assert.assertEquals("Incorrect Address Line 1 error message!", errorMessagesDeliveryAddressForm.get(2).getErrorMsg(), checkOutAttributesPage.getAddressLine1ErrorMsg());
        Assert.assertEquals("Incorrect Town/City error message!", errorMessagesDeliveryAddressForm.get(3).getErrorMsg(), checkOutAttributesPage.getTownCityErrorMsg());
        Assert.assertEquals("Incorrect PostCode/ZIP error message!", errorMessagesDeliveryAddressForm.get(4).getErrorMsg(), checkOutAttributesPage.getPostcodeErrorMsg());
    }

    @And("the following validation error messages are displayed on {string} form:")
    public void followingValidationErrorMessagesAreDisplayedOnPaymentForm(String paymentForm, List<CreditCardErrorMessages> creditCardErrorMessages) {
        Assert.assertEquals("Incorrect error messages for Payment Form!", creditCardErrorMessages.get(0).getCreditCardErrorMessages(), checkOutAttributesPage.getCreditCardErrorMsgs().replaceAll("\n", ", "));
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummary(List<CheckoutOrderSummary> checkoutOrderSummary) {
        Assert.assertEquals("Incorrect Checkout SubTotal value!", checkoutOrderSummary.get(0).getSubTotal(), checkOutAttributesPage.getCheckoutOrderSubTotal());
        Assert.assertEquals("Incorrect Checkout Delivery value!", checkoutOrderSummary.get(0).getDelivery(), checkOutAttributesPage.getCheckoutOrderDelivery());
        Assert.assertEquals("Incorrect Checkout VAT value!", checkoutOrderSummary.get(0).getVat(), checkOutAttributesPage.getCheckoutOrderVAT());
        Assert.assertEquals("Incorrect Checkout Total value!", checkoutOrderSummary.get(0).getTotal(), checkOutAttributesPage.getCheckoutOrderTotal());
    }

    @And("I checkout as a new customer with email {string}")
    public void checkoutAsANewCustomerWithEmail(String emailAddress) {
        checkOutAttributesPage.setEmailAddress(checkOutAttributesPage.getEmailAddressSrt());
    }

    @When("I fill delivery address information manually:")
    public void fillDeliveryAddressInformationManually(List<DeliveryAddressForm> deliveryAddressForm) {
        checkOutAttributesPage.fillInDeliveryAddress(deliveryAddressForm.get(0));
        checkOutAttributesPage.clearFocusFromPostcodeZipcodeInputField();
    }

    @And("I select {string} as delivery country")
    public void selectDeliveryCountry(String deliveryCountry) {
        checkOutAttributesPage.selectDeliveryCountry("UA");
    }

    @Then("there is no validation error messages displayed on {string} form")
    public void noValidationErrorMessagesDisplayedOnDeliveryAddressForm(String deliveryAddressForm) {
        Assert.assertFalse("Incorrect visibility of Email Address error message!", checkOutAttributesPage.isEmailAddressErrorMsgPresent());
        Assert.assertFalse("Incorrect visibility of Full Name error message!", checkOutAttributesPage.isFullNameErrorMsgPresent());
        Assert.assertFalse("Incorrect visibility of Address Line 1 error message!", checkOutAttributesPage.isAddressLine1ErrorMsgPresent());
        Assert.assertFalse("Incorrect visibility of Town/City error message!", checkOutAttributesPage.isTownCityErrorMsgPresent());
        Assert.assertFalse("Incorrect visibility of PostCode/Zip error message!", checkOutAttributesPage.isPostcodeErrorMsgPresent());
    }

    @When("I enter my card details")
    public void enterCardDetails(@Transpose List<CreditCardDetails> creditCardDetails) {
        checkOutAttributesPage.setCardNumber(creditCardDetails.get(0).getCardNumber());
        checkOutAttributesPage.setExpiryDate(creditCardDetails.get(0).getExpiryDate());
        checkOutAttributesPage.setCVV(creditCardDetails.get(0).getCvv());
    }
}