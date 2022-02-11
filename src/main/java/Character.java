import java.util.HashMap;
import java.util.Map;

public class Character {
    private final String name;
    public Inventory inventory;
    Map<Stats, Integer> stats;

    public Character(String name){
        this.name = name;
        inventory = new Inventory();
        stats = new HashMap<>();
    }

    private void addItemToInventory(Item itemToAdd){
        inventory.addItemToInventory(itemToAdd);
    }

}
