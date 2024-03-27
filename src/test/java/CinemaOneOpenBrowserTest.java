import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CinemaOneOpenBrowserTest {
    private static WebDriver driver;
    @BeforeClass
    public static  void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/"); // Открываем страницу
    }
    @AfterClass
    public static  void tearDown() {
        driver.quit();
    }
    @Test
    public void task1() {
        var films = "Поколение Пи";
        var serials = "Клиника";
        driver.findElement(By.id("films")).sendKeys(films); //    введите текст в поле «Ваши любимые фильмы»;
        driver.findElement(By.id("serials")).sendKeys(serials); //    введите текст в поле «Ваши любимые сериалы»;
        driver.findElement(By.className("section__button")).click(); //    нажмите «Сохранить»;
        driver.findElement(By.id("two")).click(); //    нажмите на кнопку 2;
        driver.findElement(By.id("save")).click(); //    нажмите на кнопку «Сохранить»;
        driver.findElement(By.id("ok")).click(); //    нажмите на кнопку «ОК»;

        //    проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому, который вы вводили в поле «Ваши любимые фильмы»;
        var actualReult1 = driver.findElement(By.id("best_films")).getText();
        Assert.assertEquals(films, actualReult1);
        //    проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому, который вы вводили в поле «Ваши любимые сериалы».
        var actualReult2 = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals(serials, actualReult2);
    }
    

    @Test
    public void chekForm() {
        driver.navigate().refresh();

        var actualReult1 = driver.findElement(By.className("header__content")).getText();
        var expectedResult1 = "Поделитесь списком ваших фаворитов";
        Assert.assertEquals(expectedResult1, actualReult1);

        var actualReult2 = driver.findElement(By.id("films")).getAttribute("placeholder");
        var expectedResult2 = "Ваши любимые фильмы";
        Assert.assertEquals(expectedResult2, actualReult2);

        var actualReult3 = driver.findElement(By.id("serials")).getAttribute("placeholder");
        var expectedResult3 = "Ваши любимые сериалы";
        Assert.assertEquals(expectedResult3, actualReult3);

        var actualReult4 = driver.findElement(By.id("save")).getAttribute("value");
        var expectedResult4 = "СОХРАНИТЬ";
        Assert.assertEquals(expectedResult4, actualReult4);

        var actualReult5 = driver.findElement(By.id("one")).getAttribute("value");
        var expectedResult5 = "1";
        Assert.assertEquals(expectedResult5, actualReult5);

        var actualReult6 = driver.findElement(By.id("two")).getAttribute("value");
        var expectedResult6 = "2";
        Assert.assertEquals(expectedResult6, actualReult6);

        driver.findElement(By.id("two")).click();

        var actualReult7 = driver.findElement(By.className("module__header")).getText();
        var expectedResult7 = "Я люблю смотреть фильмы:";
        Assert.assertEquals(expectedResult7, actualReult7);

        var actualReult8 = driver.findElement(By.id("page_2")).getText();
        var expectedResult8 = "Я люблю смотреть фильмы:\n" +
                "С русскими субтитрами\n" +
                "С английскими субтитрами\n" +
                "В оригинале\n" +
                "В дубляже\n" +
                "Возраст:\n" +
                "10-17\n" +
                "18-25\n" +
                "26-30\n" +
                "31-35\n" +
                "35-45";
        Assert.assertEquals(expectedResult8, actualReult8);

        var actualReult9 = driver.findElement(By.id("save")).getAttribute("value");
        var expectedResult9 = "ВВОД";
        Assert.assertEquals(expectedResult9, actualReult9);

        driver.findElement(By.id("save")).click();

        var actualReult10 = driver.findElement(By.className("popup-text")).getText();
        var expectedResult10 = "Показать ваши ответы перед сохранением?";
        Assert.assertEquals(expectedResult10, actualReult10);

        var actualReult11 = driver.findElement(By.id("ok")).getAttribute("value");
        var expectedResult11 = "ОК";
        Assert.assertEquals(expectedResult11, actualReult11);

        var actualReult12 = driver.findElement(By.id("no")).getAttribute("value");
        var expectedResult12 = "ОТМЕНА";
        Assert.assertEquals(expectedResult12, actualReult12);

        driver.findElement(By.id("ok")).click();

        var actualReult13 = driver.findElement(By.id("finish")).getText();
        var expectedResult13 = "Ваши ответы:\n" +
                "Ваши любимые фильмы:\n" +
                "Ваши любимые сериалы:\n" +
                "Я люблю смотреть фильмы:\n" +
                "Возраст:";
        Assert.assertEquals(expectedResult13, actualReult13);
    }

    @Test
    public void cancelSlection() {
        driver.navigate().refresh();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");

        driver.findElement(By.className("section__button")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("no")).click();

        var actualReult1 = driver.findElement(By.className("header__content")).getText();
        var expectedResult1 = "Поделитесь списком ваших фаворитов";
        Assert.assertEquals(expectedResult1, actualReult1);

        var actualReult2 = driver.findElement(By.id("films")).getAttribute("placeholder");
        var expectedResult2 = "Ваши любимые фильмы";
        Assert.assertEquals(expectedResult2, actualReult2);

        var actualReult3 = driver.findElement(By.id("serials")).getAttribute("placeholder");
        var expectedResult3 = "Ваши любимые сериалы";
        Assert.assertEquals(expectedResult3, actualReult3);
    }
}



