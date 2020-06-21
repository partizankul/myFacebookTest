import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest {

    private LoginPage loginPage;
    private Logger logger;
    private int countSetUp=0;
    private int countTearDown=0;

    @Before
    public void setUp() {
        countSetUp++;
        logger = Logger.getLogger("new logger");
        logger.info("Start LoginPageTest setUp " + countSetUp+ " time");
        Driver.getDriver().get("https://www.facebook.com/login");
        loginPage = new LoginPage(Driver.getDriver());
        logger.info("Finish LoginPageTest setUp " + countSetUp+ " time");

    }
    @Test
    public void registredMailTest(){
        logger.info("start LoginPageTest test registredMailTest");
        loginPage.registred("", "test");
        logger.info("loginPage.getMailErrorText() = " + loginPage.getMailErrorText());
        Assert.assertEquals("Эл. адрес или номер телефона, который вы указали, не соответствует ни одному аккаунту. Зарегистрируйте аккаунт.", loginPage.getMailErrorText());
        logger.info("finish LoginPageTest test registredMailTest");
    }

    @Test
    public void registredPassTest(){
        logger.info("start LoginPageTest test registredPassTest");
        loginPage.registred("Test@mail.ru", "test");
        Assert.assertEquals("Вы ввели неверный пароль. Забыли пароль?", loginPage.passErrorText());
        logger.info("finish LoginPageTest test registredPassTest");
    }

    @After
    public void tearDown(){
        countTearDown++;
        logger.info("Start LoginPageTest tearDown " + countTearDown+ " time");
        Driver.close();
        logger.info("Finish LoginPageTest tearDown " + countTearDown+ " time");
    }

}