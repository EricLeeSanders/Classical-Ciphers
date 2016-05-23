package classicalcipher.presenter;

import classicalcipher.cipher.AffineCipher;
import classicalcipher.cipher.ShiftCipher;
import classicalcipher.cipher.SubstitutionCipher;
import classicalcipher.cipher.VigenereCipher;
import classicalcipher.observer.ICipherObserver;
import classicalcipher.view.ICipherView;
/**
 * Presenter for the MVP pattern.
 * Sends view updates to the View through the ICipherView interface.
 * Is notified (w/ messages) by ciphers through the observer pattern.
 * @author Eric
 *
 */
public class CipherPresenter implements ICipherObserver {
	private ShiftCipher shiftCipher;
	private SubstitutionCipher subCipher;
	private AffineCipher affineCipher;
	private VigenereCipher vigenereCipher;
	private CipherType selectedCipherType = CipherType.SHIFT;
	private CipherDirection selectedCipherDirection = CipherDirection.ENCIPHER;
	private ICipherView view;

	public CipherPresenter() {
		shiftCipher = new ShiftCipher();
		shiftCipher.attachObserver(this);
		subCipher = new SubstitutionCipher();
		subCipher.attachObserver(this);
		affineCipher = new AffineCipher();
		affineCipher.attachObserver(this);
		vigenereCipher = new VigenereCipher(shiftCipher);
		vigenereCipher.attachObserver(this);
	}

	public void setView(ICipherView view) {
		this.view = view;
	}
	
	public void setCipherType(CipherType cipherType) {
		this.selectedCipherType = cipherType;
		switch (cipherType) {
		case SHIFT:
			view.shiftCipher();
			break;
		case SUBSTITUTION:
			view.substitutionCipher();
			break;
		case AFFINE:
			view.affineCipher();
			break;
		case VIGENERE:
			view.vigenereCipher();
			break;
		}
	}

	public void cipher() {
		if (selectedCipherDirection == CipherDirection.ENCIPHER) {
			String cipherText = null;
			if (selectedCipherType == CipherType.SHIFT) {
				cipherText = shiftCipher.shiftEncryption(view.getPlainText(), Integer.parseInt(view.getShiftAmount()));
			} else if (selectedCipherType == CipherType.SUBSTITUTION) {
				cipherText = subCipher.substitutionEncryption(view.getPlainText(), view.getSubKeyText());
			} else if (selectedCipherType == CipherType.AFFINE) {
				cipherText = affineCipher.affineEncryption(view.getPlainText(),
						Integer.parseInt(view.getAffineShiftAText()), Integer.parseInt(view.getAffineShiftBText()));
			} else if (selectedCipherType == CipherType.VIGENERE) {
				cipherText = vigenereCipher.vigenereEncryption(view.getPlainText(), view.getVigenereKeyText());
			}
			view.setCipherText(cipherText);
		} else if (selectedCipherDirection == CipherDirection.DECIPHER) {
			String plainText = null;
			if (selectedCipherType == CipherType.SHIFT) {
				plainText = shiftCipher.shiftDecryption(view.getCipherText(), Integer.parseInt(view.getShiftAmount()));
			} else if (selectedCipherType == CipherType.SUBSTITUTION) {
				plainText = subCipher.substitutionDecryption(view.getCipherText(), view.getSubKeyText());
			} else if (selectedCipherType == CipherType.AFFINE) {
				plainText = affineCipher.affineDecryption(view.getCipherText(),
						Integer.parseInt(view.getAffineShiftAText()), Integer.parseInt(view.getAffineShiftBText()));
			} else if (selectedCipherType == CipherType.VIGENERE) {
				plainText = vigenereCipher.vigenereDecryption(view.getCipherText(), view.getVigenereKeyText());
			}
			view.setPlainText(plainText);
		} else if (selectedCipherDirection == CipherDirection.AUTO_DECIPHER) {
			String plainText = null;
			if (selectedCipherType == CipherType.SHIFT) {
				int shiftAmount = shiftCipher.shiftAutoDecryption(view.getCipherText());
				view.setShiftAmountText(String.valueOf(shiftAmount));
				plainText = shiftCipher.shiftDecryption(view.getCipherText(), shiftAmount);
			} else if (selectedCipherType == CipherType.VIGENERE) {
				String key = vigenereCipher.vigenereAutoDecryption(view.getCipherText());
				view.setVigenereKeyText(key);
				plainText = vigenereCipher.vigenereDecryption((view.getCipherText()), key);
			}
			view.setPlainText(plainText);
		}
	}

	public CipherType getCipherType() {
		return selectedCipherType;
	}

	public void setCipherDirection(CipherDirection direction) {
		this.selectedCipherDirection = direction;
		switch (direction) {
		case ENCIPHER:
			view.encipher();
			break;
		case DECIPHER:
			view.decipher();
			break;
		case AUTO_DECIPHER:
			view.autoDecipher();
			break;
		}
	}

	public enum CipherType {
		SHIFT, SUBSTITUTION, AFFINE, VIGENERE;
	}

	public enum CipherDirection {
		ENCIPHER, DECIPHER, AUTO_DECIPHER;
	}

	@Override
	public void notifyMessage(String message) {
		view.updateLog(message);

	}
}
