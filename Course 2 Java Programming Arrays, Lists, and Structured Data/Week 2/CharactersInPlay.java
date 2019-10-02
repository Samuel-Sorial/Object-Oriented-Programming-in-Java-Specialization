import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay()
    {
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    private void update(String person)
    {
        person = person.toUpperCase();
        int currIndex = characters.indexOf(person);
        if(currIndex==-1)
            {
                characters.add(person);
                counts.add(1);
        }
        else{
                int currValue = counts.get(currIndex);
                currValue++;
                counts.set(currIndex,currValue);
        }
    }
    private void findAllCharacters()
    {
        characters.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for(String line : fr.lines())
        {
            int nameIndex = line.indexOf(".");
            if(!(nameIndex==-1))
            {
                String name = line.substring(0,nameIndex);
                update(name);
            }
        }
    }
    private int findIndexOfMax()
    {
        int max=0;
        for(int i=0; i<counts.size();i++){
            if(counts.get(i)>counts.get(max))
                max =i;
        }
        return max;
    }
    private void CharactersWithNumParts(int num1, int num2)
    {
        System.out.println("The characters spoke between " + num1 + 
                " and " + num2 + " is: ");
        for(int i=0; i<counts.size(); i++)
        {
            if(counts.get(i)>=num1 && counts.get(i)<=num2)
            {
                System.out.println(characters.get(i) + " speaked " + counts.get(i));
            }
        }
    }
    public void tester()
    {
        findAllCharacters();
        CharactersWithNumParts(10,15);
    }
}
