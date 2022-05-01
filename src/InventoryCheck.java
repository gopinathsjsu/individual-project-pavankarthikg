import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class InventoryCheck implements CheckHandler{
    private CheckHandler nextStep;
    public void setNextStep(CheckHandler nextHandler) {
        this.nextStep=nextHandler;
    }
    public void check(){
        
        boolean essflag=false;
        boolean luxflag=false;
        boolean miscflag=false;

        String flagexcp="";

        Inventory inv = Inventory.getInstance();
        inv.readDataset("Sample_Inventory.csv");
        HashMap<String, Item> csvitems= inv.items;

        InputRead readd = new InputRead();
        readd.readFile("sample_input.csv");
        List<List<String>> ip= readd.list;
    }
}
