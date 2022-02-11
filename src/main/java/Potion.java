public class Potion extends Item implements Consumable{

    public Potion(String name){
        super(name);
    }

    @Override
    public void consume() {
        System.out.println("Error: Need to override the consume method in " +
                getClass().getName() + " class");
    }
}
