public class Item {
    protected String item;
    protected String category;
    protected double quantity;
    protected double price;

    public Item(String item,String category,double quantity,double price){
        super();
        this.item=item;
        this.category=category;
        this.quantity=quantity;
        this.price=price;
    }
    //Setters
    public void setItem(String Item){
        this.item=item;
    }
    public void setCategory(String Category){
        this.category=category;
    }
    public void setQuantity(Double quantity){
        this.quantity=quantity;
    }
    public void setPrice(Double price){
        this.price=price;
    }


    //Getters
    public String getItem(){
        return item;
    }
    public String getCategory(){
        return category;
    }
    public Double getQuantity(){
        return quantity;
    }
    public Double getPrice(){
        return price;
    }
}
