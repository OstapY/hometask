import com.codeborne.selenide.SelenideElement;
import com.mysql.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import java.sql.*;

import static com.codeborne.selenide.Selenide.*;

public class SceneTwo {

    String url ="jdbc:mysql://localhost:3306/rozetkadb";
    String username = "root";
    String password = "root";
    String bd="household_chemicals";
    Connection connection;
    Driver driver;
    @Test
    public void ScenTwo() throws SQLException, ClassNotFoundException {
        WebDriverManager.chromedriver().setup();
        driver = new com.mysql.jdbc.Driver();
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
//____________________JDBC preparation__________________________________________________________________

        OpenMainPage();
        OpenCategoryMenu();
        FollowDetergentsCategory();
        OpenDetergents();
        $("#price\\[min\\]").setValue(min);
        $("#price\\[max\\]").setValue(max).pressEnter();
        for(SelenideElement selen:$$(nameSel)){
            if($$(nameSel).size()==$$(priceSel).size()){
                for(int i=0; i<$$(nameSel).size();i++){
                    statement.executeUpdate("insert into household_chemicals(Name, Price)values('"+selen.innerText()+"',"+Integer.parseInt($$(priceSel).get(i).innerText())+")");
                }
            }
            else System.out.println("Кто-то тупанул page1");
        }
        open(pageTwo);
        for(SelenideElement selen:$$(nameSel)){
            if($$(nameSel).size()==$$(priceSel).size()){
                for(int i=0; i<$$(nameSel).size();i++){
                    statement.executeUpdate("insert into household_chemicals(Name, Price)values('"+selen.innerText()+"',"+Integer.parseInt($$(priceSel).get(i).innerText())+")");
                }
            }
            else System.out.println("Кто-то тупанул page 2");
        }
        open(pageThree);
        for(SelenideElement selen:$$(nameSel)){
            if($$(nameSel).size()==$$(priceSel).size()){
                for(int i=0; i<$$(nameSel).size();i++){
                    statement.executeUpdate("insert into household_chemicals(Name, Price)values('"+selen.innerText()+"',"+Integer.parseInt($$(priceSel).get(i).innerText())+")");
                }
            }
            else System.out.println("Кто-то тупанулpage 3");
        }

        connection.close();

    }
    //__________________________________Before_ther_run____________________________________________________
    String rozetkaUrl = ("https://rozetka.com.ua");
    String mainPaigeCategoryCssSel = (".menu-toggler");
    String categoryForHomeCssSel = (".menu-wrapper_state_animated > ul:nth-child(1) > li:nth-child(4)");
    String getCategoryDetergentsCssSel = (".menu-categories__item_state_hovered > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(4) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1)");
    String categoryDetergentsCssSel = ("li.cat-tree-l-i:nth-child(4)");
    String pageTwo="https://rozetka.com.ua/ua/sredstva-dlya-stirki4632103/c4632103/page=2;price=100-300/";
    String pageThree="https://rozetka.com.ua/ua/sredstva-dlya-stirki4632103/c4632103/page=3;price=100-300/";
    String nameSel=".goods-tile__title";
    String priceSel=".goods-tile__price-value";
    String min ="100";
    String max ="300";

    private void OpenMainPage() {
        open(rozetkaUrl);
    }

    private void OpenCategoryMenu() {
        $(mainPaigeCategoryCssSel).click();
    }

    private void FollowDetergentsCategory() {
        $(categoryForHomeCssSel).hover();
        $(getCategoryDetergentsCssSel).click();
    }
    private void OpenDetergents() {
        $(categoryDetergentsCssSel).click();
    }
}

