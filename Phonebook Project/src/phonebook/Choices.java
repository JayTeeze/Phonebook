package phonebook;

public class Choices {
	
	public static void mainMenu() {
		System.out.println("\nWhat would you like to do today?\n");
		System.out.println("To add a new record, enter 1");
		System.out.println("To view an existing record, enter 2");
		System.out.println("To update an existing record, enter 3");
		System.out.println("To delete an existing record, enter 4");
		System.out.println("To exit, enter 5");
		System.out.print("Enter choice here: ");
	}
	
	public static void updateRecord() {
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
