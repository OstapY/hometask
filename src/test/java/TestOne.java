import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestOne {


    @Test
    public void Test() {
        OpenMainPage();
        ChoosePageObjectAndSetValue(nameSingIn, lognName);
        ChoosePageObjectAndSetValue(passSingIN, lognPass);
        ChoosePageObjectAndClick(loginButton);
        $(By.linkText("Flights")).click();
        ChoosePageObjectAndClick(oneWay);
        ChoosePageObjectAndSelectOption(passenWriper,"4");
        ChoosePageObjectAndClick(oneWay);
        ChoosePageObjectAndSelectOption(departingWriper, "Frankfurt");
        ChoosePageObjectAndSelectOption(depMonthWriper, "10");
        ChoosePageObjectAndSelectOption(depDayWriper, "3");
        ChoosePageObjectAndSelectOption(arrivingWriper, "Paris");
        ChoosePageObjectAndSelectOption(arriMonthWriper,"10");
        ChoosePageObjectAndSelectOption(arriDayWriper,"9");
        ChoosePageObjectAndClick(firstClass);
        ChoosePageObject(airlineWriper);
        object.selectOption(2);
        ChoosePageObjectAndClick(acceptButton);
        ChoosePageObjectAndClick(depSecondFlight);
        ChoosePageObjectAndClick(arriThirdFlight);
        ChoosePageObjectAndClick(secApplyButton);
        ChoosePageObjectAndClick(payOutButton);


    }


    //---------------------Realize Details---------------------------------------------------------
    SelenideElement object;
    //-----------------Input Data--------------------------------------------------------------
    String lognName="bary";
    String lognPass="bary";
    //-----------------Links------------------------------------------------------------------
    String mainUrl = ("http://newtours.demoaut.com");


    //-----------------CSS--------------------------------------
    String nameSingIn = ("[name=userName]");
    String passSingIN = ("[name=password]");
    String loginButton = ("[name=login]");
    String oneWay = ("[value=oneway]");
    String roundTrip = ("[value=roundtrip]");
    String passenWriper = ("[name=passCount]");
    String departingWriper = ("[name=fromPort]");
    String depMonthWriper = ("[name=fromMonth]");
    String depDayWriper = ("[name=fromDay]");
    String arrivingWriper = ("[name=toPort]");
    String arriMonthWriper = ("[name=toMonth]");
    String arriDayWriper = ("[name=toDay]");
    String bussClass= ("[value=Business]");
    String firstClass= ("[value=First]");
    String airlineWriper = ("[name=airline]");
    String acceptButton = ("[name=findFlights]");
    String depSecondFlight = ("table:nth-child(9) tb ody:nth-child(1) tr:nth-child(5) td.frame_action_xrows > input:nth-child(1)");
    String arriThirdFlight = ("table:nth-child(10) tbody:nth-child(1) tr:nth-child(7) td.frame_action_xrows > input:nth-child(1)");
    String secApplyButton = ("[name=reserveFlights]");
    String payOutButton = ("[name=buyFlights]");



    //-----------------Before Run--------------------------------------------------------------
    @BeforeClass
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }


    //------------------Method realize body-----------------------------------------------------

    private void OpenMainPage() {
        open(mainUrl);
    }
    private void ChoosePageObjectAndClick(String objectCss){
        String result;
        result=objectCss;
        object = $(result);
        object.click();
    }

    private void ChoosePageObject(String objectCss){
        String result;
        result=objectCss;
        object = $(result);
    }

    private void ChoosePageObjectAndSetValue(String objectCss, String value){
        String result=objectCss;
        String text=value;
        object = $(result);
        object.setValue(text);
    }
    private void ChoosePageObjectAndSelectOption(String objectCss, String value){
        String result=objectCss;
        String text=value;
        object = $(result);
        object.selectOptionByValue(text);
    }
}