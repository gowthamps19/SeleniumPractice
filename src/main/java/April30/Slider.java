package April30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Slider {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //String url = "https://demo.automationtesting.in/Slider.html";
        String url1 = "https://www.globalsqa.com/demo-site/sliders/#Color%20Picker";
        driver.get(url1);
        driver.manage().window().maximize();
        WebElement fram = driver.findElement(By.xpath("//*[@id=\"post-2673\"]/div[2]/div/div/div[1]/p/iframe"));
        driver.switchTo().frame(fram);
        WebElement cursor = driver.findElement(By.xpath("//div[@id='green']/span"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(cursor,100,0).build().perform();
        driver.switchTo().defaultContent();


        //doing operation in another frame
        driver.findElement(By.id("Steps")).click();
        WebElement fram1 = driver.findElement(By.xpath("//*[@id=\"post-2673\"]/div[2]/div/div/div[3]/p/iframe"));
        driver.switchTo().frame(fram1);
        WebElement stepButton = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
        act.dragAndDropBy(stepButton,300,0).build().perform();
        driver.quit();

        //without using Frames
      /*  WebElement slide = driver.findElement(By.xpath("//div[@id='slider']/a"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(slide,300,0).build().perform();
        Thread.sleep(5000);
        driver.quit();*/

        //Using Frames


    }
}
