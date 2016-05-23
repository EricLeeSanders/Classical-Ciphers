package classicalcipher.cipher;

import java.util.ArrayList;
import java.util.List;

import classicalcipher.observer.ICipherObserver;

/**
 * Vigenere Cipher Class. Can perform vigenere encryption, decryption, and auto
 * decryption
 * 
 * @author Eric
 *
 */
public class VigenereCipher {
	private final double IC_UPPER_BOUND = 0.065;
	private final double IC_LOWER_BOUND = 0.0385;
	private ShiftCipher shift;
	private List<ICipherObserver> cipherObservers = new ArrayList<ICipherObserver>();

	/**
	 * Requires a shift cipher for auto decryption
	 * 
	 * @param shift
	 */
	public VigenereCipher(ShiftCipher shift) {
		this.shift = shift;
	}

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
	 * Performs a vigenere encryption
	 * 
	 * @param plainText
	 * @param key
	 * @return String - Encrypted text
	 */
	public String vigenereEncryption(String plainText, String key) {
		validate(plainText, key);
		notifyObserversMessage("Doing a vigenere encryption...");
		plainText = plainText.toUpperCase();
		plainText = plainText.replaceAll("[^A-Z]", "");
		key = key.toUpperCase();
		char[] keyArray = key.toCharArray();
		char[] textArray = plainText.toCharArray();
		char[] cipherArray = new char[plainText.length()];
		for (int i = 0, keyPos = 0, shift = 0; i < textArray.length; i++, keyPos++) {
			keyPos %= key.length();// Store the position that we are in
									// in the keyArray. Wrap to the beginning
			shift = (keyArray[keyPos]);// Get the number that represents
										// the letter in the key
			shift -= 'A';// Subtract the shift by A so we are dealing
							// with 0-25 not ASCII Numbers.
			cipherArray[i] = (char) ((shift + textArray[i]));
			// Wrap if need be
			if (cipherArray[i] > 'Z') {
				cipherArray[i] -= 26;
			}
		}
		String cipherText = new String(cipherArray);
		notifyObserversMessage("Vigenere encryption complete!");
		return cipherText;
	}

	/**
	 * Performs a vigenere decryption
	 * 
	 * @param cipherText
	 * @param key
	 * @return String - Decrypted text
	 */
	public String vigenereDecryption(String cipherText, String key) {
		validate(cipherText, key);
		notifyObserversMessage("Doing a vigenere decryption...");
		cipherText = cipherText.toUpperCase();
		cipherText = cipherText.replaceAll("[^A-Z]", "");
		key = key.toUpperCase();
		int shift = 0;
		char[] keyArray = key.toCharArray();
		char[] textArray = cipherText.toCharArray();
		char[] cipherArray = new char[cipherText.length()];
		for (int i = 0, keyPos = 0; i < textArray.length; i++, keyPos++) {
			keyPos %= key.length();
			shift = (keyArray[keyPos]);
			shift -= 'A';
			cipherArray[i] = (char) (textArray[i] - shift);
			// Wrap if need be
			if (cipherArray[i] < 'A') {
				cipherArray[i] += 26;
			}
		}
		String plainText = new String(cipherArray);
		notifyObserversMessage("Vigenere decryption complete!");
		return plainText;
	}

	/**
	 * Auto decrypts a vigenere encryption
	 * 
	 * @param cipherText
	 * @return String - key
	 */
	public String vigenereAutoDecryption(String cipherText) {
		validateMessage(cipherText);
		notifyObserversMessage("Doing a vigenere automatic decryption...");
		cipherText = cipherText.toUpperCase();
		cipherText = cipherText.replaceAll("[^A-Z]", "");
		char[] cipherArray = cipherText.toCharArray();
		double friedmanKeyLength = friedmanTest(cipherArray); // Friedman's
																// guess for the
																// key length
		notifyObserversMessage("Friedman guess for the keyword length is = " + friedmanKeyLength);
		List<Integer> kasiskiKeyLength = kasiskiTest(cipherText);
		String key;
		if (kasiskiKeyLength != null) {
			for (int i : kasiskiKeyLength) {
				notifyObserversMessage("Kasiski guess for a possible keyword length is = " + i);
			}
			int keyLength = diffFriedmanKasiski(friedmanKeyLength, kasiskiKeyLength);
			notifyObserversMessage("Estimated key length = " + keyLength);
			key = determineKey(cipherArray, keyLength);
		} else {
			friedmanKeyLength = Math.round(friedmanKeyLength);
			notifyObserversMessage("Key Length = " + friedmanKeyLength);
			key = determineKey(cipherArray, (int) friedmanKeyLength);
		}

		return key;

	}

