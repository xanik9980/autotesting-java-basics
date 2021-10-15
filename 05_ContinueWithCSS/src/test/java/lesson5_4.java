import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lesson5_4 {

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

    //    1 Для сайта книжного магазина составьте, используя CSS:
    //    Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>. Осуществите поиск только по атрибуту test-info, равному about-us.
    //    Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
    //    Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected. Осуществите поиск только по атрибуту selected.
    //    Локатор на главной странице для элемента <div class="book-price">. Осуществите поиск одновременно по тегу и классу, равному book-price.
    //    Локатор на главной странице для всех элементов с тегом button и с атрибутом class, начинающимся на book.
    //    Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.
    //    Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
    @Test
    public void test1() {
        var aboutUsLocator = By.cssSelector("[test-info = about-us]");
        var emptyLinkLocator = By.cssSelector("a[href = '']");
        var selectedOptionLocator = By.cssSelector("[selected]");
        var bookPriceLocator = By.cssSelector("div.book-price");
        var bookButtonLocator = By.cssSelector("button[class ^= book]");
        var classEndsMainLocator = By.cssSelector("[class $= main]");
        var menuLinkLocator = By.cssSelector("a[class *= menu]");

        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(aboutUsLocator);
        driver.findElement(emptyLinkLocator);
        driver.findElement(bookPriceLocator);
        driver.findElement(bookButtonLocator);
        driver.findElement(classEndsMainLocator);
        driver.findElement(menuLinkLocator);

        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        driver.findElement(selectedOptionLocator);
    }

    //    2 Для сайта книжного магазина составьте CSS-локаторы:
    //    На главной странице найдите все теги div, которые являются дочерними элементами первого уровня у элемента <footer id="footer">.
    //    На главной странице найдите любой тег, который расположен сразу после <li id="genres">.
    //    На странице поиска найдите любые теги, которые расположены после <div class="filter-container"> (необязательно ближайший сосед).
    @Test
    public void test2() {
        var divChildOfFooterLocator = By.cssSelector("#footer > div");
        var genresNextLocator = By.cssSelector("li#genres + *");
        var afterFilterContainerLocator = By.cssSelector("div.filter-container ~ *");

        driver.navigate().to("http://qajava.skillbox.ru/index.html");
        driver.findElement(divChildOfFooterLocator);
        driver.findElement(genresNextLocator);
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
        driver.findElement(afterFilterContainerLocator);
    }

//    5 Для сайта клуба любителей весёлых носков составьте CSS-локаторы, в которых найдите:
    //    Первый тег h1, находящийся сразу на первом уровне вложенности внутри <section class="important-section-block" for="main-header-page">. Используйте поиск по первому child.
    //    Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">. Используйте поиск по child.
    //    Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
    //    Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">. Используйте поиск по type.
    //    По желанию: найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у своего родителя <div class="footer__menuList">, при этом <div class="footer__menuList"> является первым дочерним элементом у своего родителя <div class="footer__menu">. Составленный поиск должен вернуть ровно один найденный элемент.
    @Test
    public void test3() {
        var h1Locator = By.cssSelector("section.important-section-block > h1:first-child");
        var lastPOfFormLocator = By.cssSelector("#login-form > p:last-child");
        var footerLocator = By.cssSelector("body > *:nth-child(3)");
        var firstLinkLocator = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");
        var firstLinkInFirstListLocator = By.cssSelector(".footer__menu > .footer__menuList:nth-of-type(1) > a:nth-of-type(1)");

        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(h1Locator);
        driver.findElement(lastPOfFormLocator);
        driver.findElement(footerLocator);
        driver.findElement(firstLinkLocator);
        driver.findElement(firstLinkInFirstListLocator);
    }
}