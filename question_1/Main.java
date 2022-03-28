package question_1;

public class Main {
    public static void main(String[] args) {
    
        VigenereCipher trial_cipher = new VigenereCipher();

        System.out.println(trial_cipher.encrypt("encrypt_check.txt", "key_check.txt"));

        System.out.println(trial_cipher.decrypt("decrypt_check.txt", "key_check.txt"));

    }
}
