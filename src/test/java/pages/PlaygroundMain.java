package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by user on 08/07/2017.
 */
public class PlaygroundMain extends BasePage {
    private final String ANSWER = "answer";
    private final String WROTEBOOK_YES = "wrotebook";
    private final String WROTEBOOK_NO = "didntwritebook";
    private final String RED = "red";
    private final String ORANGE = "orange";
    private final String GREEN = "green";
    private final String TXT = "text";
    private By name = By.id("name");
    private By occupation = By.id("occupation");
    private By bluebox = By.className("bluebox");
    private By radioBtnWroteBook = By.name("wrotebook");
    private By submitButton = By.id("submitbutton");
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static final String URL = "http://timvroom.com/selenium/playground";

    public PlaygroundMain(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setName(String value) {
        insertText(driver.findElement(name), value);
    }

    public void setOccupation(String value) {
        if (value.equals("Science Fiction Author")) {
            value = "scifiauthor";
        } else if (value.equals("Politician")) {
            value = "politician";
        } else {
            value = "astronaut";
        }
        setDropDownByValue(driver.findElement(occupation), value);
    }

    public void insertAnswerId(String elementId, String value) {
        insertText(driver.findElement(By.id(ANSWER + elementId)), value);
    }

    public int getBlueBoxesNumber() {
        return driver.findElements(bluebox).size();
    }

    public void clickLink(String link) {
        clickElement(driver.findElement(By.linkText(link)));
    }

    public void ClickLink2AfterLink(String link, String link2) {
        wait = new WebDriverWait(driver, 20);
        driver.findElement(By.linkText(link)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(link2))).click();
    }

    public void closeAlertWindow() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void submitTestForm() {
        clickElement(driver.findElement(submitButton));
    }

    public String getBoxId(String element) {
        if (element.equalsIgnoreCase(RED)) {
            return "redbox";
        }
        if (element.equalsIgnoreCase(GREEN)) {
            return "greenbox";
        }
        if (element.equalsIgnoreCase(ORANGE)) {
            return "orangebox";
        }
        return element;
    }

    public String getElementsAttributeFromId(String element, String attribute) {
        element = getBoxId(element);
        if (attribute.equalsIgnoreCase(TXT)) {
            return getElementsTextFromId(driver.findElement(By.id(element)));
        }
        return getElementsAttributeFromId(driver.findElement(By.id(element)), attribute);
    }

    public boolean compareElementsPosition(String firstElement, String secondElement, String attribute) {
        int firstPos = Integer.parseInt(getElementsAttributeFromId(firstElement, attribute));
        int secondPos = Integer.parseInt(getElementsAttributeFromId(secondElement, attribute));
        return firstPos < secondPos;
    }

    public void setRadioBtnWroteBook(boolean wroteBook) {
        List<WebElement> radioButtons = driver.findElements(radioBtnWroteBook);
        if (wroteBook) {
            setRadioBtn(radioButtons, WROTEBOOK_YES);
        } else {
            setRadioBtn(radioButtons, WROTEBOOK_NO);
        }
    }

}
