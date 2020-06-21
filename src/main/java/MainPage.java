import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By logo = By.xpath("//*[@class=\"fb_logo img sp_PtoC_M4ckZu sx_a6eeb2\"]");
    private By creatAkkText = By.xpath("//*[text()=\"Регистрация\"]");
    private By firstNameField = By.xpath("//*[@name=\"firstname\"]");
    private By lastNameField = By.xpath("//*[@name=\"lastname\"]");
    private By numberPhoneOrMailField = By.xpath("//*[@name=\"reg_email__\"]");
    private By newPassField = By.xpath("//*[@name=\"reg_passwd__\"]");
    private By sexRadioButton = By.xpath("//*[@name=\"sex\"][@id=\"u_0_7\"]");
    private By regButton = By.xpath("//*[@name=\"websubmit\"]");

    public String getLogoText(){
        return driver.findElement(logo).getText();
    }
    public String getCreatAkkText(){
        return driver.findElement(creatAkkText).getText();
    }
    public MainPage typeFirstName(String firstname){
        driver.findElement(firstNameField).sendKeys(firstname);
        return this;
    }
    public MainPage typeLastName(String lastname){
        driver.findElement(lastNameField).sendKeys();
        return this;
    }
    public MainPage typeNumberPhoneOrMail(String phoneOrMail){
        driver.findElement(numberPhoneOrMailField).sendKeys();
        return this;
    }
    public MainPage typeNewPass(String pass){
        driver.findElement(newPassField).sendKeys();
        return this;
    }
    public MainPage clickSexRadioButton(){
        driver.findElement(sexRadioButton).click();
        return new MainPage(driver);
    }
    public MainPage clicRegButton(){
        driver.findElement(regButton).click();
        return new MainPage(driver);
    }

    public MainPage singUpAcc(String firstname, String lastname, String numberPhoneOrMail, String pass){
       this.typeFirstName(firstname);
       this.typeLastName(lastname);
       this.typeNumberPhoneOrMail(numberPhoneOrMail);
       this.typeNewPass(pass);
       this.clickSexRadioButton();
       this.clicRegButton();
     return new MainPage(driver);
    }


}
