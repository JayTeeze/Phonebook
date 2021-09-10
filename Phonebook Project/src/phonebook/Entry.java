package phonebook;

// Entry class acts as database, resets at end of program 
public class Entry {
	
	private Person[] arr = new Person[3];
	
	public Entry() {};
	
	// getter for entries
	public Person[] getCurrent() {
		return arr;
	}
	
	// pre-populates Person array at start of program
	public void prePopulate() {
		this.arr[0] = new Person("John", null, "Doe", 114, "Market", "St", "St Louis", "MO", 63403, 6366435698L);
		this.arr[1] = new Person("John", "E", "Doe", 324, "Main", "St", "St Charles", "MO", 63303, 8475390126L);
		this.arr[2] = new Person("John", "Michael", "West Doe", 574, "Pole", "Ave", "St Peters", "MO", 63333, 5628592375L);
	}
	
	public void create(String userInput) {
		if (userInput == null || userInput.isEmpty()) {
			userInput = "0";
		}
		
		char[] characters = userInput.toCharArray();
		String[] input = new String[1];
		String[] temp;
		int endOfLine = characters.length - 1;
		String word = "";
		int wordCount = 0;
		boolean isWord = false;
		
		for (int i = 0; i < characters.length; i++) {
			if (Character.isLetter(characters[i]) && i != endOfLine) {
				word += characters[i];
				isWord = true;
			} else if (!Character.isLetter(characters[i])  && isWord) {
				input[wordCount] = word;
				temp = new String[input.length + 1];
				temp[wordCount] = input[wordCount];
				input = temp;
				wordCount++;
				word = "";
				isWord = false;
			} else if (Character.isLetter(characters[i]) && i == endOfLine) {
				
			}
		}
		System.out.println(input.length);
		System.out.println(input[0]);
		
		//Person newPerson = new Person(firstName, middleName, lastName, addressNumber, addressName, streetSuffix, city, state, zipCode, phoneNum);
		//return newPerson;
	}
	
	// method to increase length of array and sets null values to last object in array
	public void add(Person newPerson) {
		Person[] tempArr = new Person[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}
		arr = tempArr;
		arr[arr.length - 1] = newPerson;
	}

}
