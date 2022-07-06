package collections;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EmployeeFileComponent {

	public static void main(String[] args) throws IOException {
		new EmployeeFileComponent().writeEmployee(new Employee(100, "Dillon", "Shomaker"));
		System.out.println("Success!");
	}

	public Scanner open(String filename) throws FileNotFoundException {
		File file = new File(filename);
		try {
			Scanner scanner = new Scanner(file);
			return scanner;
		} catch (FileNotFoundException e) {
			System.out.println("File not found..");
			e.printStackTrace();
			throw e;
		}
	}
	
	public void printEmployees() {
		String filename = "employees.csv";
		try {
			Scanner scanner = open(filename);
			// delimiter
			scanner.useDelimiter(","); // token
			String line;
			while (scanner.hasNextLine()) {					// delimiter ,                //    \n \r
				System.out.println(scanner.next() + " " + scanner.next() + " " + scanner.nextLine().substring(1));
				 // advance to the next line \n
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	 // FileNotFoundException extends IOException
	public void writeEmployee(Employee employee) {
		// OutputStream - PrintWriter
		//PrintWriter writer = new PrintWriter("employees.csv");
		// try-with resource  - AutoCloseable 
		try(FileWriter writer = new FileWriter(new File("employees.csv"), true)) {
			writer.write(employee.toString() + "\n");
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}

}




