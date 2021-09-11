package phonebook;

import java.util.Scanner;

public class MainMenu {
	
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		mainInterface();
		//Choices.updateRecord();
		
//		Entry test = new Entry();
//		test.addEntry("John Doe, 114 Market St, St Louis, MO, 63403, 6366435698");
//		test.addEntry("John E Doe, 324 Main St, St Charles, MO,63303, 8475390126");
//		test.addEntry("John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
//		test.getCurrentEntries();
		
	}
	
	public static void mainInterface() {
		Entry entries = new Entry();
		boolean endProgram = false;
		boolean exit = false;
		
		entries.addEntry("John Doe, 114 Market St, St Louis, MO, 63403, 6366435698");
		entries.addEntry("John E Doe, 324 Main St, St Charles, MO,63303, 8475390126");
		entries.addEntry("John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
		
		System.out.println("**** WELCOME TO PHONEBOOK! ****");
		
		do {
			Choices.mainMenu();
		if (in.hasNextInt()) {
			switch (Integer.parseInt(in.nextLine())) {
			case 1:
				// Add new record
				System.out.println("\nEnter entry below:");
				entries.addEntry(in.nextLine());
				System.out.println("Entry added.");
				break;
			case 2:
				// View existing record
				System.out.println("\nCurrent entries are:");
				entries.getCurrentEntries();
				Choices.exitChoices();
				
				if (entries.navigation() == 2) {
					System.out.println("\nThank you! Goodbye.");
					endProgram = true;
				}
				break;
			case 3:
				// Update existing record
				System.out.println("\nSelect an entry you would like to update:\n");
				entries.getCurrentEntries();
				if (entries.getNumberOfEntries() != 0) {
					// add code to prevent non-numbers from being added
					System.out.print("Enter selection here: ");
					entries.updateEntry(Integer.parseInt(in.nextLine()));
				}
				break;
			case 4:
				// Delete existing record
				System.out.println(4);
				break;
			case 5:
				// Exit program
				System.out.println("\nThank you! Goodbye.");
				endProgram = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} else {
			System.out.println("\nPlease enter a valid option");
		}
		} while (endProgram == false);
		
//		Choices.mainMenu();
//		if (in.hasNextInt()) {
//			switch (Integer.parseInt(in.nextLine())) {
//			case 1:
//				System.out.println("\nEnter entry below:");
//				entries.addEntry(in.nextLine());
//				System.out.println("Entry added.");
//				break;
//			case 2:
//				System.out.println("\nCurrent entries are:");
//				entries.getCurrentEntries();
//				break;
//			case 3:
//				System.out.println("\nSelect an entry you would like to update:\n");
//				entries.getCurrentEntries();
//				if (entries.getNumberOfEntries() != 0) {
//					// add code to prevent non-numbers from being added
//					System.out.print("Enter selection here: ");
//					entries.updateEntry(Integer.parseInt(in.nextLine()));
//				}
//				break;
//			case 4:
//				System.out.println(4);
//				break;
//			case 5:
//				System.out.println("\nThank you! Goodbye.");
//				endProgram = true;
//				break;
//			default:
//				System.out.println("Invalid option");
//				break;
//			}
//		} else {
//			System.out.println("\nPlease enter a valid option");
//		}
	}
	
}
