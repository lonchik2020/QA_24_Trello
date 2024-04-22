package tests;

import manager.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)

public class ProfileTests extends TestBase{
//    @BeforeClass(alwaysRun = true)
//    public void loginWithData() {
//        app.getHelperUser().login(user.getEmail(), user.getPassword());
//    }

    @Test(groups = {"smoke"})
    public void changeAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar("src/test/resources/snow.jpg");
        Assert.assertTrue(app.getHelperProfile().isElementPresent_popUpAvatarAdded(10));
    }


    @Test
    public void changeAvatarNegativeTest_wrongFileFormat(){
        app.getHelperProfile().changeAvatar("src/test/resources/Sean-Connolly---Label.pdf");
        Assert.assertTrue(app.getHelperProfile()
                .isTextToBePresentInAttribute_format_invalid
                        ("alt", "Could not load image, the format is invalid.", 5));
    }

    @AfterMethod
    public void afterTestMethod(){
        if (app.getHelperProfile()
                .isTextToBePresentInAttribute_format_invalid
                        ("alt", "Could not load image, the format is invalid.", 5)){
            app.getHelperProfile().clickBtnCancel();
        }
        app.getHelperProfile().goToTrelloBoardsPage();
    }
}
