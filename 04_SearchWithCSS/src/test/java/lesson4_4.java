import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lesson4_4 {

//    Напишите один позитивный тест для страницы починки компьютеров, включающий в себя заполнение всех полей.
//    Перед написанием кода проверьте свои локаторы через браузер. Сделайте скриншоты проверок.
//    Ищите элементы с помощью By.cssSelector, указывая один или два класса там, где поиск по одному классу будет неуникальным.

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

    private By fioLocator = By.cssSelector(".form-input.fio");
    private By streetLocator = By.cssSelector(".street");
    private By houseLocator = By.cssSelector(".house");
    private By flatLocator = By.cssSelector(".flat");
    private By dateLocator = By.cssSelector(".date");
    private By buttonLocator = By.cssSelector(".form-submit");
    private By resultLocator = By.cssSelector(".result");

    @Test
    public void testService() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        String fio = "Петров Пётр Петрович";
        String street = "Маркса";
        String house = "1";
        String flat = "2";
        String date = "Пн";

        driver.findElement(fioLocator).sendKeys(fio);
        driver.findElement(streetLocator).sendKeys(street);
        driver.findElement(houseLocator).sendKeys(house);
        driver.findElement(flatLocator).sendKeys(flat);
        driver.findElement(dateLocator).sendKeys(date);
        driver.findElement(buttonLocator).click();

        Assert.assertTrue("Блок с введёнными данными не отобразился", driver.findElement(resultLocator).isDisplayed());
    }
}
