import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookShop {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");//переходит на сайт
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void searchingElements() {
        driver.findElement(By.linkText("Обратная связь"));//нашли ссылку «Обратная связь» в самом низу страницы
        driver.findElement(By.linkText("Предзаказы"));//нашли ссылку «Предзаказы» в самом низу страницы
        driver.findElements(By.linkText("В корзину"));//нашли кнопку «В корзину» у первой книги
        driver.findElement(By.cssSelector("button.book-add"));//нашли цифру с количеством товаров в корзинке у значка корзины справа вверху
        var countEl = driver.findElement(By.id("cart_count")).getText();//
        System.out.println("количество книг в корзине - " + countEl);
        driver.findElement(By.linkText("Книги"));//нашли пункт меню «Книги»
        driver.findElement(By.cssSelector("input[placeholder='Поиск по магазину...']"));//нашли поле поиска по магазину
    }
    @Test
    public void searching15() {
        var bookInfoElements  = driver.findElements(By.cssSelector("div.book-info"));//
        if (bookInfoElements.size() == 15) {//
            System.out.println("Количество элементов равно 15");//
        } else {
            System.out.println("Количество элементов не равно 15");//
        }
    }
}
