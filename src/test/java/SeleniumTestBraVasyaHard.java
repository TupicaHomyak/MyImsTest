import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestBraVasyaHard {
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
    public void testHelloVasyaHard() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");//открыли сайт
        driver.findElement(By.name("name")).sendKeys("Вася"); // находим элемент страницы, вводим васю
        driver.findElement(By.name("email")).sendKeys("Vodeviiil@mail.ru"); // находим элемент страницы, вводим почту
        driver.findElement(By.name("phone")).sendKeys("+79125902406"); // находим элемент страницы, вводим телефон
        driver.findElement(By.className("button")).click(); //находим кнопку, нажимаем
        var actualResult = driver.findElement(By.className("start-screen__res")).getText(); //находим ответ сайта и выводим текст факт.результатом теста
        var expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту (Vodeviiil@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79125902406."; //ожидаемый результат теста
        System.out.println("Тест с Васей - " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);//сравниваем
    }
    @Test
    public void testHelloOlgaHard() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");//открыли сайт
        driver.findElement(By.name("name")).sendKeys("Ольга"); // находим элемент страницы, вводим ольгу
        driver.findElement(By.name("email")).sendKeys("Vodeviiil@mail.ru"); // находим элемент страницы, вводим почту
        driver.findElement(By.name("phone")).sendKeys("+79125902406"); // находим элемент страницы, вводим телефон
        driver.findElement(By.className("button")).click(); //находим кнопку, нажимаем
        var actualResult = driver.findElement(By.className("start-screen__res")).getText(); //находим ответ сайта и выводим текст факт.результатом теста
        var expectedResult = "Здравствуйте, Ольга.\n" +
                "На вашу почту (Vodeviiil@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79125902406."; //ожидаемый результат теста
        System.out.println("Тест с Ольгой - " + actualResult);
        Assert.assertEquals(expectedResult, actualResult);//сравниваем
    }



}
