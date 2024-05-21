package pom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class TestPage {

    WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    MouseHoverPage objMouse;
    ScrollPage objScroll;
    CheckPage objCheck;
    DataEntryPage objEntry;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //Перейти на сайт «https://www.pobeda.aero/».
        driver.get("https://www.pobeda.aero/");
        assertEquals(driver.getCurrentUrl(), "https://www.pobeda.aero/");

        //Создаем экземпляр оъекта страницы
        objMouse = new MouseHoverPage(driver);
        objScroll = new ScrollPage(driver);
        objCheck = new CheckPage(driver);
        objEntry = new DataEntryPage(driver);
        //Проверяем текст заголовка страницы
        assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", driver.getTitle());

        //Проверяем логотип Победы
        objCheck.getLogo();

    }

    @Test
    public void testSuccessfullyMouseHover() {
        //Навести мышку на пункт «Информация».
        objMouse.getMouse();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div/a[text() = 'Информация']")), "Информация"));

        //Убедиться, что появилось всплывающее окно, которое содержит следующие заголовки:
        // «Подготовка к полету», «Полезная информация», «О компании».
        Assert.assertTrue(objCheck.isDisplayed("Подготовка к полёту"));
        Assert.assertTrue(objCheck.isDisplayed("Полезная информация"));
        Assert.assertTrue(objCheck.isDisplayed("О компании"));
    }
        @Test
        public void testSuccessfullyScroll() {

            //Проскроллить страницу к блоку поиска билета
            objScroll.getScroll();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]"))));
            //Проверка поля Откуда
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[1]/div/div/input"))));
            Assert.assertTrue(objCheck.getWhereFrom());
            //Проверка поля Куда
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/div[3]/form/div/div[1]/div/div[1]/div/div[4]/div[1]/div/input"))));
            Assert.assertTrue(objCheck.getWhere());
            //Проверка поля Дата вылета туда
            Assert.assertTrue(objCheck.getDepartureDateThere());
            //Проверка поля Дата вылета обратно
            Assert.assertTrue(objCheck.getReturnFlightDate());

            //Ввести в поле значение "Москва"
            objEntry.getAddCity();
            //Нажать ENTER
            objEntry.getPressEnter();
            //Ввести в поле значение "Санкт-Петербург"
            objEntry.getAddCity2();
            //Нажать ENTER
            objEntry.getPressEnter2();

            //Проскроллить страницу к сделующему блоку
            objScroll.getScroll2();

            //Нажать кнопку Поиск
            objEntry.clockButton();
            //Проверка что после нажатия на кнопку "Поиск" около поля «Туда» появилась красная обводка.
            objCheck.getStrokePanel();
        }
        @Test
        public void testSuccessfullyScroll2() {

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
        //Нажать ENTER
        objEntry.getPressEnter4();
        //Ввести в поле ввода данные: номер заказа – XXXXXX
        objEntry.getAddOrderNumber();
        //Нажать ENTER
        objEntry.getPressEnter3();
        //Нажать кнопку Поиск
        objEntry.clockButton2();

        //Переключение на вкладку с результатами поиска
        driver.switchTo().window((String)driver.getWindowHandles().toArray()[2]);

        //Проверка что в новой вкладке на экране отображается текст ошибки «Заказ с указанными параметрами не найден»
        objCheck.getTextError();
        Assert.assertTrue(objCheck.isDisplayed("Заказ с указанными параметрами не найден"));
    }

    @After
    public void tearDown() {
        //Выйти
        driver.quit();
    }
}

