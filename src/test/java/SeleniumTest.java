import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeleniumTest {
    @Before
    public void dpBeforeTest(){
        Selenium.setUp();
    }

    @Test
    public void searchByKeywordTest(){
        Selenium.searchByKeyword("Baranauskas");
        compareResultStringTest();
    }
//sujungiam cia du testus i viena, nes jie priklauso labai visi nuo kito
//
    public void compareResultsNumberTest(){
        int results = Selenium.compareResultsNumber();
        Assert.assertEquals(156000, results);
    }

    public void compareResultStringTest(){
        String results = Selenium.compareResultString();
        Assert.assertEquals("Results", results); // tas pats kas - results.equals("Results")

        //jeigu reikia surasti eilutes dali, naudoti "contains" metoda - results.contains("results")
    }

    @After
    public void close(){
        Selenium.close();
    }

}
