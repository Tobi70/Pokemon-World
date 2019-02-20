

/*
 * @author:Alvaro Alanis
 * @date:12/5/2018
 * 
 * Description:Adventure out to discover new pokemon!
 * 
 * Pseudocode:
 * 
 *  //Create world, animal locations, boolean and array of pokemons
 * 
 *  // create print menus
 * 
 *  //start users position in the middle of the 2d array world
 *
 *  // create method that allows user to insert pokemons into the world
 *  
 *  // allow the user to delete pokemon from the world
 *  
 *  // update the world as the user explores it by the star value to an O
 *  
 *  // check if the users location contains a pokemon
 *  
 *  // if it does add the pokemon found into the observed pokemon string array
 *  
 *  // if user wants to quit make sure the loop ends
 * 
 */
import java.util.Scanner;
public class Assignment4Skeleton {
	static boolean[][] exploredWorld;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("Welcome to the jungle creator!\nIn this game, you will be inserting animals in certain places in the world\nthat you create! You will also be allowed to remove animals from certain locations before you start exploring!\nOnce you start exploring you will navigate around the world to observe the animals you have inserted.\nThe game will keep track of all the animals you have observed!");
		System.out.println("Enter the dimensions of your jungle !");
		System.out.print("Enter length: ");
		int length = sc.nextInt();
		System.out.print("Enter width: ");
		int width = sc.nextInt();
		/*TODO:
		*Declare and initialize arrays and generate the world starting from 0,0
		*Note: Don't forget to initialize exploredWorld
		*	Note: Make sure to loop through the String array animalLocations and initialize all
			it's elements to "" otherwise it initializes everything to null causing a Nullpointer exception
		*/
		
		String[][] jungle = new String [width][length];
		for(int row = 0; row < jungle.length; row++) {
			for(int column = 0; column < jungle[row].length; column++) {
				jungle[row][column] = "*";
			}
		}
		
		String[][] poketMonsters = new String [width][length];
		for(int row = 0; row < poketMonsters.length; row++) {
			for(int column = 0; column < poketMonsters[row].length; column++) {
				poketMonsters[row][column] = "";
			}
		}
		exploredWorld = new boolean[width][length];
		for(int row = 0; row < exploredWorld.length; row++) {
			for(int column = 0; column < exploredWorld[row].length; column++) {
				if(row == 0 && column == 0){
					exploredWorld[row][column] = true;
					
				}else {
					exploredWorld[row][column]= false;
				}
			}
		}
		String[] pokemon = new String[width];
		
		String choice1 = null;
		
			/* While choice is not exit:
			    Print menu
			    Take choice
			    Process the user choice
				Note: Be sure to include input validation for choice
			 * 
			 */
		
