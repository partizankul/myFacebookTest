import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForgetPageTest {
    private ForgotPage forgotPage;
    private Logger logger;
    private int countSetUp=0;
    private int countTearDown=0;

    @Before
    public void setUp(){
        countSetUp++;
        logger = Logger.getLogger("new logger");
        logger.info("Start ForgetPageTest setUp " + countSetUp+ " time");
        Driver.getDriver().get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login");
        forgotPage = new ForgotPage(Driver.getDriver());
        logger.info("Finish ForgetPageTest setUp " + countSetUp+ " time");
    }
    @Test
    public void getHeadingTest(){
        logger.info("Start ForgetPageTest getHeadingTest");
        Assert.assertEquals("Facebook", forgotPage.getHeadingText());
        logger.info("Finesh ForgetPageTest getHeadingTest");
    }
    @Test
    public void getFindYouAkkQuestionTest(){
        logger.info("Start ForgetPageTest getFindYouAkkQuestionTest");
        Assert.assertEquals("Найдите свой аккаунт", forgotPage.getFindYouAkkQuestionText());
        logger.info("Finesh ForgetPageTest getFindYouAkkQuestionTest");
    }
    @Test
    public void findAkkTest(){
        logger.info("Start ForgetPageTest findAkkTest");
        forgotPage.findAkk("test@gmail.com");
        logger.info("Finish ForgetPageTest findAkkTest");
    }
    @Test
    public void mailOrPhoneFieldIsEmptyErrorTest(){
        forgotPage.mailOrPhoneFieldIsEmpty();
        Assert.assertEquals("Заполните хотя бы одно поле", forgotPage.mailOrPhoneFieldIsEmptyErrorText());
    }


    @After
    public void tearDown(){
        countTearDown++;
        logger.info("Start ForgetPageTest tearDown " + countTearDown+ " time");
        Driver.close();
        logger.info("Finish ForgetPageTest tearDown " + countTearDown+ " time");
    }
}
