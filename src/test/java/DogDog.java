import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DogDog {
        private static WebDriver driver;
        public  By emailLocator = By.name("email");
        public  By writeToMeLocator = By.id("sendMe");
        public  By resultEmailLocator = By.id("resultTextBlock");
        public  By resultGenderBoyLocator = By.id("boy");
        public  By resultGenderGirlLocator = By.id("girl");

        @BeforeClass
        public static  void setUp() {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        @AfterClass
        public static  void tearDown() {
            driver.quit();
        }
        @Test
        public void testBoyDog(){
            driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/practice/");
            //сначала находим все элементы
            var email = "test@test.ru";
            //пишем  действия теста
            driver.findElement(resultGenderBoyLocator).click();
            driver.findElement(emailLocator).sendKeys(email);
            driver.findElement(writeToMeLocator).click();
            //пишем тест
            Assert.assertTrue("Не отобразился текст про email", driver.findElement(resultEmailLocator).isDisplayed()); // проверим вышло ли окошко

        }
        @Test
        public void testGirlDog(){
            driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/practice/");
            //сначала находим все элементы
            var email = "test@test.ru";
            //пишем  действия теста
            driver.findElement(resultGenderGirlLocator).click();
            driver.findElement(emailLocator).sendKeys(email);
            driver.findElement(writeToMeLocator).click();
            //пишем тест
            Assert.assertTrue("Не отобразился текст про email", driver.findElement(resultEmailLocator).isDisplayed()); // проверим вышло ли окошко

    }
}
