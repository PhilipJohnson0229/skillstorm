import java.io.File;

public class PropertiesGenerator {
		public static void main(String[] args) {
			File file = new File("resources.properties");
			System.out.println(file.getAbsolutePath());
		}
}
