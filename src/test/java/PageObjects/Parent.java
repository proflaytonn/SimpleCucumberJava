package PageObjects;

import Utils.ExplicitWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Parent {
    WebDriver driver;
    Actions a;
    JavascriptExecutor js;
    WebDriverWait wait;

    public Parent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        a = new Actions(driver);
        js = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWaitUtils.waitTime));
    }

    @FindBy(id = "dp_from")
    WebElement dateFrom;

    @FindBy(css = ".ui-datepicker-month")
    WebElement listMonths;

    @FindBy(css = ".ui-datepicker-year")
    WebElement listYears;

    @FindBy(css = ".ui-state-default")
    List<WebElement> listDates;

    public void filterDate() //some pages have exactly same elements
    {
        dateFrom.click();
        Select select = new Select(listMonths);
        select.selectByVisibleText("Jan");

        Select selectYear = new Select(listYears);
        selectYear.selectByVisibleText("2023");

        List<WebElement> dateCalendar = listDates;

        for (int i = 0; i < dateCalendar.size(); i++) {
            if (dateCalendar.get(i).getText().equalsIgnoreCase("1")) {
                dateCalendar.get(i).click();
                break;
            }
        }
    }

    public void waitWebElement(WebElement webElement)
    {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
