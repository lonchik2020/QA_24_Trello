package tests;

import models.BoardDto;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Random;

public class BoardsTests extends TestBase {
    @BeforeClass
    public void loginWithData() {
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test
    public void createNewBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000);
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("qa24_" + i)
                .build();
        logger.info(" start test " + method.getName() + " board title---> " + boardDto.getBoardTitle());
        //String boardTitle = "qa24_" + i;
        app.getHelperBoards().createNewBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardDto.getBoardTitle()));
    }


    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle() {
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("  ")
                .build();
        app.getHelperBoards().createNewBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isElementPresent_inputBoardTitle());
    }

    @Test
    public void deleteBoardPositiveTest(Method method){
        int i = new Random().nextInt(1000);
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("qa24_" + i)
                .build();
        logger.info(" start test " + method.getName() + " board title---> " + boardDto.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDto);
        app.getHelperBoards().clickBtnBtnBoards();
        app.getHelperBoards().deleteBoard(boardDto);
        //Assert.assertTrue(); create method isText with wait
    }

//    @AfterMethod
//    public void afterTest() {
//        if (app.getHelperBoards().isElementPresent_boardTitle())
//            app.getHelperBoards().clickBtnBtnBoards();
//        if (app.getHelperBoards().isElementPresent_inputBoardTitle())
//            app.getHelperBoards().clickBtnCloseCreateBoardForm();
//    }


}
