package phonebook;

import java.util.*;

public class MainMenu {
	
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		mainInterface();
		
	}
	
	public static void mainInterface() {
		Entry directory = new Entry();
		directory.populate();
		
		boolean endProgram = false;
		boolean exit = false;
		
		System.out.println("******* WELCOME TO PHONEBOOK! *******");
		
		do {
			Choices.mainMenu();
			try {
				switch (Integer.parseInt(in.nextLine())) {
				case 1:
				// Adds new record
					System.out.println("\nEnter entry below (First Middle Last, 123 Main St, Springfield, VA, 12345, 2021231234):");
					directory.addEntry(in.nextLine());
					break;
				case 2:
				// Searches for an existing record
					if (directory.getNumberOfEntries() != 0) {
						directory.searchEntries();
					} else if (directory.getNumberOfEntries() == 0) {
						System.out.println("\nNo entries on file.");
					}
					break;
				case 3:
				// Views existing record
					if (directory.getNumberOfEntries() != 0) {
						System.out.println("\nCurrent entries are:");
						directory.getCurrentEntries();
						
						Choices.exitChoices();
						if (directory.chooseOption() == 2) {
							System.out.println("\nThank you! Goodbye.");
							endProgram = true;
						}
					} else if (directory.getNumberOfEntries() == 0) {
						System.out.println("\nNo entries on file.");
					}
					break;
				case 4:
				// Updates existing record
					if (directory.getNumberOfEntries() != 0) {
						System.out.println("\nSelect an entry you would like to update:\n");
						directory.getCurrentEntries();
						
						System.out.print("Enter selection here: ");
						do {
							try {
								int entryNum = Integer.parseInt(in.nextLine());
								if (entryNum <= directory.getNumberOfEntries() && entryNum > 0) {
									// Convert to index number
									directory.updateEntry(entryNum - 1);
									exit = true;
								} else {
									System.out.print("Please enter a valid entry number: ");
								}
								
							} catch (NumberFormatException e) {
								System.out.print("Please enter a valid entry number: ");
							}
						} while (exit == false);
						exit = false;
					} else if (directory.getNumberOfEntries() == 0) {
						System.out.println("\nNo entries on file.");
					}
					break;
				case 5:
				// Deletes existing record
					if (directory.getNumberOfEntries() != 0) {
						System.out.println("\nSelect an entry you would like to delete:\n");
						directory.getCurrentEntries();
						
						System.out.print("Enter selection here: ");
						do {
							try {
								int entryNum = Integer.parseInt(in.nextLine());
								if (entryNum <= directory.getNumberOfEntries() && entryNum > 0) {
									// Convert to index number
									directory.deleteEntry(entryNum - 1);
									exit = true;
								} else {
									System.out.print("Please enter a valid entry number: ");
								}
							} catch (NumberFormatException e) {
								System.out.print("Please enter a valid entry number: ");
							}
						} while (exit == false);
					} else if (directory.getNumberOfEntries() == 0) {
						System.out.println("\nNo entries on file.");
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
