import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainPageTest {

    private MainPage mainPage;
    private Logger logger;
    private int countSetUp=0;
    private int countTearDown=0;

    @Before
    public void setUp(){
        countSetUp++;
        logger = Logger.getLogger("new logger");
        logger.info("Start MainPageTest setUp " + countSetUp+ " time");
        Driver.getDriver().get("https://www.facebook.com/");
        mainPage = new MainPage((Driver.getDriver()));
        logger.info("Finish MainPageTest setUp " + countSetUp+ " time");
    }

    @Test
    public void logoTest(){
        logger.info("Start MainPageTest logoTest");
        Assert.assertEquals("Facebook", mainPage.getLogoText());
        logger.info("Finish MainPageTest logoTest");
    }
    @Test
    public void getCreatAkkTest(){
        logger.info("Start MainPageTest getCreatAkkTest");
        Assert.assertEquals("Регистрация", mainPage.getCreatAkkText());
        logger.info("Finish MainPageTest getCreatAkkTest");
    }

    @Test
    public void setName(){
        logger.info("Start MainPage setName");
       mainPage.singUpAcc("myName", "myLastname", "test@gmail.com", "1234Test");

        logger.info("Finis MainPage setName");
    }


    @After
    public void tearDown(){
        countTearDown++;
        logger.info("Start MainPageTest tearDown " + countTearDown+ " time");
        Driver.close();
        logger.info("Finish MainPageTest tearDown " + countTearDown+ " time");
    }
}
