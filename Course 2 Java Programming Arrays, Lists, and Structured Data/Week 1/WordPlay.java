
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch)
    {
        char newChar = Character.toLowerCase(ch);
        if(newChar=='a' || newChar=='e' || newChar=='i' || newChar=='o' || newChar=='u' )
        {
            return true;
        }
        return false;
    }
    public String replaceVowels(String phrase , char ch)
    {
        StringBuilder st = new StringBuilder(phrase);
        for(int i = 0; i<phrase.length(); i++)
        {
            char currChar = phrase.charAt(i);
            if(isVowel(currChar))
            {
                st.setCharAt(i,ch);
            }
        }
        return st.toString();
    }
    public String emphasize(String phrase, char ch)
    {
        StringBuilder st = new StringBuilder(phrase);
        for(int i = 0; i<phrase.length(); i++)
        {
            char currChar = phrase.charAt(i);
            if(currChar==ch)
            {
                if(i%2==0)
                    st.setCharAt(i,'*');
                else
                    st.setCharAt(i,'+');
            }
        }
        return st.toString();
    }
}
