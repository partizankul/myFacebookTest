import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage {
    WebDriver driver;

    public ForgotPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//div/h1/a/i");
    private By findYouAkkQuestionText = By.xpath("//h2[@class=\"uiHeaderTitle\"][text()=\"Найдите свой аккаунт\"]");
    private By mailOrPhoneField = By.xpath("//*[@id=\"identify_email\"]");
    private By findAkkButton = By.xpath("//*[@id=\"u_0_2\"]");
    private By cancelButton = By.xpath("//*[@class=\"uiButtonText\"]");
    private By mailOrPhoneFieldIsEmptyError = By.xpath("//*[@class=\"fsl fwb fcb\"]");



    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String getFindYouAkkQuestionText (){
        return driver.findElement(findYouAkkQuestionText).getText();
    }
    public ForgotPage clickFindAkkButton(){
        driver.findElement(findAkkButton).click();
        return new ForgotPage(driver);
    }
    public ForgotPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new ForgotPage(driver);
    }
    public ForgotPage mailOrPhoneField(String mailOrPhone){
        driver.findElement(mailOrPhoneField).sendKeys(mailOrPhone);
        return this;
    }
    public ForgotPage findAkk(String mailOrPhone){
        this.mailOrPhoneField(mailOrPhone);
        this.clickFindAkkButton();
        return new ForgotPage(driver);
    }
    public String mailOrPhoneFieldIsEmptyErrorText(){
        return driver.findElement(mailOrPhoneFieldIsEmptyError).getText();
    }
    public ForgotPage mailOrPhoneFieldIsEmpty(){
        this.clickFindAkkButton();

        return this;
    }


}
