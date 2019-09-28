import edu.duke.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
 public String encrypt(String input, int key)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = Alphabet.toLowerCase();
        String shiftedAlphabet = Alphabet.substring(key) + Alphabet.substring(0,key);
        String lowerShiftedAlphabet = shiftedAlphabet.toLowerCase();
        for(int i=0; i<input.length(); i++)
        {
            char currChar = encrypted.charAt(i);
            if(Character.isLetter(currChar))
            {
                char encryptedChar =' ';
                if(Character.isLowerCase(input.charAt(i)))
                {
                  int currIndex = lowerAlphabet.indexOf(input.charAt(i));
                  encryptedChar = lowerShiftedAlphabet.charAt(currIndex);
                }
                else{
                int currIndex = Alphabet.indexOf(input.charAt(i));
                encryptedChar = shiftedAlphabet.charAt(currIndex);
                }
                encrypted.setCharAt(i,encryptedChar);
            }
        }
        return encrypted.toString();
    }
     public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = Alphabet.toLowerCase();
        String shiftedAlphabet = Alphabet.substring(key1) + Alphabet.substring(0,key1);
                    
        for(int i=0; i<input.length(); i++)
        {
            if(i%2==0){
             shiftedAlphabet = Alphabet.substring(key1) + Alphabet.substring(0,key1);
            }
            else{
             shiftedAlphabet = Alphabet.substring(key2) + Alphabet.substring(0,key2);
             }
            String lowerShiftedAlphabet = shiftedAlphabet.toLowerCase();
            char currChar = encrypted.charAt(i);
            if(Character.isLetter(currChar))
            {
                char encryptedChar =' ';
                if(Character.isLowerCase(input.charAt(i)))
                {
                  int currIndex = lowerAlphabet.indexOf(input.charAt(i));
                  encryptedChar = lowerShiftedAlphabet.charAt(currIndex);
                }
                else{
                int currIndex = Alphabet.indexOf(input.charAt(i));
                encryptedChar = shiftedAlphabet.charAt(currIndex);
                }
                encrypted.setCharAt(i,encryptedChar);
            }
        }
        return encrypted.toString();
 }
}