//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class GoogleSearch {
//    //Подключаем WebDriver
//    WebDriver driver;
//@Before
//    public void setUp(){
//        // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//    //Перейти на сайт «https://pikabu.ru/».
//    driver.get("https://pikabu.ru/");
//    }
//    @Test
//    public void strangerThingsSearchGoogle() {
//
//        //Убедиться, что заголовок сайта: «Горячее – самые интересные и обсуждаемые посты | Пикабу»
//        Assert.assertEquals(driver.getTitle(),"Горячее – самые интересные и обсуждаемые посты | Пикабу");
//
//        //Кликнуть на кнопку «Войти».
//        driver.findElement(By.cssSelector("[class=\"header-right-menu__login-button\"]")).click();
//
//        //Убедиться, что отображается модальное окно «Авторизация», отображаются поля «Логин» и «Пароль», отображается кнопка «Войти».
//        driver.findElement(By.cssSelector("[class=\"auth__notice\"]")).isDisplayed();
//        driver.findElement(By.xpath("//div[5]//form/div[1]/div/div/input")).isDisplayed();
//                driver.findElement(By.xpath("//div[5]//form/div[2]/div/div/input")).isDisplayed();
//        driver.findElement(By.xpath("//div[5]//form/div[7]/button")).isDisplayed();
//
//       // Assert.assertEquals(driver.findElement(By.xpath("//div[6]//form/div[1]/div/div/input")).getText(),"Логин");
//       // Assert.assertEquals(driver.findElement(By.xpath("//div[5]//form/div[2]/div/div/input")).getText(),"Пароль");
//
//        //Ввести в поля данные в формате логин/пароль – Qwerty/Qwerty и нажать «Войти».
//        driver.findElement(By.xpath("//div[5]//form/div[1]/div/div/input")).click();
//        driver.findElement(By.xpath("//div[5]//form/div[1]/div/div/input")).sendKeys("Qwerty");
//
//        driver.findElement(By.xpath("//div[5]//form/div[2]/div/div/input")).click();
//        driver.findElement(By.xpath("//div[5]//form/div[2]/div/div/input")).sendKeys("Qwerty");
//
//        driver.findElement(By.xpath("//div[5]//form/div[7]/button")).click();
//
//        //Убедиться, что появилось сообщение об ошибке, и его текст: «Ошибка. Вы ввели неверные данные авторизации».
//        driver.findElement(By.xpath("//div[5]/div/div[1]/div/div[1]/div/span")).isDisplayed();
//
//    }
//    @After
//    public void tearDown(){
//        //Выйти
//        driver.quit();
//    }
//}
