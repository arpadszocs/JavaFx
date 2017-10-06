package basics.components.model;

/**
 *  
 *
 * @author Szocs, Arpad (EXTERN: msg DAVID)
 * @version $Id: Land.java 31604 10/5/2017 17:01  Szocs, Arpad (EXTERN: msg DAVID) $
 * @since 10/5/2017
 */
public enum Land {

	GERMANY("Germany"),
	SPAIN("Spain"),
	FRANCE("France"),
	PORTUGAL("Portugal"),
	ITALY("Italy");

	private String name;

	Land(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
