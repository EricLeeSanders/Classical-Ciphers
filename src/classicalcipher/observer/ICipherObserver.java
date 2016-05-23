package classicalcipher.observer;
/**
 * Interface for observing a Cipher.
 * @author Eric
 *
 */
public interface ICipherObserver {
	public void notifyMessage(String message);
}
