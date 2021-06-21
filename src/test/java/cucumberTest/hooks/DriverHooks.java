package cucumberTest.hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setUpDriver() {
       DriverManager.getDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}