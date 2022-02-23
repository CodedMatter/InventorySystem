public class Item {
    private final String name;
    private String description;
    private double price;
    private Category category;

    public Item(String name, String description, Category category){
        this.name = name;
        this.description = description;
        price = 0;
        this.category = category;
    }

    public Item(String name, Category category){
        this.name = name;
        price = 0;
        this.category =  category;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double newItemPrice) {
        if(newItemPrice < 0){
            price = 0;
        }
        else {
            price = newItemPrice;
        }
    }

    public Category getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return "Name: " + name + " || Description: " + description;
    }
}
