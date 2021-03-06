package phonebook;

import java.util.Arrays;

// Entry class acts as directory, resets at end of program 
public class Entry {
	
	private Person[] directory = new Person[0];
	
	public Entry() {};
	
	// Pre-populates program for interactive purposes
	public void populate() {
		Person[] tempArr = new Person[3];
		
		Person newPerson = new Person("John", "", "Doe",
				"114 Market St", "St Louis", "MO", 63403, 6366435698L);
		tempArr[0] = newPerson;
		
		newPerson = new Person("John", "E", "Doe",
				"324 Main St", "St Charles", "MO", 63303, 8475390126L);
		tempArr[1] = newPerson;
		
		newPerson = new Person("John", "Michael", "West Doe",
				"574 Pole ave", "St. Peters", "MO", 63333, 5628592375L);
		tempArr[2] = newPerson;
		
		directory = tempArr;
		Arrays.sort(directory);
	}
	
	// Getter for entries (indexes) in directory (Person[] arr)
	public void getCurrentEntries() {
		if (directory.length == 0) {
			System.out.println("No entries on file.\n");
		} else {
			Arrays.sort(directory);
			for (int i = 0; i < directory.length; i++) {
				System.out.println("Entry #" + (i + 1) + ":\n" + directory[i].getFullEntry() + "\n");
			}
		}
	}
	
