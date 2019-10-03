import java.util.*;
import edu.duke.*;
public class Codons {
    
    private HashMap<String,Integer> map;
    
    public Codons(){
        map = new HashMap<String,Integer>();
    }
    private void buildCodonMap(int start, String dna){
        map.clear();
        for(int i=start; i+3<dna.length(); i+=3){
            String codon = dna.substring(i,i+3);
            if(map.containsKey(codon)){
                map.put(codon,map.get(codon) +1);
            }
            else{
            map.put(codon,1);
            }
        }
    }
    private String getMostCommonCodon(){
        int largest = 0;
        String largestCodon= " ";
        for(String s : map.keySet()){
            int currValue = map.get(s);
            if(currValue>largest)
            {
                largest = currValue;
                largestCodon = s;
            }
        }        
        return largestCodon;
    }
    private void printCodonCounts(int start, int end){
        for(String s : map.keySet())
        {
            int currValue = map.get(s);
            if(currValue>=start && currValue<=end)
            {
                System.out.println(s + " repeated " + map.get(s) + " times.");
            }
        }
    }
    public void tester()
    {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.trim().toUpperCase();
        for(int i=0; i<3; i++){
        System.out.println("frame starting with " + i);
        buildCodonMap(i,dna);
        String mostCodon = getMostCommonCodon();
        System.out.println("Most occure: " + mostCodon);
        printCodonCounts(1,5);
       }
    }
}
