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
    private char[] uppercase_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    // Creating the cipher alphabet in a 2D array
    private char [][] vigenere_table;

    public VigenereCipher () {

        this.vigenere_table = new char [26][26];

        int pointer = 0; // Pointer to starting letter in row

        // Iterating over each row
        for(int i = 0; i < 26; i++){

            // Iterating over each column
            for(int j = 0; j < 26; j++){

                // Each letter is given by the starting letter in the row shifted by the column position
                if(pointer + j <= 25){
                    this.vigenere_table[i][j] = uppercase_alphabet[pointer + j];
                } else{
                    this.vigenere_table[i][j] = uppercase_alphabet[(pointer + j) - 26];
                }

            }

            pointer ++;
        }
    }

    @Override
    public String encrypt(String message_filename, String key_filename){

        // Creating buffered reader to read key from key file line by line
        String full_key = "";

        try(BufferedReader key_reader = new BufferedReader(new FileReader(key_filename))){

            String key = "";

            while((key = key_reader.readLine()) != null){
                full_key = full_key.concat(key);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        String encrypted_message = "";

        // Creating buffered reader to read message from message file char by char
        try(BufferedReader message_reader = new BufferedReader(new FileReader(message_filename))){

            char message_char;
            int pointer = 0; // Pointer used to keep track of current letter in key

            while(message_reader.ready()){
                message_char = (char) message_reader.read();

                // If char is a letter, change it
                if(Character.isLetter(message_char)){

                    // Convert char to uppercase
                    message_char = Character.toUpperCase(message_char);

                    // Calculate values for alphabet cipher lookup
                    int i = indexOf(uppercase_alphabet, full_key.charAt(pointer));
                    int j = indexOf(uppercase_alphabet, message_char);

                    encrypted_message += this.vigenere_table[i][j];
                } else{

                    encrypted_message += message_char;

                }

                // Set pointer back to beginning of key if at the end, else increment
                if(pointer == full_key.length() - 1){
                    pointer = 0;
                } else{
                    pointer ++;
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        
        return encrypted_message;

    }

    @Override
    public String decrypt(String message_filename, String key_filename){
        // Creating buffered reader to read key from key file line by line
        String full_key = "";

        try(BufferedReader key_reader = new BufferedReader(new FileReader(key_filename))){

            String key = "";

            while((key = key_reader.readLine()) != null){
                full_key = full_key.concat(key);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        String decrypted_message = "";

        // Creating buffered reader to read message from message file char by char
        try(BufferedReader message_reader = new BufferedReader(new FileReader(message_filename))){

            char message_char;
            int pointer = 0; // Pointer used to keep track of current letter in key

            while(message_reader.ready()){
                message_char = (char) message_reader.read();

                // If char is a letter, change it
                if(Character.isLetter(message_char)){

                    // Convert char to uppercase
                    message_char = Character.toUpperCase(message_char);

                    // Calculate values for backwards alphabet cipher lookup
                    int i = indexOf(uppercase_alphabet, full_key.charAt(pointer));
                    
                    int j = 0;
                    while(true){
                        if(this.vigenere_table[i][j] == message_char){
                            break;
                        }
                        j++;
                    }

                    decrypted_message += this.vigenere_table[0][j];
                } else{

                    decrypted_message += message_char;

                }

                // Set pointer back to beginning of key if at the end, else increment
                if(pointer == full_key.length() - 1){
                    pointer = 0;
                } else{
                    pointer ++;
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        
        return decrypted_message;
    }

    public static void main(String[] args) {
    
        VigenereCipher trial_cipher = new VigenereCipher();

        System.out.println(trial_cipher.encrypt("question_1/encrypt_check.txt", "question_1/key_check.txt"));

        System.out.println(trial_cipher.decrypt("question_1/decrypt_check.txt", "question_1/key_check.txt"));

    }

}