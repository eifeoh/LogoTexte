package logoTexte;

import java.util.ArrayList;
import java.util.Random;

public class Wortgitter {
	private static int ROWS = 12;
	private static int COLUMNS = 12;
	private static String wortGitter = "";
    private static String[][] crossword = new String[ROWS][COLUMNS];
	
	public static String wortGitter(ArrayList<String> strings){
		prefill(crossword);
		//fill(crossword, strings);
//		fillRest(crossword);
		paintBoard(crossword);
		System.out.println(wortGitter);
		return wortGitter;
		
	}
	
	private static void prefill(String[][] crossword) {
		int currentRow = 0;
		while (currentRow < 11) {
			int currentCol = 0;
			while (currentCol < 11) {
					crossword[currentCol][currentRow] = "0";
				}
			}
			currentRow++;
	}

	private static void fillRest(String[][] crossword) {

		int currentRow = 0;
		while (currentRow < 11) {
			int currentCol = 0;
			while (currentCol < 11) {
				if(crossword[currentCol][currentRow].equals("0")){
					Random r = new Random();
					char x = (char)(r.nextInt(26) + 'a');
					String y = "" + x;
					crossword[currentCol][currentRow] = y;
				}
			}
			currentRow++;
		}
		
	}

	private static void paintBoard(String[][] board) {
		int currentRow = 0;
		while (currentRow < board.length) {
			wortGitter = wortGitter + printHorizontalLine();
			wortGitter = wortGitter + "|";
			int currentCol = 0;
			while (currentCol < board[currentRow].length) {
				wortGitter = wortGitter +" " + board[currentRow][currentCol] + " |";
				currentCol++;
			}
			wortGitter = wortGitter + "\r\n";
			currentRow++;
		}
		printHorizontalLine();
		
		System.out.println(wortGitter);
	}

	/**
	 * Draws a horizontal line.
	 */
	private static String printHorizontalLine() {
		String horizontalLine = "+";
		int i = 0;
		while (i < COLUMNS) {
			horizontalLine = horizontalLine + "---+";
			i++;
		}
		horizontalLine = horizontalLine + "\r\n";
		return horizontalLine;
	}
	


//public static void fill(String[][] crossword, ArrayList<String> strings) {
//
//
//	
//	int i = 0;
//    while (i < strings.size()) {
//
//
//		if (i == 0) {
//            for (int j = 0; j < strings.get(i).length(); j++)
//                crossword[ROWS / 2][(COLUMNS / 4) + j] = strings.get(i)
//                        .charAt(j);
//            i++;
//        }
//        if (i == 1) {
//            outerloop: for (int t = 0; t < ROWS; t++)
//                for (int s = 0; s < COLUMNS; s++)
//                    for (int j = 0; j < strings.get(i).length(); j++)
//                        if (crossword[t][s] == strings.get(i).charAt(j)) {
//                            for (int z = 0; z < j; z++)
//                                crossword[t - z - 1][s] = strings.get(i).charAt(
//                                        z);
//                            for (int h = j + 1; h < strings.get(i).length(); h++)
//                                crossword[t + h - j][s] = strings.get(i).charAt(
//                                        h);
//                            crossword[t][s] = strings.get(i).charAt(j);
//                            break outerloop;
//                        }
//            i++;
//        }
//    }
//}

}
