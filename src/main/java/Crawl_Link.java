import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jingfei Yang
 *
 * This class includes the methond to get the job name and website of the job
 * Created by jingfeiyang on 25/08/2017.
 */
public class Crawl_Link {










    String writeDirection = "";

    String phantomjsdriver = "";

    /**
     * This is the method that used to get the link information from the website
     * <p>
     * This method will get the name of the job and the website of this job
     * And the results will be written to a csv file
     * @param website the website that this class will get links from
     */
    public Boolean Crawlit(String website)
    {




        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability("screen-resolution", "1280x1024");
        caps.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsdriver);

        ArrayList<String> cliArgsCap = new ArrayList<String>();
        cliArgsCap.add("--webdriver-loglevel=NONE");
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
        Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);





        PhantomJSDriverService service = new PhantomJSDriverService.Builder()
                .usingPhantomJSExecutable(new File(phantomjsdriver))
                .withLogFile(null)
                .build();





        System.out.println("Crawlit");
//        String googledriver = "/usr/local/bin/chromedriver";

        /**
         * This method uses phantomjs as the driver to get the information of the website
         * and this is the direction of the phantomjsdriver
         */
//        String phantomjsdriver = "/usr/local/bin/phantomjs";

//        String phantomjsdriver = "/home/testuser02/Peter_Yang/phantomjs";

        /**
         * this is the direction the results will write to
         */
//        writeDirection = "/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/JobsLinks_TAS.csv";



        WebDriver driver;

        /**
         * set the property of phantomjs
         */
        System.setProperty("phantomjs.binary.path",phantomjsdriver);
//        System.setProperty("webdriver.chrome.driver",googledriver);
//        driver = new ChromeDriver();
        driver = new PhantomJSDriver(caps);



//        driver.manage().window().maximize();
        /**
         * get the website using phantomjs
         */
        driver.get(website);


        String wholepage = driver.getPageSource();

        if(wholepage.contains("Sorry, we couldn't find anything. Maybe try taking the following steps…"))
        {
            driver.quit();
            return false;
        }

//        List<WebElement> jobs = driver.findElements(By.className("e5uyowV"));

        /**
         *
         * get each job of thie website
         */
        List<WebElement> jobs = driver.findElements(By.className("_1EkZJQ7"));

//        WebElement eachJob = driver.findElement(By.className("_1EKZJQ7"));

//        System.out.println(eachJob.getText());

//        eachJob.click();
        /**
         *
         *
         * for each website, get the jobtitle and the link
         */
        try
        {
            for(WebElement job : jobs)
            {

                /**
                 * this is to get the job title of the job
                 */
                String jobTitle = job.getText();

                /**
                 * this is used to get the link of the job
                 */
                String jobURL = job.getAttribute("href");

                /**
                 * this is used to put the result in the string[] and then put it in the csv file
                 */
                String entry[] = {jobTitle, jobURL};

//                job.click();
                /**
                 *
                 * print related information
                 */
//                System.out.println(job.getAttribute("href"));
//                System.out.println();


                /**
                 * this is to generate a new object of WriteToCsv
                 */
                HandleCSV seek = new HandleCSV();

                /**
                 * this is used to write the information to the CSV file
                 */
                seek.writeACSV(writeDirection,entry);
//
//
//
//                String WholeJob = job.getText();
//                String jobDescription = WholeJob.substring(0,WholeJob.indexOf("\n"));
//                System.out.println(jobDescription);
//                System.out.println();










                /////////////////write part//////////////////////////
//                File CSVFile = new File(writeDirection);
//                Writer fileWriter = new FileWriter(CSVFile, true);
//                CSVWriter writer = new CSVWriter(fileWriter, ',');
//
//
//
//                writer.writeNext(entry);
//                writer.close();

//                Thread.sleep(3000);

                /////////////////////write part////////////////////////


            }
        }
        catch (Exception e)
        {

            System.out.println("get link wrong");
            e.printStackTrace();
            driver.quit();
        }

        driver.manage().deleteAllCookies();
        
        driver.quit();

        return true;
    }
}
