import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws Exception {
        InventoryCheck firstCheck = new InventoryCheck();
        PriceCheck secondCheck = new PriceCheck();

        firstCheck.setNextStep(secondCheck);
        firstCheck.check();
    }
}
