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
			StringBuilder strbui = new StringBuilder();
			strbui.append("Item,");
			strbui.append("Quantity,");
			strbui.append("Price");
			strbui.append("\n");
			for (List<String> item : inputList) {
				String itemNam = item.get(0);
				int itemQuantity = Integer.parseInt(item.get(1));
				double price = itemQuantity * Inventory.items.get(itemNam).price;
				totalPrice+=price;
				strbui.append(itemNam+",");
				strbui.append(itemQuantity+",");
				strbui.append(price);
				strbui.append("\n");
			}
			strbui.append("TotalPrice"+",");
			strbui.append(",");
			strbui.append(totalPrice);
	
			pw.write(strbui.toString());
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundError");
		}
	}
}
