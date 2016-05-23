package classicalcipher.view;
/**
 * Interface for the view.
 * @author Eric
 *
 */
public interface ICipherView {
	public void shiftCipher();

	public void substitutionCipher();

	public void affineCipher();

	public void vigenereCipher();

	public void encipher();

	public void decipher();

	public void autoDecipher();

	public void setCipherText(String text);

	public String getCipherText();

	public void setPlainText(String text);

	public void setVigenereKeyText(String text);

	public void setShiftAmountText(String text);

	public String getPlainText();

	public String getShiftAmount();

	public String getSubKeyText();

	public String getAffineShiftAText();

	public String getAffineShiftBText();

	public String getVigenereKeyText();

	public void updateLog(String message);
}
