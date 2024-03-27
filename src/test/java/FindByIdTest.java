import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


    /* тест на сценарий работы валидации формы авторизации */
public class FindByIdTest {
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
    //Локаторы для этих элементов вынесите в отдельный блок кода (на уровне класса или самого тестового метода).
    //При этом каждый из четырёх элементов ищите новым способом из уже изученных:
    private By emailSelector = By.id("email");//By.id,
    private By password = By.name("password");//By.name.
    private By enter = By.tagName("button");//By.tagName,
    private By messageLocator = By.className("form-error-password-email");//By.className,

    @Test
    public void  funnySocks1(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/index.html");//Перейдите на страницу.
        driver.findElement(emailSelector).sendKeys("@");//Введите в поле email значение @.
        driver.findElement(password).sendKeys("123");//Введите в поле для пароля значение 123.
        driver.findElement(enter).click();//Нажмите на кнопку «Войти».
        //Убедитесь, что отобразился текст с ошибкой (проверка только на видимость).
        //Проверьте сам текст с ошибкой, он должен быть равен «Некорректный email или пароль».
        Assert.assertTrue("Некорректный email или пароль", driver.findElement(messageLocator).isDisplayed());
    }
}
