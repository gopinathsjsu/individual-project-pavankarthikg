import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class InventoryCheck implements CheckHandler {
	private CheckHandler nextStep;
	public void setNextStep(CheckHandler nextHandler) {
		this.nextStep = nextHandler;
	}
	public void check() {
		Inventory i1 = Inventory.getInstance();
		i1.readDataset("Dataset - Sheet1.csv");
		boolean flag=false;
		boolean essflag=false;
		boolean luxflag=false;
		boolean miscflag=false;
		String quantflag="";
		
		HashMap<String, Item> dbitems = i1.items;
		InputRead r1 = new InputRead();
		r1.readFile("Input1 - Sheet1.csv");
		List<List<String>> given = r1.inputList;
		int essentialQuantity=5;
		int luxuryQuantity=3;
		int miscQuantity=6;
		for (List<String> item: given) {
			double quantity = Double.parseDouble(item.get(1));
			String itemName = item.get(0);
			if(dbitems.get(itemName).quantity<quantity) {
				flag= true;
				quantflag+= "invalid quantity for "+itemName+" "+ item.get(1)+"\n";
			}
			switch(dbitems.get(itemName).category) {
			case "Essentials":
				essentialQuantity-=quantity;
				if(essentialQuantity<0) {
					flag=true;
					essflag=true;
				}
				break;
				
			case "Luxury":
				luxuryQuantity-=quantity;
				if(luxuryQuantity<0) {
					flag=true;
					luxflag=true;
				}
				break;
				
			case "Misc":
				miscQuantity-=quantity;
				if(miscQuantity<0) {
					flag=true;
					miscflag=true;
				}
				break;
			default:
				break;
			}
		}
		if(flag || essflag || luxflag || miscflag) {
			try {
			      FileWriter myWriter = new FileWriter("errors1.txt");
			      myWriter.write("Please correct quantities"+ "\n");
			      myWriter.write(quantflag);
			      if(quantflag.equals("")) {
			    	  if(essflag)
			    	  myWriter.write("Essentials reached to the cap"+ "\n");
			    	  if(luxflag)
				    	  myWriter.write("Luxury reached to the cap"+ "\n");
			    	  if(miscflag)
				    	  myWriter.write("Misc items reached to the cap"+ "\n");
			      }
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			return;
		}
		nextStep.check();
	}
}
