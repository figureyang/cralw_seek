import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jingfeiyang on 1/09/2017.
 */
public class Main {

    public static String jobLinks = "";

    public static String jobDetails = "";

    public static String databaseURL = "";

    public static String username = "";

    public static String password = "";

    public static String phantomjsDR = "";

    public static String deletePreviousData = "";

    public static String database = "";


    public static void main(String[] args) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

        long startTime = System.currentTimeMillis();

        String currentLocation = System.getProperty("user.dir");

        String basicInformation = currentLocation + "/TheBasicDetails.csv";

//        String basicInformation = "/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/TheBasicDetails.csv";

        HandleCSV handleCSV = new HandleCSV();

        List<String[]> BasicDetails = handleCSV.readACSV(basicInformation);

        for(String[] BasicDetail : BasicDetails)
        {
           if(BasicDetail[0].equals("jobLinks"))
           {
               jobLinks = BasicDetail[1]+date.format(new Date())+".csv";
           }

           else if (BasicDetail[0].equals("jobDetails"))
           {
                jobDetails = BasicDetail[1]+date.format(new Date())+".csv";
           }

           else if (BasicDetail[0].equals("databaseURL"))
           {
               databaseURL = BasicDetail[1];
           }

           else if (BasicDetail[0].equals("username"))
           {
               username = BasicDetail[1];
           }

           else if (BasicDetail[0].equals("password"))
           {
               password = BasicDetail[1];
           }
           else if (BasicDetail[0].equals("phantomjs"))
           {
                phantomjsDR = BasicDetail[1];
           }
           else if (BasicDetail[0].equals("deletePreviousData"))
           {
               deletePreviousData = BasicDetail[1];
           }
           else if (BasicDetail[0].equals("database"))
           {
               database = BasicDetail[1];
           }
        }



        Crawl_Link Seek_link = new Crawl_Link();

        Seek_link.writeDirection = jobLinks;

//        String entryJobLinks[] = {"JobName","JobLinks"};
//
//        handleCSV.writeACSV(jobLinks,entryJobLinks);

        Seek_link.phantomjsdriver = phantomjsDR;

        Each_State each_state = new Each_State(Seek_link);


        if(args[0].equals("ALL"))
        {

            each_state.runACT();

            each_state.runNSW();

            each_state.runNT();

            each_state.runQLD();

            each_state.runSA();

            each_state.runTAS();

            each_state.runVIC();

            each_state.runWA();

        }


        if(args[0].equals("ACT"))
        {
            each_state.runACT();
        }


        else if(args[0].equals("NSW"))
        {
            each_state.runNSW();
        }

        else if(args[0].equals("NT"))
        {
            each_state.runNT();
        }


        else if(args[0].equals("QLD"))
        {
            each_state.runQLD();
        }

        else if(args[0].equals("SA"))
        {
            each_state.runSA();
        }

        else if(args[0].equals("TAS"))
        {
            each_state.runTAS();
        }


        else if(args[0].equals("VIC"))
        {
            each_state.runVIC();
        }



        else if(args[0].equals("WA"))
        {
            each_state.runWA();
        }


        List<String[]> websiteDetails = handleCSV.readACSV(jobLinks);
        

        Crawl_Details Seek_detail = new Crawl_Details();

        Seek_detail.writeDirection = jobDetails;

//        String entryJobDetails[] = {"JobName","Website","JobTitle","CompanyName","Location","Email","Phone(61-1300-658-700 is the seek service phone number)","Salary","JobDescription","JobDescription2"};
//
//        handleCSV.writeACSV(jobDetails,entryJobDetails);

        Seek_detail.CrawlUseHtmlUnit(websiteDetails);

        HandleDatabase handleDatabase = new HandleDatabase();

        handleDatabase.databaseURL = databaseURL;

        handleDatabase.username = username;

        handleDatabase.password = password;

        handleDatabase.deletePreviousData = deletePreviousData;

        handleDatabase.database = database;

        handleDatabase.writeToDataBase(jobDetails);




        long endTime = System.currentTimeMillis();
        System.out.println("the time used is");
        System.out.println(endTime - startTime);

    }
}
