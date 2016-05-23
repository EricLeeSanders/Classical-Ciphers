package classicalcipher.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel for the vigenere cipher. Shows a label and text field.
 * 
 * @author Eric
 *
 */
@SuppressWarnings("serial")
public class VigenerePanel extends JPanel {
	private JLabel vigenereLabel;
	private JTextField vigenereText;

	public VigenerePanel() {
		createLayout();
	}

	private void createLayout() {
		createControls();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(vigenereLabel);
		this.add(vigenereText);
	}

	private void createControls() {
		vigenereLabel = new JLabel("Key");
		vigenereLabel.setVisible(true);
		vigenereText = new JTextField("");
		vigenereText.setVisible(true);
		vigenereText.setPreferredSize(new Dimension(250, 25));
	}

	public String getKeyText() {
		return vigenereText.getText();
	}

	public void setKeyText(String text) {
		vigenereText.setText(text);
	}

	public void setKeyEnabled(boolean enabled) {
		vigenereText.setEditable(enabled);
		if (enabled) {
			vigenereText.setBackground(Color.white);
		} else {
			vigenereText.setBackground(Color.lightGray);
			vigenereText.setText("");
		}
	}
}
