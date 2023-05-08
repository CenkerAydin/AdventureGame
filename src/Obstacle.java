import java.util.Random;

public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int award;
    private int orjinalHealth;

    //Snake monster's damage to get random between 3 and 6
    static Random random=new Random();
    static int rand=random.nextInt(4)+3;



    public Obstacle( int id,String name, int damage, int health,int award) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.orjinalHealth=health;
        this.award=award;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
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
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if (health<0)
            health=0;
        this.health = health;
    }


}

class Zombie extends Obstacle{

    public Zombie() {
        super( 1,"Zombie", 3, 10,4);
    }

}

class Vampire extends Obstacle{

    public Vampire() {
        super(2,"Vampire",4,14,7);
    }
}

class Bear extends Obstacle{

    public Bear() {
        super(3,"Bear",7,21,12);
    }
}

class Snake extends Obstacle{

    public Snake() {
        super(4,"Snake",rand,12, 5);
    }

}