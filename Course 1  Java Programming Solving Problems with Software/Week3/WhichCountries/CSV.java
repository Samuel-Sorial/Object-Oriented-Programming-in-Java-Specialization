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
        bigExporters(parser,"$999,999,999,999");
        
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
    public void listExportersTwoProducts(CSVParser parser,
                                         String exportItem1,
                                         String exportItem2)
    {
        for(CSVRecord record : parser)
        {
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem)
    {
        int count = 0;
        for(CSVRecord record : parser)
        {
            String exports = record.get("Exports");
            if(exports.contains(exportItem))
            {
                count++;
            }
        }
        return count;
    }
    public void bigExporters(CSVParser parser, String amount)
    {
        int len = amount.length();
        for(CSVRecord record : parser)
        {
            int len2 = record.get("Value (dollars)").length();
            if(len2>len)
            {
                System.out.println(record.get("Country" ) + 
                                   record.get("Value (dollars)"));
            }
        }
    }
}
