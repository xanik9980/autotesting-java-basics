import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class lesson6_5 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // неявное ожидание появления э-та в ДОМ дереве
    }

    @After
    public void tearDown() {
        driver.quit();
    }

//    Для сайта онлайн-ежедневника составьте один тест, в котором:
//
//    Перейдите на страницу.
//    Кликните на заметку из списка заметок по центру экрана.
//    Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
//    Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
//    Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
//    В разделе «Все записи» выберите самую верхнюю запись (первую).
//    Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
//    Дождитесь исчезновения записи в разделе «Все записи».
//    Проверьте, что справа в списке «Все записи» не видно записей.

    @Test
    public void test() {
        var noteLocator = By.cssSelector(".articlePreview__link");
        var noteTitleLocator = By.cssSelector(".articlePreview__content:nth-of-type(1) .articlePreview__title");
        var noteTextLocator = By.cssSelector(".articlePreview__content:nth-of-type(1) .articlePreview__text");

        var noteInAllLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__link");
        var noteInAllTitleLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__title");
        var noteInAllTextLocator = By.cssSelector(".articlePreview:nth-of-type(1) .articlePreview__text");

        var basketLocator = By.cssSelector(".pageArticle__buttons .pageArticle__button:last-child svg");

        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        var titleMainPage = driver.findElement(noteTitleLocator).getText();
        var textMainPage = driver.findElement(noteTextLocator).getText();
        driver.findElement(noteLocator).click();

        var titleInAll = driver.findElement(noteInAllTitleLocator).getText();
        var textInAll = driver.findElement(noteInAllTextLocator).getText();

        Assert.assertEquals("Заголовки заметок не совпадают", titleMainPage, titleInAll);
        Assert.assertEquals("Тексты заметок не совпадают", textMainPage, textInAll);

        driver.findElement(basketLocator).click();
        driver.findElement(noteInAllLocator).click();
        driver.findElement(basketLocator).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(noteInAllLocator));
        Assert.assertTrue("Записи справа присутствуют", driver.findElements(noteInAllLocator).isEmpty());

    }
}