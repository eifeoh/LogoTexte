package logoTexte;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadList {

	/**
	 * @param args
	 */
	public static ArrayList<String> strings = new ArrayList<String>();
	public static int counter = 1;

	public static void readList(String[] args) throws IOException {
		String pathToListFile = args[0];
		readList(pathToListFile);

	}


	/**
	 * Parse a file containing words and insert them into "strings".
	 * Use the Class BufferedReader
	 *
	 * @param path
	 * @return 
	 * @throws IOException
	 */
	public static ArrayList<String> readList(String path) throws IOException{
		// initialisiere reader mit null
		BufferedReader reader = null;
		try{
			// versuche, ob Datei existiert und initialisiere reader mit Datei
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.println("Test-Datei nicht vorhanden");
			e.printStackTrace();
		}


		String text = null;

		// erzeuge Array bis Liste leer
		while ((text = reader.readLine()) != null) {
			// parse Text zu ints und hänge an numbers an
			
			
			if(text.contains(" ")){
				String[] elements = text.split(" ");
				for (int ii = 0; ii < elements.length; ii++){
					strings.add(elements[ii]);
				}
				
			}else {
			strings.add(text);
			}
		}
		// schliesse Reader, falls noch nicht null
		if (reader != null) {
			reader.close();
		}
		
	return strings;
	}
}
