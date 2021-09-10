package phonebook;

public class Address {
	
	private int number;
	private String street;
	private String suffix;
	private String city;
	private String state;
	private int zip;
	
	public Address() {};
	
	public Address(int number, String street, String suffix, String city, String state, int zip) {
		super();
		this.number = number;
		this.street = street;
		this.suffix = suffix;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
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
	
	public String getFullAddress() {
		return number + " " + street + " " + suffix + "\n" + city + ", " + state + " " + zip;
	}
	
}
