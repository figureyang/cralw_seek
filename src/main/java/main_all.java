public class main_all {

    public static String databaseURL = "jdbc:mysql://192.168.1.143:3306?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    public static String username = "seekcrawler";

    public static String password = "T5cWseekwebot";

    public static void main(String[] args) {

        String jobDetails = "/home/testuser02/Peter_Yang/Details.csv_wholeAus.csv";

        HandleDatabase justWrite = new HandleDatabase();

        justWrite.databaseURL = databaseURL;

        justWrite.username = username;

        justWrite.password = password;

        justWrite.writeToDataBase(jobDetails);


    }


}
