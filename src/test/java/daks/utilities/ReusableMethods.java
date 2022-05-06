package daks.utilities;

import daks.pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {

    static WebDriverWait wait = null;

    public static void getLogin() {

        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().get("http://192.168.81.155:8082/");

        if (ReusableMethods.isAlertReady()) {
            Driver.getDriver().switchTo().alert().accept();
        } else
            System.out.println("kein alert");

        LoginPage login = new LoginPage();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


/*
// Bu durum systevo oberfläche icin gecerlidir. => alaert cikiyor ve baglanabilmem icin dismiss tiklamam gerekiyor, ancak tiklamiyor ve systevo ya baglanamdim.
        login.weitereButton.click();

        login.smallLink.click(); // alert bu linke tikladiktan sonra cikiyor.

        if (ReusableMethods.isAlertReady()){
            Driver.getDriver().switchTo().alert().dismiss();
        }else
            System.out.println("kein alert");// konsolda, alert yok diyor,
Driver.getDriver().switchTo().alert().dismiss();
 */

        login.username.sendKeys("sysadm");
        login.password.sendKeys("sysadm");
        login.loginButton.click();
    }

    public static boolean isAlertReady() {
        try {
            Driver.getDriver().switchTo().alert();
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    public static WebElement getVisibilityOfWait(WebElement element){


        wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));

        return element;

    }



    public static void selectMethod(WebElement element){

        Select select = new Select(element);
        select.selectByIndex((int) (Math.random() * select.getOptions().size()));

        /*
       Select select = new Select(selectElement);
       select.selectByValue("-1");
         */

    }




    public static void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);

    }


    public static void doubleClick(WebElement element) {

        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }


    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    public static void sleep(int miliseconds) {

        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }





}