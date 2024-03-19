package tests;

import manager.ApplicationManager;
import models.UserDto;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();//creation of object

    UserDto user = new UserDto("krasleo@gmail.com", "messi2468");

    @BeforeSuite
    public void setup(){
        app.init();
    }


    @AfterSuite
    public void tearDown(){
        //app.stop();
    }
}