	/**
	 * Performs the Friedman test for auto decryption
	 * 
	 * @param cipherArray
	 * @return double - calculated key length
	 */
	private double friedmanTest(char[] cipherArray) {
		notifyObserversMessage("Doing a vigenere auto decryption w/ Friedman...");
		double ic = calculateIC(cipherArray);
		notifyObserversMessage("Friedman test complete!");
		return calculateKeyLength(cipherArray, ic);
	}

	/**
	 * Count the number of times each character in the alphabet is used
	 * 
	 * @param cipherArray
	 * @return double []
	 */
	private double[] getCharCount(char[] cipherArray) {
		double[] charCount = new double[26];
		for (char letter : cipherArray) {
			charCount[letter - 'A']++;
		}
		return charCount;
	}

	/**
	 * Calculates the index of coincidence IC = the sum of letter(i) *
	 * letter(i)-1 / text length * text length-1
	 * 
	 * @param cipherArray
	 * @return
	 */
	private double calculateIC(char[] cipherArray) {
		notifyObserversMessage("Calculating the Index of Coincidence...");
		double sum = 0;
		double[] charCount = getCharCount(cipherArray);
		// sum of letter(i) * letter(i)-1
		for (int i = 0; i < 26; i++) {
			sum += (charCount[i] * (charCount[i] - 1));
		}
		notifyObserversMessage("Sum = " + sum);
		// Denominator = text length * text length-1
		double denominator = (double) cipherArray.length * (cipherArray.length - 1);
		notifyObserversMessage("Denominator = " + denominator);
		double ic = sum / denominator;
		notifyObserversMessage("IC = " + ic);
		return ic;
	}

	/**
	 * Calculates the key length. Used for Friedman test.
	 * 
	 * @param cipherArray
	 * @param ic
	 * @return double - keyLength
	 */
	private double calculateKeyLength(char[] cipherArray, double ic) {
		int n = cipherArray.length;
		double numerator = (IC_UPPER_BOUND - IC_LOWER_BOUND) * n;
		double denominator = (IC_UPPER_BOUND - ic) + (n * (ic - IC_LOWER_BOUND));
		double keyLength = Math.abs(numerator / denominator);
		notifyObserversMessage("Friedman estimated Key length= " + keyLength);
		return keyLength;
	}

	/**
	 * Performs the Kasiski test for auto decryption
	 * 
	 * @param cipherText
	 * @return List<Integer> - possible key lengths
	 */
	public List<Integer> kasiskiTest(String cipherText) {
		notifyObserversMessage("Doing a vigenere auto decryption w/ Kasiski...");
		List<Integer> keyLengths = repetitiveString(cipherText);
		notifyObserversMessage("Kasiski test complete!");
		return keyLengths;
	}

	/**
	 * Find repetitive strings for the Kasiski test. Divides the text into 3
	 * character substrings and finds the number of occurrences for each. The
	 * factors for the minimum distance that occurs more than once are
	 * determined and returned.
	 * 
	 * @param cipherText
	 * @return List<Integer> - list of factors
	 *
	 */
	private List<Integer> repetitiveString(String cipherText) {
		List<Integer> distances = new ArrayList<Integer>();
		for (int i = 0; i < cipherText.length() - 3; i++) {
			String sub = cipherText.substring(i, i + 3);
			int numOfOccurrences = 0;
			int prevOccurrence = 0;
			for (int index = cipherText.indexOf(sub); index >= 0; index = cipherText.indexOf(sub, index + 1)) {
				if (numOfOccurrences > 0) { // has to occur more than once
					distances.add(index - prevOccurrence);
				}
				prevOccurrence = index;
				numOfOccurrences++;
			}
		}
		if (distances.size() <= 0) {
			notifyObserversMessage("The Kasiski Test did not find any repeated strings!");
			return null;
		}
		int minDistance = distances.get(0);
		for (int i = 1; i < distances.size(); i++) {
			if ((distances.get(i) != 1) && (distances.get(i) < minDistance)) {
				minDistance = distances.get(i);
			}
		}
		notifyObserversMessage("min = " + minDistance);
		List<Integer> factors = calculateFactors(minDistance);
		notifyObserversMessage("Factors = " + factors);
		return factors;
	}

