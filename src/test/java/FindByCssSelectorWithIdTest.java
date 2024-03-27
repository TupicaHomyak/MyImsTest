import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* Ищем элементы с помощью By.cssSelector с поиском по ID. */
public class FindByCssSelectorWithIdTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    private By emailSelector = By.cssSelector("#email");
    private By password = By.cssSelector("#password");
    private By enter = By.cssSelector("#submit");
    private By messageLocator = By.cssSelector("#error");

    @Test
    public void funnySocks4() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailSelector).sendKeys("@");//Введите в поле email значение @.
        driver.findElement(password).sendKeys("123");//Введите в поле для пароля значение 123.
        driver.findElement(enter).click();//Нажмите на кнопку «Войти».
        //Убедитесь, что отобразился текст с ошибкой (проверка только на видимость).
        //Проверьте сам текст с ошибкой, он должен быть равен «Некорректный email или пароль».
        Assert.assertTrue("Некорректный email или пароль", driver.findElement(messageLocator).isDisplayed());
    }
}
