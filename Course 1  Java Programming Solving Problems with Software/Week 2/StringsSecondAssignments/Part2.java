
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa,String stringb){
        int occur = 0;
        int currIndex = stringb.indexOf(stringa);
        while(currIndex != -1){
            occur++;
            currIndex = stringb.indexOf(stringa,currIndex + stringa.length());
        }
        return occur;
    }
}