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
        boolean flag=false;
        boolean essflag=false;
        boolean luxflag=false;
        boolean miscflag=false;

        String flagexcp="";

        Inventory inv = Inventory.getInstance();
        inv.readDataset("Sample_Inventory.csv");
        HashMap<String, Item> csvitems= Inventory.items;

        InputRead readd = new InputRead();
        readd.readFile("sample_input.csv");
        List<List<String>> ip= InputRead.list;
        
        int essentialCap=3;
        int luxuryCap=4;
        int miscCap=6;

        for (List<String> item:ip){
            double quantity=Double.parseDouble(item.get(1));
            String itemName=item.get(0);
            if(csvitems.get(itemName).quantity<quantity){
                flag=true;
                flagexcp+=itemName+"'s quantity is limited to"+item.get(1)+"\n";
            }

            switch (csvitems.get(itemName).category) {
                case "Essential":
                    essentialCap-=quantity;
                    if (essentialCap<0){
                        flag=true;
                        essflag=true;
                    }
                    break;

                case "Luxury":
                    luxuryCap-=quantity;
                    if (luxuryCap<0){
                        flag=true;
                        luxflag=true;
                    }
                    break;

                case "Misc":
                    miscCap-=quantity;
                    if (miscCap<0){
                        flag=true;
                        miscflag=true;
                    }    
                    break;
            
                default:
                    break;
            }
        }

        if (flag || essflag || luxflag || miscflag){
            try{
                FileWriter fw = new FileWriter("errors.txt");
                fw.write("Please correct the quantities\n");
                fw.write(flagexcp);
                if(flagexcp.equals("")){
                    if(essflag)
                    fw.write("Number of essentials reached the limit \n");

                    if(luxflag)
                    fw.write("Number of Luxury items has reached the limit \n");

                    if(miscflag)
                    fw.write("Number of miscellaenous items has reached the limit \n");
                }
                fw.close();
                System.out.println("Errors have been succesfully written to the fiel");

            }
            catch(IOException e){
                System.out.println("Sorry, an error occured!");
                e.printStackTrace();
            }
            return;
    }
    nextStep.check();
}
}
