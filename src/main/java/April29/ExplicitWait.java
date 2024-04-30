package April29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
       // WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(180));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        long start = System.currentTimeMillis();

        driver.get("https://www.amazon.in/");
        long finish = System.currentTimeMillis();
        long totalTime = finish - start;
        System.out.println("Total Time for page load - "+totalTime);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shampoo");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        List<WebElement> d = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
      // List<WebElement> d =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"]")));
        System.out.println(d.size());
        boolean flage = false;

        for(WebElement d1:d){
           //System.out.println(d1.getText());

            if(d1.getText().contains("Shampoo")|| d1.getText().contains("shampoo")){
                System.out.println("if :"+d1.getText());
                flage=true;
            }
            else if (d1.getText().isEmpty()){
                System.out.println("EMPTY STRING");
                flage=false;
                break;
            }
            else{
                flage=false;
                break;
            }

        }
       if(flage)
        System.out.println("Test case Passed");
       else
           System.out.println("Test case failed");

        driver.quit();
    }
}