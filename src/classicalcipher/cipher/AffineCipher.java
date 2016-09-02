package classicalcipher.cipher;

import java.util.ArrayList;
import java.util.List;

import classicalcipher.observer.ICipherObserver;

/**
 * Affine Cipher Class. Can perform Affine encryption and decryption.
 * 
 * @author Eric
 *
 */
public class AffineCipher {
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
	 * Performs an Affine encryption
	 * 
	 * @param plainText
	 * @param shiftAmountA
	 * @param shiftAmountB
	 * @return String - The encrypted text
	 */
	public String affineEncryption(String plainText, int shiftAmountA, int shiftAmountB) {
		validate(plainText, shiftAmountA, shiftAmountB);
		notifyObserversMessage("Doing an affine encryption...");
		plainText = plainText.toUpperCase();
		plainText = plainText.replaceAll("[^A-Z]", "");

		char[] textArray = plainText.toCharArray();
		char[] cipherArray = new char[plainText.length()];
		for (int i = 0, shift = 0; i < textArray.length; i++) {
			// Subtract A so that we are dealing with 0-25 not ASCII numbers
			shift = (shiftAmountA * (textArray[i] - 'A') + shiftAmountB) % 26;
			cipherArray[i] = (char) (shift + 'A');// Add back 'A' because we
													// need the ASCII number
		}
		String cipherText = new String(cipherArray);
		notifyObserversMessage("Affine encryption complete!");
		return cipherText;
	}

	/**
	 * Performs an Affine decryption
	 * 
	 * @param cipherText
	 * @param shiftAmountA
	 * @param shiftAmountB
	 * @return
	 */
	public String affineDecryption(String cipherText, int shiftAmountA, int shiftAmountB) {
		validate(cipherText, shiftAmountA, shiftAmountB);
		notifyObserversMessage("Doing an affine decryption...");
		cipherText = cipherText.toUpperCase();
		cipherText = cipherText.replaceAll("[^A-Z]", "");

		char[] textArray = cipherText.toCharArray();
		char[] cipherArray = new char[cipherText.length()];
		int aInverse = 0;
		// Finds the inverse of A
		for (int i = 0; i < 26; i++) {
			// if true then we found the inverse;
			if (((shiftAmountA * i) % 26) == 1) {
				aInverse = i;
				break;
			}

		}
		for (int i = 0, shift = 0; i < textArray.length; i++) {
			shift = textArray[i] - 'A';
			shift -= shiftAmountB;
			while (shift < 0) {
				shift = 26 - Math.abs(shift);
			}
			shift *= aInverse;
			shift %= 26;

			cipherArray[i] = (char) (shift + 'A');// Add back 'A' because we
													// need the ASCII number
		}
		String plainText = new String(cipherArray);
		notifyObserversMessage("Affine decryption complete!");
		return plainText;
	}

	/**
	 * Determines if shiftAmountA is relatively prime to 26
	 * 
	 * @param shiftAmountA
	 * @return boolean - relatively prime
	 */
	private boolean relativelyPrime(int shiftAmountA) {
		return (gcd(shiftAmountA, 26) == 1);
	}

	/**
	 * Euclid's Algorithm to find the GCD
	 * 
	 * @param p
	 * @param q
	 * @return int - GCD
	 */
	private int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}
	
	/**
	 * Validates a message and shift amount
	 * 
	 * @param message
	 * @param shiftAmount
	 */
	private void validate(String message, int shiftAmountA, int shiftAmountB) {
		if (message == null || message.trim().isEmpty()) {
			notifyObserversMessage("User did not enter a message to encrypt/decrypt");
			throw new IllegalArgumentException("User did not enter a message to encrypt/decrypt");
		}
		if (shiftAmountA > 26 || shiftAmountA < 1) {
			notifyObserversMessage("User did not enter a shift between 1-26");
			throw new IllegalArgumentException("User did not enter a shift between 1-26");
		}
		if (shiftAmountB > 26 || shiftAmountB < 1) {
			notifyObserversMessage("User did not enter a shift between 1-26");
			throw new IllegalArgumentException("User did not enter a shift between 1-26");
		}
		if (!relativelyPrime(shiftAmountA)) {
			notifyObserversMessage(shiftAmountA + " is not relatively prime to 26");
			throw new IllegalArgumentException(shiftAmountA + " Shift Amount A is not relatively prime to 26");
		}
	}
}