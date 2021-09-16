package phonebook;

public class Address {
	
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	
	public Address() {};
	
	public Address(String streetAddress, String city, String state, int zip) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreetAddress() {
		setStreetAddress(streetAddress);
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = capitalCase(streetAddress);
	}

	public String getCity() {
		setCity(city);
		return city;
	}

	public void setCity(String city) {
		this.city = capitalCase(city);
	}

	public String getState() {
		setState(state);
		return state;
	}

	public void setState(String state) {
		String[] validStates = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
				"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE",
				"NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
				"TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "DC", "GU", "PR", "VI", "AA", "AE", "AP"};
		boolean isValid = false;
		
		for (int i = 0; i < validStates.length; i++) {
			if (validStates[i].equalsIgnoreCase(state)) {
				isValid = true;
				break;
			}
		}
		if (isValid == true) {
			this.state = state.substring(0).toUpperCase();
		} else {
			this.state = "Invalid State";
		}
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getFullAddress() {
		return getStreetAddress() + "\n" + getCity() + ", " + getState() + " " + zip;
	}
	
	private String capitalCase(String word) {
		String wordCapitalized = "";
		
		if (word.length() > 0) {
			String[] words = word.trim().split(" ");
			
			for (int i = 0; i < words.length; i++) {
				wordCapitalized += words[i].trim().substring(0, 1).toUpperCase() + words[i].substring(1) + " ";
			}
			return wordCapitalized.trim();
		} else {
			return word;
		}
	}
	
}
