package basics.components.util;

import basics.components.model.CarBrand;
import javafx.util.StringConverter;

/**
 *  
 * We need a String converter for every UI component that is not represented as a String, and we want to be
 * displayed, so we use a StringConverter to somehow convert it to string so it can be displayed.
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: CarBrandConverter.java 31604 10/5/2017 17:45  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class CarBrandConverter extends StringConverter<CarBrand> {

	@Override
	public String toString(CarBrand carBrand) {
		return carBrand == null ? "" : carBrand.getName();
	}

	@Override
	public CarBrand fromString(String string) {
		return CarBrand.valueOf(string);
	}
}
