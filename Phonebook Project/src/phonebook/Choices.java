package phonebook;

public class Choices {
	
	public static void mainMenu() {
		System.out.println("What would you like to do today?\n");
		System.out.println("To add a new record, press 1");
		System.out.println("To view an existing record, press 2");
		System.out.println("To update an existing record, press 3");
		System.out.println("To delete an existing record, press 4");
		System.out.println("To exit, press 5");
		System.out.print("Enter choice here: ");
	}
	
	public static void viewRecord() {
		System.out.println("Search records by:\n");
		System.out.println("First name, press 1");
		System.out.println("Middle name, press 2");
		System.out.println("Last name, press 3");
		System.out.println("Address, press 4");
		System.out.print("\nEnter choice here: ");
	}
	
	public static void updateRecord() {
		System.out.println("What would you like to update?\n");
		System.out.println("To add a new record, press 1");
		System.out.println("To update an existing record, press 2");
		System.out.println("To delete an existing record, press 3");
	}
	
	public static void deleteRecord() {
		System.out.println("To add a new record, press 1");
		System.out.println("To update an existing record, press 2");
		System.out.println("To delete an existing record, press 3");
	}

}
