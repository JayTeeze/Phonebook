package phonebook;

// Entry class acts as database, resets at end of program 
public class Entry {
	
	private Person[] arr = new Person[0];
	
	public Entry() {};
	
	// getter for entries
	public void getCurrentEntries() {
		if (arr.length == 0) {
			System.out.println("No records on file.");
		} else {
			for (int i = 0; i < arr.length; i++) {
				System.out.println("Entry #" + (i + 1) + ":\n" + arr[i].getFullEntry() + "\n");
			}
		}
	}
	
	// Gets number of entries in directory
	public int getNumberOfEntries() {
		return arr.length;
	}
	
	public int navigation() {
		int choice = 1;
		switch (Integer.parseInt(MainMenu.in.nextLine())) {
		case 1:
			// Returns to Main Menu
			choice = 1;
			break;
		case 2:
			// Exits program
			choice = 2;
			break;
		}
		return choice;
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
	
	// method paired with 'addEntry' to increase length of array
	private void increaseEntrySize(Person newPerson) {
		Person[] tempArr = new Person[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
		arr[arr.length - 1] = newPerson;
	}
	
	// Updates existing entries in directory
	public void updateEntry(int entry) {
		entry -= 1;
		System.out.println("\nYou selected: \n" + arr[entry].getFullEntry());
		Choices.updateRecord();
		
//		do {
//			
//		} while ();
		
		switch (Integer.parseInt(MainMenu.in.nextLine())) {
		case 1:
			System.out.print("\nEnter new FIRST NAME: ");
			arr[entry].setFirstName(MainMenu.in.nextLine().trim());
			System.out.println("\nFirst name has been updated!");
			break;
		case 2:
			System.out.print("\nEnter new MIDDLE NAME: ");
			arr[entry].setMiddleName(MainMenu.in.nextLine().trim());
			System.out.println("\nMiddle name has been updated!");
			break;
		case 3:
			System.out.print("\nEnter new LAST NAME: ");
			arr[entry].setLastName(MainMenu.in.nextLine().trim());
			System.out.println("\nLast name has been updated!");
			break;
		case 4:
			System.out.println("\nEnter new STREET ADDRESS (i.e. 123 Main St): ");
			String[] streetAddress = MainMenu.in.nextLine().trim().split(" ");
			
			arr[entry].setStreetNumber(Integer.parseInt(streetAddress[0]));
			arr[entry].setStreetName(streetAddress[1]);
			
			String suffix = "";
			for (int i = 2; i < streetAddress.length; i++) {
				suffix += streetAddress[i] + " ";
			}
			arr[entry].setStreetSuffix(suffix.trim());
			System.out.println("\nStreet Address has been updated!");
			break;
		case 5:
			System.out.print("\nEnter new CITY: ");
			arr[entry].setCity(MainMenu.in.nextLine().trim());
			System.out.println("\nCity has been updated!");
			break;
		case 6:
			System.out.print("\nEnter new STATE: ");
			arr[entry].setState(MainMenu.in.nextLine().trim());
			System.out.println("\nState has been updated!");
			break;
		case 7:
			System.out.print("\nEnter new ZIP CODE: ");
			arr[entry].setZip(Integer.parseInt(MainMenu.in.nextLine().trim()));
			System.out.println("\nZip code has been updated!");
			break;
		case 8:
			System.out.print("\nEnter new PHONE NUMBER (i.e.8881112020): ");
			arr[entry].setPhoneNumber(Long.parseLong(MainMenu.in.nextLine().trim()));
			System.out.println("\nPhone number has been updated!");
			break;
		default:
			System.out.print("\nInvalid option. Try again: ");
		}
	}

}
