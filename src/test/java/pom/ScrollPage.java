package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollPage {
    WebDriver driver;
    //Проскроллить страницу к блоку поиска билета
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]")
    WebElement scroll;
    //Проскроллить страницу к сделующему блоку
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[4]/div/div[1]/div/div[1]/a/div[1]/div/div[1]")
    WebElement scroll2;
    //Проскроллить страницу чуть ниже и кликнуть на пункт «Управление бронированием».
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[3]")
    WebElement scroll3;

    public ScrollPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getScroll() {
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]"))).perform();
        return scroll;
    }
    public WebElement getScroll2() {
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[4]/div/div[1]/div/div[1]/a/div[1]/div/div[1]"))).perform();
        return scroll2;
    }
    public WebElement getScroll3() {
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[3]"))).perform();
        return scroll3;
    }
}
