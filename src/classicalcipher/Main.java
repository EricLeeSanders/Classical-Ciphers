package classicalcipher;

import classicalcipher.presenter.CipherPresenter;
import classicalcipher.view.CipherView;

public class Main {

	public static void main(String[] args) {
		CipherPresenter cipherPresenter = new CipherPresenter();
		CipherView view = new CipherView(cipherPresenter);
		cipherPresenter.setView(view);
	}

}
