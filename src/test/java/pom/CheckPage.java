package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

public class CheckPage {

    //Проверяем логотип Победы
  private SelenideElement logo = $(By.xpath("//*[@id=\"__next\"]/div[2]/header/div[2]/div/a[1]/img"));

    //Проверка поля Откуда
    private SelenideElement whereFrom = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[1]/div/div/input"));

    //Проверка поля Куда
    private SelenideElement where = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input"));

    //Проверка поля Дата вылета туда
    private SelenideElement departureDateThere = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[2]/div[1]/div/div[1]/div/input"));

    //Проверка поля Дата вылета обратно
    private SelenideElement returnFlightDate = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[2]/div[1]/div[1]/div[3]/div/input"));

    //Проверка что после нажатия на кнопку "Поиск" около поля «Туда» появилась красная обводка.
    private SelenideElement strokePanel = $(By.xpath("//*[@id=\\\"__next\\\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[2]/div[2]/div/div[1]/div"));

    //Проверка поля «Номер заказа или билета»
    private SelenideElement orderOrTicketNumber = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[2]/div/div/input"));

    //Проверка поля «Фамилия клиента»
    private SelenideElement clientLastName = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[1]/div/div/input"));

    //Проверка наличия поля есть кнопка «Поиск»
    private SelenideElement theSearchButton = $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[3]/button"));

    //Проверка что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»
    private SelenideElement textError = $(By.xpath("/html/body/div[1]/section/div[1]/div/div/div[2]"));

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
            $(By.xpath("//*[contains(text(),'" + name + "')]")).isDisplayed();
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }
}
