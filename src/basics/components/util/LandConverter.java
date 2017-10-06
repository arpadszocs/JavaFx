package basics.components.util;

import basics.components.model.Land;
import javafx.util.StringConverter;

/**
 *  
 *  see {@link CarBrandConverter}'s description.
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: LandConverter.java 31604 10/5/2017 17:28  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public class LandConverter extends StringConverter<Land> {


	@Override
	public String toString(Land land) {
		return land.getName();
	}

	@Override
	public Land fromString(String string) {
		return Land.valueOf(string);
	}
}
