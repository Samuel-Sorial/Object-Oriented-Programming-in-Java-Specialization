import java.io.File;
import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of ColdestDay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColdestDay {
    public void coldestFile(){
        DirectoryResource dr = new DirectoryResource();
        lowestFile("TemperatureF" , dr);
    }
    public void lowestFile(String filter,DirectoryResource dr)
    {
        CSVRecord lowest = null;
        String lowestFileName = null;
        CSVParser lowestPars = null;
        FileResource lowestFileResource = null;
            for(File f : dr.selectedFiles())
            {
            String currName = f.getName();
            FileResource fr = new FileResource(f);
            CSVParser pars = fr.getCSVParser();
            CSVRecord currRec = coldestHour(pars);
            if(lowest==null)
            {
                lowest = currRec;
                lowestFileName = currName;
                lowestPars = pars;
                lowestFileResource = fr;
            }
            else{
                double currTemp = Double.parseDouble(currRec.get(filter));
                 if(whichSmaller(lowest,currRec,filter))
                    {
                        lowest = currRec;
                        lowestFileName = currName;
                        lowestPars = pars;
                        lowestFileResource = fr;
                   
                    }
        }
        }
        System.out.println("Lowest" + filter + " was in file " + lowestFileName);
        System.out.println("Lowest " + filter + " : on that day was " + lowest.get(filter));
        if(filter.contains("TemperatureF")){
        //printAllTemperatures(lowestFileResource);
        } else if(filter.contains("Humidity"))
        {
            System.out.println(lowest.get("DateUTC"));
        }
    }
    public void lowestHumidityFiles(){
        DirectoryResource dr = new DirectoryResource();
        lowestFile("Humidity",dr);
    }
    public double averageTemperature(CSVParser parser)
    {
        double avg = 0;
        double sum = 0;
        int count = 0;
        for(CSVRecord record : parser)
        {
            double curr = Double.parseDouble(record.get("TemperatureF"));
            if(curr != -9999)
            {
                sum = sum + curr;
                count++;
            }
        }
        return sum/count;
    }
    public void testavg(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(averageTemperature(parser));
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value)
    {
        double avg = 0;
        double sum = 0;
        int count = 0;
        for(CSVRecord record : parser)
        {
            String hum = record.get("Humidity");
            if(!(hum.contains("N/A")) && Double.parseDouble(hum) >= value )
            {
                double currTemp = Double.parseDouble(record.get("TemperatureF"));
                sum = sum + currTemp;
                count++;
            }
        }
        if(count == 0)
        {
            return 0.00;
        }
        else{
        return sum/count;
         }
    }
    void testaveragetemp(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureWithHighHumidityInFile(parser,80);
        if(avg == 0 )
        {
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average temp when high hum is " + avg);
        }
    }
    public void printAllTemperatures(FileResource fr)
    {
        CSVParser parser = fr.getCSVParser();
        System.out.println("All temp is :");
        for(CSVRecord record : parser)
        {
            System.out.println(record.get("DateUTC") + ":  " + record.get("TemperatureF"));
        }
    }
    public CSVRecord coldestHour(CSVParser parser){
        CSVRecord coldestRec = null;
        for(CSVRecord record : parser)
        {
            if(coldestRec == null)
            { 
                coldestRec = record;
            }
            else{
                double currTemp = Double.parseDouble(record.get("TemperatureF"));
                    if(whichSmaller(coldestRec,record,"TemperatureF"))
                    {
                    coldestRec = record;
                    }
                }
        }
        return coldestRec;
    }
    public void testColdestHourDay()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord rec = coldestHour(parser);
        System.out.println("The coldest hour was " + rec.get("TemperatureF") + " " + rec.get("DateUTC"));
    }
    public boolean whichSmaller(CSVRecord coldestRec , CSVRecord record,String filter)
    {
                double coldestTemp = Double.parseDouble(coldestRec.get(filter));
                if(record.get("Humidity").contains("N/A") || record.get("TemperatureF").contains("-9999")){return false;}
                double currTemp = Double.parseDouble(record.get(filter));
                return currTemp<coldestTemp;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord LowestHumidity = null;
         for(CSVRecord record : parser)
            {
                if(LowestHumidity == null)
                { 
                LowestHumidity = record;
                }
                else{
                    if(whichSmaller(LowestHumidity,record,"Humidity"))
                    {
                    LowestHumidity = record;
                    }
                  }
            }
        return LowestHumidity;
    }
    public void testHumidity()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("The lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
}

