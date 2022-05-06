import java.util.*;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.IOException;  

public class Billing {
    public static void main(String[] args) {
    	CheckInventory check1= new CheckInventory();
    	CheckPrice check2= new CheckPrice();
    	check1.setNextStep(check2);
    	check1.check();    	
    }
}
