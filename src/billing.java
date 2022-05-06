public class Billing {
    public static void main(String[] args) {
    	InventoryCheck check1= new InventoryCheck();
    	PriceCheck check2= new PriceCheck();
    	check1.setNextStep(check2);
    	check1.check();    	
    }
}
