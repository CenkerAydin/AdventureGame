import java.util.ArrayList;

public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name,int id, int damage, int price) {
        this.name=name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static ArrayList<Weapon> weapons(){
        ArrayList<Weapon> weapons=new ArrayList<>();
        weapons.add(0, new Weapon("Pistol", 1, 2, 10));
        weapons.add(1, new Weapon("Sword", 2, 3, 35));
        weapons.add(2, new Weapon("Rifle", 3, 7, 45));
        weapons.add(3, new Weapon("Awp", 4, 10, 70));
        return weapons;
    }

    public static Weapon getWeapon(int id){

        for (Weapon w:Weapon.weapons()){
            if (w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
