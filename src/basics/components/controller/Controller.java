package basics.components.controller;

import basics.components.custom.CustomTableCell;
import basics.components.model.CarBrand;
import basics.components.model.CarModel;
import basics.components.model.Land;
import basics.components.model.User;
import basics.components.util.CarBrandConverter;
import basics.components.util.LandConverter;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: Controller.java 31604 10/5/2017 15:45  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class Controller implements Initializable {

	@FXML
	private TextField textFieldFirstName;
	@FXML
	private TextField textFieldLastName;

	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonRemove;

	@FXML
	private TableView<User> tableView;
	@FXML
	private TableColumn<User, Long> colId;
	@FXML
	private TableColumn<User, String> colFirstName;
	@FXML
	private TableColumn<User, String> colLastName;
	@FXML
	private TableColumn<User, String> colCustom;
	@FXML
	private TreeTableView<CarModel> treeTableView;
	@FXML
	public TreeTableColumn<CarModel, CarBrand> colBrand;
	@FXML
	public TreeTableColumn<CarModel, String> colName;
	@FXML
	public TreeTableColumn<CarModel, String> colDescription;
	@FXML
	public TreeTableColumn<CarModel, Double> colPrice;
	@FXML
	public TreeTableColumn<CarModel, Boolean> colAvailable;

	@FXML
	private ComboBox<Land> comboBoxLand;

	@FXML
	private Button buttonAddBrand;
	@FXML
	private Button buttonAddModel;

	@FXML
	private CheckBox checkBoxDisable;

	private ObservableList<User> userData = FXCollections.observableArrayList();

	private final ObservableList<CarBrand> brands = FXCollections
			.observableArrayList(Arrays.asList(CarBrand.values()));

	private static long id = 1;

	/**
	 * It is called right after the constructor call, and at this step, it is sure that all components
	 * annotated with @{@link FXML} are initialized, so you can call their methods without
	 * any {@link NullPointerException}
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initializeTable();
		initializeTreeTable();
		initializeButtons();
		initializeLands();

		// TODO : Listeners
		//addSelectionListener();
		//addListener();

		//TODO : Bindings
		//bindToCheckBox();
		//bindTextFields();
		//bindTextFieldsBidirectional();
		//bindModified();
		//chainBindings();
		//whenAndThen();
		//bindAddDisable();
		//bindModifiedAddDisable();
	}

	private void initializeTable() {
		// tableView = new TableView(); // never do this!!! :)
		// You should never instantiate any component which are annotated with @FXML

		// CellValueFactory handles the value that should be displayed in the text
		colId.setCellValueFactory(data -> data.getValue().idProperty().asObject());

		colFirstName.setCellValueFactory(data -> data.getValue().firstNameProperty());

		colLastName.setCellValueFactory(data -> data.getValue().lastNameProperty());

		// By default the table is not editable, so you may call editable true if you want to be editable.
		tableView.setEditable(true);
		colCustom.setCellValueFactory(data -> data.getValue().customProperrty());

		// CelLFactory handles the things about the Cell itself for example the displayed Node(TextField,ComboBox,...)
		colCustom.setCellFactory(factory -> new CustomTableCell());
	}

	private void initializeTreeTable() {
		treeTableView.setShowRoot(false);
		treeTableView.setEditable(true); // default is false
		treeTableView.setRoot(new TreeItem<>());

		colBrand.setCellValueFactory(data -> data.getValue().getValue().brandProperty());
		colBrand.setCellFactory(factory -> new ComboBoxTreeTableCell<>(new CarBrandConverter(), brands));

		colName.setCellValueFactory(data -> data.getValue().getValue().nameProperty());
		// By default is not defined any StringConverter that needed to display text in a cell,
		// so you have to define one.
		colName.setCellFactory(factory -> new TextFieldTreeTableCell<>(new StringConverter<String>() {
			@Override public String toString(String object) {
				return object;
			}

			@Override public String fromString(String string) {
				return string;
			}
		}));

		colDescription.setCellValueFactory(data -> data.getValue().getValue().descriptionProperty());
		colDescription.setCellFactory(factory -> new TextFieldTreeTableCell<>(new StringConverter<String>() {
			@Override public String toString(String object) {
				return object;
			}

			@Override public String fromString(String string) {
				return string;
			}
		}));

		colPrice.setCellValueFactory(data -> data.getValue().getValue().priceProperty().asObject());
		colPrice.setCellFactory(factory -> new TextFieldTreeTableCell<>(new StringConverter<Double>() {
			@Override public String toString(Double object) {
				return object.toString();
			}

			@Override public Double fromString(String string) {
				return Double.valueOf(string);
			}
		}));

		colAvailable.setCellValueFactory(data -> data.getValue().getValue().availableProperty());
		colAvailable.setCellFactory(factory -> new CheckBoxTreeTableCell<>());
		colAvailable.setStyle("-fx-alignment: center");

		tableView.setItems(userData);

	}

	private void initializeButtons() {
		// On the button press is executed the event added in setOnAction.
		buttonAdd.setOnAction(event -> addNewUser());

		buttonRemove.setOnAction(event -> removeUser());

		buttonAddBrand.setOnAction(event -> addBrand());

		buttonAddModel.setOnAction(event -> addNewCarModel());
	}

	private void initializeLands() {
		List<Land> lands = Arrays.asList(Land.values());
		comboBoxLand.setItems(FXCollections.observableArrayList(lands));
		comboBoxLand.setConverter(new LandConverter());
	}

	private void addNewUser() {
		// Simply just add elements to the ObservableList the rest is handled by the TableView's ItemsProperty.
		userData.add(new User(id++, textFieldFirstName.getText(), textFieldLastName.getText(), ""));
	}

	private void removeUser() {
		// You can remove by removing the element from the list.
		userData.remove(tableView.getSelectionModel().getSelectedItem());
	}

	private void addBrand() {
		CarModel brand = new CarModel();
		// Every TreeTable has TreeItem's as rows, therefore you have to create one treeItem that can be added to
		// another TreeItem which is its parent.
		// As value you can specify a Model and add it to the TreeItem.
		TreeItem<CarModel> brandItem = new TreeItem<>(brand);
		treeTableView.getRoot().getChildren().add(brandItem);
	}

	private void addNewCarModel() {
		CarModel model = new CarModel();
		TreeItem<CarModel> parentItem = treeTableView.getSelectionModel().getSelectedItem();
		parentItem.getChildren().add(new TreeItem<>(model));

	}

	/*
	 * You can use the listeners and the bindings on the {@link javafx.beans.property.Property}es
	 *
	 */

	/**
	 * Listeners
	 */

	private void addSelectionListener() {
		// At the most of the cases we care about the newValue, because we want to do something with the newValue,
		// The observable is just the observed value which value is handled
		tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			// usually we have a condition, to check one of the value's property.
			if (newValue.getId() % 2 == 0) { // some condition
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Alert!!!");
				alert.setContentText(newValue.toString());
				alert.show();
			}
		});

	}

	private void addListener() {
		// We can also pass as a method in the lambdas and handle it separately
		checkBoxDisable.selectedProperty().addListener((observable, oldValue, newValue) -> setUiDisabled(newValue));
	}

	/**
	 * For example disable the UI
	 */
	private void setUiDisabled(boolean disabled) {
		treeTableView.setEditable(!disabled);

		textFieldFirstName.setDisable(disabled);
		textFieldFirstName.setEditable(!disabled);

		textFieldLastName.setDisable(disabled);
		textFieldLastName.setEditable(!disabled);

		buttonAddModel.setDisable(disabled);
		buttonAddBrand.setDisable(disabled);
		buttonAdd.setDisable(disabled);
		buttonRemove.setDisable(disabled);

		comboBoxLand.setDisable(disabled);
	}

	/**
	 * Bindings
	 */

	private void bindToCheckBox() {
		//Simple binding that binds two properties, which means that on properties change
		// results the change of the other's
		buttonAdd.disableProperty().bind(checkBoxDisable.selectedProperty());
	}

	/**
	 * Binds the two {@link TextField}s in one direction which means if you enter a text in the first it results the
	 * second's text is updated to the first one, but in the other direction is not working unless you use bidirectional
	 * binding
	 */
	private void bindTextFields() {
		textFieldLastName.textProperty().bind(textFieldFirstName.textProperty());
	}

	/**
	 * Bidirectional binding that supports binding in both way, it doesn't matter which textfield are you editing,
	 * it results the change at the other one.
	 */
	private void bindTextFieldsBidirectional() {
		textFieldLastName.textProperty().bindBidirectional(textFieldFirstName.textProperty());
	}

	private void bindModified() {
		textFieldFirstName.textProperty().bind(Bindings.createStringBinding(() ->
				textFieldLastName.getText().toUpperCase(), // observed value
				textFieldLastName.textProperty() // observed property
		));
	}

	private void chainBindings() {
		textFieldLastName.disableProperty()
				.bind(textFieldFirstName.textProperty().isEmpty().not()
						.and(Bindings.size(tableView.getItems()).greaterThan(10)));
	}

	private void whenAndThen() {
		textFieldLastName.textProperty().bind(
				Bindings.when(textFieldFirstName.textProperty().isEmpty())
						.then("Empty")
						.otherwise(textFieldFirstName.textProperty())
		);
	}

	private void bindAddDisable() {
		buttonAdd.disableProperty()
				.bind(textFieldFirstName.textProperty().isNotEmpty().or(textFieldLastName.textProperty().isEmpty()));
	}

	private void bindModifiedAddDisable() {
		// You can create any complex binding using any observableValue as dependency.
		buttonAdd.disableProperty()
				.bind(Bindings.createBooleanBinding(
						() -> !textFieldFirstName.getText().matches("[A-Z][a-z]{3}") || !textFieldLastName.getText()
								.matches("[A-Z][a-z]{3}") || textFieldLastName.getText().isEmpty(),
						textFieldFirstName.textProperty(),
						textFieldLastName.textProperty()));
	}

}
