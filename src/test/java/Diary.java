import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Diary {
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
    public void testDiaryElements(){
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var noteElements = driver.findElements(By.className("articlePreview"));
        Assert.assertEquals("Неверное количество записей на странице АХХАХАХА", 2, noteElements.size());
    }
    @Test
    public void testDiaryElement(){
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/");
        var noteElements = driver.findElement(By.className("articlePreview pageCreate_articlePreview"));
        Assert.assertEquals("Неверное количество записей на странице АХХАХАХА", true, noteElements.isDisplayed());
    }

}
