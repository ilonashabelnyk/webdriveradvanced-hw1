package pages;

import driver.DriverManager;

public class LoginPage extends BasePage {
    private static final String expectedRedirectURLSignInJoin = "https://www.bookdepository.com/account/login/to/account";

    public static String getExpectedRedirectURLSignInJoin() {
        return expectedRedirectURLSignInJoin;
    }

    public String getLoginPage() {
        return DriverManager.getDriver().getCurrentUrl();
    }
}
