package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver newDriver;

    public LoginPage(WebDriver loadDriver) {

        newDriver = loadDriver;
        PageFactory.initElements(loadDriver, this);
    }

    @FindBy(xpath = "//img[@class=\"MuiAvatar-img mui-style-1hy9t21\"]")
    @CacheLookup
    WebElement accountIcon;

    @FindBy(xpath = "//p[contains(text(),\"Login\")]")
    @CacheLookup
    WebElement loginBtn;
    @FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth mui-style-1ajje9v\"]")
    @CacheLookup
    WebElement phoneSubmitBtn;
    @FindBy(xpath = "//input[@id=\":r5:\"]")
    @CacheLookup
    WebElement mobileField;

    @FindBy(xpath = "//div[@class=\"mui-style-1ja1tam-submit\"]/button")
    @CacheLookup
    WebElement continueLogin;
    @FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd mui-style-1pwpjow\"]")
    @CacheLookup
    WebElement searchBox;
    @FindBy(xpath = "//div[@class=\"mui-style-dqy2kp-gradient\"]")
    @CacheLookup
    WebElement movieSelect;
    @FindBy(xpath = "//p[contains(text(),\"Cast\")]")
    @CacheLookup
    WebElement movieDetails;

    @FindBy(xpath = "//a/button")
    @CacheLookup
    WebElement moviePlay;

    public void setMobileField(String mobileNbr) {
        mobileField.clear();
        mobileField.sendKeys(mobileNbr);
        mobileField.sendKeys(Keys.RETURN);
    }

    public void setSearchBox() {
        searchBox.clear();
        searchBox.sendKeys("asur");

    }

    public void clickAcc() {
        accountIcon.click();
    }

    public void clickLogin() {

        loginBtn.click();
    }

    public void clickMovie() {
        movieSelect.click();

    }

    public void clickPlay() {
        moviePlay.click();
    }

    public boolean loginCheck() {

        if (searchBox.isDisplayed()) {
            return true;
        } else {

            return false;
        }
    }

    public boolean movieDetails() {

        if (movieDetails.isDisplayed()) {
            return true;
        } else {

            return false;
        }
    }

    public void submitPhone() {
        phoneSubmitBtn.click();
    }

}
