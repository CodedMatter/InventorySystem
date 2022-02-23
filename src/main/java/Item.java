public class Item {
    private final String name;
    private String description;
    private double price;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
        price = 0;
    }

    public Item(String name){
        this.name = name;
        price = 0;
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

    @Override
    public String toString() {
        return "Name: " + name + " || Description: " + description;
    }
}
