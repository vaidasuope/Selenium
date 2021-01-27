import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    //browser pasideklaruojam kaip globalu kintamaji
    private static WebDriver browser;
    public static final int WAIT_FOR_TIME = 2;

    public static void main(String args[]){
        //atspausdinam su kokiu irankiu dirbam pirmiausia
        System.out.println("Selenium");

        setUp();

        searchByKeyword("Baranauskas");

        compareResults();

        close();
    }
//cia susikuriam atskiras funkcijas konkretiems veiksmams
    public static void setUp (){
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver88.exe");

        browser = new ChromeDriver();
        browser.get("https://www.bing.com");
    }

    //siuo atveju keyword - bet koks paieskos zodis - galima ieskoti pagal id, name, xpath - search laukeliui kok priskirtas html'e
    public static void searchByKeyword (String keyword){
        waitForTimeXpath("//*[@id=\"sb_form_q\"]");
        WebElement searchField = browser.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.ENTER);
    }

    public static void compareResults (){
        WebElement countResults = browser.findElement(By.className("sb_count"));
        System.out.println(countResults.getText());

        //kaip viena eilute reikia rasyti
        String results = countResults.getText()
                .replaceAll("[A-Za-z]", "")
                .replaceAll("[.  ,]","");

        //cia konvertuojam is string in integer
        int results2 = Integer.parseInt(results);

        if (results2>50000){
            System.out.println("Rašytojas yra populiarus!");
        }else {
            System.out.println("Nelabai populiarus");
        }
    }

    public static void close (){
        browser.close();
    }

    public static void waitForTimeXpath(String element){
        WebDriverWait wait = new WebDriverWait(browser, WAIT_FOR_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

};
