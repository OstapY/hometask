import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class ScenOne {



    @Test
    public void ScenarioOne() throws IOException {
        writer =new  FileWriter("Result.txt");
        OpenMainPage();
        OpenCategoryMenu();
        FollowSphoneCategory();
        writer.write("      1 Page result: \n___________________________________________________\n");
        GetPhoneNamesFromActivePage();
        OpenPageTwo();
        writer.write("\n       2 Page result: \n___________________________________________________\n");
        GetPhoneNamesFromActivePage();
        OpenPageThree();
        writer.write("\n    3 Page result: \n___________________________________________________\n");
        GetPhoneNamesFromActivePage();
        writer.write("\n_____________________End of list_________________________");
        writer.close();



    }



    //---------------------Realize Details---------------------------------------------------------
    //-----------------Input Data--------------------------------------------------------------
    String rozetkaUrl = ("https://rozetka.com.ua");
    String mainPaigeCategoryCssSel = (".menu-toggler");
    String categorySmartphoneTvCssSel = (".menu-wrapper_state_animated > ul:nth-child(1) > li:nth-child(2)");
    String categorySmartphoneCssSel = (".menu-categories__item_state_hovered > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1)");
    String smartphoneNameCssSel=(".goods-tile__title");

    //-----------------Before Run--------------------------------------------------------------
    FileWriter writer;
    @BeforeClass
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    //------------------Method realize body-----------------------------------------------------

    private void OpenMainPage(){
        open(rozetkaUrl);
    }
    private void OpenCategoryMenu() {
        $(mainPaigeCategoryCssSel).click();
    }
    private void FollowSphoneCategory() {
        $(categorySmartphoneTvCssSel).hover();
        $(categorySmartphoneCssSel).click();
    }
    private void GetPhoneNamesFromActivePage() throws IOException {
        for(SelenideElement selen : $$(smartphoneNameCssSel)){
            writer.write(selen.innerText()+"\n");
        }
    }
    private void OpenPageTwo() {
        open("https://rozetka.com.ua/mobile-phones/c80003/page=2;preset=smartfon/");

    }
    private void OpenPageThree() {
        open("https://rozetka.com.ua/mobile-phones/c80003/page=3;preset=smartfon/");
    }
}
