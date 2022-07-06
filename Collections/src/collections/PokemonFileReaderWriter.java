package collections;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class PokemonFileReaderWriter {

	static int pokemonInBag = 0;
	
	public static void main(String[] args) {
		//we will store all of our pokemon inside of this linked list
		LinkedList<Pokemon> bagOfPokemon = new LinkedList<>();
		//this object will allow us to call the read and write methods
		PokemonFileReaderWriter pfr = new PokemonFileReaderWriter();
		//lets add our pokemon to the bag
		bagOfPokemon.add(new Pokemon("Pikachu","Lightning",10));
		bagOfPokemon.add(new Pokemon("Bulbasaur","Grass",5));
		bagOfPokemon.add(new Pokemon("Squirtle","Water",12));
		bagOfPokemon.add(new Pokemon("Charmander","Fire",15));
		bagOfPokemon.add(new Pokemon("Mr. Mime","Psychic",20));
		bagOfPokemon.add(new Pokemon("Rocket Raccoon","Avenger",99));
		//linkedList inherits from Iterable class so we can use the foreach loop to cycle through 
		for(Pokemon p : bagOfPokemon) 
		{
			pfr.addPokemon(p);
		}
		//lets print the result to the console
		System.out.println("Here are your " + pokemonInBag + " pokemon!");
		System.out.println("Gotta cath 'em all!");
		System.out.println();
		pfr.printPokemon();
	}

	public Scanner open(String filename) throws FileNotFoundException {
		File file = new File(filename);
		try {
			Scanner scanner = new Scanner(file);
			return scanner;
		} catch (FileNotFoundException e) {
			System.out.println("File not found..");
			throw e;
		}
	}
	
	public void printPokemon() {
		String filename = "pokemon.csv";
		try {
			Scanner scanner = open(filename);
			// this is the delimiter used to separate each token(data value)
			scanner.useDelimiter(","); // token
			String line;
			while (scanner.hasNextLine()) {					// delimiter ,               
				System.out.println(scanner.next() + " " + scanner.next() + " " + scanner.nextLine().substring(1));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	
	public void addPokemon(Pokemon pokemon) {
		// try-with resource  - AutoCloseable 
		try(FileWriter writer = new FileWriter(new File("pokemon.csv"), true)) {
			// the \n characters will ensure we get a new line after each pokemon is added
			writer.write(pokemon.toString() + "\n");
			pokemonInBag += 1;
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}

}




