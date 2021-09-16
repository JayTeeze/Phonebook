package phonebook;

public class Person extends Address implements Comparable <Person> {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private long phoneNumber;
	
	public Person() {};
	
	public Person(String firstName, String middleName, String lastName, String streetAddress,
			String city, String state, int zip, long phoneNumber) {
		super(streetAddress, city, state, zip);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		setFirstName(firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = capitalCase(firstName);
	}

	public String getMiddleName() {
		setMiddleName(middleName);
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = capitalCase(middleName);
	}

	public String getLastName() {
		setLastName(lastName);
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = capitalCase(lastName);
	}
	
	public String getFullName() {
		String fullName;
		if (middleName == null || middleName == "") {
			fullName = getFirstName() + " " + getLastName();
		} else {
			fullName = getFirstName() + " " + getMiddleName() + " " + getLastName();
		}
		return fullName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public String getPhoneAsString() {
		return String.valueOf(phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFullEntry() {
		return getFullName() + "\n" + getFullAddress() + "\n" + getPhoneAsString();
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

	@Override
	public int compareTo(Person o) {
		return getFullName().compareTo(o.getFullName());
	}
	
	
}
