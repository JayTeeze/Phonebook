package phonebook;

import java.util.Scanner;

public class MainMenu {
	
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		//mainInterface();
		
		Entry test = new Entry();
		test.create("hello.");
		
	}
	
	public static void mainInterface() {
		Entry entries = new Entry();
		entries.prePopulate();
		boolean mainExit = false;
		
		System.out.println("**** WELCOME TO PHONEBOOK! ****");
		Choices.mainMenu();
		
		switch (in.nextInt()) {
		case 1:
			//entries.add(entries.create());
			entries.getCurrent()[entries.getCurrent().length - 1].getFullEntry();
			break;
		case 2:
			System.out.println();
			for (int i = 0; i < entries.getCurrent().length; i++) {
				System.out.println("Entry #" + (i + 1) + ":\n" +
				entries.getCurrent()[i].getFullEntry() + "\n");
			}
			break;
		case 3:
			System.out.println(3);
			break;
		case 4:
			System.out.println(4);
			break;
		case 5:
			mainExit = true;
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
	}
	
}
