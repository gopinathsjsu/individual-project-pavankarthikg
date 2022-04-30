import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class InventoryCheck {
    public void check(){
        boolean essflag=false;
        boolean luxflag=false;
        boolean miscflag=false;

        String flagexcp="";

        Inventory i1=Inventory.getInstance();
        i1.readDataset("Sample_Inventory.csv");
        


    }
}
