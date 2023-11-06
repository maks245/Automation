package HW_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://store.steampowered.com/");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.xpath("//*[@id='store_nav_search_term']"));
        search.sendKeys("Dota 2");
        search.submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@src, 'https://cdn.akamai.steamstatic.com/steam/apps/124')]")));

        boolean isDisplayed = driver.findElement(By.xpath("//*[contains(@src, 'https://cdn.akamai.steamstatic.com/steam/apps/124')]")).isDisplayed();
        String text = driver.findElement(By.xpath("//*[@class='col search_name ellipsis']//span[contains(text(), 'Dota 2')]")).getText();
        driver.findElement(By.xpath("//*[@id=\"search_resultsRows\"]/a[1]")).click();
        driver.quit();
        System.out.println(isDisplayed);
        System.out.println(text);
    }
}

