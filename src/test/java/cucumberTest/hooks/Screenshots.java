package cucumberTest.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

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