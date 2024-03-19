package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class BoardsTests extends TestBase{
    @BeforeClass
    public void loginWithData(){
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test
    public void createNewBoardPositiveTest(){
        int i = new Random().nextInt(1000);
        String boardTitle = "qa24_" + i;
        app.getHelperBoards().createNewBoard(boardTitle);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardTitle));
    }


    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle(){
        app.getHelperBoards().createNewBoard("   ");
        Assert.assertTrue(app.getHelperBoards().isElementPresent_inputBoardTitle());
    }

    @AfterMethod
    public void afterTest(){
        if(app.getHelperBoards().isElementPresent_boardTitle())
            app.getHelperBoards().clickBtnBtnBoards();
        if(app.getHelperBoards().isElementPresent_inputBoardTitle())
            app.getHelperBoards().clickBtnCloseCreateBoardForm();
    }
}
