import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class PriceCheck implements CheckHandler {
	private CheckHandler nextStep;

	public void setNextStep(CheckHandler nextHandler) {
		this.nextStep = nextHandler;

	}

	public void check() {
		double totalPrice=0;
		List<List<String>> inputList = InputRead.inputList;
		try (PrintWriter pw = new PrintWriter("output2.csv")) {
			StringBuilder sb = new StringBuilder();
			sb.append("Item,");
			sb.append("Quantity,");
			sb.append("Price");
			sb.append("\n");
			for (List<String> item : inputList) {
				String itemNam = item.get(0);
				int itemQuantity = Integer.parseInt(item.get(1));
				double price = itemQuantity * Inventory.items.get(itemNam).price;
				totalPrice+=price;
				sb.append(itemNam+",");
				sb.append(itemQuantity+",");
				sb.append(price);
				sb.append("\n");
			}
			sb.append("TotalPrice"+",");
			sb.append(",");
			sb.append(totalPrice);
	
			pw.write(sb.toString());
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundError");
		}
	}
}
