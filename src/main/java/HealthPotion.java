public class HealthPotion extends Potion{

    int healingAmount;

    public HealthPotion(){
        super("Health Potion");
        super.setPrice(10);
        healingAmount = 10;
    }

    @Override
    public void consume(Character personConsuming) {
        if(personConsuming.hasStat(Stat.HEALTH)){
            personConsuming.getStats().put(Stat.HEALTH,
                    personConsuming.getSpecificStat(Stat.HEALTH)+healingAmount);
        }
        else{
            System.out.println(personConsuming.getName() + " doesnt have a health stat.");
        }
    }
}
