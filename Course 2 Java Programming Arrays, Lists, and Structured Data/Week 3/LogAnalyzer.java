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
     public ArrayList<String> uniqueIPVisitsOnDay(String someday)
     {
         String month = someday.substring(0,3);
         String day = someday.substring(4);
         ArrayList<String> foundIps = new ArrayList<String>();
         for(LogEntry log : records)
         {
             String Date = log.getAccessTime().toString();
             String dayDate = Date.substring(8,10);
             if(Date.contains(month) && dayDate.equals(day))
             {
                 if(!foundIps.contains(log.getIpAddress()))
                 {
                     foundIps.add(log.getIpAddress());
                 }
             }
         }
         return foundIps;
     }
     public void printAllHigherThanNum(int num)
     {
         for(LogEntry log : records)
         {
             int currIP = log.getStatusCode();
             if(currIP>num)
                System.out.println(log);
            }
     }
     public int countUniqueIPsInRange(int low , int high)
     {
         ArrayList<String> foundIps = new ArrayList<String>();
         for(LogEntry log : records)
         {
             int currStatus = log.getStatusCode();
             if(currStatus>=low && currStatus <= high && 
             !foundIps.contains(log.getIpAddress()))
             { 
                 foundIps.add(log.getIpAddress());
             }
         }
         return foundIps.size();
     }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
    }   
