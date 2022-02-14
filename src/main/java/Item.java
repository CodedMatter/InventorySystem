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


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
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
}
