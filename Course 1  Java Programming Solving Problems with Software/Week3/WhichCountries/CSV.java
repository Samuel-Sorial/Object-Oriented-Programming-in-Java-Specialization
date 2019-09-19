import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of CSV here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSV {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String info = countryInfo(parser,"Germany");
        System.out.println(info);
    }
    public String countryInfo(CSVParser parser, String country)
    {
        String info = "NOT FOUND";
        for( CSVRecord record : parser){
            String count  = record.get("Country");
            if (country.equals(count))
            {
                info = count + " : " + record.get("Exports") + " : "
                              + record.get("Value (dollars)");
            }
        }
        return info;
    }
}
