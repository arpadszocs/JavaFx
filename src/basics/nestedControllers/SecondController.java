package basics.nestedControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: SecondController.java 31604 10/6/2017 10:24  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/6/2017
 */
public class SecondController implements Initializable {

	@FXML
	private TextField textField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public TextField getTextField() {
		return textField;
	}
}
