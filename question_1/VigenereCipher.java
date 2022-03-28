package question_1;

// Implementing the Vigenère chiper class using the cipher interface
public class VigenereCipher implements Cipher {

    @Override
    public String encrypt(String message_filename, String key_filename){
        return "";
    }

    @Override
    public String decrypt(String message_filename, String key_filename){
        return "";
    }

    public static void main(String[] args) {
    
        VigenereCipher trial_cipher = new VigenereCipher();

        System.out.println(trial_cipher.encrypt("encrypt_check.txt", "key_check.txt"));

        System.out.println(trial_cipher.decrypt("decrypt_check.txt", "key_check.txt"));

    }

}