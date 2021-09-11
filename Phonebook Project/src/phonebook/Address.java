package phonebook;

public class Address {
	
	private int streetNumber;
	private String streetName;
	private String streetSuffix;
	private String city;
	private String state;
	private int zip;
	
	public Address() {};
	
	public Address(int streetNumber, String streetName, String streetSuffix, String city, String state, int zip) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.streetSuffix = streetSuffix;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetSuffix() {
		return streetSuffix;
	}

	public void setStreetSuffix(String streetSuffix) {
		this.streetSuffix = streetSuffix;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getStreetAddress() {
		return streetNumber + " " + streetName + " " + streetSuffix;
	}
	
	public String getFullAddress() {
		return streetNumber + " " + streetName + " " + streetSuffix + "\n" + city + ", " + state + " " + zip;
	}
	
}
