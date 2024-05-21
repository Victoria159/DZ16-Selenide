package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Instant;

public class DataEntryPage {
    WebDriver driver;

    //Ввести в поле значение "Москва"
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input")
    WebElement addCity;
    //Нажать ENTER
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[1]/div[1]/div/input")
    WebElement pressEnter;
    //Ввести в поле значение "Санкт-Петербург"
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input")
    WebElement addCity2;
    //Нажать ENTER
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input")
    WebElement pressEnter2;
    //Нажать кнопку Поиск
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[4]/button")
    WebElement pressButton;
    //Кликнуть на пункт «Управление бронированием»
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[3]")
    WebElement clickButton;

    //Ввести в поле ввода данные: номер заказа – XXXXXX
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[2]/div/div/input")
    WebElement addOrderNumber;
    //Нажать ENTER
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[2]/div/div/input")
    WebElement pressEnter3;
    //Ввести в поле ввода данные: фамилия – Qwerty
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[1]/div/div/input")
    WebElement addSurname;

    //Нажать ENTER
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[1]/div/div/input")
    WebElement pressEnter4;
    //Нажать кнопку Поиск в пункте «Управление бронированием»
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[3]/button")
    WebElement pressButton2;


    public DataEntryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getAddCity() {
        addCity.sendKeys("Москва");
    }

    public void getPressEnter() {
        pressEnter.sendKeys(Keys.ENTER);
    }

    public void getAddCity2() {
        addCity2.sendKeys("Санкт-Петербург");
    }

    public void getPressEnter2() {
        pressEnter2.sendKeys(Keys.ENTER);
    }
      public void clockButton(){
          pressButton.click();
     }
    public void clickButtonBookingManagement(){
        clickButton.click();
    }
    public void getAddOrderNumber() {
        addOrderNumber.sendKeys("XXXXXX");
    }
    public void getPressEnter3() {
        pressEnter3.sendKeys(Keys.ENTER);
    }
    public void getAddSurname() {
        addSurname.sendKeys("Qwerty");
    }
    public void getPressEnter4() {
        pressEnter4.sendKeys(Keys.ENTER);
    }
    public void clockButton2(){
        pressButton2.click();
    }

}
