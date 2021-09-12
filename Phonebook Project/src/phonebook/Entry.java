package phonebook;

import java.util.Arrays;

// Entry class acts as directory, resets at end of program 
public class Entry {
	
	private Person[] arr = new Person[0];
	
	public Entry() {};
	
	// Getter for entries (indexes) in directory (Person[] arr)
	public void getCurrentEntries() {
		if (arr.length == 0) {
			System.out.println("No records on file.");
		} else {
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				System.out.println("Entry #" + (i + 1) + ":\n" + arr[i].getFullEntry() + "\n");
			}
		}
	}
	
	// Gets number of entries in directory (Person[] arr)
	public int getNumberOfEntries() {
		return arr.length;
	}
	
	// Used to return 1 or 2 to stay in loops or exit loops
	public int chooseOption() {
		int choice = 1;
		boolean exit = false;
		
		do {
			try {
				int number = Integer.parseInt(MainMenu.in.nextLine());
				if (number >= 1 && number <= 2) {
					switch (number) {
					case 1:
						choice = 1;
						break;
					case 2:
						choice = 2;
						break;
					default:
						choice = 2;
					}
					exit = true;
				} else {
					System.out.print("Please enter a valid option: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("Please enter a valid option: ");
			}
		} while (exit == false);
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
		
		// Adds new entry(Person) to directory (Person[] arr)
		Person[] tempArr = new Person[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
		arr[arr.length - 1] = newPerson;
	}
	
	// Updates fields in existing entries in directory (Person[] arr)
	public void updateEntry(int entry) {
		boolean exit = false;
		entry -= 1;
		System.out.println("\nYou selected: \n" + arr[entry].getFullEntry());
		
		do {
			Choices.updateRecord();
			try {
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
					long phoneNumber = Long.parseLong(MainMenu.in.nextLine().trim().replaceAll("[^0-9]", ""));
					arr[entry].setPhoneNumber(phoneNumber);
					System.out.println("\nPhone number has been updated!");
					break;
				default:
					System.out.print("\nInvalid option. Try again: ");
				}
				System.out.println("Would you like to update another field?");
				Choices.yesOrNo();
				if (chooseOption() == 2) {
					exit = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid option");
			}
		} while (exit == false);
	}
	
	// Deletes an entry selected by user
	public void deleteEntry(int entry) {
		entry -= 1;
		
		System.out.println("\nYou selected: \n" + arr[entry].getFullEntry());
		System.out.println("\nAre you sure you want to delete this entry?\n");
		
		Choices.yesOrNo();
		if (chooseOption() == 1) {
			arr[entry].setFirstName("");
			Arrays.sort(arr);
			// After sort, entry gets sent to front of array and gets overwritten below
			Person[] tempArr = new Person[arr.length - 1];
			
			for (int i = 1; i < arr.length; i++) {
				tempArr[i - 1] = arr[i];
			}
			arr = tempArr;
			
			System.out.println("\nEntry deleted!");
		}
	}
}
