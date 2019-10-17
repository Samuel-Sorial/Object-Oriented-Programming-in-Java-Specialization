
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    public void testLogAnalyzer() {
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("weblog2_log");
        //analyzer.printAll();
        //System.out.println(analyzer.countUniqueIPs() + " Uniqe Ips");
        //analyzer.printAllHigherThanNum(400);
        //System.out.println(analyzer.uniqueIPVisitsOnDay("Sep 27").size());
        //System.out.println(analyzer.countUniqueIPsInRange(400,499));
        //HashMap<String,Integer> counts = new HashMap<String,Integer>();
        //counts = analyzer.countVisitsPerIP();
        //System.out.println(counts);
        //System.out.println(analyzer.mostNumberVisitsByIP(counts));
        //ArrayList<String> ips = analyzer.iPsMostVisits(counts);
        //for(String s : ips)
        //{
        //   System.out.println(s);
        //}
        //System.out.println(analyzer.iPsForDay());
        HashMap<String,ArrayList<String>> map = analyzer.iPsForDay();
        //System.out.println(analyzer.dayWithMostIPVisits(map));
        System.out.println(analyzer.iPsWithMostVisitsOnDay(map,"Sep 29"));
    }
}