	while(choice1 != "exit"){
		printMainMenu();
		choice1 = sc.nextLine();
		switch(choice1) {
		case "1":
			insertAnimalToWorld(poketMonsters);
			break;
		case "2":
			removeAnimalFromWorld(poketMonsters);
			break;
		case "3":
			explore(jungle,poketMonsters,pokemon);
			break;
			
		default:
			System.out.println("That is not an option");
			break;
		}
		
	}
		
	

	}


	


	/*TODO: Complete makeWorld
	 * This methods basically sets up the visible world. Assigning “*” 
	 * to unexplored areas and “O” to explored areas. 
	 * It also sets the user’s current position: (posX,posY) to a string of your choosing, example “x”. 
	 * At the end of the method and after assigning new Strings using loops and if statements, 
	 * it returns the 2D String array world.
	 */
	public static String[][] makeWorld(String[][] world, int posX, int posY) {
		//creating the world
		for(int row = 0; row < world.length; row++) {
			for(int column = 0; column < world[row].length; column++) {
				world[row][column] = "*";
			}
		}
		// initializng the current position of the user
		world[posX][posY] = "O";
		
		return world;
	
	}

	/*TODO: Complete printMainMenu
	 * Prints: 
		1. Insert an animal into the world
		2. Remove an animal from the world
		3. Explore the world
		Enter your choice: 
	 * 
	 */
	public static void printMainMenu() {
		System.out.println("1. Insert an animal into the world");
		System.out.println("2. Remove an animal from the world");
		System.out.println("3. Explore the world");
		System.out.println("Enter your choice");

	}

	/*TODO: Complete printMoveMenu
	 * Prints: 
		W. Move Forward
		A. Move Left
		S. Move Backward
		D. Move Right
		I. Display observed animals
		E. Exit
		Enter your choice: 
	 * 
	 */
	public static void printMoveMenu() {
		System.out.println("W. Move Forward");
		System.out.println("A. Move Left");
		System.out.println("S. Move Backward");
		System.out.println("D. Move Right");
		System.out.println("I. Display observed animals");
		System.out.println("E. Exit");
		System.out.println("Enter your choice:");
		
	}

	/*
	 * TODO: Complete insertAnimal to World
	 *  Prompts the user to enter the x and y coordinate as well as their desired animal name and inserts it to the world in the location [x,y]as long as:
		-  The  x and y coordinates are in the world’s boundaries
		- The area [x,y] is not occupied by another animal
	If the conditions are not met prompt the user to enter the coordinates 
	as well as the animal name again until the conditions above are met.

	 */
	public static void insertAnimalToWorld(String[][] animalLocations) {
		Scanner sc = new Scanner(System.in);
		
		int x;
		int y;
		String key = null;
		
		
		
		System.out.println("Enter the X coordinate of your monster");
		do {
		x = sc.nextInt();
		}while(x > animalLocations.length);
		System.out.println("Enter the Y coordinate of your monster");
		do {
		y = sc.nextInt();
		}while(y > animalLocations[0].length);
		animalLocations[x][y] = key;
		if(key == "") {
		System.out.println("What pokemon would you like to place");
		String pokemon = sc.nextLine();
		animalLocations[x][y] = pokemon;
		}else {
			System.out.println("There is already a pokemon there");
		}

	}
	
	
	/* TODO: Complete removeAnimalFromWorld
	 * Prompts the user to enter the x and y coordinate and removes the animal  from the world in the location [x,y] as long as:
		-  The  x and y coordinates are in the world’s boundaries
		- The area [x,y] is not empty (contains an animal)
	If the conditions are not met prompt the user to enter the coordinates until the conditions above are met.

	Hint: To remove the animal you can just set the String at [x,y] to “” .
	 * 
	 */
	public static void removeAnimalFromWorld(String[][] animalLocations) {
		Scanner sc = new Scanner(System.in);
		
		int x;
		int y;
		
		String key = null;
		
		System.out.println("Enter the X coordinate of your monster");
		do {
		x = sc.nextInt();
		}while(x > animalLocations.length);
		System.out.println("Enter the Y coordinate of your monster");
		do {
		y = sc.nextInt();
		}while(y > animalLocations[0].length);
		animalLocations[x][y] = key;
		if(key != "") {
			animalLocations[x][y] = "";
		}else {
			System.out.println("There is already no pokemon");
		}

	}

	/* TODO: Complete isEmptyBlock
	 * 
	 *  Returns false if the array has an animal at [x,y] and true if [x,y] is empty.
	 * 
	 */
	public static boolean isEmptyBlock(String[][] world, int x, int y) {
		if(world[x][y] != "") {
			return false;
		}else {
			return true;
		}

	}

	/*TODO: Complete updateObservedAnimals
	 *  adds animal into the observedAnimals array into the first occurrence of an empty String “” 
	 *  and returns the observedAnimals array.
	 */
	public static String[] updateObservedAnimals(String[] observedAnimals, String animal) {
		
		for(int i = 0; 1 < observedAnimals.length; i++) {
			if(observedAnimals[i] == "") {
				observedAnimals[i] = animal;
						
			}
		}
		
		return observedAnimals;
	
		

	}

	/*
	 * Prints the 2D array world
	 * Note: Nothing to do here, it's done for you! 
	 */
	public static void printWorld(String[][] world) {
		for (int i = 0; i < world.length; i++){
			for (String s : world[i]) {
				System.out.print(s + " ");
			}
			
		System.out.println();
		}
	}
	
	
	/* TODO: Complete explore
	 * Starts the exploration! 
	 * This method prints out the world and then the move menu and asks the user to choose 
	 * from the move menu until the user chooses to exit. In this method, 
	 * make sure to declare the x and y variables that keep track of the user’s position in the world. 
	 * When the user chooses to move forward for example, change the x and y values accordingly (refer to activity 8.0) and 
	 * make sure they are within the world’s bounds, if they are, call the move method and print the world, 
	 * otherwise reset the position to 0,0 and tell the user that they went off bounds.
	 * If the user chooses to print observed animals , call the print observed animals method
	 * If the user chooses to exit, exit the program
	 */
	public static void explore(String[][] world, String[][] animalLocations, String[] observedAnimals) {
		Scanner sc = new Scanner(System.in);
		int x = world.length / 2;
		int y = world[0].length / 2;
		world[x][y] = "O";
		int exit = 1;
		String[][] world2 = world;
		char choice;
		do {
		
		printWorld(world);
		
		printMoveMenu();
		
		choice = sc.next().charAt(0);
		
		switch(choice) {
		case 'W':
			x++;
			world[x][y] = "O";
			move(world2,x,y,observedAnimals,animalLocations);
			break;
		case 'A':
			y--;
			world[x][y] = "O";
			move(world2,x,y,observedAnimals,animalLocations);
			break;
			
		case 'S':
			x--;
			world[x][y] = "O";
			move(world2,x,y,observedAnimals,animalLocations);
			break;
			
		case 'D':
			y++;
			world[x][y] = "O";
			move(world2,x,y,observedAnimals,animalLocations);
			break;
		case 'I':
			System.out.println("This are your observed animals");
			System.out.println(observedAnimals);
			break;
		case 'E':
			exit = 0;
			break;
		
		}
		}while(exit != 0);
		
		
		
	}

	/* TODO: Complete move
	 * This method calls the makeWorld method to create a new world with the new user position 
	 * and sets the 2D boolean array at [x,y] to be true, setting this area as explored. 
	 * If [x,y] has an animal display the animal name and add it to the observed animals list 
	 * and print the observed animals list, otherwise display you did not encounter anything :( . 
	 * This method returns the 2D array world in the end.
	 * 
	 */
	public static String[][] move(String[][] world, int x, int y, String[] observedAnimals, String[][] animalLocations) {

		makeWorld(world,x,y);
		exploredWorld[x][y] = true;
		
		for(int i = 0; i < world.length; i++) {
			for(int j = 0; j < world[i].length; j++) {
				if(exploredWorld[i][j] == true) {
					world[i][j] = "O";
				}
			}
		}
		
		if(animalLocations[x][y] != "") {
			System.out.println("You found a " + animalLocations);
			for(int i = 0; i < observedAnimals.length; i++) {
				if(observedAnimals[i] == "") {
					animalLocations[x][y] = observedAnimals[i];
				}
			}
			
			
			
		}else {
			System.out.println("Did not find anything");
		}
		
		return world;

	}

	/*
	 * Prints the observedAnimals list by printing each animal  on one line separated by a space.
		Note: nothing to do here it's done for you.
	 */
	public static void printobservedAnimals(String[] observedAnimals) {
		for (int i=0;i<observedAnimals.length;i++){
			if (observedAnimals[i] != null)
				System.out.print(observedAnimals[i] + " ");
		}
		System.out.println();
	}

	
	
	/*
	 * Returns true if [x,y] is explored and false if [x,y] is not explored.
	 * Note: Nothing to do here it's done for you.
	 */
	public static boolean isExplored(int x, int y) {

		return exploredWorld[x][y];

	}

}
