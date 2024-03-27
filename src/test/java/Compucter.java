import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Compucter {
    private static WebDriver driver;

    @BeforeClass
    public static  void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterClass
    public static  void tearDown() {
        driver.quit();
    }
    @Test   // ОТЗЫВ. ПОИСК ПО ДВУМ ЗНАЧЕНИЯМ КЛАССА
    public void testFeedback(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson3/os.html");
        var nameLocator = By.cssSelector(".data.text");//локаторы сss для поля ввода имени
        var emailLocator = By.cssSelector(".data.field");//локаторы сss для поля ввода почты
        var feedBackLocator = By.cssSelector(".field.text");//локаторы сss для поля ввода отзыва
        var buttonLocator1 = By.className("comment");// находим кнопку
        var messageLocator1 = By.cssSelector(".message-description.comment");//находим благодарность за отзыв

        driver.findElement(nameLocator).sendKeys("Вася");//вводим имя
        driver.findElement(emailLocator).sendKeys("Vasya@yandex.ru");//вводим почту
        driver.findElement(feedBackLocator).sendKeys("Я теперь так счастлив!");//вводим отзыв
        driver.findElement(buttonLocator1).click();
        //пишем тест
        Assert.assertTrue("Не отобразился текст", driver.findElement(messageLocator1).isDisplayed()); // проверим, вышел ли ответ
    }
    @Test   // ВЫЗОВ МАСТЕРА. ПОИСК ПО ДВУМ ЗНАЧЕНИЯМ КЛАССА
    public void testWizard(){
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson3/index.html");

        var nameLocator = By.cssSelector(".form-input.fio");//локаторы сss для поля ввода имени
        var streetLocator = By.cssSelector(".data.form-input.street");//локаторы сss для поля ввода улицы
        var houseLocator = By.cssSelector(".form-input.house");//локаторы сss для поля ввода дома
        var apartmentLocator = By.cssSelector(".form-input.flat");//локаторы сss для поля ввода квартиры
        var whenLocator = By.cssSelector(".form-input.date");//локаторы сss для поля ввода даты
        var buttonOkLocator2 = By.className("form-submit");// находим кнопку отправки вызова
        var messageLocator2 = By.cssSelector(".form-result.result");//находим ответ

        driver.findElement(nameLocator).sendKeys("Вася");//вводим имя
        driver.findElement(streetLocator).sendKeys("Яблоневая");//вводим улицу
        driver.findElement(houseLocator).sendKeys("34");//вводим дом
        driver.findElement(apartmentLocator).sendKeys("2");//вводим квартиру
        driver.findElement(whenLocator).sendKeys("01.04.2024");//вводим дату
        driver.findElement(buttonOkLocator2).click();
        //пишем тест
        Assert.assertTrue("Не отобразился текст", driver.findElement(messageLocator2).isDisplayed()); // проверим, вышел ли ответ
    }
}
