package logoTexte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<String> strings = null;

		String directory = ".";
		List<String> textFiles = new ArrayList<String>();
		File dir = new File(directory);
		for (File file : dir.listFiles()) {
			if (file.getName().endsWith((".txt")) 
					&& !(file.getName().toLowerCase().contains("output"))) {
				textFiles.add(file.getName());
			}
		}


		for(int i = 0; i < textFiles.size(); i++){
			try {
				strings = ReadList.readList(textFiles.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(strings.size() > 0){

			String outputFile = textFiles.get(i) + "_output.txt";
			FileWriter writer = new FileWriter(outputFile);
			writer.append("Finde die richtige Schreibweise \r\n");
			writer.append(MissSpelling.missSpelling(strings) + "\r\n");
			writer.append("Wortschlange \r\n");
			writer.append(Wortschlange.wortSchlange(strings) + "\r\n");
			writer.append("Wortgitter \r\n");
			writer.append(Wortgitter.wortGitter(strings) + "\r\n");
			writer.flush();
			writer.close();
			}
		}
	}


}
