package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
//        String email = "krasleo@gmail.com";
//        String password = "messi2468";
        app.getHelperUser().login(user.getEmail(),user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent_btnAccount());

    }
}
