import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Inventory {
    private static Inventory inventory=null;
    static HashMap<String, Item> items=new HashMap<String,Item>();
    static HashMap<String, Integer> capValues=new HashMap<String,Integer>();
    private Inventory(){
        capValues.put("Essentials",3);
        capValues.put("Luxury",4);
        capValues.put("Misc",6);
    }
    public static Inventory getInstance() {
        if (inventory!=null){
            return inventory;
        }
        else{
            inventory=new Inventory();
            return inventory;
        }
    }

}
