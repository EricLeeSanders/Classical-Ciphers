package classicalcipher.view.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import classicalcipher.presenter.CipherPresenter;

/**
 * Panel for selected different ciphers
 * 
 * @author Eric
 *
 */
@SuppressWarnings("serial")
public class CipherSelectPanel extends JPanel implements ActionListener {
	private JRadioButton rbShift, rbSubstitution, rbAffine, rbVigenere, rbEncipher, rbDecipher, rbAutoDecipher;
	private CipherPresenter presenter;

	public CipherSelectPanel(CipherPresenter presenter) {
		this.presenter = presenter;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		createCipherTypeControls();
		createCipherDirectionControls();
		this.add(createCipherDirectionLayout());
		this.add(createCipherTypeLayout());
	}

	private JPanel createCipherTypeLayout() {
		JPanel cipherType = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cipherType.add(rbShift);
		cipherType.add(rbSubstitution);
		cipherType.add(rbAffine);
		cipherType.add(rbVigenere);
		return cipherType;
	}

	private void createCipherTypeControls() {
		rbShift = new JRadioButton("Shift");
		rbShift.setActionCommand(CipherPresenter.CipherType.SHIFT.name());
		rbShift.setSelected(true);
		rbSubstitution = new JRadioButton("Substitution");
		rbSubstitution.setActionCommand(CipherPresenter.CipherType.SUBSTITUTION.name());
		rbAffine = new JRadioButton("Affine");
		rbAffine.setActionCommand(CipherPresenter.CipherType.AFFINE.name());
		rbVigenere = new JRadioButton("Vigenere");
		rbVigenere.setActionCommand(CipherPresenter.CipherType.VIGENERE.name());

		// Group the radio buttons.
		ButtonGroup cipherTypeGroup = new ButtonGroup();
		cipherTypeGroup.add(rbShift);
		cipherTypeGroup.add(rbSubstitution);
		cipherTypeGroup.add(rbAffine);
		cipherTypeGroup.add(rbVigenere);
		// Register an action listener for the radio buttons.
		rbShift.addActionListener(this);
		rbSubstitution.addActionListener(this);
		rbAffine.addActionListener(this);
		rbVigenere.addActionListener(this);

	}

	private void createCipherDirectionControls() {
		rbEncipher = new JRadioButton("Encipher");
		rbEncipher.setActionCommand(CipherPresenter.CipherDirection.ENCIPHER.name());
		rbEncipher.setSelected(true);
		rbDecipher = new JRadioButton("Decipher");
		rbDecipher.setActionCommand(CipherPresenter.CipherDirection.DECIPHER.name());
		rbAutoDecipher = new JRadioButton("Auto Decipher");
		rbAutoDecipher.setActionCommand(CipherPresenter.CipherDirection.AUTO_DECIPHER.name());
		// Group the radio buttons.
		ButtonGroup cipherDirectionGroup = new ButtonGroup();
		cipherDirectionGroup.add(rbEncipher);
		cipherDirectionGroup.add(rbDecipher);
		cipherDirectionGroup.add(rbAutoDecipher);
		// Register an action listener for the radio buttons.
		rbEncipher.addActionListener(this);
		rbDecipher.addActionListener(this);
		rbAutoDecipher.addActionListener(this);
	}

	private JPanel createCipherDirectionLayout() {
		JPanel cipherTypePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cipherTypePanel.add(rbEncipher);
		cipherTypePanel.add(rbDecipher);
		cipherTypePanel.add(rbAutoDecipher);

		return cipherTypePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString().equals(CipherPresenter.CipherType.SHIFT.name())) {
			presenter.setCipherType(CipherPresenter.CipherType.SHIFT);
		} else if (e.getActionCommand().toString().equals(CipherPresenter.CipherType.SUBSTITUTION.name())) {
			presenter.setCipherType(CipherPresenter.CipherType.SUBSTITUTION);
		} else if (e.getActionCommand().toString().equals(CipherPresenter.CipherType.AFFINE.name())) {
			presenter.setCipherType(CipherPresenter.CipherType.AFFINE);
		} else if (e.getActionCommand().toString().equals(CipherPresenter.CipherType.VIGENERE.name())) {
			presenter.setCipherType(CipherPresenter.CipherType.VIGENERE);
		}

		if (e.getActionCommand().toString().equals(CipherPresenter.CipherDirection.ENCIPHER.name())) {
			presenter.setCipherDirection(CipherPresenter.CipherDirection.ENCIPHER);
		} else if (e.getActionCommand().toString().equals(CipherPresenter.CipherDirection.DECIPHER.name())) {
			presenter.setCipherDirection(CipherPresenter.CipherDirection.DECIPHER);
		} else if (e.getActionCommand().toString().equals(CipherPresenter.CipherDirection.AUTO_DECIPHER.name())) {
			presenter.setCipherDirection(CipherPresenter.CipherDirection.AUTO_DECIPHER);
		}
	}

	/**
	 * Updates the radio buttons for enciphering
	 */
	public void encipher() {
		rbShift.setEnabled(true);
		rbSubstitution.setEnabled(true);
		rbAffine.setEnabled(true);
		rbVigenere.setEnabled(true);
	}

	/**
	 * Updates the radio buttons for deciphering
	 */
	public void decipher() {
		rbShift.setEnabled(true);
		rbSubstitution.setEnabled(true);
		rbAffine.setEnabled(true);
		rbVigenere.setEnabled(true);
	}

	/**
	 * Updates the radio buttons for auto deciphering
	 */
	public void autoDecipher() {
		rbShift.setEnabled(true);
		rbSubstitution.setEnabled(false);
		rbAffine.setEnabled(false);
		rbVigenere.setEnabled(true);
		if (rbSubstitution.isSelected() || rbAffine.isSelected()) {
			rbShift.setSelected(true);
			presenter.setCipherType(CipherPresenter.CipherType.SHIFT);
		}

	}

}
