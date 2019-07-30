import com.codeborne.selenide.SelenideElement;
import com.mysql.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import java.sql.*;

import static com.codeborne.selenide.Selenide.*;

public class ScenTwo {

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
        $("#price\\[min\\]").setValue("100");
        $("#price\\[max\\]").setValue("300");

        for(SelenideElement selen:$$(detergentsCssSel)){
            statement.executeUpdate("insert into household_chemicals(Name, Price)values(')+selen.getAttribute(nameSel)+(',)+selen.getAttribute(priceSel)+())");
        }
        open(pageTwo);
        for(SelenideElement selen:$$(detergentsCssSel)){
            statement.executeUpdate("insert into household_chemicals(Name, Price)values(')+selen.getAttribute(nameSel)+(',)+selen.getAttribute(priceSel)+())");
        }
        open(pageThree);
        for(SelenideElement selen:$$(detergentsCssSel)){
            statement.executeUpdate("insert into household_chemicals(Name, Price)values('"+selen.getAttribute(nameSel)+"',"+selen.getAttribute(priceSel)+")");
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
    String detergentsCssSel = ("");
    String nameSel="";
    String priceSel="";


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