import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    protected Scanner inp = new Scanner(System.in);

    Location(Player player, String name) {
        this.player = player;
        this.name = name;

    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class NormalLoc extends Location {

    NormalLoc(Player p, String name) {
        super(p, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}

class SafeHouse extends NormalLoc {
    public SafeHouse(Player p) {
        super(p, "SafeHouse");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house");
        System.out.println("Your health is full");
        return true;
    }
}

class ToolStore extends NormalLoc {
    public ToolStore(Player p) {
        super(p, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to shop ");
        boolean showMenu=true;
        while (showMenu) {
            System.out.println("1-Weapon");
            System.out.println("2-Armor");
            System.out.println("3-Exit");
            System.out.println("Please enter the choose");
            int selectCase = inp.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid input.Try again");
                selectCase = inp.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you later");
                    showMenu=false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Weapons");
        System.out.println();
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getName() +
                    " Money: " + weapon.getPrice() +
                    ", Damage: " + weapon.getDamage());
        }
        System.out.println("0 -Exit");
    }

    public void buyWeapon() {
        System.out.println("Please enter the weapon");
        int selectWeaponID = inp.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().size()) {
            System.out.print("Invalid input,Try again");
            selectWeaponID = inp.nextInt();
        }
        if (selectWeaponID !=0){
            Weapon selectedWeapon = Weapon.getWeapon(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println(selectedWeapon.getName() + " bought");
                    int newMoney = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(newMoney);
                    System.out.println("Current Money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
              }
            }
        }
    }

    public void printArmor() {
        System.out.println("Weapon");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getName() +
                    " Block: " + armor.getBlock() +
                    " Money: " + armor.getPrice());
        }
        System.out.println("0- Exit");
    }

    public void buyArmor(){
        System.out.println("Please enter the armor");
        int selectArmorID = inp.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().size()) {
            System.out.print("Invalid input,Try again");
            selectArmorID = inp.nextInt();
        }
        if (selectArmorID !=0){
            Armor selectedArmor=Armor.getArmor(selectArmorID);
            if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                System.out.println("You don't have enough money!");
            }else {
                System.out.println(selectedArmor.getName()+" bought");
                int newMoney=this.getPlayer().getMoney()-selectedArmor.getPrice();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Current Money: "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
        }
        }
    }
}
