package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class CheckPage {
    WebDriver driver;
    //Проверяем логотип Победы
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/header/div[2]/div/a[1]/img")
    WebElement logo;
    //Проверка поля Откуда
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[1]/div/div/input")
    WebElement whereFrom;
    //Проверка поля Куда
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input")
    WebElement where;
    //Проверка поля Дата вылета туда
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[2]/div[1]/div/div[1]/div/input")
    WebElement departureDateThere;
    //Проверка поля Дата вылета обратно
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[2]/div[1]/div/div[3]/div/input")
    WebElement returnFlightDate;
    //Проверка что после нажатия на кнопку "Поиск" около поля «Туда» появилась красная обводка.
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[2]/div[2]/div/div[1]/div")
    WebElement strokePanel;
    //Проверка поля «Номер заказа или билета»
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[2]/div/div/input")
    WebElement orderOrTicketNumber;
    //Проверка поля «Фамилия клиента»
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[1]/div/div/input")
    WebElement clientLastName;
    //Проверка наличия поля есть кнопка «Поиск»
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[3]/button")
    WebElement theSearchButton;
    //Проверка что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»
    @FindBy(xpath = "/html/body/div[1]/section/div[1]/div/div/div[2]")
    WebElement textError;


    public CheckPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean getWhereFrom() {
        return whereFrom.isDisplayed();
    }

    public boolean getWhere() {
        return where.isDisplayed();
    }
    public boolean getDepartureDateThere() {
        return departureDateThere.isDisplayed();
    }
    public boolean getReturnFlightDate() {
        return returnFlightDate.isDisplayed();
    }

    public boolean getLogo() {
        return logo.isDisplayed();
    }

    public String getStrokePanel() {
        return strokePanel.getCssValue(".dp-1bgth1z-root[data-errored]");
    }
    public boolean getOrderOrTicketNumber() {
        return orderOrTicketNumber.isDisplayed();
    }
    public boolean getClientLastName() {
        return clientLastName.isDisplayed();
    }
    public boolean getTheSearchButton() {
        return theSearchButton.isDisplayed();
    }
    public String getTextError() {
        return textError.getText();
    }

    public boolean isDisplayed(String name) {

        boolean present;
        try {
            driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]")).isDisplayed();
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }
}
