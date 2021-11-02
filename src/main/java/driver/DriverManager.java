//package driver;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class DriverManager {
//    //    private final static String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
////    private final static int IMPLICIT_WAIT_TIMEOUT = 5;
////    private final static int PAGE_LOAD_TIMEOUT = 20;
////    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
////
////    private DriverManager() {
////    }
////
////    public static void setUpDriver() {
////        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
////        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
////        webDriverThreadLocal.set(driver);
////    }
////
////    public static WebDriver getDriver() {
////        if (webDriverThreadLocal.get() == null) {
////            setUpDriver();
////        }
////        return webDriverThreadLocal.get();
////    }
////
////    public static void quitDriver() {
////        webDriverThreadLocal.get().quit();
////        webDriverThreadLocal.remove();
////    }
//    public static void setUpDriver() {
//        WebDriver driver = null;
//        String browser = System.getProperty("browser");
//        if (browser.equalsIgnoreCase("iexplore")) {
//            driver = new InternetExplorerDriver();
//        }
//        if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//            driver = new FirefoxDriver();
//        }
//        if (browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            driver = new ChromeDriver();
//        }
//    }
//}