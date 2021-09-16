package phonebook;

import java.util.*;

public class MainMenu {
	
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		mainInterface();
		
	}
	
	public static void mainInterface() {
		Entry entries = new Entry();
		boolean endProgram = false;
		boolean exit = false;
		
		System.out.println("***** WELCOME TO PHONEBOOK! *****");
		
		do {
			Choices.mainMenu();
			try {
				switch (Integer.parseInt(in.nextLine())) {
				case 1:
				// Adds new record
					System.out.println("\nEnter entry below (First Middle Last, 123 Main St, Springfield, VA, 12345, 2021231234):");
					entries.addEntry(in.nextLine());
					break;
				case 2:
				// Searches for an existing record
					if (entries.getNumberOfEntries() != 0) {
						Choices.searchEntries();
						do {
							try {
								int entryNum = Integer.parseInt(in.nextLine());
								if (entryNum >= 1 && entryNum <= 6) {
									entries.searchEntries(entryNum);
									exit = true;
								} else if (entryNum == 7) {
									exit = true;
								} else {
									System.out.print("Please enter a valid entry number: ");
								}
							} catch (NumberFormatException e) {
								System.out.print("Please enter a valid entry number: ");
							}
						} while (exit == false);
						exit = false;
					} else if (entries.getNumberOfEntries() == 0) {
						System.out.println("\nNo entries on file.");
					}
					break;
				case 3:
				// Views existing record
					System.out.println("\nCurrent entries are:");
					entries.getCurrentEntries();
					
					Choices.exitChoices();
					if (entries.chooseOption() == 2) {
						System.out.println("\nThank you! Goodbye.");
						endProgram = true;
					}
					break;
				case 4:
				// Updates existing record
					System.out.println("\nSelect an entry you would like to update:\n");
					entries.getCurrentEntries();
					
					if (entries.getNumberOfEntries() != 0) {
						System.out.print("Enter selection here: ");
						do {
							try {
								int entryNum = Integer.parseInt(in.nextLine());
								if (entryNum <= entries.getNumberOfEntries() && entryNum > 0) {
									// Convert to index number
									entries.updateEntry(entryNum - 1);
									exit = true;
								} else {
									System.out.print("Please enter a valid entry number: ");
								}
								
							} catch (NumberFormatException e) {
								System.out.print("Please enter a valid entry number: ");
							}
						} while (exit == false);
						exit = false;
					}
					break;
				case 5:
				// Deletes existing record
					System.out.println("\nSelect an entry you would like to delete:\n");
					entries.getCurrentEntries();
					
					if (entries.getNumberOfEntries() != 0) {
						System.out.print("Enter selection here: ");
						do {
							try {
								int entryNum = Integer.parseInt(in.nextLine());
								if (entryNum <= entries.getNumberOfEntries() && entryNum > 0) {
									// Convert to index number
									entries.deleteEntry(entryNum - 1);
									exit = true;
								} else {
									System.out.print("Please enter a valid entry number: ");
								}
							} catch (NumberFormatException e) {
								System.out.print("Please enter a valid entry number: ");
							}
						} while (exit == false);
					}
					exit = false;
					break;
				case 6:
				// Exits program
					System.out.println("\nThank you! Goodbye.");
					endProgram = true;
					break;
				default:
					System.out.println("\nPlease enter a valid option");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("\nPlease enter a valid option");
			}
		} while (endProgram == false);
	}
	
}
