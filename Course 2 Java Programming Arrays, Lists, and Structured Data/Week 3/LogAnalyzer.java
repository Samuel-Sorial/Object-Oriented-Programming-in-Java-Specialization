

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String line : fr.lines())
         {
             LogEntry log = WebLogParser.parseEntry(line);
             records.add(log);
            }
        }
     public int countUniqueIPs()
     {
         ArrayList<String> foundIPs = new ArrayList<String>();
         for(LogEntry log : records)
         {
             if(!foundIPs.contains(log.getIpAddress()))
             {
                 foundIPs.add(log.getIpAddress());
                }
            }
         return foundIPs.size();
     }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
}
