package April30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "http://www.dhtmlgoodies.com/packages/dhtml-suite-for-applications/demos/demo-drag-drop-3.html#google_vignette";
        driver.navigate().to(url);
       WebElement source= driver.findElement(By.id("box3"));
       WebElement target = driver.findElement(By.id("box105"));
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        //act.clickAndHold(source).moveToElement(target).release().build().perform();
        act.dragAndDrop(source,target).build().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}
