import edu.duke.StorageResource;
import edu.duke.FileResource;
import java.lang.Math;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
      public int findStopCodon(String dna,int startIndex,String stopCodon)
      {
     int currIndex = dna.indexOf(stopCodon,startIndex);
     while (currIndex !=-1)
     {
         int diff =currIndex - startIndex;
         if ( (diff%3)==0){
                return currIndex;
         }
         currIndex = dna.indexOf(stopCodon,currIndex+3);
     }
     return dna.length();
    }
    public String findGene(String dna ,int currIndex){
     int startIndex = dna.indexOf("ATG",currIndex);
     if(startIndex==-1){
         return "";
        }
     int TAA = findStopCodon(dna,startIndex,"TAA");
     int TGA = findStopCodon(dna,startIndex,"TGA");
     int TAG = findStopCodon(dna,startIndex,"TAG");
     int min = Math.min(TAA,Math.min(TGA,TAG));
     if(min == dna.length())
     {return dna;}
     return dna.substring(startIndex,min+3);
    }
    public StorageResource getAllGenes(String dna){
     StorageResource storage = new StorageResource();
     int currIndex = 0;
     while(true){
         String gene = findGene(dna,currIndex);
         if(gene.isEmpty()){
             break;
         }
         else if(gene.length()==dna.length()){
             break;
         }
         storage.add(gene);
         currIndex = dna.indexOf(gene) + gene.length();
     }
     return storage;
    }    
    public void testStorage(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        StorageResource store = getAllGenes(dna);
        processGenes(store);
    }
        
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
    public void processGenes(StorageResource sr){
        int counterNine = 0;
        int counterCGRatio=0;
        int longest = 0;
        for(String item : sr.data()){
            if(item.length()>60){
                counterNine++;
                if(item.length()>longest)
                {
                    longest = item.length();
                }
            }
            if(cgRatio(item)>.35){
                counterCGRatio++;
            }
        }
        System.out.println("Number of longer than 9 Is " + counterNine);
        System.out.println("Number of bigger .35 is " + counterCGRatio);
        System.out.println("Number of letters in bigger gene is " + longest);
    }
}
