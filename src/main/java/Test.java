import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by jingfeiyang on 4/09/2017.
 */
public class Test {
    public static void main(String[] args) {


        try {
            File CSVFile = new File("/Users/jingfeiyang/Desktop/clps/filesFortheProject/crawl_jobs/testout_put.csv");
            Writer fileWriter = new FileWriter(CSVFile, true);
            CSVWriter writer = new CSVWriter(fileWriter, ',');

            String[] entry = {"hehehehehehe"};

            writer.writeNext(entry);
            writer.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
