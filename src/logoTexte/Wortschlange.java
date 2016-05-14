package logoTexte;

import java.util.ArrayList;

/*
 * @parameters Takes words
 */


public class Wortschlange {
	
	public static String wortSchlange(ArrayList<String> strings){
		String wortschlange = "\r\n";
		for(int i = 0; i < strings.size(); i++){

			String temp;
			temp = strings.get(i);
			
			
			wortschlange = wortschlange + temp.toUpperCase();;	
			
		}
		
		return wortschlange;
		
	}

}
