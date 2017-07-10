package driverSetup;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseDriver {
    private WebDriver driver;
    static String driverPath = "src/test/drivers/";
    protected WebDriverWait wait;
    public WebDriver getDriver() {
        return driver;
    }

    private static WebDriver setDriver() {
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void changeSize(int width, int height){
        driver.manage().window().setSize(new Dimension(width,height));
    }

    @BeforeClass
    public void initializeDriver() {
        try {
            driver = setDriver();

        } catch (Exception e) {
            System.err.println("Initialization Error: " + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}

