import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();

        }else {
            System.out.println("Wrong browser name");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);
        System.out.println(" GET current URL" + driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(" GET current URL" + driver.getCurrentUrl());

        driver.navigate().refresh();

        driver.navigate().forward();
        System.out.println(" GET current URL" + driver.getCurrentUrl());


        //Find Email field element and type the Email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com");

        //find password field element and type password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Prime123");

        //Find login link element and click on it
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();


        driver.quit();
    }
}
