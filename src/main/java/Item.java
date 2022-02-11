public class Item {
    private final String name;
    private String description;
    private String price;

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Item(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
