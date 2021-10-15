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

public class lesson8 {

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

    @Test
    public void testXPathLocators()
    {
        //    Для сайта домашнего кинотеатра составьте XPath-локаторы следующих элементов:
//    Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
//    Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум классам. <a href="#" class="da-link button">Узнать больше</a>
//    Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
//    Все элементы, у которых класс начинается на слова button.
//    Кнопка «Подписаться сейчас».
//    Все картинки клиентов из раздела «Наши клиенты». Для уточнения локатора используйте указание ближайшего родительского элемента с ID.
//    Необязательное задание. Все элементы с ценами тарифов, следующих после тарифа «Любительский».
//    Необязательное задание. Все поля для ввода в форме «Скажите “Привет”», которые предшествуют полю «* Текст сообщения».

        By previousButtonLocator = By.xpath("//span[@class = 'da-arrows-prev']");
        By learnMoreLocator = By.xpath("//a[@class = 'da-link button'][.= 'Узнать больше']");
        By noActiveFilterLocator = By.xpath("//li[@class = 'filter'][not(contains(@class, 'active'))]");
        By anyButtonLocator = By.xpath("//*[starts-with(@class, 'button')]");
        By subscribeNowButtonLocator = By.xpath("//a[.= 'Подписаться сейчас']");
        By clientsPhotoLocator = By.xpath("//div[@id = 'clients']//img");
        By proPremiumPricesLocator = By.xpath("//div[@class = 'price-table row-fluid']/div/following-sibling::div//li[@class = 'price']");
        By formInputsLocator = By.xpath("//form[@id = 'contact-form']//input");


//    Для сайта онлайн-института составьте XPath-локаторы следующих элементов:
//    Заголовок пятого курса.
//    Элемент с учебным периодом последнего курса.
//    Необязательное задание. Все div, которые являются непосредственными родителями для ссылок с href='#'.
//    Необязательное задание. Преобразуйте предыдущий локатор, чтобы он возвращал пятый элемент.
//    Необязательное задание. Все родительские элементы заголовка «Все курсы».

        By fifthCourseLocator = By.xpath("(//span[@class = 'baseCard__title'])[5]");
        By lastCourseDurationLocator = By.xpath("((//div[@class = 'baseCard__content'])[last()]//div[@class = 'baseCondition'])[last()]/p");
        By divWithFollowEmptyLinkLocator = By.xpath("//a[@href='#']/parent::div");
        By div5WithFollowEmptyLinkLocator = By.xpath("(//a[@href='#']/parent::div)[5]");
        By allAncestorsOfAllCoursesTitleLocator = By.xpath("//div[@class = 'pageCreate__title']/ancestor::*");


//    Применяя правила построения хороших локаторов, составьте XPath-локаторы для следующих элементов на сайте книжного магазина:
//    Ссылка «О магазине» в футере.
//    Заголовок «Бестселлеры».
//    Строка поиска.
//    Итоговая сумма заказа в корзине.
//    Заголовок «Ваш заказ: в корзине.
//    Кнопка «Отменить» на странице поиска.

        By aboutUsInFooterLocator = By.xpath("//a[.= 'О магазине']");
        By bestsellersTitleLocator = By.xpath("//h1[.= 'Бестселлеры']");
        By searchInputLocator = By.xpath("//*[@id = 'search-input']");
        By totalPriceLocator = By.xpath("//*[@id = 'total']");
        By yourOrderLocator = By.xpath("//*[@id = 'order-info']//*[contains(., 'Ваш заказ: ')]");
        By cancelLocator = By.xpath("//*[.= 'Отменить']");
    }
}

