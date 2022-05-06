package daks.pages;

import daks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@class='selectType de_DE']")
    public WebElement anmeldenAls;

    @FindBy(xpath = "//input[@class='editUser de_DE']")
    public WebElement username;

    @FindBy(xpath = "//input[@class='editPassword de_DE']")
    public WebElement password;

    @FindBy(xpath = "//div[@class='loginButton de_DE']")
    public WebElement loginButton;


//systevo oberfläche

    @FindBy(xpath = "//button[@class='secondary-button small-link']")
    public WebElement weitereButton;

    @FindBy(xpath = "//a[@class='small-link']")
    public WebElement smallLink;

    @FindBy(xpath = "//input[@class='editUser de_DE']")
    public WebElement user;

    @FindBy(xpath = "//input[@class='editPassword de_DE']")
    public WebElement pass;

    @FindBy(xpath = "//div[@class='loginButton de_DE']")
    public WebElement logi;
}
