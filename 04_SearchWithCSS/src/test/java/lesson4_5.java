import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lesson4_5 {


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



//    1 Запишите один тест на сценарий работы валидации формы авторизации на сайте клуба любителей весёлых носков.
    //    Реализуйте следующий сценарий:
    //    Перейдите на страницу.
    //    Введите в поле email значение @.
    //    Введите в поле для пароля значение 123.
    //    Нажмите на кнопку «Войти».
    //    Убедитесь, что отобразился текст с ошибкой (проверка только на видимость).
    //    Проверьте сам текст с ошибкой, он должен быть равен «Некорректный email или пароль».
    //    Локаторы для этих элементов вынесите в отдельный блок кода (на уровне класса или самого тестового метода).
    //    Элементы ищите непосредственно перед взаимодействием.
    //    При этом каждый из четырёх элементов ищите новым способом из уже изученных: By.id, By.tagName, By.className, By.name.
    //    Используйте при проверках assertTrue и assertEquals с указанием сообщений в случае падения теста.
    @Test
    public void test1() {
        By emailLocator = By.name("email");
        By passwordLocator = By.id("password");
        By buttonLocator = By.tagName("button");
        By errorLocator = By.className("form-error-password-email");

        var site = "http://qajava.skillbox.ru/module04/homework/auth/index.html";
        driver.navigate().to(site);
        var email = "@";
        var password = "123";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        var resultErrorElement = driver.findElement(errorLocator);
        var errorText = "Некорректный email или пароль";

        Assert.assertTrue("Ошибка не отображается", resultErrorElement.isDisplayed());
        Assert.assertEquals("Текст ошибки неверный", errorText, resultErrorElement.getText());
    }

//    Страница авторизации обновилась. Запишите для неё точно такой же тест. В этом задании ищите все элементы с помощью By.cssSelector. Там, где элемент нельзя найти уникально по одному классу, ищите по двум.
    @Test
    public void test2() {
        By emailLocator = By.cssSelector(".input-data");
        By passwordLocator = By.cssSelector(".password");
        By buttonLocator = By.cssSelector(".form-submit");
        By errorLocator = By.cssSelector(".form-error-password-email");

        var site = "http://qajava.skillbox.ru/module04/homework/auth/changed.html";
        driver.navigate().to(site);
        var email = "@";
        var password = "123";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        var resultErrorElement = driver.findElement(errorLocator);
        var errorText = "Некорректный email или пароль";

        Assert.assertTrue("Ошибка не отображается", resultErrorElement.isDisplayed());
        Assert.assertEquals("Текст ошибки неверный", errorText, resultErrorElement.getText());
    }

// Используйте сценарий и тест как в задании 2, только теперь ищите элементы с помощью By.cssSelector с поиском по тегу и одному или двум классам одновременно.
    @Test
    public void test3() {
        By emailLocator = By.cssSelector("input.input-data.form-input"); // можно искать по input.input-data но в задании сказано, чтобы что-нибудь искалось по 2 классам
        By passwordLocator = By.cssSelector("input.password");
        By buttonLocator = By.cssSelector("button.form-submit");
        By errorLocator = By.cssSelector("pre.form-error-password-email");

        var site = "http://qajava.skillbox.ru/module04/homework/auth/changed.html";
        driver.navigate().to(site);
        var email = "@";
        var password = "123";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        var resultErrorElement = driver.findElement(errorLocator);
        var errorText = "Некорректный email или пароль";

        Assert.assertTrue("Ошибка не отображается", resultErrorElement.isDisplayed());
        Assert.assertEquals("Текст ошибки неверный", errorText, resultErrorElement.getText());
    }

    //Используйте сценарий и тест как в задании 2, только теперь ищите элементы с помощью By.cssSelector с поиском по ID.
    @Test
    public void test4() {
        By emailLocator = By.cssSelector("#email");
        By passwordLocator = By.cssSelector("#password");
        By buttonLocator = By.cssSelector("#submit");
        By errorLocator = By.cssSelector("#error");

        var site = "http://qajava.skillbox.ru/module04/homework/auth/changed.html";
        driver.navigate().to(site);
        var email = "@";
        var password = "123";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        var resultErrorElement = driver.findElement(errorLocator);
        var errorText = "Некорректный email или пароль";

        Assert.assertTrue("Ошибка не отображается", resultErrorElement.isDisplayed());
        Assert.assertEquals("Текст ошибки неверный", errorText, resultErrorElement.getText());
    }

    //Используйте сценарий и тест как в задании 2. Элементы с одним классом ищите с помощью By.cssSelector с поиском по ID, тегу и классу одновременно. Элементы с двумя классами ищите по ID, тегу и двум классам.
    @Test
    public void test5() {
        By emailLocator = By.cssSelector("input#email.input-data.form-input");
        By passwordLocator = By.cssSelector("input#password.password");
        By buttonLocator = By.cssSelector("button#submit.form-submit");
        By errorLocator = By.cssSelector("pre#error.form-error-password-email");

        var site = "http://qajava.skillbox.ru/module04/homework/auth/changed.html";
        driver.navigate().to(site);
        var email = "@";
        var password = "123";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();
        var resultErrorElement = driver.findElement(errorLocator);
        var errorText = "Некорректный email или пароль";

        Assert.assertTrue("Ошибка не отображается", resultErrorElement.isDisplayed());
        Assert.assertEquals("Текст ошибки неверный", errorText, resultErrorElement.getText());
    }
}