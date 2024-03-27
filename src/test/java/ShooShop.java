import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShooShop {
    private WebDriver driver;
    @Before //чтобы не дублировать ставим аннотацию  before, и этот метод будет выполняться перед КАЖДЫМ тестом
    public void setUp() {
        System.setProperty("webdriver.chrom.driver", "driver\\chromedriver.exe");
        driver = new ChromeDriver(); //открыли браузер
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");//переходит на сайт
    }
    @After //чтобы не дублировать ставим аннотацию  After, и этот метод будет выполняться после КАЖДОГО теста
    public void tearDown() {
        driver.quit();//закрыли браузер
    }
    @Test
    public void testSize38() {
        driver.findElement(By.name("check")).sendKeys("38");//ищет поле для ввода Размера
        driver.findElement(By.id("check-size-button")).click();//находим кнопку, нажимаем
        var actualResult = driver.findElement(By.id("size-success")).getText(); //находим ответ сайта и выводим текст факт.результатом теста
        var expectedResult = "В нашем магазине есть обувь вашего размера"; //ожидаемый результат теста
        System.out.println("Тест 38 размера - " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);//сравниваем
    }
    @Test
    public void testSize25() {
        driver.findElement(By.name("check")).sendKeys("25");//ищет поле для ввода Размера
        driver.findElement(By.id("check-size-button")).click();//находим кнопку, нажимаем
        var actualResult = driver.findElement(By.id("size-error")).getText(); //находим ответ сайта и выводим текст факт.результатом теста
        var expectedResult = "В нашем магазине нет обуви вашего размера"; //ожидаемый результат теста
        System.out.println("Тест 25 размера - " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);//сравниваем
    }

    @Test
    public void testSize33() {
        driver.findElement(By.id("size")).sendKeys("33");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult1 = driver.findElement(By.id("size-error")).getText();
        var expectedResult1 = "В нашем магазине нет обуви вашего размера";
        System.out.println("Тест 33 размера - " + actualResult1);
        Assert.assertEquals(expectedResult1, actualResult1);
    }

    @Test
    public void testSize0() {
        driver.findElement(By.id("size")).sendKeys("gaga");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult1 = driver.findElement(By.id("size-error")).getText();
        var expectedResult1 = "Введите размер обуви!";
        System.out.println("gaga - " + actualResult1);
        Assert.assertEquals(expectedResult1, actualResult1);
    }



}
