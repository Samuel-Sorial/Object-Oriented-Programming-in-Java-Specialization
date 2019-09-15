
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
public String findSimpleGene(String dna)
{
    int startIndex = dna.indexOf("ATG");
    if(startIndex==-1){
        return " No gene was found ";
    }
    int endIndex = dna.indexOf("TTA", startIndex+3);
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
    String dna = "GTEATGEETGTEETGTTAER";
    System.out.println("The dna is "+ dna);
    String gene = findSimpleGene(dna);
    System.out.println(gene);
    dna = "GTEATGEETGTEETGTTER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna);
    System.out.println(gene);
    dna = "GTEATGEETGTETGTTAER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna);
    System.out.println(gene);
    dna = "GTEATEETGTEETGTTAER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna);
    System.out.println(gene);
    dna = "GTEEETGTEETGER";
    System.out.println("The dna is "+ dna);
    gene = findSimpleGene(dna);
    System.out.println(gene);
}
}
