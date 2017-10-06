package basics.components.model;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: CarBrand.java 31604 10/5/2017 16:19  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public enum CarBrand {

	AUDI("Audi"),
	VOLKSWAGEN("Volkswagen"),
	BMW("Bmw"),
	SEAT("Seat"),
	SKODA("Skoda");

	private String name;

	CarBrand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
