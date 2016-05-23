package classicalcipher.view;

import java.awt.Container;
import javax.swing.JFrame;
import classicalcipher.presenter.CipherPresenter;
import classicalcipher.view.panel.AffinePanel;
import classicalcipher.view.panel.CipherSelectPanel;
import classicalcipher.view.panel.MainPanel;
import classicalcipher.view.panel.ShiftPanel;
import classicalcipher.view.panel.SubstitutionPanel;
import classicalcipher.view.panel.VigenerePanel;
import net.miginfocom.swing.MigLayout;
/**
 * Main view for the MVP pattern.
 * Uses different panels to show different widgets which
 * are updated dynamically by the presenter
 * @author Eric
 *
 */
public class CipherView implements ICipherView {
	private JFrame frame;
	private CipherSelectPanel cipherSelectPanel;
	private ShiftPanel shiftPanel;
	private SubstitutionPanel substitutionPanel;
	private AffinePanel affinePanel;
	private VigenerePanel vigenerePanel;
	private MainPanel mainPanel;
	private CipherPresenter presenter;

	public CipherView(CipherPresenter presenter) {
		this.presenter = presenter;
		frame = new JFrame("Classical Ciphers");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(createLayout());
		frame.pack();
		frame.setVisible(true);
	}

	private Container createLayout() {
		Container container = new Container();

		cipherSelectPanel = new CipherSelectPanel(presenter);
		shiftPanel = new ShiftPanel();
		substitutionPanel = new SubstitutionPanel();
		substitutionPanel.setVisible(false);
		affinePanel = new AffinePanel();
		affinePanel.setVisible(false);
		vigenerePanel = new VigenerePanel();
		vigenerePanel.setVisible(false);
		mainPanel = new MainPanel(presenter);

		container.setLayout(new MigLayout("", "[]", "[center][grow][]"));
		container.add(cipherSelectPanel, "align center, wrap");
		container.add(shiftPanel, "hidemode 3, wrap");
		container.add(substitutionPanel, "hidemode 3, wrap");
		container.add(affinePanel, "hidemode 3, wrap");
		container.add(vigenerePanel, "hidemode 3, wrap");
		container.add(mainPanel);

		return container;
	}

	@Override
	public void shiftCipher() {
		shiftPanel.setVisible(true);
		substitutionPanel.setVisible(false);
		affinePanel.setVisible(false);
		vigenerePanel.setVisible(false);
	}

	@Override
	public void substitutionCipher() {
		substitutionPanel.setVisible(true);
		shiftPanel.setVisible(false);
		affinePanel.setVisible(false);
		vigenerePanel.setVisible(false);
	}

	@Override
	public void affineCipher() {
		affinePanel.setVisible(true);
		substitutionPanel.setVisible(false);
		shiftPanel.setVisible(false);
		vigenerePanel.setVisible(false);
	}

	@Override
	public void vigenereCipher() {
		vigenerePanel.setVisible(true);
		affinePanel.setVisible(false);
		substitutionPanel.setVisible(false);
		shiftPanel.setVisible(false);
	}

	@Override
	public void encipher() {
		mainPanel.encipher();
		cipherSelectPanel.encipher();
		updateAutoDecryptionPanels(true);
	}

	@Override
	public void decipher() {
		mainPanel.decipher();
		cipherSelectPanel.decipher();
		updateAutoDecryptionPanels(true);
	}

	@Override
	public void autoDecipher() {
		mainPanel.autoDecipher();
		cipherSelectPanel.autoDecipher();
		updateAutoDecryptionPanels(false);

	}

	private void updateAutoDecryptionPanels(boolean enabled) {
		vigenerePanel.setKeyEnabled(enabled);
		shiftPanel.setShiftAmountEnabled(enabled);
	}

	@Override
	public String getPlainText() {
		return mainPanel.getPlainText();
	}

	@Override
	public String getShiftAmount() {
		return shiftPanel.getShiftAmount();
	}

	@Override
	public void setCipherText(String text) {
		mainPanel.setCipherText(text);
	}

	@Override
	public String getCipherText() {
		return mainPanel.getCipherText();
	}

	@Override
	public void setPlainText(String text) {
		mainPanel.setPlainText(text);
	}

	@Override
	public void setVigenereKeyText(String text) {
		vigenerePanel.setKeyText(text);
	}

	@Override
	public void setShiftAmountText(String text) {
		shiftPanel.setShiftAmount(text);
	}

	@Override
	public void updateLog(String message) {
		mainPanel.updateLog(message);

	}

	@Override
	public String getSubKeyText() {
		return substitutionPanel.getKeyText();
	}

	@Override
	public String getAffineShiftAText() {
		return affinePanel.getShiftAmountA();
	}

	@Override
	public String getAffineShiftBText() {
		return affinePanel.getShiftAmountB();
	}

	@Override
	public String getVigenereKeyText() {
		return vigenerePanel.getKeyText();
	}

}
