import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cinema {
    private WebDriver driver;

    @Before //чтобы не дублировать ставим аннотацию  before, и этот метод будет выполняться перед КАЖДЫМ тестом
    public void  setUp() {
        System.setProperty("webdriver.chrom.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver(); //открыли браузер
    }
    @After //чтобы не дублировать ставим аннотацию  After, и этот метод будет выполняться после КАЖДОГО теста
    public void tearDown(){
        driver.quit();//закрыли браузер
    }

    @Test
    public void testLocators(){
        //
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");//переходит на сайт
        var emileElement = driver.findElement(By.className("form-input"));//ищет поле Email
        var passwordElement = driver.findElement(By.id("password"));//ищет поле Пароль
        var passwordConfirmElement = driver.findElement(By.name("confirm_password"));//ищет поле Подтверждение пароля

        //несколько раз будем использовать логин и пароль, потому оформим в переменные
        var password = "123";
        var email = "test@test";

        //дополняем тест действиями
        emileElement.sendKeys(email);//вводим логин, пароль и подтверждение пароля
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);

        var buttonElement = driver.findElement(By.tagName("button"));//находим кнопку
        var headerResultElement = driver.findElement(By.tagName("h3"));//заголовок регистрации находим

        buttonElement.click(); //жмем кнопку

        //добавляем проверки
        var emailResultElement1 = driver.findElement(By.linkText(email));
        var emailResultElement2 = driver.findElement(By.partialLinkText(email)); //две стратегии поиска одного итого же элемента
        Assert.assertEquals("неверный текст при успешной регистрации", "Спасибо за регистрацию!", headerResultElement.getText());
        Assert.assertEquals("неверный email при успешной регистрации", email, emailResultElement1.getText());

    }
}