	// Gets number of entries in directory (Person[] arr)
	public int getNumberOfEntries() {
		return directory.length;
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
		String firstName = "", middleName = "", lastName = "", streetAddress = "", city = "", state = "";
		int zipCode = 0;
		long phoneNum = 0;
		
		String[] input = userInput.split(","), streetArr, fullName;
		
		try {
			if (userInput.length() < 100) {
				if (input.length == 5 || input.length == 6) {
					// Finds beginning of address and uses characters beforehand to input name fields
					char[] charInput = userInput.toCharArray();
					String tempName = "";
					for (int i = 0; i < charInput.length; i++) {
						if (Character.isDigit(charInput[i])) {
							tempName = userInput.substring(0, i).replaceAll(",", "");
							break;
						}
					}
					// Checks length of name field and assigns name starting from first > middle > last
					fullName = tempName.trim().split(" ");
					if (fullName.length == 1) {
						firstName = fullName[0];
						
					} else if (fullName.length == 2) {
						firstName = fullName[0];
						lastName = fullName[1];
						
					} else if (fullName.length == 3) {
						firstName = fullName[0];
						middleName = fullName[1];
						lastName = fullName[2];
						
					} else if (fullName.length > 3) {
						firstName = fullName[0];
						middleName = fullName[1];
						
						for (int i = 2; i < fullName.length; i++) {
							lastName += fullName[i] + " ";
						}
					}
					
					// Finds first character that is a number and assigns streetAddress
					String tempAddress = "";
					for (int i = 0; i < charInput.length; i++) {
						if (Character.isDigit(charInput[i])) {
							tempAddress = userInput.substring(i);
							break;
						}
					}
					streetArr = tempAddress.split(",");
					streetAddress = streetArr[0].trim();
					
					// Assuming user followed format, uses comma to split and extract city
					tempAddress = streetArr[1].trim();
					streetArr = tempAddress.split(" ");
					
					if (streetArr.length > 1) {
						for (int i = 0; i < 2; i++) {
							city += streetArr[i].trim() + " ";
						}
					} else {
						city = streetArr[0].trim();
					}
					
					// Finds characters resembling state and zip code and assigns to respective fields
					state = userInput.replaceFirst(".*\\w*.*\\s([a-zA-Z]+).*\\s*\\d{5}.*\\s*\\d{3}.*\\d{3}.*\\d{4}.*$", "$1");
					zipCode = Integer.parseInt(userInput.replaceFirst(".*\\w*.*\\s*[a-zA-Z][a-zA-Z]"
							+ ".*\\s*(\\d{5}).*\\s*\\d{3}.*\\d{3}.*\\d{4}.*$", "$1"));
					
					// Will look for series of numbers resembling US phone number format
					// Assigns that number to phone number
					phoneNum = Long.parseLong(userInput.replaceFirst(".*(\\d{3}).*(\\d{3}).*(\\d{4}).*$", "$1$2$3"));
					
					Person newPerson = new Person(firstName, middleName, lastName,
							streetAddress, city, state, zipCode, phoneNum);
					
					// Adds new entry(Person) to directory (Person[] directory)
					Person[] tempArr = new Person[directory.length + 1];
					for (int i = 0; i < directory.length; i++) {
						tempArr[i] = directory[i];
					}
					directory = tempArr;
					directory[directory.length - 1] = newPerson;
					
					System.out.println("\nEntry added!");
				} else {
					System.out.println("\nInvalid entry format. Check your commas.");
				}
			} else {
				System.out.println("\nEntry is over max allowed characters.");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\nInvalid entry.");
		} catch (NumberFormatException e) {
			System.out.println("\nInvalid entry.");
		}
	}
	
	// Searches for existing entries using user selected search criteria
	public void searchEntries() {
		int[] searchResultChoice = new int[0];
		int counter = 0;
		boolean exit = false;
		Arrays.sort(directory);
		
		Choices.searchEntries();
		do {
			try {
				int entry = Integer.parseInt(MainMenu.in.nextLine());
				if (entry >= 1 && entry <= 6) {
					
					switch (entry) {
					case 1:
						System.out.print("\nEnter FIRST NAME: ");
						String searchInput = MainMenu.in.nextLine().trim();
						String[] searchArr = searchInput.split(" ");
						int matchesFound = 0;
						
						for (int i = 0; i < directory.length; i++) {
							for (int j = 0; j < searchArr.length; j++) {
								if (directory[i].getFirstName().toLowerCase().contains(searchArr[j].trim().toLowerCase())) {
									matchesFound++;
								}
								if (matchesFound == searchArr.length) {
									System.out.println("\nEntry #" + (counter + 1) + ":\n" + directory[i].getFullEntry());
									// Getting index number in Person[] directory for any matching results and adding to search results array
									int[] tempArr = new int[searchResultChoice.length + 1];
									for (int index = 0; index < searchResultChoice.length; index++) {
										tempArr[index] = searchResultChoice[index];
									}
									searchResultChoice = tempArr;
									searchResultChoice[searchResultChoice.length - 1] = i;
									counter++;
								}
							}
							matchesFound = 0;
						}
						break;
					case 2:
						System.out.print("\nEnter LAST NAME: ");
						searchInput = MainMenu.in.nextLine().trim();
						searchArr = searchInput.split(" ");
						matchesFound = 0;
						
						for (int i = 0; i < directory.length; i++) {
							for (int j = 0; j < searchArr.length; j++) {
								if (directory[i].getLastName().toLowerCase().contains(searchArr[j].trim().toLowerCase())) {
									matchesFound++;
								}
								if (matchesFound == searchArr.length) {
									System.out.println("\nEntry #" + (counter + 1) + ":\n" + directory[i].getFullEntry());
									// Getting index number in Person[] directory for any matching results and adding to search results array
									int[] tempArr = new int[searchResultChoice.length + 1];
									for (int index = 0; index < searchResultChoice.length; index++) {
										tempArr[index] = searchResultChoice[index];
									}
									searchResultChoice = tempArr;
									searchResultChoice[searchResultChoice.length - 1] = i;
									counter++;
								}
							}
							matchesFound = 0;
						}
						break;
					case 3:
						System.out.print("\nEnter FULL NAME: ");
						searchInput = MainMenu.in.nextLine().trim();
						searchArr = searchInput.split(" ");
						matchesFound = 0;
						
						for (int i = 0; i < directory.length; i++) {
							for (int j = 0; j < searchArr.length; j++) {
								if (directory[i].getFullName().toLowerCase().contains(searchArr[j].trim().toLowerCase())) {
									matchesFound++;
								}
								if (matchesFound == searchArr.length) {
									System.out.println("\nEntry #" + (counter + 1) + ":\n" + directory[i].getFullEntry());
									// Getting index number in Person[] directory for any matching results and adding to search results array
									int[] tempArr = new int[searchResultChoice.length + 1];
									for (int index = 0; index < searchResultChoice.length; index++) {
										tempArr[index] = searchResultChoice[index];
									}
									searchResultChoice = tempArr;
									searchResultChoice[searchResultChoice.length - 1] = i;
									counter++;
								}
							}
							matchesFound = 0;
						}
						break;
					case 4:
						System.out.print("\nEnter TELEPHONE NUMBER: ");
						searchInput = MainMenu.in.nextLine().trim().replaceAll("[^0-9]", "");
						
						if(searchInput.matches("^\\d+$")) {
							long phoneNumber = Long.parseLong(searchInput);
							for (int i = 0; i < directory.length; i++) {
								if (phoneNumber == directory[i].getPhoneNumber()) {
									System.out.println("\nEntry #" + (counter + 1) + ":\n" + directory[i].getFullEntry());
									
									// Getting index number in Person[] directory for any matching results and adding to search results array
									int[] tempArr = new int[searchResultChoice.length + 1];
									for (int index = 0; index < searchResultChoice.length; index++) {
										tempArr[index] = searchResultChoice[index];
									}
									searchResultChoice = tempArr;
									searchResultChoice[searchResultChoice.length - 1] = i;
									counter++;
								}
							}
						}
						break;
					case 5:
						System.out.print("\nEnter CITY: ");
						searchInput = MainMenu.in.nextLine().trim();
						searchArr = searchInput.split(" ");
						matchesFound = 0;
						
						for (int i = 0; i < directory.length; i++) {
							for (int j = 0; j < searchArr.length; j++) {
								if (directory[i].getCity().toLowerCase().contains(searchArr[j].trim().toLowerCase())) {
									matchesFound++;
								}
								if (matchesFound == searchArr.length) {
									System.out.println("\nEntry #" + (counter + 1) + ":\n" + directory[i].getFullEntry());
									// Getting index number in Person[] directory for any matching results and adding to search results array
									int[] tempArr = new int[searchResultChoice.length + 1];
									for (int index = 0; index < searchResultChoice.length; index++) {
										tempArr[index] = searchResultChoice[index];
									}
									searchResultChoice = tempArr;
									searchResultChoice[searchResultChoice.length - 1] = i;
									counter++;
								}
							}
							matchesFound = 0;
						}
						break;
					case 6:
						System.out.print("\nEnter STATE: ");
						searchInput = MainMenu.in.nextLine().trim();
						
						for (int i = 0; i < directory.length; i++) {
							if (searchInput.equalsIgnoreCase(directory[i].getState())) {
								System.out.println("\nEntry #" + (counter + 1) + ":\n" + directory[i].getFullEntry());
								// Getting index number in Person[] directory for any matching results and adding to search results array
								int[] tempArr = new int[searchResultChoice.length + 1];
								for (int index = 0; index < searchResultChoice.length; index++) {
									tempArr[index] = searchResultChoice[index];
								}
								searchResultChoice = tempArr;
								searchResultChoice[searchResultChoice.length - 1] = i;
								counter++;
							}
						}
						break;
					}
					exit = true;
				} else if (entry == 7) {
					exit = true;
				} else {
					System.out.print("\nPlease enter a valid entry number: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("\nPlease enter a valid entry number: ");
			}
		} while (exit == false);
		
		// If results come back, execute code below
		if (counter > 0) {
			subSearchEntries(searchResultChoice, counter);
		} else {
			System.out.println("No entries matched criteria.");
		}
	}
	
	// Sub-method for searchEntries() that when together hold index of Person in Person[] directory
	// Will either update an entry, delete an entry or return to Main Menu
	private void subSearchEntries(int[] searchResultChoice, int counter) {
		boolean exit = false;
		Choices.searchEntriesSubMenu();
		do {
			try {
				int choice = Integer.parseInt(MainMenu.in.nextLine());
				if (choice >= 1 && choice <= 4) {
					switch (choice) {
					case 1:
					// Updates a record from search results and prompts user to select entry to update
						System.out.print("\nPlease select entry # from search results: ");
						do {
							try {
								choice = Integer.parseInt(MainMenu.in.nextLine());
								if (choice > 0 && choice <= counter) {
									// Passes index from search result entry to updateEntry()
									updateEntry(searchResultChoice[choice - 1]);
									exit = true;
								} else {
									System.out.print("\nPlease enter a valid option: ");
								}
							} catch (NumberFormatException e) {
								System.out.print("\nPlease enter a valid option: ");
							}
						} while (exit == false);
						exit = false;
						break;
					case 2:
					// Deletes a record from the search results
						System.out.print("\nPlease select entry # from search results: ");
						do {
							try {
								choice = Integer.parseInt(MainMenu.in.nextLine());
								if (choice > 0 && choice <= counter) {
									// Passes index from search result entry to deleteEntry()
									deleteEntry(searchResultChoice[choice - 1]);
									exit = true;
								} else {
									System.out.print("\nPlease enter a valid option: ");
								}
							} catch (NumberFormatException e) {
								System.out.print("\nPlease enter a valid option: ");
							}
						} while (exit == false);
						exit = false;
						break;
					// Allows user to search another entry after finishing a search query
					case 3:
						searchEntries();
						break;
					// Ends loop and returns user to Main Menu
					case 4:
						break;
					}
					exit = true;
				} else {
					System.out.print("\nPlease enter a valid option: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("\nPlease enter a valid option: ");
			}
		} while (exit == false);
	}
	
	// Updates fields in existing entries in directory Person[] directory
	public void updateEntry(int entry) {
		boolean exit = false;
		System.out.println("\nEntry selected: \n" + directory[entry].getFullEntry());
		
		do {
			Choices.updateEntry();
			try {
				switch (Integer.parseInt(MainMenu.in.nextLine())) {
				case 1:
					System.out.print("\nEnter new FIRST NAME: ");
					directory[entry].setFirstName(MainMenu.in.nextLine().trim());
					System.out.println("\nFirst name has been updated!\n");
					break;
				case 2:
					System.out.print("\nEnter new MIDDLE NAME: ");
					directory[entry].setMiddleName(MainMenu.in.nextLine().trim());
					System.out.println("\nMiddle name has been updated!\n");
					break;
				case 3:
					System.out.print("\nEnter new LAST NAME: ");
					directory[entry].setLastName(MainMenu.in.nextLine().trim());
					System.out.println("\nLast name has been updated!\n");
					break;
				case 4:
					System.out.println("\nEnter new STREET ADDRESS (i.e. 123 Main St): ");
					directory[entry].setStreetAddress(MainMenu.in.nextLine().trim());
					System.out.println("\nStreet Address has been updated!\n");
					break;
				case 5:
					System.out.print("\nEnter new CITY: ");
					directory[entry].setCity(MainMenu.in.nextLine().trim());
					System.out.println("\nCity has been updated!\n");
					break;
				case 6:
					System.out.print("\nEnter new STATE: ");
					directory[entry].setState(MainMenu.in.nextLine().trim());
					System.out.println("\nState has been updated!\n");
					break;
				case 7:
					System.out.print("\nEnter new ZIP CODE: ");
					directory[entry].setZip(Integer.parseInt(MainMenu.in.nextLine().trim()));
					System.out.println("\nZip code has been updated!\n");
					break;
				case 8:
					System.out.print("\nEnter new PHONE NUMBER: ");
					long phoneNumber = Long.parseLong(MainMenu.in.nextLine().replaceAll("[^0-9]", ""));
					directory[entry].setPhoneNumber(phoneNumber);
					System.out.println("\nPhone number has been updated!\n");
					break;
				default:
					System.out.print("\nInvalid option. Try again: ");
				}
				Arrays.sort(directory);
				System.out.println("Would you like to update another field?\n");
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
		System.out.println("\nEntry selected: \n" + directory[entry].getFullEntry());
		System.out.println("\nAre you sure you want to delete this entry?\n");
		
		Choices.yesOrNo();
		if (chooseOption() == 1) {
			// Deletes first name and sends to first spot in array after array sort
			directory[entry].setFirstName("");
			Arrays.sort(directory);
			// After sort, entry gets sent to front of array and gets overwritten below
			Person[] tempArr = new Person[directory.length - 1];
			
			for (int i = 1; i < directory.length; i++) {
				tempArr[i - 1] = directory[i];
			}
			directory = tempArr;
			
			System.out.println("\nEntry deleted!");
		}
	}
}
