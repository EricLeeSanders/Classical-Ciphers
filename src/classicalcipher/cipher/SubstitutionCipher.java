package classicalcipher.cipher;

/**
 * Substitution Cipher Class.
 * Uses keyword columnar transposition substitution.
 * Can perform Substitution encryption and decryption
 */
import java.util.ArrayList;
import java.util.List;

import classicalcipher.observer.ICipherObserver;

public class SubstitutionCipher {
	private List<ICipherObserver> cipherObservers = new ArrayList<ICipherObserver>();

	/**
	 * Attaches an Observer to the class
	 * 
	 * @param cipherObserver
	 */
	public void attachObserver(ICipherObserver cipherObserver) {
		cipherObservers.add(cipherObserver);
	}

	/**
	 * Notifies the Observers with a message
	 * 
	 * @param message
	 */
	private void notifyObserversMessage(String message) {
		for (ICipherObserver cipherObserver : cipherObservers) {
			cipherObserver.notifyMessage(message);
		}
	}

	/**
	 * Creates the cipher alphabet with a given key.
	 * 
	 * @param key
	 * @return char[] - the cipher alphabet
	 */
	private char[] createCipherAlphabet(String key) {
		char[] keyArray = new char[key.length()];
		keyArray = key.toCharArray();

		ArrayList<Character> tempList = new ArrayList<Character>();

		// remove repetitive characters from the key and put them into the temp
		// list
		boolean inKey = false;
		for (int i = 0; i < key.length(); i++) {
			inKey = false;
			for (int j = 0; j < tempList.size(); j++) {
				if (tempList.indexOf(keyArray[i]) != -1) {
					inKey = true;
					break;
				}
			}
			if (inKey == false) {
				tempList.add(keyArray[i]);
			}
		}
		int columnSize = tempList.size();
		// Add the rest of the alphabet to the temp list
		inKey = false;
		char letter;
		for (int i = 0; i < 26; i++) {
			inKey = false;
			letter = (char) (i + 'A');
			for (int j = 0; j < keyArray.length; j++) {
				if (key.indexOf(letter) != -1) {
					inKey = true;
					break;
				}
			}
			if (inKey == false) {
				tempList.add(letter);
			}
		}

		// We need to take the size of the keyword after removing repetitive
		// characters and use it to make the imaginary columns
		List<Character> cipherList = new ArrayList<Character>();
		boolean newLine = false;
		for (int i = 0, j = 0; i < columnSize; i++) {
			j = i;
			newLine = false;
			while (newLine == false) {
				cipherList.add(tempList.get(j));
				j += columnSize;
				if (j >= 26) {
					newLine = true;
				}
			}

		}
		// convert to array
		char[] cipherAlphabet = new char[26];
		for (int i = 0; i < 26; i++) {
			cipherAlphabet[i] = cipherList.get(i);
		}
		notifyObserversMessage("Substitution Alphabet: " + String.valueOf(cipherAlphabet));
		return cipherAlphabet;
	}

	/**
	 * Performs a substitution encryption
	 * 
	 * @param plainText
	 * @param key
	 * @return String - The encrypted text
	 */
	public String substitutionEncryption(String plainText, String key) {
		validate(plainText, key);
		notifyObserversMessage("Doing a substitution encryption...");
		plainText = plainText.toUpperCase();
		plainText = plainText.replaceAll("[^A-Z]", "");
		char[] plainTextArray = plainText.toCharArray();
		key = key.toUpperCase();
		key = key.replaceAll("[^A-Z]", "");

		char[] cipherAlphabet = createCipherAlphabet(key);
		char[] cipherArray = new char[plainTextArray.length];
		for (int i = 0, pos = 0; i < plainTextArray.length; i++) {
			pos = (plainTextArray[i]) - 'A';
			cipherArray[i] = cipherAlphabet[pos];
		}

		String cipherText = new String(cipherArray);
		notifyObserversMessage("Substitution encryption complete!");
		return cipherText;
	}

	/**
	 * Performs a substitution decryption
	 * 
	 * @param cipherText
	 * @param key
	 * @return String - the decrypted text
	 */
	public String substitutionDecryption(String cipherText, String key) {
		validate(cipherText, key);
		notifyObserversMessage("Doing a substitution decryption...");
		cipherText = cipherText.toUpperCase();
		cipherText = cipherText.replaceAll("[^A-Z]", "");
		char[] cipherTextArray = cipherText.toCharArray();
		key = key.toUpperCase();
		key = key.replaceAll("[^A-Z]", "");

		char[] englishAlphabet = new char[26];
		for (int i = 0; i < 26; i++) {
			englishAlphabet[i] = (char) ('A' + i);
		}

		String cipherString = new String(createCipherAlphabet(key));
		char[] plainTextArray = new char[cipherTextArray.length];
		for (int i = 0, pos = 0; i < cipherTextArray.length; i++) {
			pos = cipherString.indexOf(cipherTextArray[i]);
			plainTextArray[i] = englishAlphabet[pos];
		}

		String plainText = new String(plainTextArray);
		notifyObserversMessage("Substitution decryption complete!");
		return plainText;
	}

	/**
	 * Validates a message and key
	 * 
	 * @param message
	 * @param key
	 */
	private void validate(String message, String key) {
		if (message.equals("") || message == null) {
			notifyObserversMessage("Error: User did not enter a message to encrypt/decrypt");
			throw new IllegalArgumentException("User did not enter a message to encrypt/decrypt");
		}
		if (key.equals("") || key == null) {
			notifyObserversMessage("Error: User did not enter a key");
			throw new IllegalArgumentException("User did not enter a ley");
		}
	}
}