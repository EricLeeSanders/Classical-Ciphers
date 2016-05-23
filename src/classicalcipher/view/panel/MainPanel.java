package classicalcipher.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import classicalcipher.presenter.CipherPresenter;
import net.miginfocom.swing.MigLayout;

/**
 * Main panel that shows the plain text, encrypted text and the log.
 * 
 * @author Eric
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener {
	private JButton submitButton;
	private JLabel plainLabel, cipherLabel, logLabel;
	private JTextArea plainText, cipherText, logText;
	private CipherPresenter presenter;

	public MainPanel(CipherPresenter presenter) {
		this.presenter = presenter;
		createLayout();
	}

	private void createLayout() {

		createControls();
		setLayout(new MigLayout("", "[]", "[][][][][][][][]"));
		this.add(plainLabel, "wrap");
		this.add(createScrollPane(plainText), "wrap");
		this.add(cipherLabel, "wrap");
		this.add(createScrollPane(cipherText), "wrap");
		this.add(submitButton, "wrap");
		this.add(logLabel, "wrap");
		this.add(createScrollPane(logText));
	}

	private void createControls() {
		submitButton = new JButton("Encrypt");
		submitButton.addActionListener(this);
		plainLabel = new JLabel("Enter the plain text");
		cipherLabel = new JLabel("Cipher text");
		plainText = new JTextArea();
		plainText.setEditable(true);
		plainText.setLineWrap(true);
		cipherText = new JTextArea("");
		cipherText.setEditable(false);
		cipherText.setLineWrap(true);
		cipherText.setBackground(Color.lightGray);
		logLabel = new JLabel("Log:");
		logText = new JTextArea("");
		logText.setEditable(false);
		logText.setLineWrap(true);

	}

	private JScrollPane createScrollPane(JTextArea jta) {
		JScrollPane scrollPane = new JScrollPane(jta);
		scrollPane.setPreferredSize(new Dimension(400, 75));
		scrollPane.setMaximumSize(new Dimension(400, 75));
		return scrollPane;
	}

	public void encipher() {
		submitButton.setText("Encrypt");
		plainText.setEditable(true);
		cipherText.setText("");
		cipherText.setEditable(false);
		cipherText.setBackground(Color.lightGray);
		plainText.setBackground(Color.white);
	}

	public void decipher() {
		submitButton.setText("Decrypt");
		setDecipherConfig();
	}

	public void autoDecipher() {
		submitButton.setText("Auto Decrypt");
		setDecipherConfig();
	}

	private void setDecipherConfig() {
		plainText.setEditable(false);
		plainText.setText("");
		plainText.setBackground(Color.lightGray);
		cipherText.setBackground(Color.white);
		cipherText.setEditable(true);
	}

	public void setCipherText(String text) {
		cipherText.setText(text);
	}

	public String getCipherText() {
		return cipherText.getText();
	}

	public void setPlainText(String text) {
		plainText.setText(text);
	}

	public String getPlainText() {
		return plainText.getText();
	}

	public void updateLog(String message) {
		logText.append(message + '\n');

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submitButton) {
			presenter.cipher();
		}

	}
}
