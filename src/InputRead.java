import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class InputRead{
	static List<List<String>> inputList =  new ArrayList<>();
	
	public void readFile(String filePath) {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			br.readLine();
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] card = line.split(",");
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(card[0]);
				temp.add(card[1]);
				if(card.length > 2){
					temp.add(card[2]);
					CardDetails.cards.add(card[2]);
				}
				else{
					temp.add("");
					CardDetails.cards.add("");
				}
				
				
				
				inputList.add(temp);
				//br.close();
			}
			System.out.println("Cards hashset");
			System.out.println(CardDetails.cards);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

