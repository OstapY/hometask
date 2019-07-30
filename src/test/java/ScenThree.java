import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class ScenThree {



    @Test
    public void ScenThree() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Result sheet");
        OpenMainPage();
        OpenCategoryMenu();
        FollowSphoneCategory();
        $("#price\\[min\\]").setValue(min);
        $("#price\\[max\\]").setValue(max);
        PressOk();
        GetPhoneNamesFromActivePage();
        OpenPageTwo();
        GetPhoneNamesFromActivePage();
        OpenPageThree();
        GetPhoneNamesFromActivePage();
        OpenPageFour();
        GetPhoneNamesFromActivePage();
        OpenPageFive();
        GetPhoneNamesFromActivePage();


    }



    //---------------------Realize Details---------------------------------------------------------
    //-----------------Input Data--------------------------------------------------------------
    String rozetkaUrl = ("https://rozetka.com.ua");
    String mainPaigeCategoryCssSel = (".menu-toggler");
    String categorySmartphoneTvCssSel = (".menu-wrapper_state_animated > ul:nth-child(1) > li:nth-child(2)");
    String categorySmartphoneCssSel = (".menu-categories__item_state_hovered > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1)");
    String smartphoneNameCssSel=(".goods-tile__title");
    String min ="3000";
    String max ="6000";

    //-----------------Before Run--------------------------------------------------------------
    @BeforeClass
    public static void setupWebDriver() {
        WebDriverManager.chromedriver().setup();
    }
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    String nameSel=".goods-tile__title";
    String priceSel=".goods-tile__price-value";

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
        for(SelenideElement selen:$$(nameSel)){
            if($$(nameSel).size()==$$(priceSel).size()){
                for(int i=0; i<$$(nameSel).size();i++){
//__________________________Здесь метод записи в Ексель___________________________________________________
                selen.innerText();
                }
            }
            else System.out.println("Кто-то тупанул page1");
        }
    }
    private void PressOk(){
        $("#submitprice").click();
    }
    private void OpenPageTwo() {
        open("https://rozetka.com.ua/mobile-phones/c80003/page=2;preset=smartfon;price=3000-6000/");

    }
    private void OpenPageThree() {
        open("https://rozetka.com.ua/mobile-phones/c80003/page=3;preset=smartfon;price=3000-6000/");
    }
    private void OpenPageFour() {
        open("https://rozetka.com.ua/mobile-phones/c80003/page=4;preset=smartfon;price=3000-6000/");
    }
    private void OpenPageFive() {
        open("https://rozetka.com.ua/mobile-phones/c80003/page=5;preset=smartfon;price=3000-6000/");
    }
}
