package basics.components.custom;

import basics.components.model.User;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

import java.util.Arrays;

/**
 *  
 * Sometimes we need to create a custom table cell, that supports multiple different components,
 * this is not supported by the basic JavaFx API, therefore we have to create them.
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: CustomTableCell.java 31604 10/6/2017 09:18  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/6/2017
 */
public class CustomTableCell extends TableCell<User, String> {

	private TextField textField;
	private CheckBox checkBox;

	public CustomTableCell() {
		createTextField();
		createComboBox();
	}

	@Override
	public void startEdit() {
		// state when you began to edit the cell
		User user = (User) getTableRow().getItem();
		if (user.getId() % 2 == 0) { // some random condition
			textField.setText(getString());
			textField.selectAll();
			textField.end();
			super.startEdit();
			setText(null);
			setGraphic(textField);
			textField.requestFocus();
		}
	}

	@Override
	public void commitEdit(String newValue) {
		super.commitEdit(newValue);
	}

	@Override
	protected void updateItem(String item, boolean empty) {
		// is called when the cell's state is not editing
		super.updateItem(item, empty);
		User user = (User) getTableRow().getItem();
		if (empty || user == null) {
			setText(null);
			setGraphic(null);
			return;
		}
		if (user.getId() % 2 == 0) {
			setText(getString());
			setGraphic(null);
		} else {
			setText(null);
			setGraphic(checkBox);
		}
	}

	private void createTextField() {
		textField = new TextField();
		textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				commitEdit(textField.getText());
				getTableView().edit(-1, null);
			}
		});
	}

	private void createComboBox() {
		checkBox = new CheckBox();
	}

	private String getString() {
		return getItem() == null ? "" : getItem();
	}

}
