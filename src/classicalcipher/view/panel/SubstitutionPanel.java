package classicalcipher.view.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel for the substitution cipher. Shows a label and a text field.
 * 
 * @author Eric
 *
 */
@SuppressWarnings("serial")
public class SubstitutionPanel extends JPanel {
	private JLabel substitutionLabel;
	private JTextField substitutionText;

	public SubstitutionPanel() {
		createLayout();
	}

	private void createLayout() {

		createControls();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(substitutionLabel);
		this.add(substitutionText);
	}

	private void createControls() {
		substitutionLabel = new JLabel("Key");
		substitutionLabel.setVisible(true);
		substitutionText = new JTextField("");
		substitutionText.setVisible(true);
		substitutionText.setPreferredSize(new Dimension(150, 25));
	}

	public String getKeyText() {
		return substitutionText.getText();
	}
}
