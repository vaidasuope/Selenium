import org.testng.annotations.*;

public class SeleniumTestNG {
    @BeforeTest
    public void doBeforeRunTest(){
        Selenium.setUp();
    }

    @Test (priority = 0)
    public void searchByKeywordTest() {
        Selenium.searchByKeyword("Baranauskas");
    }

    @Test (priority = 1)
    public void compareResultsNumber(){
        Selenium.compareResultsNumber();
    }

    @AfterTest
    public void closeBrowser(){
        Selenium.close();
    }

}
