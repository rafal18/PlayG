package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getElementsAttributeFromId(WebElement elm,String attribute){
        return elm.getAttribute(attribute);
    }

    public String getElementsTextFromId(WebElement elm){
        return elm.getText();
    }

    public void insertText(WebElement elm, String value) {
        if(elm.isDisplayed()){
            elm.clear();
            elm.sendKeys(value);
        }

    }
    public boolean verifyElementIsOnPage(String element){
        return driver.findElements(By.id(element)).size() > 0;

    }

    public boolean verifyElementIsVisible(String element){
        if (verifyElementIsOnPage(element))
                return driver.findElement(By.id(element)).isDisplayed();
        return false;

    }

    public void setDropDownByValue(WebElement elm, String value){
        if(elm.isDisplayed()){
            Select selection = new Select(elm);
            selection.selectByValue(value);
        }
    }
    public void clickElement(WebElement link){
        if(link.isDisplayed())
            link.click();
    }


    public void setRadioBtn(List<WebElement> radioButtons, String value){
        if (radioButtons.size() > 0) {
            for (int i = 0; i < radioButtons.size(); i++) {
                if (radioButtons.get(i).getAttribute("value").trim()
                        .equalsIgnoreCase(value)) {
                    if (!(radioButtons.get(i).isSelected())) {
                        radioButtons.get(i).click();
                    }
                }
            }
        }
    }
}
