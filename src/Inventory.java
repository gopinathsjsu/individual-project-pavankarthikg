import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Inventory {
	private static Inventory inventory = null;
	static HashMap<String, Item> items = new HashMap<String, Item>();
	static HashMap<String,Integer> capCategory = new HashMap<String,Integer>();
	private Inventory() {
		capCategory.put("Essentials",3);
		capCategory.put("Luxury",4);
		capCategory.put("Misc",6);
	}

	public static Inventory getInstance() {
		if (inventory != null)
			return inventory;
		else {
			inventory = new Inventory();
			return inventory;
		}
	}

	public void readDataset(String filename) {
		String line = "";
		String splitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			br.readLine();
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] item = line.split(splitBy);
				double quantity = Double.parseDouble(item[2]);//
				double price = Double.parseDouble(item[3]);
				Item newItem = new Item(item[1], item[0], quantity, price);
				items.put(item[0], newItem);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
