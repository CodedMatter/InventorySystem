public class ManaPotion extends Potion{
    int manaGained;

    public ManaPotion() {
        super("Mana Potion");
        super.setPrice(10);
        manaGained = 10;

    }

    @Override
    public void consume(Character personConsuming) {

    }
}
