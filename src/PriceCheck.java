import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
public class PriceCheck implements CheckHandler{
    private CheckHandler nextStep;

    public void setNextStep(CheckHandler nextHandler){
        this.nextStep=nextHandler;
    }

    public void check(){
        double totPrice=0;
        List<List<String>> inpuList=InputRead.list;
        try(PrintWriter pw=new PrintWriter("output.csv")){
            StringBuilder sb = new StringBuilder();
            sb.append("Item Name,");
            sb.append("Quantity,");
            sb.append("Total Price,");
            sb.append("\n");
            for (List<String> item: inpuList){
                String itemName = item.get(0);
                int itemQuantity = Integer.parseInt(item.get(1));
                double price= itemQuantity * Inventory.items.get(itemName).price;
                totPrice+=price;
                sb.append(itemName+",");
                sb.append(itemQuantity+",");
                sb.append(price);
                sb.append("\n");
            }

            sb.append("Total"+",");
            sb.append(",");
            sb.append(totPrice);
            pw.write(sb.toString());

        }
        catch (FileNotFoundException e){
            System.out.println("Not found");
        }
    }
    
}
