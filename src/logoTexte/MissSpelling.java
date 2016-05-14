package logoTexte;

import java.util.ArrayList;
import java.util.Random;

public class MissSpelling {

	public static String missSpelling(ArrayList<String> strings){
		String missSpelled = "\r\n";
		
		if(strings.isEmpty() || strings.size() == 0){
			return missSpelled;
		}
		
		for(int i = 0; i < strings.size(); i++){
			String temp, temp1, temp2, temp3, temp5;
			temp = strings.get(i);
			Random r = new Random();
			char x = (char)(r.nextInt(26) + 'a');
			char y = (char)(r.nextInt(26) + 'a');

			int length = temp.length();

			temp1 = temp.substring(0, length/2) + x + temp.substring(length/2);
			temp3 = temp.substring(0, length/3) + y + temp.substring(length/3);

			if(temp.length() > 1){
			temp2 = temp.substring(0, length/2) + temp.substring(length/2 + 1);
			temp5 = temp.substring(0, length/4)	+ temp.substring((int) (Math.ceil(length/4.0) - 1)).toLowerCase();
			} else{
				temp2 = temp;
				temp5 = temp;
			}


			ArrayList<String> tempStrings = new ArrayList<String>();

			tempStrings.add(temp1);
			tempStrings.add(temp2);
			tempStrings.add(temp3);
			tempStrings.add(temp);
			tempStrings.add(temp5);

			for(int z = 0; z < 3; z++){
				int ran = r.nextInt(5);
				tempStrings.add(tempStrings.get(ran));
				tempStrings.remove(ran);
			}
			missSpelled = missSpelled + tempStrings.get(0);

			for(int k = 1; k < tempStrings.size(); k++){
				missSpelled = missSpelled + ", " + tempStrings.get(k);
			}
			//System.out.print(temp1 + ", " + temp2 + ", " + temp3 + ", " + temp4 + ", " +  temp5 + "\n");
			missSpelled = missSpelled + "\r\n";
		
		}


		return missSpelled;

	}
}
