package basics.components.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model that represents a row in the tableView.
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: User.java 31604 10/5/2017 16:12  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class User {

	private LongProperty id; // used LongProperty just for test purpose, usually we don't use.
	private StringProperty firstName;
	private StringProperty lastName;

	private StringProperty custom;

	public User(Long id, String firstName, String lastName, String custom) {
		this.id = new SimpleLongProperty(id);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.custom = new SimpleStringProperty(custom);
	}

	public long getId() {
		return id.get();
	}

	public LongProperty idProperty() {
		return id;
	}

	public String getFirstName() {
		return firstName.get();
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public String getCustom() {
		return custom.get();
	}

	public StringProperty customProperrty() {
		return custom;
	}

	@Override
	public String toString() {
		return getId() + " " + getFirstName() + " " + getLastName();
	}
}
