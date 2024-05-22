package pom;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;


public class TestPage {

    @Before
    public void setUp() {
        //Перейти на сайт «https://www.pobeda.aero/».
        open("https://www.pobeda.aero/");

        //Создаем экземпляр оъекта страницы
        CheckPage objCheck = new CheckPage();
        //Проверяем текст заголовка страницы
       assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", title());
        //Проверяем логотип Победы
        objCheck.getLogo();
    }

    @Test
    public void testSuccessfullyMouseHover() {
        //Создаем экземпляр оъекта страницы
        MouseHoverPage objMouse = new MouseHoverPage();
        CheckPage objCheck = new CheckPage();
        //Навести мышку на пункт «Информация».
        objMouse.getMouse();
        ExpectedConditions.textToBePresentInElement($(By.xpath("//div/a[text() = 'Информация']")), "Информация");

        //Убедиться, что появилось всплывающее окно, которое содержит следующие заголовки:
        // «Подготовка к полету», «Полезная информация», «О компании».
        Assert.assertTrue(objCheck.isDisplayed("Подготовка к полёту"));
        Assert.assertTrue(objCheck.isDisplayed("Полезная информация"));
        Assert.assertTrue(objCheck.isDisplayed("О компании"));
    }
        @Test
        public void testSuccessfullyScroll() {
            //Создаем экземпляр оъекта страницы
            ScrollPage objScroll = new ScrollPage();
            CheckPage objCheck = new CheckPage();
            DataEntryPage objEntry = new DataEntryPage();

            //Проскроллить страницу к блоку поиска билета
            objScroll.getScroll().shouldBe(visible,
                    Duration.ofSeconds(20));
            //Проверка поля Откуда
            objCheck.getWhereFrom();
            //Проверка поля Куда
            objCheck.getWhere();
            //Проверка поля Дата вылета туда
            objCheck.getDepartureDateThere();
            //Проверка поля Дата вылета обратно
            objCheck.getReturnFlightDate();

            //Ввести в поле значение "Москва"
            objEntry.getAddCity();

            //Ввести в поле значение "Санкт-Петербург"
            objEntry.getAddCity2();

            //Проскроллить страницу к сделующему блоку
          //  objScroll.getScroll2();

            //Нажать кнопку Поиск
            objEntry.clockButton();
            //Проверка что после нажатия на кнопку "Поиск" около поля «Туда» появилась красная обводка.
            objCheck.getStrokePanel();
        }
        @Test
        public void testSuccessfullyScroll2() {
            //Создаем экземпляр оъекта страницы
            ScrollPage objScroll = new ScrollPage();
            CheckPage objCheck = new CheckPage();
            DataEntryPage objEntry = new DataEntryPage();
        //Проскроллить страницу чуть ниже и кликнуть на пункт «Управление бронированием».
        objScroll.getScroll3().shouldBe(visible,
                Duration.ofSeconds(10));
        objEntry.clickButtonBookingManagement();
        //Проверка поля «Номер заказа или билета»
           objCheck.getOrderOrTicketNumber();
        //Проверка поля «Фамилия клиента»
        objCheck.getClientLastName();
        //Проверка наличия поля есть кнопка «Поиск»
        objCheck.getTheSearchButton();

        //Ввести в поле ввода данные: фамилия – Qwerty
        objEntry.getAddSurname();

        //Ввести в поле ввода данные: номер заказа – XXXXXX
        objEntry.getAddOrderNumber();

        //Нажать кнопку Поиск
        objEntry.clockButton2();

        //Переключение на вкладку с результатами поиска
            switchTo().newWindow(WindowType.TAB);
            open("https://ticket.pobeda.aero/websky/?lang=ru#/search-order/XXXXXX/Qwerty");
        //Проверка что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»

            $(By.xpath("/html/body/div[1]/section/div[1]/div/div/div[2]")).shouldBe(visible,
                    Duration.ofSeconds(30));
            objCheck.getTextError();
    }
}

