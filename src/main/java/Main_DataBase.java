import java.sql.*;
import java.util.List;

/**
 * Created by jingfeiyang on 1/09/2017.
 */
public class Main_DataBase {
    public static void main(String[] args) {

//        String databaseURL = "jdbc:mysql://localhost:3306/test?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

        String databaseURL = "jdbc:mysql://localhost:3306?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

        String username = "root";
        String password = "yjf1992918";
        String tableName = "Employees";
        Connection con = null;

        String sqlCode = "select * from Employees";


        HandleCSV theDetails = new HandleCSV();

        String readDirection = "/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsDetails_NT_PRACTICE_2.csv";

        List<String[]> websites = theDetails.readACSV_Detail(readDirection);




        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(databaseURL,username,password);

            Statement statement = con.createStatement();
            if(!con.isClosed())
            {
                System.out.println("access the database success!");
            }

            statement.execute("create database if not exists clps;");

            statement.execute("use clps;");

            statement.execute("create table if not exists seekDataDetail (id int(6) NOT NULL AUTO_INCREMENT, name TEXT, website TEXT, name2 TEXT, location TEXT, email TEXT, phone TEXT, salary TEXT, jd TEXT, jb2 TEXT, date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (id));");




            PreparedStatement psql;

            for (String[] website : websites)
            {
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
            }

            con.close();

//            psql = con.prepareStatement("insert into seekData (name)" + "values(?)");
//
////            psql.setInt(1,2);
//            psql.setString(1,"rocket");
//
//            psql.executeUpdate();



//            ResultSet rs = statement.executeQuery(sqlCode);
//
//            String empid = "";
//
//            String lastName = "";
//
//            String title = "";
//
//            while(rs.next())
//            {
//                empid = rs.getString("empid");
//                lastName = rs.getString("lastname");
//                title = rs.getString("title");
//
//                System.out.println(empid + "\t" + lastName +"\t" + title);
//            }
//
//            rs.close();
//





//            con.close();



        }
        catch (Exception e)
        {
            System.out.println("something wrong with the connection to the database");
            e.printStackTrace();
        }
    }
}
