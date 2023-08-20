package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Parent {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement textboxEmail;

    @FindBy(id = "password")
    WebElement textboxPassword;

    @FindBy(css = ".btn-glow.primary.login")
    WebElement loginButton;

    public HomePage login(String url, String email, String password)
    {
        driver.get(url);
        textboxEmail.sendKeys(email);
        textboxPassword.sendKeys(password);
        loginButton.click();
        HomePage homePage = new HomePage(driver);
        return homePage;
    }


}
