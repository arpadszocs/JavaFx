package basics.nestedControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: ParentController.java 31604 10/6/2017 10:26  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/6/2017
 */
public class ParentController implements Initializable {

	// included controllers
	// naming convention that must be respected: "fx:id"+"Controller" e.g. "first"+"Controller"
	@FXML
	private FistController firstController;
	@FXML
	private SecondController secondController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		firstController.getButtonFirst()
				.setOnAction(event -> secondController.getTextField().setText("Button pressed"));
	}
}
