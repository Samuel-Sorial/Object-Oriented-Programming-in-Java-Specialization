
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public float cgRatio(String dna){
        float CG = alphaNumbers(dna,"C") + alphaNumbers(dna,"G");
        int total = dna.length();
        return CG / total ;
    }
    public int alphaNumbers(String dna , String alpha){
        int CG=0;
        int currIndex = dna.indexOf(alpha);
        while(currIndex != -1){
            CG++;
            currIndex = dna.indexOf(alpha,currIndex+1);
        }
        return CG;
    }
    public int countCTG(String dna){
        int count = alphaNumbers(dna,"CTG");
        return count;
    }
}
