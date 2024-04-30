package April30;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Amazon1 {
    public static void main(String[] args) throws InterruptedException, StaleElementReferenceException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        String url = "https://www.amazon.in/";
        driver.get(url);

        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")).click();
        Select options = new Select(driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")));
        List<WebElement> options1 = options.getOptions();
        String ValueToBeSelected = "Electronics";
        for (WebElement op : options1) {
            if (op.getText().equals(ValueToBeSelected)) {
                options.selectByVisibleText(ValueToBeSelected);
                break;
            }
        }
        driver.findElement(By.id("nav-search-submit-button")).click();
        List<WebElement> list = driver.findElements(By.xpath("//span[@dir='auto'][contains(.,'Accessories')]"));
        for (WebElement l : list) {
            if (l.getText().equals("Accessories")) {
                l.click();
                break;
            }
        }
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[2]/div[3]/div[1]/div/div/div/ul/li[1]"))).build().perform();
        driver.findElement(By.xpath("//span[@class=\"a-size-base a-color-base\"][contains(.,'Mobile Phone Accessories')]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
