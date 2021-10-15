import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    @Test
    public void testHelloVasya()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Вася!";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testEmptyName()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testHello2ValidAll()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys("test@test.test");
        driver.findElement(By.name("phone")).sendKeys("+79998887766");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Вася.\n" +
                "На вашу почту (test@test.test) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79998887766.";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testHello2InvalidEmail()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Вася Петров");
        driver.findElement(By.name("email")).sendKeys("testtest");
        driver.findElement(By.name("phone")).sendKeys("+79998887766");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Email введён неверно";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testHello2InvalidFIO()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("&^$%*%GHF^&");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("+79998887766");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "ФИО введёно неверно";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testHello2InvalidPhone()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Вася Петров");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("dskghsd^%&*^gxuidgh");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Телефон введён неверно";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testHello2InvalidAll()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("UI&*Y87");
        driver.findElement(By.name("email")).sendKeys("igds78^*ui");
        driver.findElement(By.name("phone")).sendKeys("KLJHUIY&*(");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "ФИО введёно неверно\n" +
                "Email введён неверно\n" +
                "Телефон введён неверно";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }

    @Test
    public void testHello2Empty()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо ввести данные!";

        Assert.assertEquals(expectedResult, actualResult);

        driver.quit();
    }
}
