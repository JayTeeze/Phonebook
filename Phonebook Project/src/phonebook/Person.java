package phonebook;

public class Person extends Address {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private long phoneNumber;
	
	public Person() {};
	
	public Person(String firstName, String middleName, String lastName, int number, String street, 
			String suffix, String city, String state, int zip, long phoneNumber) {
		super(number, street, suffix, city, state, zip);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		if (middleName == null || middleName == "") {
			middleName = "NMI";
		}
		return firstName + " " + middleName + " " + lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFullEntry() {
		return getFullName() + "\n" + getFullAddress() + "\n" + getPhoneNumber();
	}
	
	
}
