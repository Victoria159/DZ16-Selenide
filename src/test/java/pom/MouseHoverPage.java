package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MouseHoverPage {
    WebDriver driver;
    //Навести мышку на пункт «Информация».
    @FindBy(xpath = "//div/a[text() = 'Информация']")
    WebElement mouse;

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getMouse() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div/a[text() = 'Информация']"))).perform();
        return mouse;
    }
}

