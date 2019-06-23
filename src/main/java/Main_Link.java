/**
 * This main methond is used to run the program to get the links of each job
 * @author jingfei Yang
 * Created by jingfeiyang on 25/08/2017.
 */
public class Main_Link {
    public static void main(String[] args) {

        /**
         * This is used to get the start time, to get the time the program used
         */
        long startTime = System.currentTimeMillis();

        /**
         *
         * Generate a new object of Crawl_Link Class, Crawl_Link is used to get the links of each job
         */
        Crawl_Link Seek = new Crawl_Link();


        /**
         * This is to get the specifical websites's jobs' links
         */
        for(int i = 1; i<=2; i++)
        {
////            Seek.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NSW?page="+i);

            Seek.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-Tasmania-TAS?page=" + i);

        }




//       String googledriver = "/usr/local/bin/chromedriver";
//       String writeDirection = "/Users/jingfeiyang/Desktop/clps/CLPS_Crawl_Seek/data/JobsFromSeek.csv";
//
//        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver",googledriver);
//        driver = new ChromeDriver();
//
//
////        driver.manage().window().maximize();
//        driver.get("https://www.seek.com.au/jobs-in-information-communication-technology?page=2");
//
//
//        List<WebElement> jobs = driver.findElements(By.className("e5uyowV"));
//
//        try
//        {
//            for(WebElement job : jobs)
//            {
////                System.out.println(job.getText());
//                System.out.println();
//
//
//
//                String WholeJob = job.getText();
//                String jobDescription = WholeJob.substring(0,WholeJob.indexOf("\n"));
//                System.out.println(jobDescription);
//                System.out.println();
//
//
//                /////////////////write part//////////////////////////
//                File CSVFile = new File(writeDirection);
//                Writer fileWriter = new FileWriter(CSVFile, true);
//                CSVWriter writer = new CSVWriter(fileWriter, ',');
//
//                String entry[] = {jobDescription};
//
//                writer.writeNext(entry);
//                writer.close();
//
////                Thread.sleep(3000);
//
//               /////////////////////write part////////////////////////
//
//
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//
//        driver.quit();
//
//        Crawl_Link Seek = new Crawl_Link();
//
//        Seek.CrawlIt("https://www.seek.com.au/jobs-in-information-communication-technology");


        /**
         * this is used to get the end time to get the time the program used
         */
        long endTime = System.currentTimeMillis();

        /**
         * print the time the program used
         */
        System.out.println(endTime - startTime);

    }
}
