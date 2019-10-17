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
     public HashMap<String,Integer> countVisitsPerIP()
     {
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         for(LogEntry log : records)
         {
             String currIP = log.getIpAddress();
             if(counts.containsKey(currIP))
             {
                 counts.put(currIP,counts.get(currIP) + 1);
             }
             else{
                 counts.put(currIP,1);
             }
             }
         return counts;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts)
     {
         ArrayList<String> Ips = new ArrayList<String>();
         int maximumVisits = mostNumberVisitsByIP(counts);
         for(String currIP : counts.keySet())
         {
             int currVisits = counts.get(currIP);
             if(currVisits==maximumVisits)
                Ips.add(currIP);
            }
         return Ips;
        }
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts)
     {
         int maximum = 0;
         for(int i : counts.values())
         {
             if(i>maximum)
                maximum =i;
            }
         return maximum;
        }
     public HashMap<String,ArrayList<String>> iPsForDay()
     {
         HashMap<String,ArrayList<String>> ips = new HashMap<String,ArrayList<String>>();
         for(LogEntry log : records)
         {
             String currIp = log.getIpAddress();
             String Date = log.getAccessTime().toString();
             String dayDate = Date.substring(8,10);
             String monthDate = Date.substring(4,7);
             String newFormatDate = monthDate + " " + dayDate;
             if(ips.containsKey(newFormatDate))
             {
                 ArrayList<String> currList = ips.get(newFormatDate);
                 currList.add(currIp);
                 ips.put(newFormatDate, currList);
             }
             else
             {
                 ArrayList<String> newList = new ArrayList<String>();
                 newList.add(currIp);
                 ips.put(newFormatDate,newList);
              }
            }
         return ips;
     }
     public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> map)
     {
        int maximum = 0;
        String maximumSt = "Not responding";
        for(ArrayList<String> s : map.values())
        {
            if(s.size()>maximum)
            {  maximum = s.size();
            }
        }
        for(String s : map.keySet())
        {
            if(map.get(s).size()==maximum)
            {
              return s;
            }
        }
        return maximumSt;
     }
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map, String date)
     {
         ArrayList<String> results = map.get(date);
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         for(String s : results){
             if(counts.containsKey(s))
             {
                counts.put(s,counts.get(s)+1);
            }
            else{
                counts.put(s,1);
            }
        }
        ArrayList<String> maximum = iPsMostVisits(counts);
        return maximum;
    }
    public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
    }   
