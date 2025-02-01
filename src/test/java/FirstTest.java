import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {
    //-------------------Global Variables-----------------------------------
//Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "http://www.google.com";
    //----------------------Test Setup-----------------------------------
    @BeforeClass
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
//Create a new ChromeDriver
        driver = new ChromeDriver();
//Go to site
        driver.navigate().to(testURL);
    }
    @Test(priority = 1)
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("thomann");
        searchTextBox.submit();
        Thread.sleep(25000);

        driver.findElement(By.xpath("/html/body/div[3]/div/div[12]/div/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/button[1]/span")).click();


        WebElement testLink =
                driver.findElement(By.xpath("/html/body/main/div[1]/h1")
                );
        Assert.assertEquals(testLink.getText(), "Welcome to Thomann");
        System.out.print(testLink.getText());
    }

    @Test(priority = 2)
    public void testProductSearch() throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath("/html/body/header/div/div[2]/div[2]/form/div/input[1]"));
        searchBox.sendKeys("Gibson Les Paul");
        searchBox.submit();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/a[2]/div[1]/div[1]/span[2]")).click();
        Thread.sleep(3000);
        
        WebElement firstResult = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div[2]/div[1]/h1"));
        Assert.assertTrue(firstResult.getText().contains("Gibson"), "Rezultati pretrage nisu relevantni.");
    }

    @Test(priority = 3)
    public void testAddToCart() throws InterruptedException {
        //WebElement searchBox = driver.findElement(By.name("query"));
        WebElement searchBox = driver.findElement(By.xpath("/html/body/header/div/div[2]/div[2]/form/div/input[1]"));
        searchBox.sendKeys("Gibson Les Paul");
        searchBox.submit();
        Thread.sleep(4000);

        WebElement firstProduct = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div/a[2]/div[1]/div[1]/span[2]"));

        firstProduct.click();
        Thread.sleep(4000);

        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div[3]/div/div[2]/div[4]/form/div[2]/button[1]"));
        addToCartButton.click();
        Thread.sleep(4000);


        WebElement cartProductTitle = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[1]/div[1]/a/div[1]"));
        Assert.assertTrue(cartProductTitle.getText().contains("Gibson"), "Proizvod nije dodan u košaricu.");
    }

    @Test(priority = 4)
    public void testRemoveFromCart() throws InterruptedException {
        WebElement cart = driver.findElement(By.xpath("/html/body/header/div/div[3]/div/div[3]/a/span"));

        cart.click();
        Thread.sleep(3000);

        WebElement removeFromCartButton = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]"));
        removeFromCartButton.click();
        Thread.sleep(3000);

        //WebElement cartProductTitle = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[1]/div[1]/a/div[1]"));

        WebElement testLink =
                driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[2]/div/div/div[1]/div/div/div")
                );
        Assert.assertEquals(testLink.getText(), "Your shopping basket is empty at the moment.");
    }

    @Test(priority = 5)
    public void testHomeButtonRedirect() throws InterruptedException {
        String expectedHomeURL = "https://www.thomannmusic.com/"; // Zamijeni sa stvarnim URL-om početne stranice
        Thread.sleep(3000);

        WebElement homeButton = driver.findElement(By.xpath("/html/body/header/div/div[2]/div[1]/a/div[1]"));
        homeButton.click();
        Thread.sleep(3000);

        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(currentURL, expectedHomeURL, "Gumb ne vraća na početnu stranicu!");
    }


    //---------------Test TearDown-----------------------------------
    @AfterClass
    public void teardownTest() {
//Close browser and end the session
        driver.quit();
    }
}