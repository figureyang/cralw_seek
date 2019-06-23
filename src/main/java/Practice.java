import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jingfeiyang on 1/09/2017.
 */
public class Practice {

    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//
//        System.out.println(date.format(new Date()));



        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.seek.com.au/job/34768959?type=standout&userqueryid=7e115caf93e250a9f5ecdee0adbadceb-8339880");

        try
        {
            List<WebElement> canBeCompanyName = driver.findElements(By.className("_3FrNV7v"));
//                    List<WebElement> canBeCompanyName = driver.findElements(By.cssSelector("_3FrNV7v _1djzLEN E6m4BZB"));

            WebElement company1 = canBeCompanyName.get(5);

//            System.out.println(company1.toString());

            String companyNameF = company1.getText();

            String companyName = companyNameF.substring(0,companyNameF.indexOf("\n"));
            System.out.println(companyName);

        }
        catch (Exception e)
        {
            try
            {
                List<WebElement> canBeCompanyName = driver.findElements(By.className("_3FrNV7v"));
//                    List<WebElement> canBeCompanyName = driver.findElements(By.cssSelector("_3FrNV7v _1djzLEN E6m4BZB"));

                WebElement company1 = canBeCompanyName.get(5);

//            System.out.println(company1.toString());

                String companyNameF = company1.getText();

                String companyName = companyNameF;
                System.out.println(companyName);
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
            System.out.println("no companyName");
        }

    }
}
