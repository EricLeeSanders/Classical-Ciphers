package classicalcipher.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel for the shift cipher. Shows a label and text field.
 * 
 * @author Eric
 *
 */
@SuppressWarnings("serial")
public class ShiftPanel extends JPanel {
	private JLabel shiftAmountLabel;
	private JTextField shiftAmountText;

	public ShiftPanel() {
		createLayout();
	}

	private void createLayout() {

		createControls();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(shiftAmountLabel);
		this.add(shiftAmountText);
	}

	private void createControls() {
		shiftAmountLabel = new JLabel("Shift");
		shiftAmountLabel.setVisible(true);
		shiftAmountText = new JTextField("");
		shiftAmountText.setVisible(true);
		shiftAmountText.setPreferredSize(new Dimension(40, 25));
	}

	public String getShiftAmount() {
		return shiftAmountText.getText();
	}

	public void setShiftAmount(String text) {
		shiftAmountText.setText(text);
	}

	public void setShiftAmountEnabled(boolean enabled) {
		shiftAmountText.setEditable(enabled);
		if (enabled) {
			shiftAmountText.setBackground(Color.white);
		} else {
			shiftAmountText.setBackground(Color.lightGray);
			shiftAmountText.setText("");
		}
	}
}
