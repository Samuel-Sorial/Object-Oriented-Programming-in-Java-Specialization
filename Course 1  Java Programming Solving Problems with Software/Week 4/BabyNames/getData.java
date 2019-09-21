import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of getData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class getData {
    public void totalBirths(FileResource fr)
    {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int uniqeNames = 0;
        int uniqeBoys = 0;
        int uniqeGirls = 0;
        for(CSVRecord record : fr.getCSVParser())
        {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            uniqeNames++;
            if(record.get(1).equals("M"))
            {
                totalBoys += numBorn;
                uniqeBoys++;
            }
            else
            {
                totalGirls += numBorn;
                uniqeGirls++;
            }
        }
        System.out.println("Total Births = " + totalBirths);
        System.out.println("Total Boys = " + totalBoys);
        System.out.println("Total Girls = " + totalGirls);
        System.out.println("Total uniqe names = " + uniqeNames);
        System.out.println("uniqe boys = " + uniqeBoys);
        System.out.println("uniqe girls = " + uniqeGirls);
    }
    public int Rank(int year, String name, String gender)
    {
        String yearName = "years/yob"+ year+".csv";
        FileResource fr = new FileResource(yearName);
        int thisBirth = 0;
        int Rank = 1;
        for(CSVRecord record : fr.getCSVParser())
        {
            if(record.get(1).equals(gender) && record.get(0).equals(name))
            {
                thisBirth = Integer.parseInt(record.get(2));
            }
            else if(thisBirth<Integer.parseInt(record.get(2)) && record.get(1).equals(gender))
            {
                    Rank++;
            }
        }
        if(thisBirth==0)
            return -1;
        return Rank;
    }
    public String getName(int year, int rank, String gender)
    {
        String yearName = "years/yob" + year + ".csv";
        FileResource fr = new FileResource(yearName);
        for(CSVRecord record : fr.getCSVParser())
        {
            String name = record.get(0);
            int ranking = Rank(year,name,gender);
            if(ranking == rank )
                return name;
        }
        return "NO NAME";
    }
    public void whatIsNameInYear(String name, int year, int newYear, String gender)
    {
        int rank = Rank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
    }
    public int yearOfHighestRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int highestYear =-1;
        int highestRank = 10000000;
        for(File f : dr.selectedFiles())
        {
            String fileName = f.getName();
            int year = getYear(fileName);
            int rank = Rank(year,name,gender);
            if(rank<highestRank)
            {
                highestYear = year;
                highestRank = rank;
            }
        }
        return highestYear;
    }
    public int getYear(String fileName)
    {
            int startYearName = fileName.indexOf("b");
            String yearName = fileName.substring(startYearName+1,startYearName+5);
            int year = Integer.parseInt(yearName);
            return year;
    }
    public double getAverageRank(String name,String gender)
    {
        double sum = 0.00;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            String fileName = f.getName();
            int year = getYear(fileName);
            int rank = Rank(year,name,gender);
            sum += rank;
            count++;
        }
        if(sum==0.00 && count ==0)
            return -1;
        return sum/count;
    }
    public int getTotalBirthsRankedHigher(int year, String name, String gender)
    {
        int rank = Rank(year,name,gender);
        int totalBirths = 0;
        String yearName = "years/yob" + year + ".csv";
        FileResource fr = new FileResource(yearName);
        for(CSVRecord record : fr.getCSVParser())
        {
            String currName = record.get(0);
            int currBirth = Integer.parseInt(record.get(2));
            String currGender = record.get(1);
            if(currGender.equals(gender))
            {
                int currRank = Rank(year,currName,currGender);
                if(currRank<rank)
                    totalBirths += currBirth;
            }
        }
        return totalBirths;
    }
    public void test()
    {
           FileResource fr = new FileResource();
           totalBirths(fr);
    }
}
