package StepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Steps {
    WebDriver driver;
    public LoginPage lp;

    @Given("the user is on jio login page")
    public void the_user_is_on_jio_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.jiocinema.com/");
        driver.manage().window().maximize();
        System.out.println("In Login page");
    }

    @When("jio login page")
    public void jio_login_page() {
        lp = new LoginPage(driver);
        lp.clickAcc();
        lp.clickLogin();
        System.out.println("Login success");
    }

    @And("the user enters a jio valid phone number {string}")
    public void the_user_enters_a_jio_valid_phone_number(String phoneNumber) throws InterruptedException {
        Thread.sleep(3000);
        lp.setMobileField(phoneNumber);
        Thread.sleep(3000);
        System.out.println("Hit submit");
        //lp.submitPhone();
        Thread.sleep(12000);
    }

    @Then("hits jio submit")
    public void hits_jio_submit() throws InterruptedException {
        //Enter OTP manually, to automate this step Appium required
        System.out.println("Wait For OTP");
        Assert.assertEquals(true, lp.loginCheck());
        Thread.sleep(9000);
        lp.setSearchBox();

    }

    @When("OTP accepted select movie")
    public void otp_accepted_select_movie() throws InterruptedException {

        Thread.sleep(6000);
        lp.clickMovie();
        Thread.sleep(6000);
        boolean movieDetails = lp.movieDetails();
        Assert.assertEquals(true, movieDetails);
        System.out.println("Ready to play movie");
    }

    @And("Movie Played")
    public void movie_played() throws InterruptedException {

        lp.clickPlay();
        Thread.sleep(6000);
        String name = driver.findElement(By.xpath("//h1")).getText();
        System.out.println((name));
        if (name.contains("Asur")) {
            assert true;
        } else {
            assert false;
        }
    }

    @Then("Close Browser")
    public void close_browser() {
        driver.quit();
    }
}
