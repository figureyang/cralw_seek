import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jingfeiyang on 25/08/2017.
 */
public class HandleCSV {


    /**
     * this method is used to read the websites from the file and the basic details
     * @param readDirection this is the file that the program will read from
     * @return the list of the jobs' title and website
     */
    public List<String[]> readACSV(String readDirection)
    {
        List<String[]> websites = new ArrayList<String[]>();
        try
        {
            String nextLine[];
            CSVReader reader = new CSVReader(new FileReader(readDirection));
            while ((nextLine = reader.readNext())!=null)
            {
                String[] eachWebsite = new String[] {nextLine[0], nextLine[1]};

                websites.add(eachWebsite);
            }
            reader.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return websites;
    }


    public List<String[]> readACSV_Detail(String readDirection)
    {
        List<String[]> websites = new ArrayList<String[]>();
        try
        {
            String nextLine[];
            CSVReader reader = new CSVReader(new FileReader(readDirection));
            while ((nextLine = reader.readNext())!=null)
            {
                String[] eachWebsite = new String[] {nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4], nextLine[5], nextLine[6], nextLine[7], nextLine[8],nextLine[9]};

                websites.add(eachWebsite);
            }
            reader.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return websites;
    }

    /**
     * write the information to the specific file
     * @param writeDirection the direction of the file that the information that will write to
     * @param entry the string[] that will be writed to the file
     */
    public void writeACSV(String writeDirection, String[] entry)
    {
        try {
            File CSVFile = new File(writeDirection);
            Writer fileWriter = new FileWriter(CSVFile, true);
            CSVWriter writer = new CSVWriter(fileWriter, ',');



            writer.writeNext(entry);
            writer.close();
            fileWriter.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
