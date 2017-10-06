package basics.components.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: CarModel.java 31604 10/5/2017 16:18  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class CarModel {


	// Usually we don't use property for Id, because we don't display it.
	// Id is needed for the save, and usually is null for new objects.
	private Long id;

	private ObjectProperty<CarBrand> brand; // custom object property
	private StringProperty name;
	private StringProperty description;
	private DoubleProperty price;
	private BooleanProperty available;

	private static long fakeId = 1;

	public CarModel() {
		this(fakeId++, null, "", "", 0D, false);
	}

	public CarModel(
			Long id,
			CarBrand brand,
			String name,
			String description, Double price, Boolean available) {
		this.id = id;
		this.brand = new SimpleObjectProperty<>(brand);
		this.name = new SimpleStringProperty(name);
		this.description = new SimpleStringProperty(description);
		this.price = new SimpleDoubleProperty(price);
		this.available = new SimpleBooleanProperty(available);
	}

	public Long getId() {
		return id;
	}

	public CarBrand getBrand() {
		return brand.get();
	}

	public ObjectProperty<CarBrand> brandProperty() {
		return brand;
	}

	public String getName() {
		return name.get();
	}

	public StringProperty nameProperty() {
		return name;
	}

	public String getDescription() {
		return description.get();
	}

	public StringProperty descriptionProperty() {
		return description;
	}

	public double getPrice() {
		return price.get();
	}

	public DoubleProperty priceProperty() {
		return price;
	}

	public BooleanProperty availableProperty() {
		return available;
	}

	public boolean isAvailable() {
		return available.get();
	}
}
