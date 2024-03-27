import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatCat {
    private static WebDriver driver;
    public  By emailLocator = By.className("email");
    public  By writeToMeLocator = By.id("write-to-me");
    public  By resultEmailLocator = By.className("notification-email");

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
    public void testKittens(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/changed.html");
        //сначала находим все элементы
        var email = "test@test.ru";
        //пишем  действия теста
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        //пишем тест
        Assert.assertTrue("Не отобразился текст про email", driver.findElement(resultEmailLocator).isDisplayed()); // проверим вышло ли окошко
        Assert.assertEquals("Неправильный текст про email", email, driver.findElement(resultEmailLocator).getText()); //проверим,
    }
    @Test
    public void testKittensEmptyEmail(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/changed.html");
        driver.findElement(writeToMeLocator).click();
        Assert.assertEquals("Неправильный текст про email", "", driver.findElement(resultEmailLocator).getText());
    }
}
