import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestBraVasya {
    @Test
    public void testHelloVasya() {
        System.setProperty("webdriver.chrom.driver", "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //открыли браузер
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");//открыли сайт
        driver.findElement(By.name("name")).sendKeys("Вася"); // находим элемент страницы, вводим васю
        driver.findElement(By.className("button")).click(); //находим кнопку, нажимаем
        var actualResult = driver.findElement(By.className("start-screen__res")).getText(); //находим "Привет, Вася" и выводим текст факт.результатом теста
        var expectedResult = "Привет, Вася!"; //ожидаемый результат теста
        Assert.assertEquals(expectedResult, actualResult);//сравниваем

        driver.quit();//закрыли браузер

    }
    @Test
    public void testHelloNoName() {
        System.setProperty("webdriver.chrom.driver", "driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //открыли браузер
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");//открыли сайт

        driver.findElement(By.className("button")).click(); //находим кнопку, нажимаем
        var actualResult = driver.findElement(By.className("start-screen__res")).getText(); //находим "Привет, Вася" и выводим текст факт.результатом теста
        var expectedResult = "Привет, !"; //ожидаемый результат теста
        Assert.assertEquals(expectedResult, actualResult);//сравниваем

        driver.quit();//закрыли браузер

    }
}
