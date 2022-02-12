import java.util.HashMap;
import java.util.Map;

public class Character extends Inventory {
    private final String name;
    private String description;
    private Map<Stat, Integer> stats;
    private double balance;

    public Character(String name){
        this.name = name;
        description = "";
        stats = new HashMap<>();
        balance = 0;
    }
    public Character(String name,Map<Stat,Integer> stats){
        this.name = name;
        description = "";
        this.stats = stats;
        balance = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Stat, Integer> getStats() {
        return stats;
    }
    public int getSpecificStat(Stat stat){
        return stats.get(stat);
    }
    public boolean hasStat(Stat stat) {
        return stats.containsKey(stat);
    }

    public void recieveMoney(double moneyGained){
        balance += moneyGained;
    }


}
