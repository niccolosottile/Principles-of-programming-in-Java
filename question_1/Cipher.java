package question_1;

/**
* Cipher interface for use with the CM10228: Principles of Programming 2 coursework.
* 
* This should not be modified by the student.
* 
* @author		Christopher Clarke
* @version		1.0	
*/
public interface Cipher {
	
	/**
	* Encrypts a message using a key.
	*
	* @param  message_filename		the filename of the message to be encrypted
	* @param  key_filename			the filename of the key to be used to encrypt the message
	* @return       The encrypted message
	*/
	public String encrypt(String message_filename, String key_filename);
	
	/**
	* Decrypts a message using a key.
	*
	* @param  message_filename		the filename of the message to be decrypted
	* @param  key_filename			the filename of the key to be used to decrypt the message
	* @return       The decrypted message
	*/
	public String decrypt(String message_filename, String key_filename);
}