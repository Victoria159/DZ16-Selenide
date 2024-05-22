package pom;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
      //  wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div/a[text() = 'Информация']")), "Информация"));

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
            objScroll.getScroll();
            $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]")).shouldBe(visible,
                    Duration.ofSeconds(20));
           // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]"))));
            //Проверка поля Откуда
           // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[1]/div/div/input"))));
            Assert.assertTrue(objCheck.getWhereFrom());
            //Проверка поля Куда
           // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input"))));
            Assert.assertTrue(objCheck.getWhere());
            //Проверка поля Дата вылета туда
            Assert.assertTrue(objCheck.getDepartureDateThere());
            //Проверка поля Дата вылета обратно
            Assert.assertTrue(objCheck.getReturnFlightDate());

            //Ввести в поле значение "Москва"
            objEntry.getAddCity();

            //Ввести в поле значение "Санкт-Петербург"
            objEntry.getAddCity2();

            //$(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input")).shouldBe(visible,
                 //   Duration.ofSeconds(10));
            //Проскроллить страницу к сделующему блоку
            objScroll.getScroll2();
//            $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[3]")).shouldBe(visible,
//                    Duration.ofSeconds(30));
            //Нажать кнопку Поиск
          //  $(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[2]/div[3]/form/div/div[4]/button")).shouldBe(visible,
          //         Duration.ofSeconds(10));
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
        objScroll.getScroll3();
        objEntry.clickButtonBookingManagement();
        //Проверка поля «Номер заказа или билета»
        Assert.assertTrue(objCheck.getOrderOrTicketNumber());
        //Проверка поля «Фамилия клиента»
        Assert.assertTrue(objCheck.getClientLastName());
        //Проверка наличия поля есть кнопка «Поиск»
        Assert.assertTrue(objCheck.getTheSearchButton());

        //Ввести в поле ввода данные: фамилия – Qwerty
        objEntry.getAddSurname();

        //Ввести в поле ввода данные: номер заказа – XXXXXX
        objEntry.getAddOrderNumber();

        //Нажать кнопку Поиск
        objEntry.clockButton2();

        //Переключение на вкладку с результатами поиска
            Selenide.switchTo().newWindow(WindowType.TAB);
            Selenide.open("https://ticket.pobeda.aero/websky/?lang=ru#/search-order/XXXXXX/Qwerty");
        //Проверка что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»
       // objCheck.getTextError();
            $(By.xpath("/html/body/div[1]/section/div[1]/div/div/div[2]")).shouldBe(visible,
                    Duration.ofSeconds(30));
            objCheck.getTextError();
       // Assert.assertTrue(objCheck.isDisplayed("Заказ с указанными параметрами не найден"));
    }

}

