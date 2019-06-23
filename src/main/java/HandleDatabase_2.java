import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class HandleDatabase_2 {
    String databaseURL = "";

    String username = "";
    String password = "";
    Connection con = null;


    public void writeToDataBase(String[] website)
    {

//        HandleCSV theDetails = new HandleCSV();
//
//
//        List<String[]> websites = theDetails.readACSV_Detail(readDirection);

        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(databaseURL,username,password);

            Statement statement = con.createStatement();
            if(!con.isClosed())
            {
                System.out.println("access the database success!");
            }

            statement.execute("create database if not exists clps_peter_yang;");

            statement.execute("use clps_peter_yang;");

            statement.execute("create table if not exists seekDataDetail (id int(6) NOT NULL AUTO_INCREMENT, name TEXT, website TEXT, name2 TEXT, location TEXT, email TEXT, phone TEXT, salary TEXT, jd TEXT, jb2 TEXT, date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (id));");




            PreparedStatement psql;

            psql = con.prepareStatement("insert into seekDataDetail (name, website,name2, location, email, phone, salary, jd,jb2)" + "values(?,?,?,?,?,?,?,?,?)");
            psql.setString(1,website[0]);
            psql.setString(2,website[1]);
            psql.setString(3,website[2]);
            psql.setString(4,website[3]);
            psql.setString(5,website[4]);
            psql.setString(6,website[5]);
            psql.setString(7,website[6]);
            psql.setString(8,website[7]);
            psql.setString(9,website[8]);
            psql.executeUpdate();

            Thread.sleep(30);

            System.out.println("complete writing to database");

//            for (String[] website : websites)
//            {
//                psql = con.prepareStatement("insert into seekDataDetail (name, website,name2, location, email, phone, salary, jd,jb2)" + "values(?,?,?,?,?,?,?,?,?)");
//                psql.setString(1,website[0]);
//                psql.setString(2,website[1]);
//                psql.setString(3,website[2]);
//                psql.setString(4,website[3]);
//                psql.setString(5,website[4]);
//                psql.setString(6,website[5]);
//                psql.setString(7,website[6]);
//                psql.setString(8,website[7]);
//                psql.setString(9,website[8]);
//                psql.executeUpdate();
//
//                Thread.sleep(100);
//            }


            con.close();


        }
        catch (Exception e)
        {
            System.out.println("something wrong with the connection to the database");
            e.printStackTrace();
        }



    }
}
