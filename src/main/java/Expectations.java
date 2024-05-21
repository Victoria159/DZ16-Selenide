//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//
//public class Expectations {
//    //Подключаем WebDriver
//    private WebDriver driver;
//    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    private WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
//
//    @Before
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        //Перейти на сайт «https://www.google.com/».
//        driver.get("https://www.google.com/");
//    }
//
//    @Test
//    public void strangerThingsSearchPobeda() {
//        //Открыть сайт google.com и ввести в строку поиска «Сайт компании Победа», после чего нажать Enter.
//        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).click();
//        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys("Сайт компании Победа");
//        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector("h3")).click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.pobeda.aero/");
//
//        //Дождаться прогрузки страницы АК «Победа», после чего дождаться появления картинки с текстом «Полетели в Калининград» и проверить,
//        // что текст на странице действительно совпадает с текстом «Полетели в Калининград».
//        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[2]/main//div[1]/div/div[1]/button[9]/img"))));
//        Assert.assertEquals(driver.findElement(By.xpath("//div[2]/main//div[1]/div/div[1]/button[9]//div[3]/div/div")).getText(), "Полетели в Калининград!");
//
////        //Кликнуть на переключатель языка
////        driver.findElement(By.xpath("//header//div[1]/div[2]/button[1]")).click();
////        //выбрать английский язык
////        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/button[2]/div")).getText(), "English");
////        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/button[2]")))).click();
////        //убедиться, что на главной странице отображаются тексты "Ticket search", "Online check-in", "Manage my booking"
////        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]/div[1]")), "Ticket search"));
////        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[2]/div[1]")), "Online check-in"));
////        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[3]/div[1]")), "Manage my booking"));
//    }
//@Test
//public void switchTheLanguage(){
//    //Открыть сайт google.com и ввести в строку поиска «Сайт компании Победа», после чего нажать Enter.
//    driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).click();
//    driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys("Сайт компании Победа");
//    driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(Keys.ENTER);
//    driver.findElement(By.cssSelector("h3")).click();
//    Assert.assertEquals(driver.getCurrentUrl(), "https://www.pobeda.aero/");
//    //Кликнуть на переключатель языка
//    driver.findElement(By.xpath("//header//div[1]/div[2]/button[1]")).click();
//    //выбрать английский язык
//    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/button[2]/div")).getText(), "English");
//    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/button[2]")))).click();
//    //убедиться, что на главной странице отображаются тексты "Ticket search", "Online check-in", "Manage my booking"
//    wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[1]/div[1]")), "Ticket search"));
//    wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[2]/div[1]")), "Online check-in"));
//    wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[3]/div[1]")), "Manage my booking"));
//
//    }
//    @After
//    public void tearDown() {
//        //Выйти
//        driver.quit();
//    }
//}
