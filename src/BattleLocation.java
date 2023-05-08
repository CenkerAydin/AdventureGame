import java.util.Random;

public  abstract class BattleLocation extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLocation(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacle();
        System.out.println("Now here: "+this.getName());
        System.out.println("Careful! Here : "+obsNumber+" "+this.getObstacle().getName()+" here ");
        System.out.print("Figth(F) or run(R)");
        String selectFigth=inp.nextLine();
        selectFigth=selectFigth.toUpperCase();
        if (selectFigth.equals("F")){
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " you have defeated all obstacles ");
                return true;
            }
        }
        if (this.getPlayer().getHealthy()<0){
            System.out.println("You dead");
        }
        return true;

    }
    public boolean combat(int obsNumber){
        for (int i=0;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            System.out.println();
            playerStats();
            System.out.println();
            obstacleStatus();
            while (this.getPlayer().getHealthy()>0 && this.getObstacle().getHealth()>0){
                Random random =new Random();
                int rand=random.nextInt(2);
                if (rand==0) {
                    System.out.println("Fight or run");
                    String selectCombat = inp.nextLine().toUpperCase();
                    if (selectCombat.equals("F")) {
                        System.out.println("You hit");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                        afterHit();
                    }
                }else {
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Obstacle hit");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterHit();
                    }
                }
                }
        }
        return false;
    }
    public void afterHit(){
        System.out.println("Your health: "+this.getPlayer().getHealthy());
        System.out.println("Obstacle health: "+this.getObstacle().getHealth());
    }
    public void playerStats(){
        System.out.println("Player Status");
        System.out.println("------------------");
        System.out.println("Health: "+this.getPlayer().getHealthy());
        System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: "+this.getPlayer().getDamage());
        System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: "+this.getPlayer().getMoney());
        if (this.getPlayer().getInventory().getWeapon().getDamage()>0){
            System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapon().getName());
        }
    }
    public void obstacleStatus(){
        System.out.println(this.getObstacle().getName()+" Status");
        System.out.println("------------------");
        System.out.println("Health: "+this.getObstacle().getHealth());
        System.out.println("Damage: "+this.getObstacle().getDamage());
        System.out.println("Award: "+this.getObstacle().getAward());
    }
    public int randomObstacle(){
        Random r=new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}

