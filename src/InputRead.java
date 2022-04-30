import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputRead {
    static List<List<String>> list = new ArrayList<>();
    public void readFile(String filePath){
        String line="";
        try{
            BufferedReader br=new BufferedReader(new FileReader(filePath));
            br.readLine();
            while((line=br.readLine())!=null){
                String[] employee = line.split(",");
                ArrayList<String> tmp=new ArrayList<>();
                tmp.add(employee[0]);
                tmp.add(employee[1]);
                tmp.add(employee[2]);

                CardDetails.cards.add(employee[2]);
                list.add(tmp);
            }
            System.out.println("Cards");
            System.out.println(CardDetails.cards);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
