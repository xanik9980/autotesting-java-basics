import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests3 {

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

    @Test
    public void testBootsShop () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var inputSizeElement = driver.findElement(By.tagName("input"));
        inputSizeElement.sendKeys("36");
        var button = driver.findElement(By.id("check-size-button"));
        button.click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";

        Assert.assertEquals("Сообщение о наличии обуви не найдено", expectedResult, actualResult);
    }

    @Test
    public void testBootsShopNeg () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        var button = driver.findElement(By.id("check-size-button"));
        button.click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "Введите размер обуви!";

        Assert.assertEquals("Сообщение об ошибке не найдено", expectedResult, actualResult);
    }

    @Test
    public void testBooksShop () {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var feedbackLink = driver.findElement(By.linkText("Обратная связь"));
        var preordersLink = driver.findElement(By.linkText("Предзаказы"));
        var toCartButton = driver.findElement(By.className("book-add"));
        var goodsInCart = driver.findElement(By.id("cart_count"));
        var booksMenuItem = driver.findElement(By.id("genres"));
        var searchField = driver.findElement(By.name("search-input-form"));
    }

    @Test
    public void testBooksShop2 () {
        driver.navigate().to("http://qajava.skillbox.ru/");
        var bookElements = driver.findElements(By.className("book-info"));
        Assert.assertEquals("Неверное кол-во элементов на странице", 15, bookElements.size());
    }

    @Test
    public void testCinema1 () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var yourFavouriteFilms = driver.findElement(By.name("films"));
        String films = "Fast and Furious 1-8";
        yourFavouriteFilms.sendKeys(films);
        var yourFavouriteSerials = driver.findElement(By.name("serials"));
        String serials = "South Park";
        yourFavouriteSerials.sendKeys(serials);
        var btnSave = driver.findElement(By.id("save"));
        btnSave.click();
        var btn2 = driver.findElement(By.id("two"));
        btn2.click();
        var btnEnter = driver.findElement(By.id("save"));
        btnEnter.click();
        var btnOk = driver.findElement(By.id("ok"));
        btnOk.click();

        var textFilms = driver.findElement(By.id("best_films"));
        var actualTextFilms = textFilms.getText();
        Assert.assertEquals("Текст Ваши ответы - фильмы неправильный", films, actualTextFilms);
        var textSerials = driver.findElement(By.id("best_serials"));
        var actualTextSerials = textSerials.getText();
        Assert.assertEquals("Текст Ваши ответы - сериалы неправильный", serials, actualTextSerials);
    }

    @Test
    public void testCinema2 () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("two")).click();
        var iLikeFilms = driver.findElements(By.className("fake-checkbox"));
        for (var checkbox : iLikeFilms) {
            checkbox.click();
        }
        String expectedTextLikes = "С русскими субтитрами, С английскими субтитрами, В оригинале, В дубляже";
        driver.findElement(By.className("fake-radiobutton")).click();
        String expectedTextAge = "10-17";
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();

        var textLikes = driver.findElement(By.id("language"));
        var actualTextLikes = textLikes.getText();
        Assert.assertEquals("Текст Ваши ответы - любимые фильмы неправильный", expectedTextLikes , actualTextLikes);
        var textAge = driver.findElement(By.id("age"));
        var actualTextAge = textAge.getText();
        Assert.assertEquals("Текст Ваши ответы - сериалы неправильный", expectedTextAge, actualTextAge);

    }

    @Test
    public void testCinema3 () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        driver.findElement(By.id("two")).click();
        var iLikeFilms = driver.findElement(By.className("fake-checkbox"));
        iLikeFilms.click();
        driver.findElement(By.id("one")).click();
        driver.findElement(By.id("two")).click();
        var iLikeFilms2 = driver.findElement(By.className("fake-checkbox"));
        Assert.assertEquals("Отметка чекбокса слетела", true, iLikeFilms.isEnabled());

    }
}
