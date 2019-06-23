public class TestWriteToDatabase {
    public static String jobLinks = "";//"/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT_NEW.csv";

    public static String jobDetails = "";//"/Users/jingfeiyang/Desktop/clps/data_of_the_first_project/practice/JobsLinks_NT_NEW_Detail.csv";

    public static String databaseURL = "";//"jdbc:mysql://localhost:3306?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

    public static String username = "";//"root";

    public static String password = "";//"yjf1992918";

    public static String phantomjsDR = "";

    public static void main(String[] args) {

        HandleDatabase handleDatabase = new HandleDatabase();

        handleDatabase.databaseURL = "jdbc:mysql://rm-3ns2h1u05swb1nw4mo.mysql.rds.aliyuncs.com:3306?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

        handleDatabase.username = "crawler";

        handleDatabase.password = "C123456@";

        handleDatabase.writeToDataBase("/home/testuser02/Peter_Yang/DetailsForTest.csv");
    }
}
