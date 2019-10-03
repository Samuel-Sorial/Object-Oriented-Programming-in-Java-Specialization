import java.util.*;
import edu.duke.*;
import java.io.File;
public class WordInFiles {
    private HashMap<String,ArrayList<String>> map;
    
    public WordInFiles()
    {
        map = new HashMap<String,ArrayList<String>>();
    }
    private void addWordsFromFile(File f)
    {
        String fileName = f.getName();
        FileResource fr = new FileResource(f);
        for( String word : fr.words())
        {
            if(map.containsKey(word))
            {
                ArrayList<String> currList = map.get(word);
                currList.add(fileName);
                map.put(word,currList);
            }
            else
            {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(fileName);
                map.put(word,newList);
            }
        }
    }
    private void buildWordFileMap()
    {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
    }
    private int maxNumber()
    {
        int maximum=0;
        for(ArrayList<String> s : map.values()){
            int currSize = s.size();
            if(currSize>maximum)
                maximum = currSize;
        }
        return maximum;
    }
    private ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> words = new ArrayList<String>();
        for(String s : map.keySet())
        {
            int num = map.get(s).size();
            if(num==number)
               words.add(s); 
        }
        return words;
    }
    private void printFilesIn(String word)
    {
        ArrayList<String> files = map.get(word);
        for(int i=0;i<files.size();i++)
        {
            System.out.println(files.get(i));
        }
    }
    public void tester()
    {
        buildWordFileMap();
        System.out.println("The maximum file same word contained: " + maxNumber());
        
    }
}
