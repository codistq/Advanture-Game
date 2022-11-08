import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health ;
    private int money;
    private String name;
    private String charName;
    private int shield;
    private int orjinalhealth;
    private String specialAward;
    private Scanner scan = new Scanner(System.in);
    Player(String name){
        this.name = name;
        this.inventory= new Inventory();
        this.orjinalhealth = health;
    }

    public String getSpecialAward() {
        return specialAward;
    }

    public void setSpecialAward(String specialAward) {
        this.specialAward = specialAward;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getCurrentDamage(){
        return damage+this.getInventory().getWeapons().getDamage();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public int getOrjinalhealth(){return this.orjinalhealth;}
    public void setOrjinalhealth(int orjinalhealth){this.orjinalhealth = orjinalhealth;}

    public void selectChar(){
        GameChar[] game = {new Samurai(),new Archer(),new Knight()};
        boolean IsSelectChar = true;
        System.out.println("*******--->SELECT YOUR CHARACTER<---*******");
        for (int i = 0; i <game.length-2;i++){
            System.out.println("CHARACTER  (1)-->"+game[0].getName()+"--> " +
                    "\tDAMAGE:"+game[0].getDamage()+"" +
                    "\tHEALTHY:"+game[0].getHealth()+"" +
                    "\tGOLD:"+game[0].getGold());
            System.out.println("CHARACTER  (2)-->"+game[1].getName()+"--> " +
                    "\tDAMAGE:"+game[1].getDamage()+"" +
                    "\tHEALTHY:"+game[1].getHealth()+"" +
                    "\tGOLD:"+game[1].getGold());
            System.out.println("CHARACTER  (3)-->"+game[2].getName()+"--> " +
                    "\tDAMAGE:"+game[2].getDamage()+"" +
                    "\tHEALTHY:"+game[2].getHealth()+"" +
                    "\tGOLD:"+game[2].getGold());
        }
        System.out.println("===========================================================");
        System.out.print("Select your Char ! :");
        String selectChar = scan.next();
        while (IsSelectChar){
            if(selectChar.equals("1")|| selectChar.equals("2")|| selectChar.equals("3")){
                switch (selectChar){
                    case "1":
                        initPlayer(game[0]);
                        System.out.println("Your selected char is :");
                        System.out.println("CHARACTER  (1)-->"+game[0].getName()+"--> " +
                                "\tDAMAGE:"+game[0].getDamage()+"" +
                                "\tHEALTHY:"+game[0].getHealth()+"" +
                                "\tGOLD:"+game[0].getGold());
                        break;
                    case "2" :
                        initPlayer(game[1]);
                        System.out.println("CHARACTER  (2)-->"+game[1].getName()+"--> " +
                                "\tDAMAGE:"+game[1].getDamage()+"" +
                                "\tHEALTHY:"+game[1].getHealth()+"" +
                                "\tGOLD:"+game[1].getGold());
                        break;
                    case "3" :
                        initPlayer(game[2]);
                        System.out.println("CHARACTER  (3)-->"+game[2].getName()+"-->" +
                                "\tDAMAGE:"+game[2].getDamage()+"" +
                                "\tHEALTHY:"+game[2].getHealth()+"" +
                                "\tGOLD:"+game[2].getGold());
                        break;
                    default:
                        System.out.println("Choose carefully !  ");
                }
                IsSelectChar=false;
            }else{
                System.out.print("Select carefully ! :");
                selectChar = scan.next();

            }
        }

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getDamage());
        this.setMoney(gameChar.getGold());
        this.setCharName(gameChar.getName());
        this.setOrjinalhealth(gameChar.getHealth());

    }
    public void getInfo(){
        System.out.println("==========**==========");
        System.out.println("---CHARACTER INFORMATION---");
        System.out.println("|>"+"Current Gun :"+this.getInventory().getWeapons().getName());
        System.out.println("|>"+"Current Damage :"+this.getDamage());
        System.out.println("|>"+"Current Shield :"+this.getInventory().getArmor().getName());
        System.out.println("|>"+"Current Block :"+this.getInventory().getArmor().getBlock());
        System.out.println("|>"+"Current Health :"+this.getHealth());
        System.out.println("|>"+"Current Gold :"+this.getMoney());
        System.out.println("|>"+"Special Award :"+this.getSpecialAward());
        System.out.println("==========**==========");


    }








}
