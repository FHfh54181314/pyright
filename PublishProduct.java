package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PublishProductTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Desktop\\22\\软件质量测试\\edgedriver_win64\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("http://localhost:8082/#/login");
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/main/div/div[1]/form/div[1]/div/div/input")).sendKeys("david");
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/main/div/div[1]/form/div[2]/div/div/input")).sendKeys("adminpass000");
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/main/div/div[2]/button")).click();
        
      http:
        String expectedUrl = "http://localhost:8082/#/dashboard/good";
          WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @Test
    public void testPublishProduct() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/div[5]/div[1]/table/thead/tr/th[6]/div/div/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[3]/div/div[2]/form/div[1]/div/div/input")).sendKeys("测试商品");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[3]/div/div[2]/form/div[2]/div/div/input")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[3]/div/div[2]/form/div[3]/div/div/input")).sendKeys("image.jpg");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[3]/div/div[2]/form/div[4]/div/div/textarea")).sendKeys("这是一个测试商品");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[3]/div/div[3]/span/button[2]")).click();

        driver.navigate().refresh();

        String productName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/div[3]/table/tbody/tr[5]/td[2]/div")).getText();
        String productPrice = driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/div[3]/table/tbody/tr[5]/td[3]/div")).getText();

        assertTrue(productName.equals("测试商品"));
        assertTrue(productPrice.equals("100"));
    }
}
