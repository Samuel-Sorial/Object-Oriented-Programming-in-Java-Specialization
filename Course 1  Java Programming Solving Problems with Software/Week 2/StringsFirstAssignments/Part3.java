
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
public boolean twoOccurrences(String stringa , String stringb)
{
    int startIndex = stringb.indexOf(stringa);
    if(startIndex==-1)
    { 
        return false;
    }
    int nextStartIndex = stringb.indexOf(stringa,startIndex);
    if(nextStartIndex == -1)
    {
        return false;
    }
    return true;
}
public String lastPart(String stringa, String stringb)
{
    int startIndex = stringb.indexOf(stringa);
    if(startIndex==-1)
    {
        return stringb;
    }
    return stringb.substring(startIndex + stringa.length());
}
public void testTwoOccurrences()
{ 
    String str1= "a";
    String str2="banana";
    boolean exists = twoOccurrences(str1,str2);
    System.out.println(str1 + " exists in " + str2 + exists);
    str1= "a";
    str2="bann";
    exists = twoOccurrences(str1,str2);
    System.out.println(str1 + " exists in " + str2 + exists);    
}
public void testLastPart()
{
    String str1 = "an";
    String str2 = "banana";
    System.out.println(lastPart(str1,str2));
    str1="zoo";
    str2="forest";
    System.out.println(lastPart(str1,str2));
}
}
