
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
public String findSimpleGene(String dna,String startCodon,String stopCodon)
{
    int startIndex = dna.indexOf(startCodon);
    if(startIndex==-1){
        return " No gene was found ";
    }
    int endIndex = dna.indexOf(stopCodon, startIndex+3);
    if(endIndex == -1)
    {
        return " No gene was found ";
    }
    if( (startIndex-endIndex)%3 != 0)
    {
        return " No gene was found " ;
    }
    
    return dna.substring(startIndex,endIndex+3);
}
public void testSimpleGene()
{
    String dna = "AAATGCCCTAACTAGATTAAGAAACC";
    System.out.println("The dna is "+ dna);
    String gene = findSimpleGene(dna,"ATG","TAA");
    System.out.println(gene);
    dna = "GTEATGEETGTEETGTTER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna,"ATG","TTA");
    System.out.println(gene);
    dna = "GTEATGEETGTETGTTAER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna,"ATG","TTA");
    System.out.println(gene);
    dna = "GTEATEETGTEETGTTAER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna,"ATG","TTA");
    System.out.println(gene);
    dna = "GTEEETGTEETGER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna,"ATG","TTA");
    System.out.println(gene);
}
}
