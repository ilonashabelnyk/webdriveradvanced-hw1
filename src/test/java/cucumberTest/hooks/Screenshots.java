package cucumberTest.hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Rule;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

public class Screenshots {
    public static final String PNG_FILE_EXTENSION = "image/png";

    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = (Selenide.screenshot(OutputType.BASE64).getBytes(StandardCharsets.UTF_8));
            scenario.attach(screenshot, PNG_FILE_EXTENSION, scenario.getName());
        }
    }
}