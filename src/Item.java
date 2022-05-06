public class Item {
	protected String category;
	protected String item;
	protected double quantity;
	protected double price;
	public Item(String item, String category, double quantity, double price) {
		super();
		this.category = category;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public String getItem() {
		return item;
	}
	public double getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
    public void setItem(String item) {
		this.item = item;
	}
    public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
    public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
