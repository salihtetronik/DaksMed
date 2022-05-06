package daks.tests;

import daks.utilities.Driver;
import daks.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest {

    String url = "http://192.168.81.155:8082/";

    @Test
    public void loginTest() throws InterruptedException {

        Driver.getDriver().get("http://192.168.81.155:8082/");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
     /*
       WebElement selectElement = Driver.getDriver().findElement(By.xpath("//select[@class='selectType de_DE']"));
       Select select = new Select(selectElement);
       select.selectByValue("-1");
      */
        WebElement name = Driver.getDriver().findElement(By.xpath("//input[@class='editUser de_DE']"));
        name.click();
        ReusableMethods.sleep(1000);

        name.sendKeys("sysadm");


        WebElement pass = Driver.getDriver().findElement(By.xpath("//input[@class='editPassword de_DE']"));
        pass.sendKeys("sysadm");

        WebElement login = Driver.getDriver().findElement(By.xpath("//div[@class='loginButton de_DE']"));
        login.click();
    }



    @Test
    public void loginDaksmed() {

        ReusableMethods.getLogin();

    }
}
