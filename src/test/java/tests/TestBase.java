package tests;

import manager.ApplicationManager;
import manager.PropertiesReader;
import models.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    static ApplicationManager app = new ApplicationManager();//creation of object

    //UserDto user = new UserDto("krasleo@gmail.com", "messi2468");
    UserDto user = new UserDto(PropertiesReader.getProperty("email"), PropertiesReader.getProperty("password"));



    @BeforeSuite(alwaysRun = true)
    public void setup(){
        logger.info(" login with email----> " + user.getEmail()+ " password----> " + user.getPassword());
        app.init();
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }
}
