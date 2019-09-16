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
    public void printNumGenes(String dna){
     int currIndex = 0;
     int num = 0;
     while(true){
         String gene = findGene(dna,currIndex);
         if(gene.isEmpty()){
             break;
         }
         num++;
         currIndex = dna.indexOf(gene) + gene.length();
     }
     System.out.println(num);
    }
    
}
