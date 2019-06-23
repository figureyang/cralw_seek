import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.logging.Level;

public class Crawl_Details_2 {
    String writeDirection = "";

    String databaseURL = "";

    String username = "";
    String password = "";

    public void CrawlUseHtmlUnit(List<String[]> Websites)
    {
        /**
         * generating an object of the HandleCSV
         */
        HandleCSV handleCSV = new HandleCSV();

        /**
         * This is the direction that the information will write to
         */
//        writeDirection = "/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsDetails_NT_PRACTICE_2.csv";


        /**
         * Handle each link and get its detailed information
         */
        int count = 1;

        for(String Website[] : Websites)
        {
            String jobTitle = Website[0];
            String newJobtitle = "null";
            String location = "null";
            String salary = "0";
            String phone = "0000000000";
            String email = "@@@@@@@@@@";
            String JD = "null";
            String websiteURL = Website[1];
            String tagedDetails = "";


            /**
             * this program uses the htmlunitdriver
             */
            WebDriver driver = new HtmlUnitDriver();
            driver.get(Website[1]);


            java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);

            try
            {
                /**
                 * get the whole's page's data
                 */
                String wholePage = driver.getPageSource();

//        String lastEmail = wholePage.substring(wholePage.indexOf("@"),wholePage.indexOf("@")+10);


                try
                {
                    /**
                     * get the job's title again in case there are some change happened
                     */
                    WebElement title = driver.findElement(By.className("jobtitle"));
                    newJobtitle = title.getText();
//                System.out.println();


                }
                catch (Exception e)
                {
                    System.out.println("no jobtitle");
                }


                /**
                 * combinedDetails is the most important of te job, like job description or something
                 */
                String combinedDetails = "";

                try
                {
                    /**
                     * firt way is to get the text of the class templatetext, it is the most imporant class of the
                     * job's details
                     */
                    List<WebElement> details4 = driver.findElements(By.className("templatetext"));


                    for(WebElement detail4 : details4)
                    {

                        combinedDetails = combinedDetails + detail4.getText().replace("\n"," ");
                    }

                }
                catch (Exception e)
                {
                    System.out.println("no templatetext");
                    try
                    {
                        /**
                         * if the templatetext does not exist, can use other tags like p strong and br
                         * to get the details of each job
                         */
                        List<WebElement> details = driver.findElements(By.tagName("p"));
                        List<WebElement> details2 = driver.findElements(By.tagName("strong"));
                        List<WebElement> details3 = driver.findElements(By.tagName("br"));




                        for(WebElement detail : details)
                        {
                            combinedDetails = combinedDetails + detail.getText().replace("\n"," ");
                        }

                        for(WebElement detail2 : details2)
                        {
                            combinedDetails = combinedDetails + detail2.getText().replace("\n"," ");
                        }

                        for(WebElement detail3 : details3)
                        {
                            combinedDetails = combinedDetails + detail3.getText().replace("\n"," ");
                        }
                    }
                    catch (Exception e1)
                    {
                        System.out.println("no detail");
                    }
                }

                /**
                 * give the value to JD
                 */
                JD = combinedDetails;
//        wrong
//        String emailPart = wholePage.substring(combinedDetails.substring(0,combinedDetails.indexOf("@")).lastIndexOf(" ")+1,combinedDetails.indexOf(" ",combinedDetails.indexOf("@")));
//        wrong

                /**
                 * this is to get the email address of this job's company
                 *
                 * I use the combinedDetails to get the details of the email
                 *
                 *
                 */
                try
                {
                    if(combinedDetails.contains("@")) {

//                        System.out.println("in get email");
//
//                        System.out.println("this is combined email :" + combinedDetails);

                        combinedDetails.replaceAll("\n", " ");

//                        System.out.println("this is the second combined email :" + combinedDetails);

                        String emailPart = "@@@@@@";

//                        System.out.println(combinedDetails.indexOf("@"));
                        try
                        {
                            /**
                             * first way is to use the @ and the space after the email to get the email address
                             */
                            emailPart = combinedDetails.substring(combinedDetails.substring(0,combinedDetails.indexOf("@")).lastIndexOf(" ")+1,combinedDetails.indexOf(" ",combinedDetails.indexOf("@")));
//                System.out.println(emailPart);
                        }
                        catch (Exception e_space)
                        {
                            try
                            {
                                /**
                                 * second way is to use the @ to the end to get the email of the job
                                 */
                                emailPart = combinedDetails.substring(combinedDetails.substring(0,combinedDetails.indexOf("@")).lastIndexOf(" ")+1,combinedDetails.length());
                            }
                            catch (Exception e_end)
                            {
                                System.out.println("no email for space");
                            }

                            System.out.println("can not use @");

                            e_space.printStackTrace();
                        }



//                        System.out.println("get the email");
                        email = emailPart;
                    }
                }
                catch (Exception e_email)
                {
                    System.out.println("don't have email");
                    e_email.printStackTrace();
                }


                /**
                 * this is used to get the salary and other details of the job
                 */
                List<WebElement> attributes = driver.findElements(By.className("lwHBT6d"));


                /**
                 * this is used to get the salary
                 */
                for(WebElement attribute : attributes)
                {
                    if (attribute.getText().contains("$"))
                    {
                        salary = attribute.getText();
                    }
//            System.out.println(attribute.getText());
                }


                /**
                 * this is used to get the phone number
                 */
                if(wholePage.contains("+61"))
                {
                    phone = wholePage.substring(wholePage.indexOf("+61"),wholePage.indexOf("+61")+20);
//                System.out.println(phone);
                }

                if(combinedDetails.contains("+61"))
                {
                    phone = combinedDetails.substring(combinedDetails.indexOf("+61"),combinedDetails.indexOf("+61")+20);
//                System.out.println(phone);
                }

                /**
                 * this is used to get the location of the job
                 */
                String[] locations = new String[] {" Canberra ", " Melbourne ", " Adelaide ", " Brisbane ", " Darwin ", " Hobart ", " Perth ", " Sydney ", " ACT ", " NSW ", " NT ", " QLD ", " SA ", " TAS ", " VIC ", " WA "};

                for (String theLocation : locations)
                {
                    if (wholePage.contains(theLocation))
                    {
                        location = theLocation.replaceAll(" ","");
//                    System.out.println(theLocation.replaceAll(" ",""));
                        break;
                    }
                }


                /**
                 * this is used to get the whole contents of the important information of the job
                 *
                 * this includes all of the tags and attributes
                 */
                if(wholePage.contains("<div class=\"details\">"))
                {
                    /**
                     * first use the <div class="templatetext"> and <div class="details"> to get the contents
                     */
                    tagedDetails = wholePage.substring(wholePage.indexOf("<div class=\"templatetext\">"), wholePage.indexOf("<div class=\"details\">"));
                }

                else
                {
                    /**
                     * second is to use the <div class="templatetext"> and <div> to get the content
                     */
                    tagedDetails = wholePage.substring(wholePage.indexOf("<div class=\"templatetext\">"), wholePage.indexOf("</div>",wholePage.indexOf("<div class=\"templatetext\">"))+6);
                }





//                System.out.println(tagedDetails);

//                driver.quit();


            }
            catch (Exception e0)
            {
                System.out.println("no such page");
            }

            /**
             * this is put all of the information to the string[] and then write it to the file
             */
            String entry[] = {jobTitle, websiteURL, newJobtitle, location, email, phone, salary, JD, tagedDetails};

            /**
             * this is to write the information in the file
             */
            handleCSV.writeACSV(writeDirection, entry);

            driver.manage().deleteAllCookies();

            driver.quit();

            count ++;

            HandleDatabase_2 handleDatabase = new HandleDatabase_2();

            handleDatabase.databaseURL = databaseURL;

            handleDatabase.username = username;

            handleDatabase.password = password;

            handleDatabase.writeToDataBase(entry);

            if(count % 50 == 0)
            {
                try
                {
                    Thread.sleep(2000);
                    System.out.println("details sleep 2 seconds");
                }
                catch (Exception eD)
                {
                    eD.printStackTrace();
                    System.out.println("Something wrong with the sleep of detail");
                }
            }



        }
    }
}
