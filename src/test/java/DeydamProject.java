
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.enterprise.inject.Stereotype;


public class DeydamProject {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //test 1. open chrome browser
        driver = new ChromeDriver();
        //test2. input your selenium page demo url or any url you want to test
        driver.get("https://www.deydam.com/login");
        //(now input a command that will ensure the page waits for the loading of the url inputted)
        Thread.sleep(2000);
        //test 3. maximize window
        driver.manage().window().maximize();
        //test 4. click on the sign up button to open the signup page.
        // to copy element you can get by ID,NAME, or xpath,
        // just inspect the webpage and click the element that speaks to what you wanna use
        // then right click to copy by xpath.
        Thread.sleep(1000);
    }

    @Test (priority = 0)
    public void GetPageTitle() throws InterruptedException {
        driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.deydam.com/login"))
            //pass
            System.out.println("Welcome to Dey Dam login page");
        else
            //fail
            System.out.println("User not redirected to Dey Dam login page");
        Thread.sleep(1000);
    }
    //

    @Test (priority = 1)
    public void ClickTheSignUpButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/form/p[2]/span/a")).click();
        Thread.sleep(2000);
        driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.deydam.com/signup"))
            //pass
            System.out.println("Welcome to Dey Dam Sign Up page, Wetin Dey Down?");
        else
            //fail
            System.out.println("User not redirected to Dey Dam signup page");
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    public void ReturnToLoginPage() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/p/span/a")).click();
        Thread.sleep(2000);
        driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.deydam.com/login"))
            //pass
            System.out.println("Welcome to Dey Dam Login page, Please Login to Continue");
        else
            //fail
            System.out.println("User not redirected to Dey Dam login page");
        Thread.sleep(1000);
    }

    @Test (priority = 3)
    public void InputDetailsToLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/form/div/input")).sendKeys("Testify");
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testifier");
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/form/button")).click();
        Thread.sleep(1000);
        driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.deydam.com/app/feed"))
            //pass
            System.out.println("Welcome Testify! We're happy to have you back.");
        else
            //fail
            System.out.println("Login failed");
        Thread.sleep(1000);
    }

    @Test (priority = 4)
    public void Logout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[1]/div/div[1]/div[4]/div/div[2]/div/div/div[2]/div/h4")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div[1]/div/div[2]/div/div/div")).click();
        Thread.sleep(1000);
        driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://www.deydam.com/login"))
            //pass   //*[@id="root"]/div/div[2]/div/main/div/div[1]/div/div[2]/div/div/div
            System.out.println("Log out successful, Please Log in again to continue");
        else
            //fail
            System.out.println("Log out failed");
        Thread.sleep(500);
    }

    @AfterTest
    public void closeBrowser() {
        //quit the browser
        driver.quit();
    }
}

