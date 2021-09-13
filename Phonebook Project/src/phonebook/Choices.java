package phonebook;

public class Choices {
	
	public static void mainMenu() {
		System.out.println("\nWhat would you like to do today?\n");
		System.out.println("To add a new entry, enter 1");
		System.out.println("To search for an existing entry, enter 2");
		System.out.println("To view an existing entry, enter 3");
		System.out.println("To update an existing entry, enter 4");
		System.out.println("To delete an existing entry, enter 5");
		System.out.println("To exit, enter 6");
		System.out.print("Enter choice here: ");
	}
	
	public static void searchEntries() {
		System.out.println("\nSelect search criteria:");
		System.out.println("Search by FIRST NAME, enter 1");
		System.out.println("Search by LAST NAME, enter 2");
		System.out.println("Search by FULL NAME, enter 3");
		System.out.println("Search by TELEPHONE NUMBER, enter 4");
		System.out.println("Search by CITY, enter 5");
		System.out.println("Search by STATE, enter 6");
		System.out.print("Enter choice here: ");
	}
	
	public static void searchEntriesSubMenu() {
		System.out.println("To UPDATE an entry, enter 1");
		System.out.println("To DELETE an entry, enter 2");
		System.out.println("To go back to Main Menu, enter 3");
		System.out.print("Enter choice here: ");
	}
	
	public static void updateEntry() {
		System.out.println("\nWhat would you like to update?\n");
		System.out.println("To update FIRST NAME, enter 1");
		System.out.println("To update MIDDLE NAME, enter 2");
		System.out.println("To update LAST NAME, enter 3");
		System.out.println("To update STREET ADDRESS, enter 4");
		System.out.println("To update CITY, enter 5");
		System.out.println("To update STATE, enter 6");
		System.out.println("To update ZIP CODE, enter 7");
		System.out.println("To update PHONE NUMBER, enter 8");
		System.out.print("Enter choice here: ");
	}
	
	public static void exitChoices() {
		System.out.println("To return to Main Menu, enter 1");
		System.out.println("To exit program, enter 2");
		System.out.print("Enter choice here: ");
	}
	
	public static void yesOrNo() {
		System.out.println("YES, enter 1");
		System.out.println("NO, enter 2");
		System.out.print("Enter choice here: ");
	}

}
