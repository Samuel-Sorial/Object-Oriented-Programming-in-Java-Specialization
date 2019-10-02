import java.util.*;
import edu.duke.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    private void findUnique(){
            myWords.clear();
            myFreqs.clear();
            FileResource fr = new FileResource();
            for(String word : fr.words()){
                word = word.toLowerCase();
                int currIndex = myWords.indexOf(word);
                if(currIndex==-1){
                    myWords.add(word);
                    myFreqs.add(1);
                }
                else{
                    int currValue = myFreqs.get(currIndex);
                    myFreqs.set(currIndex, currValue+1);
                }
            }
    }
    public int findIndexOfMax()
    {
        int max=0;
        for(int i=0; i<myFreqs.size();i++){
            if(myFreqs.get(i)>myFreqs.get(max))
                max =i;
        }
        return max;
    }
    public void tester(){
        findUnique();
        System.out.println("The number of unique words is:" + myWords.size());
        for(int i=0; i< myWords.size(); i++)
        {
            System.out.println(myWords.get(i) + " has occured: " + myFreqs.get(i));
        }
        int maxIndex= findIndexOfMax();
        System.out.println("The most occurrence word is " + myWords.get(maxIndex) 
        + " it has occurred " + myFreqs.get(maxIndex) + " times.");
    }
}
