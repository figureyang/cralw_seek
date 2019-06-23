import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main_WA {
    public static String jobLinks = "";//"/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT_NEW.csv";

    public static String jobDetails = "";//"/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT_NEW_Detail.csv";

    public static String databaseURL = "";//"jdbc:mysql://localhost:3306?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    public static String username = "";//"root";

    public static String password = "";//"yjf1992918";



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
        }



        Crawl_Link Seek_link = new Crawl_Link();

        Seek_link.writeDirection = jobLinks;

//        /**
//         * run ACT
//         */
//        Boolean runACT = true;
//        int iACT = 1;
//        while(runACT)
//        {
//            runACT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-ACT?page=" + iACT);
//            iACT ++;
//        }
//
//        /**
//         * run NSW
//         */
//        Boolean runNSW = true;
//        int iNSW = 1;
//        while(runNSW)
//        {
//            runNSW = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NSW?page=" + iNSW);
//            iNSW ++;
//        }
//
//
//        /**
//         * run NT
//         */
//        Boolean runNT = true;
//        int iNT = 1;
//        while(runNT)
//        {
//            runNT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NT?page=" + iNT);
//            iNT ++;
//        }
//
//        /**
//         * run QLD
//         */
//        Boolean runQLD = true;
//        int iQLD = 1;
//        while(runQLD)
//        {
//            runQLD = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-QLD?page=" + iQLD);
//            iQLD ++;
//        }
//
//
//        /**
//         * run sa
//         */
//        Boolean runSA = true;
//        int iSA = 1;
//        while(runSA)
//        {
//
//            runSA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-SA?page=" + iSA);
//            iSA ++;
//        }
//
//
//        /**
//         * run tas
//         */
//        Boolean runTAS = true;
//        int iTAS = 1;
//        while(runTAS)
//        {
//
//            runTAS = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-TAS?page=" + iTAS);
//            iTAS ++;
//        }
//
//        /**
//         * run VIC
//         */
//
//        Boolean runVIC = true;
//        int iVIC = 1;
//        while(runVIC)
//        {
//            runVIC = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-VIC?page=" + iVIC);
//            iVIC ++;
//        }


        /**
         * run WA
         */

        Boolean runWA = true;
        int iWA = 1;
        while(runWA)
        {
            runWA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-WA?page=" + iWA);
            iWA ++;
        }






        Crawl_Details Seek_detail = new Crawl_Details();

        Seek_detail.writeDirection = jobDetails;



        List<String[]> websiteDetails = handleCSV.readACSV(jobLinks);

        Seek_detail.CrawlUseHtmlUnit(websiteDetails);

        HandleDatabase handleDatabase = new HandleDatabase();

        handleDatabase.databaseURL = databaseURL;

        handleDatabase.username = username;

        handleDatabase.password = password;

        handleDatabase.writeToDataBase(jobDetails);




        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
}
