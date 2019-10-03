package GladLib;

import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap<String,ArrayList<String>> map;
    private ArrayList<String> usedWords = new ArrayList<String>();
    private ArrayList<String> usedCategories = new ArrayList<String>();
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLib(){
        map = new HashMap<String,ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        String[] categories = { "adjective","noun","color","country","name",
            "animal","timeframe","verb","fruit"};
        for(String s : categories)
        {
            map.put(s,readIt(source+"/"+s+".txt"));
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if(map.containsKey(label)){
        return randomFrom(map.get(label));
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(usedWords.indexOf(sub)!=-1 && usedWords.size()!=0)
        {
            sub = getSubstitute(w.substring(first+1,last));
        }
        usedWords.add(sub);
        String category = w.substring(first+1,last);
        if(!usedCategories.contains(category))
            usedCategories.add(category);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    public void totalWordsInMap()
    {
        int totalNo = 0;
        for(ArrayList<String> s : map.values())
        {
            totalNo += s.size();
        }
        System.out.println("The number of words we can choose from: " + totalNo);
    }
    private void totalWordsConsidered()
    {
        int totalNo=0;
        for(String s : usedCategories)
        {
            int currNo = map.get(s).size();
            totalNo+=currNo;
        }
        System.out.println("Total of considered is: " + totalNo);
    }
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("datalong/madtemplate2.txt");
        printOut(story, 60);
        usedWords.clear();
        usedCategories.clear();
    }    
}
