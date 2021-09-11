package phonebook;

// Entry class acts as database, resets at end of program 
public class Entry {
	
	private Person[] arr = new Person[0];
	
	public Entry() {};
	
	// getter for entries
	public void getCurrentEntries() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Entry #" + (i + 1) + ":\n" + arr[i].getFullEntry() + "\n");
		}
		if (arr.length == 0) {
			System.out.println("No records on file.");
		}
	}
	
	// Adds user input as an entry
	public void addEntry(String userInput) {
		String firstName = "", middleName = null, lastName = "", addressName = "", streetSuffix = "", city = "", state = "";
		int addressNumber = 0, zipCode = 0;
		long phoneNum = 0;
		
		String[] input = userInput.trim().split(",");
		String[] fullName = input[0].trim().split(" ");
		String[] streetAddress = input[1].trim().split(" ");
		
		// Checks whether name input is "First Last" or "First Middle Last" and assigns to name fields
		if (fullName.length == 2) {
			firstName = fullName[0];
			lastName = fullName[1];
		} else if (fullName.length == 3) {
			firstName = fullName[0];
			middleName = fullName[1];
			lastName = fullName[2];
		} else if (fullName.length == 4) {
			firstName = fullName[0];
			middleName = fullName[1];
			lastName = fullName[2] + " " + fullName[3];
		}
		
		// Assigns to address fields
		addressNumber = Integer.parseInt(streetAddress[0]);
		addressName = streetAddress[1];
		streetSuffix = streetAddress[2];
		city = input[2].trim();
		state = input[3].trim();
		zipCode = Integer.parseInt(input[4].trim());
		
		// Assigns phone number
		phoneNum = Long.parseLong(input[5].trim());
		
		Person newPerson = new Person(firstName, middleName, lastName, addressNumber, addressName, streetSuffix, city, state, zipCode, phoneNum);
		increaseEntrySize(newPerson);
	}
	
	// method paired with 'addEntry' to increase length of array and sets null values to last object in array
	private void increaseEntrySize(Person newPerson) {
		Person[] tempArr = new Person[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
		arr[arr.length - 1] = newPerson;
	}
	
	private void updateEntry() {
		
	}

}
