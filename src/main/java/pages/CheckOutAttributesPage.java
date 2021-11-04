package pages;

import com.codeborne.selenide.SelenideElement;
import dto.DeliveryAddressForm;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CheckOutAttributesPage extends BasePage {
    private static final String basketCheckoutBtnOnPopUp = "//div[@class='modal-body']//a[contains(@class,'continue-to-basket')]";
    private static final String expectedYourBasketTitle = "Your basket";
    private static final String checkoutBtn = "//a[@class='checkout-btn btn original-bucket']";
    private static final String checkoutPageTxt = "//*[text()='Payment details']";
    private static final String expectedCheckoutPageTxt = "Payment details";
    private static final String buyNowBtn = "//*[@class='address-form-col checkout-flex-buttons']/button[@type='submit']";
    private static final String emailAddress = "//input[@name='emailAddress']";
    private static final String fullName = "//input[@name='delivery-fullName']";
    private static final String deliveryCountryDropDown = "//select[@name='deliveryCountry']";
    private static final String addressLine1 = "//input[@name='delivery-addressLine1']";
    private static final String addressLine2 = "//input[@name='delivery-addressLine2']";
    private static final String townCity = "//input[@name='delivery-city']";
    private static final String countryState = "//input[@name='delivery-county']";
    private static final String postcodeZipcode = "//input[@name='delivery-postCode']";
    private static final String cardNumber = "//input[@id='credit-card-number']";
    private static final String expiryDate = "//input[@id='expiration']";
    private static final String cvv = "//input[@id='cvv']";
    private static final String basketOrderDeliveryCost = "dl.delivery-text dd";
    private static final String basketOrderTotal = "div.basket-totals dl.total dd";
    private static final String fullNameErrorMsg = "//div[text()='Please enter your Full name']";
    private static final String emailAddressErrorMsg = "//div[text()='Please enter your Email address']";
    private static final String addressLine1ErrorMsg = "//div[text()='Please enter your Address line 1']";
    private static final String townCityErrorMsg = "//div[text()='Please enter your Town/City']";
    private static final String postcodeErrorMsg = "//*[@id='delivery-postCode']//div[@class='error-block']";
    private static final String checkoutOrderSubTotal = "div.wrapper >dl:nth-child(2) dd";
    private static final String checkoutOrderDelivery = "div.wrapper dl:nth-child(3) dd";
    private static final String checkoutOrderVAT = "div.wrapper > dl:nth-child(4) dd";
    private static final String checkoutOrderTotal = "dl.order-summary-last-dl dd";
    private static final String creditCardNumberIframe = "//iframe[@id='braintree-hosted-field-number']";
    private static final String expiryDateIframe = "//iframe[@id='braintree-hosted-field-expirationDate']";
    private static final String cvvIframe = "//iframe[@id='braintree-hosted-field-cvv']";
    private static final String creditCardErrorMsgs = "//div[@class='buynow-error-msg']";
    private static final String emailAddressSrt = "test@user.com";

    public SelenideElement basketCheckoutBtnOnPopUp() {
        return findElement(By.xpath(basketCheckoutBtnOnPopUp)).should(appear);
    }

    public void clickOnBasketCheckoutBtnOnPopUp() {
        Wait().until(ExpectedConditions.elementToBeClickable(basketCheckoutBtnOnPopUp()));
        basketCheckoutBtnOnPopUp().shouldBe(visible).click();
    }

    public static String getExpectedYourBasketTitle() {
        return expectedYourBasketTitle;
    }

    public String getYourBasketPageTitle() {
        return executeJavaScript("return document.title;").toString();
    }

    public SelenideElement checkoutBtn() {
        return findElement(By.xpath(checkoutBtn));
    }

    public void clickOnCheckoutBtn() {
        Wait().until(ExpectedConditions.elementToBeClickable(checkoutBtn()));
        checkoutBtn().shouldBe(exist).click();
    }

    public SelenideElement checkoutPageTxt() {
        return findElement(By.xpath(checkoutPageTxt)).shouldBe(appear);
    }

    public String getCheckoutPageTxt() {
        return checkoutPageTxt().getText();

    }

    public static String getExpectedCheckoutPageTxt() {
        return expectedCheckoutPageTxt;
    }

    public SelenideElement buyNowBtn() {
        return findElement(By.xpath(buyNowBtn));
    }

    public void clickOnBuyNowBtn() {
        Wait().until(ExpectedConditions.elementToBeClickable(buyNowBtn()));
        executeJavaScript("arguments[0].click();", buyNowBtn());
    }

    public SelenideElement emailAddress() {
        return findElement(By.xpath(emailAddress));
    }

    public void setEmailAddress(String emailAddressStr) {
        emailAddress().sendKeys(emailAddressStr);
    }

    public static String getEmailAddressSrt() {
        return emailAddressSrt;
    }

    public WebElement fullName() {
        return findElement(By.xpath(fullName));
    }

    public void setFullName(String fullNameStr) {
        actions()
                .moveToElement(fullName())
                .keyDown(fullName(), Keys.SHIFT)
                .sendKeys(fullName(), fullNameStr)
                .keyUp(fullName(), Keys.SHIFT)
                .build()
                .perform();
    }

    public void setAddressLine1(String addressLine1Str) {
        findElement(By.xpath(addressLine1)).sendKeys(addressLine1Str);
    }

    public void setAddressLine2(String addressLine2Str) {
        findElement(By.xpath(addressLine2)).sendKeys(addressLine2Str);
    }

    public void setTownCity(String townCityStr) {
        findElement(By.xpath(townCity)).sendKeys(townCityStr);
    }

    public void setCountryState(String countryStateStr) {
        findElement(By.xpath(countryState)).sendKeys(countryStateStr);
    }

    public WebElement postcodeZipcode() {
        return findElement(By.xpath(postcodeZipcode));
    }

    public void setPostcodeZipcode(String postcodeZipcodeStr) {
        findElement(By.xpath(postcodeZipcode)).sendKeys(postcodeZipcodeStr);
    }

    public void clearFocusFromPostcodeZipcodeInputField() {
        actions()
                .moveToElement(postcodeZipcode(), -10, 25)
                .click()
                .build().perform();
    }

    public CheckOutAttributesPage fillInDeliveryAddress(DeliveryAddressForm deliveryAddress) {
        setFullName(deliveryAddress.getFullName());
        setAddressLine1(deliveryAddress.getAddressLine1());
        setAddressLine2(deliveryAddress.getAddressLine2());
        setTownCity(deliveryAddress.getTownCity());
        setCountryState(deliveryAddress.getCountryState());
        setPostcodeZipcode(deliveryAddress.getPostcode());
        return this;
    }

    public void selectDeliveryCountry(String deliveryCountryStr) {
        Select deliveryCountry = new Select(findElement(By.xpath(deliveryCountryDropDown)));
        deliveryCountry.selectByValue(deliveryCountryStr);
    }

    public SelenideElement basketOrderDeliveryCost() {
        return findElement(By.cssSelector(basketOrderDeliveryCost));
    }

    public SelenideElement basketOrderTotal() {
        return findElement(By.cssSelector(basketOrderTotal));
    }

    public String getBasketOrderDeliveryCost() {
        return basketOrderDeliveryCost().getText();
    }

    public String getBasketOrderTotal() {
        return basketOrderTotal().getText();
    }

    public SelenideElement checkoutOrderSubTotal() {
        return findElement(By.cssSelector(checkoutOrderSubTotal));
    }

    public SelenideElement checkoutOrderDelivery() {
        return findElement(By.cssSelector(checkoutOrderDelivery));
    }

    public SelenideElement checkoutOrderVAT() {
        return findElement(By.cssSelector(checkoutOrderVAT));
    }

    public SelenideElement checkoutOrderTotal() {
        return findElement(By.cssSelector(checkoutOrderTotal));
    }

    public String getCheckoutOrderSubTotal() {
        return checkoutOrderSubTotal().getText();
    }

    public String getCheckoutOrderDelivery() {
        return checkoutOrderDelivery().getText();
    }

    public String getCheckoutOrderVAT() {
        return checkoutOrderVAT().getText();
    }

    public String getCheckoutOrderTotal() {
        return checkoutOrderTotal().getText();
    }

    public SelenideElement creditCardNumberIframe() {
        return findElement(By.xpath(creditCardNumberIframe));
    }

    public SelenideElement expiryDateIframe() {
        return findElement(By.xpath(expiryDateIframe));
    }

    public SelenideElement cvvIframe() {
        return findElement(By.xpath(cvvIframe));
    }

    public void setCardNumber(String cardNumberStr) {
        switchTo().frame(creditCardNumberIframe());
        findElement(By.xpath(cardNumber)).sendKeys(cardNumberStr);
        switchTo().defaultContent();
    }

    public void setExpiryDate(String expiryDateStr) {
        switchTo().frame(expiryDateIframe());
        findElement(By.xpath(expiryDate)).sendKeys(expiryDateStr);
        switchTo().defaultContent();
    }

    public void setCVV(String cvvStr) {
        switchTo().frame(cvvIframe());
        findElement(By.xpath(cvv)).sendKeys(cvvStr);
        switchTo().defaultContent();
    }

    public SelenideElement fullNameErrorMsg() {
        return findElement(By.xpath(fullNameErrorMsg));
    }

    public boolean isFullNameErrorMsgPresent() {
        return isCurrentlyVisible(By.xpath(fullNameErrorMsg));
    }

    public String getFullNameErrorMsg() {
        return fullNameErrorMsg().getText();
    }

    public SelenideElement emailAddressErrorMsg() {
        return findElement(By.xpath(emailAddressErrorMsg));
    }

    public boolean isEmailAddressErrorMsgPresent() {
        return isCurrentlyVisible(By.xpath(emailAddressErrorMsg));
    }

    public String getEmailAddressErrorMsg() {
        return emailAddressErrorMsg().getText();
    }

    public SelenideElement addressLine1ErrorMsg() {
        return findElement(By.xpath(addressLine1ErrorMsg));
    }

    public boolean isAddressLine1ErrorMsgPresent() {
        return isCurrentlyVisible(By.xpath(addressLine1ErrorMsg));
    }

    public String getAddressLine1ErrorMsg() {
        return addressLine1ErrorMsg().getText();
    }

    public SelenideElement townCityErrorMsg() {
        return findElement(By.xpath(townCityErrorMsg));
    }

    public boolean isTownCityErrorMsgPresent() {
        return isCurrentlyVisible(By.xpath(townCityErrorMsg));
    }

    public String getTownCityErrorMsg() {
        return townCityErrorMsg().getText();
    }

    public SelenideElement postcodeErrorMsg() {
        return findElement(By.xpath(postcodeErrorMsg));
    }

    public boolean isPostcodeErrorMsgPresent() {
        return isCurrentlyVisible(By.xpath(postcodeErrorMsg));
    }

    public String getPostcodeErrorMsg() {
        return postcodeErrorMsg().getText();
    }

    public SelenideElement creditCardErrorMsgs() {
        return findElement(By.xpath(creditCardErrorMsgs));
    }

    public String getCreditCardErrorMsgs() {
        return creditCardErrorMsgs().getText();
    }
}