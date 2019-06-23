import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jingfeiyang on 1/09/2017.
 */
public class Main_Background_SelectAllOfTheState {

    public static String jobLinks = "";//"/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT_NEW.csv";

    public static String jobDetails = "";//"/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT_NEW_Detail.csv";

    public static String databaseURL = "";//"jdbc:mysql://localhost:3306?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    public static String username = "";//"root";

    public static String password = "";//"yjf1992918";

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

        Seek_link.phantomjsdriver = phantomjsDR;



        if(args[0].equals("ALL"))
        {
            /**
             * run ACT
             */
            Boolean runACT = true;
            int iACT = 1;
            while(runACT)
            {
                runACT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-ACT?page=" + iACT);
                iACT ++;

                try
                {
                    if(iACT % 10 == 0)
                    {
                        Thread.sleep(1000);
                        System.out.println("have a reset sleep, ACT");
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iact sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run NSW
             */
            Boolean runNSW = true;
            int iNSW = 1;
            while(runNSW)
            {
                runNSW = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NSW?page=" + iNSW);
                iNSW ++;

                try
                {
                    if(iNSW % 10 == 0)
                    {
                        Thread.sleep(1000);
                        System.out.println("have a reset sleep, iNSW");
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iNSW sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run NT
             */
            Boolean runNT = true;
            int iNT = 1;
            while(runNT)
            {
                runNT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NT?page=" + iNT);
                iNT ++;

                try
                {
                    if(iNT % 10 == 0)
                    {
                        System.out.println("have a reset sleep, NT");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iNT sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run QLD
             */
            Boolean runQLD = true;
            int iQLD = 1;
            while(runQLD)
            {
                runQLD = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-QLD?page=" + iQLD);
                iQLD ++;

                try
                {
                    if(iQLD % 10 == 0)
                    {
                        System.out.println("have a reset sleep, iQLD");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iQLD sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run sa
             */
            Boolean runSA = true;
            int iSA = 1;
            while(runSA)
            {

                runSA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-SA?page=" + iSA);
                iSA ++;
                try
                {
                    if(iSA % 10 == 0)
                    {
                        System.out.println("have a reset sleep, QLD");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iQLD sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run tas
             */
            Boolean runTAS = true;
            int iTAS = 1;
            while(runTAS)
            {

                runTAS = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-TAS?page=" + iTAS);
                iTAS ++;

                try
                {
                    if(iTAS % 10 == 0)
                    {
                        System.out.println("have a reset sleep, TAS");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iTAS sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run VIC
             */

            Boolean runVIC = true;
            int iVIC = 1;
            while(runVIC)
            {
                runVIC = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-VIC?page=" + iVIC);
                iVIC ++;

                try
                {
                    if(iVIC % 10 == 0)
                    {
                        System.out.println("have a reset sleep, VIC");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iVIC sleep");
                    et.printStackTrace();
                }
            }

            /**
             * run WA
             */

            Boolean runWA = true;
            int iWA = 1;
            while(runWA)
            {
                runWA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-WA?page=" + iWA);
                iWA ++;

                try
                {
                    if(iWA % 10 == 0)
                    {
                        System.out.println("have a reset sleep, WA");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iWA sleep");
                    et.printStackTrace();
                }
            }

        }


        if(args[0].equals("ACT"))
        {
            /**
             * run ACT
             */
            Boolean runACT = true;
            int iACT = 1;
            while(runACT)
            {
                runACT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-ACT?page=" + iACT);
                iACT ++;

                try
                {
                    if(iACT % 10 == 0)
                    {
                        Thread.sleep(1000);
                        System.out.println("have a reset sleep, ACT");
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iact sleep");
                    et.printStackTrace();
                }
            }
        }


        else if(args[0].equals("NSW"))
        {
            /**
             * run NSW
             */
            Boolean runNSW = true;
            int iNSW = 1;
            while(runNSW)
            {
                runNSW = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NSW?page=" + iNSW);
                iNSW ++;

                try
                {
                    if(iNSW % 10 == 0)
                    {
                        Thread.sleep(1000);
                        System.out.println("have a reset sleep, iNSW");
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iNSW sleep");
                    et.printStackTrace();
                }
            }
        }

        else if(args[0].equals("NT"))
        {
            /**
             * run NT
             */
            Boolean runNT = true;
            int iNT = 1;
            while(runNT)
            {
                runNT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NT?page=" + iNT);
                iNT ++;

                try
                {
                    if(iNT % 10 == 0)
                    {
                        System.out.println("have a reset sleep, NT");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iNT sleep");
                    et.printStackTrace();
                }
            }
        }


        else if(args[0].equals("QLD"))
        {
            /**
             * run QLD
             */
            Boolean runQLD = true;
            int iQLD = 1;
            while(runQLD)
            {
                runQLD = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-QLD?page=" + iQLD);
                iQLD ++;

                try
                {
                    if(iQLD % 10 == 0)
                    {
                        System.out.println("have a reset sleep, iQLD");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iQLD sleep");
                    et.printStackTrace();
                }
            }
        }

        else if(args[0].equals("SA"))
        {
            /**
             * run sa
             */
            Boolean runSA = true;
            int iSA = 1;
            while(runSA)
            {

                runSA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-SA?page=" + iSA);
                iSA ++;

                try
                {
                    if(iSA % 10 == 0)
                    {
                        System.out.println("have a reset sleep, QLD");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iQLD sleep");
                    et.printStackTrace();
                }
            }
        }

        else if(args[0].equals("TAS"))
        {
            /**
             * run tas
             */
            Boolean runTAS = true;
            int iTAS = 1;
            while(runTAS)
            {

                runTAS = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-TAS?page=" + iTAS);
                iTAS ++;

                try
                {
                    if(iTAS % 10 == 0)
                    {
                        System.out.println("have a reset sleep, TAS");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iTAS sleep");
                    et.printStackTrace();
                }
            }
        }


        else if(args[0].equals("VIC"))
        {
            /**
             * run VIC
             */

            Boolean runVIC = true;
            int iVIC = 1;
            while(runVIC)
            {
                runVIC = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-VIC?page=" + iVIC);
                iVIC ++;

                try
                {
                    if(iVIC % 10 == 0)
                    {
                        System.out.println("have a reset sleep, VIC");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iVIC sleep");
                    et.printStackTrace();
                }
            }
        }



        else if(args[0].equals("WA"))
        {
            /**
             * run WA
             */

            Boolean runWA = true;
            int iWA = 1;
            while(runWA)
            {
                runWA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-WA?page=" + iWA);
                iWA ++;

                try
                {
                    if(iWA % 10 == 0)
                    {
                        System.out.println("have a reset sleep, WA");
                        Thread.sleep(1000);
                    }
                }
                catch (Exception et)
                {
                    System.out.println("iWA sleep");
                    et.printStackTrace();
                }
            }
        }


        List<String[]> websiteDetails = handleCSV.readACSV(jobLinks);



//        Crawl_Details_2 Seek_detail = new Crawl_Details_2();
//
//        Seek_detail.writeDirection = jobDetails;
//
//        Seek_detail.databaseURL = databaseURL;
//
//        Seek_detail.password = password;
//
//        Seek_detail.username = username;
//
//        Seek_detail.CrawlUseHtmlUnit(websiteDetails);



        Crawl_Details Seek_detail = new Crawl_Details();

        Seek_detail.writeDirection = jobDetails;

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
