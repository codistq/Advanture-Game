import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private String specialAward;
    BattleLoc(Player player,String name,Obstacle obstacle,String award,int maxObstacle,String specialAward){
        super(player,name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.specialAward = specialAward;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {

        this.obstacle = obstacle;
    }

    public String getSpecialAward() {
        return specialAward;
    }
    public void setSpecialAward(String specialAward) {
        this.specialAward = specialAward;
    }

    @Override
    public  boolean onLocation(){
        int obsnumber = this.randomObstacle();
        String fightorRun;
        System.out.println("You are here -->"+this.getName());
        System.out.println("There are "+obsnumber+" "+this.getObstacle().getName()+" here !");
        System.out.println("Do you want to fight ?");
        System.out.println("FIGHT--> Y");
        System.out.println("RUN--> N");
        System.out.print("SELECT:");
        fightorRun = scan.next();
        fightorRun = fightorRun.toUpperCase();
            if(fightorRun.equals("Y") || fightorRun.equals("N")) {
                if(fightorRun.equals("Y")){
                    if(combat(obsnumber)){
                        return true;
                    }
                }else{
                    return false;
                }
                if(this.getPlayer().getHealth()>0){
                    return true;
                }else{
                    System.out.println("You dead!");
                    return false;

                }
            }
        return true;
    }
    public boolean combat(int obsNumber ){
        for(int i = 1 ;i<=obsNumber;i++) {

            this.getObstacle().setHealth(this.obstacle.getOrjinalHealth());
            String keepFight;
            statusChar();
            statusObs(i);
            while (this.getObstacle().getHealth() > 0 && this.getPlayer().getHealth() > 0) {

                System.out.println("Hit or Run ( H or R ) :");
                keepFight = scan.next().toUpperCase();
                if(keepFight.equals("H")){
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.println("You hit ! ");
                        this.obstacle.setHealth(obstacle.getHealth()-getPlayer().getCurrentDamage());
                        if(this.getObstacle().getHealth()>0){
                            seeCharHealth();
                        }
                    }
                    if (this.obstacle.getHealth() > 0) {
                        System.out.println(obstacle.getName()+" Hit to you !");
                        int obstacleDamage= this.obstacle.getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        if (this.getPlayer().getHealth() > 0) {
                            seeCharHealth();
                        }
                    }
                    if(this.obstacle.getHealth()<=0){
                        if(this.getObstacle().getName().equals("Snake")){
                            possible();
                        }else {

                            System.out.println("You earn the " + this.obstacle.getAward() + " Gold from " + this.obstacle.getName());
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                            System.out.println("Current gold---->" + this.getPlayer().getMoney());
                            System.out.println("You earn a " + this.getSpecialAward());
                            this.getPlayer().setSpecialAward(this.specialAward);

                        }

                    }

                } else if (keepFight.equals("R")) {
                    return  false;
                }
            }
        }
        return  false;
    }
    public void statusChar(){
        System.out.println("=====CHAR STATUS=====");
        System.out.println("=============================");
        System.out.println("Name-->"+this.getPlayer().getName());
        System.out.println("Health-->"+this.getPlayer().getHealth());
        System.out.println("Damage-->"+this.getPlayer().getDamage());
        System.out.println("Weapon-->"+this.getPlayer().getInventory().getWeapons().getName());
        System.out.println("Armor Type-->"+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block Ability-->"+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println();
    }
    public void statusObs(int i){
        System.out.println("=====OBSTACLE STATUS=====");
        System.out.println("=============================");
        System.out.println("Name:"+this.getObstacle().getName()+"--->"+i+" .Obstacle");
        System.out.println("Health:"+this.getObstacle().getHealth());
        System.out.println("Damage:"+this.getObstacle().getDamage());
        if(obstacle.getName().equals("Snake")){
            System.out.println("Award: Money or Weapon or Armor ! ");
        }else {
            System.out.println("Award:" + this.getObstacle().getAward() + " Gold");
        }
        System.out.println();

    }
    public void seeCharHealth(){
        System.out.println("------------------");
        System.out.println("Char current health--> "+this.getPlayer().getHealth());
        System.out.println("Obstacle current health--> "+this.getObstacle().getHealth());
        System.out.println("------------------");
        System.out.println();
    }


    public int randomObstacle(){
        Random r = new Random();
       return r.nextInt(this.getMaxObstacle()) + 1;
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public void possible(){
        double random1 = Math.random();
       int random2 = (int) (random1*100);
        if(random2<=15){ ///GUN///
            double random3 = Math.random();
            int random4 = (int) (random3*100);
            if(random4<=20){
                System.out.println("You have rifle ");
                this.getPlayer().getInventory().setWeapons(Weapons.weapons()[0]);
            } else if (random4>21 &&random4<=51) {
                System.out.println("You have Sword");
                this.getPlayer().getInventory().setWeapons(Weapons.weapons()[1]);
            } else if (random4>52 && random4<=100) {
                System.out.println("You have pistol");
                this.getPlayer().getInventory().setWeapons(Weapons.weapons()[3]);
            }
            ////////////////////////////
        } else if (random2>16 &&random2<=42) { //ARMOR//
            double random5 = Math.random();
            int random6 = (int) (random5*100);
            if(random6<=20){
                System.out.println("You have High armor");
                this.getPlayer().getInventory().setArmor(Armor.armors()[2]);
            } else if (random6>21 &&random6<=51) {
                System.out.println("You have Medium armor");
                this.getPlayer().getInventory().setArmor(Armor.armors()[1]);
            } else if (random6>52 && random6<=100) {
                System.out.println("You have Low armor");
                this.getPlayer().getInventory().setArmor(Armor.armors()[0]);
            }
            ///////////////////////////
        } else if (random2>42 && random2<=66) {//money//
           //money
            double random7 = Math.random();
            int random8 = (int) (random7*100);
            if(random8<=20){
                this.getPlayer().setMoney(getPlayer().getMoney()+10);
                System.out.println("you won +10 gold");
            } else if (random8>21 &&random8<=51) {
                System.out.println("you won +5 gold");
                this.getPlayer().setMoney(getPlayer().getMoney()+5);
            } else if (random8>52 && random8<=100) {
                System.out.println("you won +1 gold");
                this.getPlayer().setMoney(getPlayer().getMoney()+1);
            }
            ///////////////////////////
        } else if (random2>=66 && random2<=100) {
            System.out.println("You weren't earn anything !");
        }
    }
}
