import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@Configurable
public class SpringApplicationTests {

    @Autowired
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver.manage().window().maximize();
    }

    @Test
    public void testcase_1() throws InterruptedException {
        driver.navigate().to("https://jqueryui.com/droppable/");
    }

    @Test
    public void testcase_2() throws InterruptedException {
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions a = new Actions(driver);
        a.dragAndDrop(drag, drop).build().perform();
    }

    @Test
    public void testcase_3() throws InterruptedException {
        WebElement drop = driver.findElement(By.id("droppable"));
        Assert.assertEquals(drop.getText(), "Dropped!");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Bean
    public WebDriver getWebDriver() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "http://localhost:8081");
        return new ChromeDriver();
    }
}
