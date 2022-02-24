public class Player extends Character{

    public Player(String name) {
        super(name);
        super.changeBalance(100);
        for (int i = 0; i < 2; i++) {
            HealthPotion healthPotion = new HealthPotion();
            addItemToInventory(healthPotion);
        }

        for (int i = 0; i < 2; i++) {
            ManaPotion manaPotion = new ManaPotion();
            addItemToInventory(manaPotion);
        }

        for (int i = 0; i < 2; i++) {
            HealthPotion healthPotion = new HealthPotion();
            addItemToInventory(healthPotion);
        }
    }

    public void inspectPlayer() {
        // don't know what goes here yet
    }
}
