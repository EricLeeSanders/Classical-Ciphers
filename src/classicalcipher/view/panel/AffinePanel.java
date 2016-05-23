package classicalcipher.view.panel;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * Panel for Affine Cipher. Shows 2 labels and 2 text fields.
 * 
 * @author Eric
 *
 */
@SuppressWarnings("serial")
public class AffinePanel extends JPanel {
	private JLabel shiftAmountLabel_A, shiftAmountLabel_B;
	private JTextField shiftAmountText_A, shiftAmountText_B;

	public AffinePanel() {
		createLayout();
	}

	private void createLayout() {

		createControls();
		setLayout(new MigLayout("", "[][]", "[][]"));
		this.add(shiftAmountLabel_A);
		this.add(shiftAmountText_A, "wrap");
		this.add(shiftAmountLabel_B);
		this.add(shiftAmountText_B);

	}

	private void createControls() {
		shiftAmountLabel_A = new JLabel("Shift A");
		shiftAmountLabel_A.setVisible(true);
		shiftAmountText_A = new JTextField("");
		shiftAmountText_A.setVisible(true);
		shiftAmountText_A.setPreferredSize(new Dimension(40, 25));

		shiftAmountLabel_B = new JLabel("Shift B");
		shiftAmountLabel_B.setVisible(true);
		shiftAmountText_B = new JTextField("");
		shiftAmountText_B.setVisible(true);
		shiftAmountText_B.setPreferredSize(new Dimension(40, 25));
	}

	public String getShiftAmountA() {
		return shiftAmountText_A.getText();
	}

	public String getShiftAmountB() {
		return shiftAmountText_B.getText();
	}
}
