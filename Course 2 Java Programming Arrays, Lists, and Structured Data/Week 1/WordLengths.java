import edu.duke.*;

/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public int[] countWordLengths(FileResource resource, int[] counts)
    {
        for(String word : resource.words())
        {
        int length = word.length();
         if(Character.isLetter(word.charAt(0)) && Character.isLetter(word.charAt(length-1)))
           {
             if(length <= counts.length)
             {
                counts[length]+=1;
             }
             else{
                 counts[counts.length-1]+=1;
             }
        }
        else{
             if(length <= counts.length)
             {
                counts[length-1]+=1;
             }
             else{
                 counts[counts.length-1]+=1;
             }
        }
    }
    return counts;
   }
   public int indexOfMax(int[] values)
   {
       int maxIndex=0;
       for(int i=0; i<values.length; i++)
       {
           if(values[maxIndex] < values[i])
           {
               maxIndex = i;
            }
        }
        return maxIndex;
    }
   public void testCountWordLengths()
   {
       FileResource fr = new FileResource();
       int[] counts = new int[31];
       counts = countWordLengths(fr,counts);
       System.out.println(indexOfMax(counts));
   }
   
}