	/**
	 * Calculates the factors for a given integer n
	 * 
	 * @param n
	 * @return List<Integer> - factors
	 */
	public List<Integer> calculateFactors(int n) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 1, b = 0; i <= n; i++) {
			b = n % i;
			if (b == 0) {
				factors.add(i);
			}
		}
		return factors;
	}

	/**
	 * Find the difference between Friedman's key length guess and Kasiski's key
	 * length guess to help determine which is the actual key length of the
	 * encrypted text
	 * 
	 * @param fKey
	 * @param kKey
	 * @return int - key length
	 */
	private int diffFriedmanKasiski(double fKey, List<Integer> kKey) {
		// find smallest distance between kKey and fKey
		double min = Integer.MAX_VALUE;
		int pos = 0;
		double diff = 0;
		for (int i = 0; i < kKey.size(); i++) {
			diff = Math.abs((double) kKey.get(i) - fKey);
			if (diff < min) {
				pos = i;
				min = diff;
			}
		}
		notifyObserversMessage(
				"The Smallest distance is between Friendman Key and Kasiski Key at: " + kKey.get(pos) + " = " + min);
		return kKey.get(pos);
	}

	/**
	 * Guesses what the key is by utilizing frequency analysis in the shift auto
	 * decryption
	 * 
	 * @param cipherArray
	 * @param keyLength
	 * @return String - key
	 */
	private String determineKey(char[] cipherArray, int keyLength) {

		List<Character> cipherList = new ArrayList<Character>();
		for (char c : cipherArray) {
			cipherList.add(c);
		}
		List<List<Character>> shiftList = new ArrayList<List<Character>>();

		// break the cipher text into columns based on the key size
		boolean newLine = false;
		for (int i = 0, j = 0; i < keyLength; i++) {
			shiftList.add(new ArrayList<Character>());
			j = i;
			newLine = false;
			while (!newLine) {
				shiftList.get(i).add(cipherList.get(j));
				j += keyLength;
				if (j >= cipherList.size()) {
					newLine = true;
				}
			}
		}
		// use frequency analysis of each column created above to determine
		// the best shift for each letter in the key
		int[] shiftAmountArray = new int[shiftList.size()];
		for (int i = 0; i < shiftAmountArray.length; i++) {
			shiftAmountArray[i] = shift.shiftAutoDecryption(shiftList.get(i).toString()) % 26;
			notifyObserversMessage("Shift Amount for " + i + " = " + shiftAmountArray[i]);
		}
		char[] keyArray = new char[shiftList.size()];
		for (int i = 0; i < keyArray.length; i++) {
			keyArray[i] = (char) (shiftAmountArray[i] + 'A');
		}
		String key = new String(keyArray);
		notifyObserversMessage("Key = " + key);

		return key;
	}

	/**
	 * Validates a message
	 * 
	 * @param message
	 */
	private void validateMessage(String message) {
		if (message.equals("") || message == null) {
			notifyObserversMessage("Error: User did not enter a message to encrypt/decrypt");
			throw new IllegalArgumentException("User did not enter a message to encrypt/decrypt");
		}
	}

	/**
	 * Validates a message and key
	 * 
	 * @param message
	 * @param key
	 */
	private void validate(String message, String key) {
		validateMessage(message);
		if (key.equals("") || key == null) {
			notifyObserversMessage("Error: User did not enter a key");
			throw new IllegalArgumentException("User did not enter a ley");
		}
	}
}
