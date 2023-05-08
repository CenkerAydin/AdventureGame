import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private String charName;
    private Scanner inp=new Scanner(System.in);
    private Inventory inventory;

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }
    public void selectChar(){
        GameCharacter[]charList={new Samurai(),new Knight(),new Archer()};
        System.out.println("------------------------------");
        for (GameCharacter gameChar:charList) {

            System.out.println("ID : "+gameChar.getId()+
                    " Characters:"+gameChar.getName()+
                    "\t Damage: "+gameChar.getDamage()+
                    "\t Health:"+gameChar.getHealth()+
                    "\t Money: "+gameChar.getMoney());

        }
        System.out.println("------------------------------");
        System.out.println("Please enter the character:");
        int selectChar=inp.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Character: "+this.getName()+
            "\t Damage: "+this.getDamage()+
            "\t Health: "+this.getHealthy()+
            "\t Money:  "+this.getMoney());
    }

    public void printInfo(){
        System.out.println(
                " Weapon: "+this.getInventory().getWeapon().getName()+
                " ,Armor: "+this.getInventory().getArmor().getName()+
                " ,Block: "+this.getInventory().getArmor().getBlock()+
                " ,Damage: "+this.getDamage()+
                " ,Health: "+this.getHealthy()+
                " ,Money: "+this.getMoney());
    }
    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealthy(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setName(gameCharacter.getName());
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealthy() {
        return healthy;
    }
    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCharName() {
        return charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
