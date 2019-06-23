import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by jingfeiyang on 1/09/2017.
 */
public class HandleDatabase {


    String databaseURL = "";

    String username = "";
    String password = "";

    String deletePreviousData = "";

    String database = "";

    Connection con = null;


    public void writeToDataBase(String readDirection)
    {

        HandleCSV theDetails = new HandleCSV();


        List<String[]> websites = theDetails.readACSV_Detail(readDirection);

        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";

            Class.forName(driver);

            con = DriverManager.getConnection(databaseURL,username,password);

//            Statement statement = con.createStatement();
            if(!con.isClosed())
            {
                System.out.println("access the database success!");
            }

            Statement statement = con.createStatement();


//            statement.execute("create database if not exists seekcrawler;");

            statement.execute("create database if not exists " + database + ";");


//            statement.execute("use seekcrawler;");
            statement.execute("use " + database + ";");




            statement.execute("create table if not exists seekDataDetail (id int(6) NOT NULL AUTO_INCREMENT, jobName TEXT, website TEXT, jobTitle TEXT, companyName TEXT, location TEXT, email TEXT, phone TEXT, salary TEXT, jobDescription TEXT, jobDescription2 TEXT, date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (id));");

            if(deletePreviousData.toLowerCase().equals("yes"))
            {
                System.out.println(deletePreviousData);
                System.out.println("delete the previous data");
                statement.execute("delete from seekDataDetail");
            }


            statement.close();

            int count = 0;

            for (String[] website : websites)
            {
                PreparedStatement psql;
                psql = con.prepareStatement("insert into seekDataDetail (jobName, website,jobTitle,companyName ,location, email, phone, salary, jobDescription,jobDescription2)" + "values(?,?,?,?,?,?,?,?,?,?)");

                try
                {
                    count ++ ;
                    psql.setString(1,website[0]);
                    psql.setString(2,website[1]);
                    psql.setString(3,website[2]);
                    psql.setString(4,website[3]);
                    psql.setString(5,website[4]);
                    psql.setString(6,website[5]);
                    psql.setString(7,website[6]);
                    psql.setString(8,website[7]);
                    psql.setString(9,website[8]);
                    psql.setString(10,website[9]);
                    psql.executeUpdate();

                    System.out.println("write successfully" + count);

//                Thread.sleep(30);

                }
                catch (Exception eLoop)
                {

                    eLoop.printStackTrace();
                }

                psql.close();

            }



            con.close();

            if(con.isClosed())
            {
                System.out.println("close the database successfully");
            }


        }
        catch (Exception e)
        {
            System.out.println("something wrong with the connection to the database");
            e.printStackTrace();
        }



    }

}
