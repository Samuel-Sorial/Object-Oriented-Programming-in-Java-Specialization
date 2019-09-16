import java.lang.Math;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 */
public class Part1 {
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
 public void printAllGenes(String dna){
     int currIndex = 0;
     while(true){
         String gene = findGene(dna,currIndex);
         if(gene.isEmpty()){
             break;
         }
         System.out.println("The gene is " + gene);
         currIndex = dna.indexOf(gene) + gene.length();
     }
    }
 public void testFindGene()
 {
     testOneDna("ooooooTAA");
     testOneDna("oATGoooTAATAG");
     testOneDna("rqwATGooooTAAooTGAqwre");
     testOneDna("tqweATGooooTAArqwer");
 }
 public void testOneDna(String dna){
        System.out.println("The original DNA is " + dna);
       // System.out.println(findGene(dna));
 }
 public void testFindCodon(){
     String dna = "ATGoooTAAyrt";
     System.out.println("Original DNA is " + dna);
     System.out.println(findStopCodon(dna,0,"TAA"));
     dna = "oATGoooTAAtqwet";
     System.out.println("Original DNA is " + dna);     
     System.out.println(findStopCodon(dna,1,"TAA"));   
     dna = "ATGooooTAArewqr";
     System.out.println("Original DNA is " + dna);     
     System.out.println(findStopCodon(dna,0,"TAA"));    
     dna = "oATGooTAAqwe";
     System.out.println("Original DNA is " + dna);     
     System.out.println(findStopCodon(dna,1,"TAA"));    
     dna = "ATGooooTATAAerew";
     System.out.println("Original DNA is " + dna);     
     System.out.println(findStopCodon(dna,0,"TAA"));    
     dna = "oATGooooTATAAER";
     System.out.println("Original DNA is " + dna);     
     System.out.println(findStopCodon(dna,1,"TAA"));    }
}
