// Question open: if the key is made up of non letter characters what to do

package question_1;

// Importing useful packages
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

// Implementing the Vigenère chiper class using the cipher interface
public class VigenereCipher implements Cipher {

    public static int indexOf(char[] array, char key){
        for (int i = 0; i < array.length; i++)
            if (array[i] == key)
                return i;
    
        return -1;
    }

    // Storing the uppercase alphabet in an array
    private char[] uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    // Creating the cipher alphabet in a 2D array
    private char [][] vigenereTable;

    public VigenereCipher () {

        this.vigenereTable = new char [26][26];

        int pointer = 0; // Pointer to starting letter in row

        // Iterating over each row
        for(int i = 0; i < 26; i++){

            // Iterating over each column
            for(int j = 0; j < 26; j++){

                // Each letter is given by the starting letter in the row shifted by the column position
                if(pointer + j <= 25){
                    this.vigenereTable[i][j] = uppercaseAlphabet[pointer + j];
                } else{
                    this.vigenereTable[i][j] = uppercaseAlphabet[(pointer + j) - 26];
                }

            }

            pointer++;
        }
    }

    @Override
    public String encrypt(String message_filename, String key_filename){

        // Creating buffered reader to read key from key file line by line
        String fullKey = "";

        try(BufferedReader keyReader = new BufferedReader(new FileReader(key_filename))){

            String key = "";

            while((key = keyReader.readLine()) != null){
                fullKey = fullKey.concat(key.toUpperCase());
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        String encryptedMessage = "";

        // Creating buffered reader to read message from message file char by char
        try(BufferedReader messageReader = new BufferedReader(new FileReader(message_filename))){

            char messageChar;
            int pointer = 0; // Pointer used to keep track of current letter in key

            while(messageReader.ready()){
                messageChar = (char) messageReader.read();

                // If char is a letter, change it
                if(Character.isLetter(messageChar)){

                    // Calculate values for alphabet cipher lookup
                    int i = indexOf(uppercaseAlphabet, fullKey.charAt(pointer));
                    int j = indexOf(uppercaseAlphabet, Character.toUpperCase(messageChar));

                    encryptedMessage += this.vigenereTable[i][j];
                } else{

                    encryptedMessage += messageChar;

                }

                // Set pointer back to beginning of key if at the end, else increment
                if(pointer == fullKey.length() - 1){
                    pointer = 0;
                } else{
                    pointer++;
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        
        return encryptedMessage;

    }

    @Override
    public String decrypt(String message_filename, String key_filename){
        // Creating buffered reader to read key from key file line by line
        String fullKey = "";

        try(BufferedReader keyReader = new BufferedReader(new FileReader(key_filename))){

            String key = "";

            while((key = keyReader.readLine()) != null){
                fullKey = fullKey.concat(key.toUpperCase());
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        String decryptedMessage = "";

        // Creating buffered reader to read message from message file char by char
        try(BufferedReader messageReader = new BufferedReader(new FileReader(message_filename))){

            char messageChar;
            int pointer = 0; // Pointer used to keep track of current letter in key

            while(messageReader.ready()){
                messageChar = (char) messageReader.read();

                // If char is a letter, change it
                if(Character.isLetter(messageChar)){

                    // Calculate values for backwards alphabet cipher lookup
                    int i = indexOf(uppercaseAlphabet, fullKey.charAt(pointer));
                    
                    int j = 0;
                    while(true){
                        if(this.vigenereTable[i][j] == Character.toUpperCase(messageChar)){
                            break;
                        }
                        j++;
                    }

                    decryptedMessage += this.vigenereTable[0][j];
                } else{

                    decryptedMessage += messageChar;

                }

                // Set pointer back to beginning of key if at the end, else increment
                if(pointer == fullKey.length() - 1){
                    pointer = 0;
                } else{
                    pointer++;
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        
        return decryptedMessage;
    }

    public static void main(String[] args) {
    
        VigenereCipher trial_cipher = new VigenereCipher();

        System.out.println(trial_cipher.encrypt("question_1/encrypt_check.txt", "question_1/key_check.txt"));

        System.out.println(trial_cipher.decrypt("question_1/decrypt_check.txt", "question_1/key_check.txt"));

    }

}