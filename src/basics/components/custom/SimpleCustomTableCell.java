package basics.components.custom;

import basics.components.model.User;
import javafx.scene.control.TableCell;

/**
 * Each instance represents a single cell in the table.
 *  
 * A simple example of how we can @Override a tableCell that is needed in most of the cases.
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: SimpleCustomTableCell.java 31604 10/6/2017 09:12  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/6/2017
 */
public class SimpleCustomTableCell extends TableCell<User, String> {

	/**
	 * This method is called every time a changed is made in the UI, so the cell have to be rendered again.
	 */
	@Override
	protected void updateItem(String item, boolean empty) {
		// 95 % of the cases you firstly should call the super.updateItem
		// If you don't call it, or it is called later, the behaviour of the cell maybe won't be as expected
		super.updateItem(item, empty);
		User user = (User) getTableRow().getItem();
		// In the most of the cases you have to do the following check because you cannot ensure that the cell won't be
		// empty or the containing element is not null.
		if (empty || user == null) {
			setText(null);
			setGraphic(null);
			setStyle(null);
			return;
		}

		// Some random action that you can do with the cell.
		if (user.getId() % 3 == 0) {
			setStyle("-fx-background-color: red");
		} else if (user.getId() % 3 == 1) {
			setStyle("-fx-background-color: green");
		} else {
			setStyle("-fx-background-color: blue");
		}
	}
}
