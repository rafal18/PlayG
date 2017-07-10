package tests;

import driverSetup.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PlaygroundMain;


public class PlaygroundTest extends BaseDriver {
    private final String ANSWERONE = "1";
    private final String ANSWERFOUR = "4";
    private final String ANSWERSIX = "6";
    private final String ANSWEREIGHT = "8";
    private final String ANSWERTEN = "10";
    private final String ANSWERELEVEN = "11";
    private final String ANSWERTHIRTEEN = "13";
    private final String ANSWERFOURTEEN = "14";
    private final String YES = "yes";
    private final String NO = "no";
    private final String NAME = "Kilgore Trout";
    private final String OCCUPATION = "Science Fiction Author";
    private final String CLICKME = "click me";
    private final String CLICKWAIT = "click then wait";
    private final String CLICKAFTER = "click after wait";
    private final String REDBOX = "red";
    private final String GREENBOX = "green";
    private final String ORANGEBOX = "orange";
    private final String CLASS = "class";
    private final String TXT = "text";
    private final String OFFSET_TOP = "offsetTop";
    private final String ISHERE = "ishere";
    private final String PURPLEBOX = "purplebox";
    private WebDriver driver;
    private PlaygroundMain mainPage;


    @BeforeClass
    public void setUp(){
        driver = getDriver();
        driver.get(PlaygroundMain.URL);
        mainPage = PageFactory.initElements(driver,PlaygroundMain.class);
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }

    @Test
    public void Test01(){
        mainPage.insertAnswerId(ANSWERONE,driver.getTitle());
    }
    @Test
    public void Test02(){
        mainPage.setName(NAME);
    }
    @Test
    public void Test03(){
        mainPage.setOccupation(OCCUPATION);
    }
    @Test
    public void Test04(){
        mainPage.insertAnswerId(ANSWERFOUR,  String.valueOf(mainPage.getBlueBoxesNumber()));
    }
    @Test
    public void Test05(){
        mainPage.clickLink(CLICKME);
    }
    @Test
    public void Test06(){
        mainPage.insertAnswerId(ANSWERSIX,mainPage.getElementsAttributeFromId(REDBOX,CLASS));
    }

    @Test
    public void Test07(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("ran_this_js_function();" );
    }
    @Test
    public void Test08(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object jsReturnVal = js.executeScript("return got_return_from_js_function();" );
        mainPage.insertAnswerId(ANSWEREIGHT,jsReturnVal.toString());
    }
    @Test
    public void Test09(){
        mainPage.setRadioBtnWroteBook(true);
    }
    @Test
    public void Test10(){
        mainPage.insertAnswerId(ANSWERTEN,mainPage.getElementsAttributeFromId(REDBOX,TXT));
    }

    @Test
    public void Test11(){
      if (mainPage.compareElementsPosition(GREENBOX,ORANGEBOX,OFFSET_TOP)){
          mainPage.insertAnswerId(ANSWERELEVEN,GREENBOX);
      }
      else{
          mainPage.insertAnswerId(ANSWERELEVEN,ORANGEBOX);
      }

    }

    @Test
    public void Test12(){
        changeSize(850,650);
    }

    @Test
    public void Test13(){
        mainPage.insertAnswerId(ANSWERTHIRTEEN,mainPage.verifyElementIsOnPage(ISHERE)?YES:NO);
    }

    @Test
    public void Test14(){
        mainPage.insertAnswerId(ANSWERFOURTEEN,mainPage.verifyElementIsVisible(PURPLEBOX)?YES:NO);
    }

    @Test
    public void Test15and16(){
        mainPage.ClickLink2AfterLink(CLICKWAIT,CLICKAFTER);
        mainPage.closeAlertWindow();
    }

    @Test
    public void Test17(){
        mainPage.submitTestForm();
    }

}
