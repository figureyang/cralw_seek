import java.util.List;

/**
 * @author Jingfei Yang
 *
 * Created by jingfeiyang on 25/08/2017.
 *
 * This class is the main class to get the detiled information of every job in the seek
 */
public class Main2_Details {
    public static void main(String[] args) {


        /**
         * this is to get the time of the program
         */
        long startTime = System.currentTimeMillis();


        /**
         * this is to get the direction of the file that the program will read information from, and the file is the
         * file have the basic information (jobtitle and link) of each job
         */
        String readDirection = "/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT.csv";


        /**
         *
         * generating an object of the HandleCSV
         */
        HandleCSV theDetails = new HandleCSV();


        /**
         * generating an object of Crawl_Details
         */
        Crawl_Details eachJob = new Crawl_Details();

        /**
         * read the information of the basic information to the list, then use the list to get the detailed information
         */
        List<String[]> websites = theDetails.readACSV(readDirection);

        eachJob.CrawlUseHtmlUnit(websites);



//        WebDriver driver = new HtmlUnitDriver();
//        driver.get("https://www.seek.com.au/job/34243910?type=standard&userqueryid=4c7f1e73cbeb6352897988341be16b53-0732930");
//
//        WebElement detail = driver.findElement(By.className("templatetext"));
//
//        System.out.println(detail.getText());
//
//        String phantomjsdriver = "/usr/local/bin/phantomjs";
//
//        String writeDirection = "/Users/jingfeiyang/Desktop/clps/CLPS_Crawl_Seek/data/JobsLinks.csv";
//
//
//
////        WebDriver driver;
////
////        System.setProperty("phantomjs.binary.path",phantomjsdriver);
////
////        driver = new PhantomJSDriver();
////        driver.get("https://www.seek.com.au/job/34105941?type=standard&userqueryid=132bf9afd02e341071614907b92d1843-5846418");
//
//        String wholePage = driver.getPageSource();
//
////        String lastEmail = wholePage.substring(wholePage.indexOf("@"),wholePage.indexOf("@")+10);
//
//
//
//        WebElement title = driver.findElement(By.className("jobtitle"));
//
//
//
//        System.out.println(title.getText());
//
//        List<WebElement> details = driver.findElements(By.tagName("p"));
//        List<WebElement> details2 = driver.findElements(By.tagName("strong"));
//        List<WebElement> details3 = driver.findElements(By.tagName("br"));
//
//        String combinedDetails = "";
//
//        for(WebElement detail : details)
//        {
//            combinedDetails = combinedDetails + detail.getText().replace("\n"," ");
//        }
//
//        for(WebElement detail2 : details2)
//        {
//            combinedDetails = combinedDetails + detail2.getText().replace("\n"," ");
//        }
//
//        for(WebElement detail3 : details3)
//        {
//            combinedDetails = combinedDetails + detail3.getText().replace("\n"," ");
//        }
//
//
////        wrong
////        String emailPart = wholePage.substring(combinedDetails.substring(0,combinedDetails.indexOf("@")).lastIndexOf(" ")+1,combinedDetails.indexOf(" ",combinedDetails.indexOf("@")));
////        wrong
//
//
//        if(combinedDetails.contains("@")) {
//
//            String emailPart = combinedDetails.substring(combinedDetails.substring(0,combinedDetails.indexOf("@")).lastIndexOf(" ")+1,combinedDetails.indexOf(" ",combinedDetails.indexOf("@")));
//            System.out.println(emailPart);
//        }
//
//        String[] locations = new String[] {" Canberra ", " Melbourne ", " Adelaide ", " Brisbane ", " Darwin ", " Hobart ", " Perth ", " Sydney ", " ACT ", " NSW ", " NT ", " QLD ", " SA ", " TAS ", " VIC ", " WA "};
//
//        List<WebElement> attributes = driver.findElements(By.className("lwHBT6d"));
//
//
//        for(WebElement attribute : attributes)
//        {
//            if (attribute.getText().contains("$"))
//            {
//                System.out.println(attribute.getText());
//            }
////            System.out.println(attribute.getText());
//        }
//
//
//
//        if(wholePage.contains("+61"))
//        {
//            String phone = wholePage.substring(wholePage.indexOf("+61"),wholePage.indexOf("+61")+16);
//            System.out.println(phone);
//        }
//
//        if(combinedDetails.contains("+61"))
//        {
//            String phone = combinedDetails.substring(combinedDetails.indexOf("+61"),combinedDetails.indexOf("+61")+16);
//            System.out.println(phone);
//        }
//
//
//
//
//        System.out.println(combinedDetails);
//        for (String location : locations)
//        {
//            if (wholePage.contains(location))
//            {
//                System.out.println(location.replaceAll(" ",""));
//                break;
//            }
//        }
//
//        if (wholePage.contains("Sydney"))
//        {
//            System.out.println("Sydney");
//        }
//
//
//
//        driver.quit();
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
