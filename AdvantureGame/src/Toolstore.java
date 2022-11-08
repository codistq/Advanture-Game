

public class Toolstore extends NormalLoc {
    private boolean control = true;
    Toolstore(Player player, String name) {
        super(player, name = "Store");
    }
    boolean isBackMainMenu = true;
    @Override
    public boolean onLocation() {
        while (isBackMainMenu) {
            System.out.println("You're in the ToolStore ! ");
            System.out.println("Welcome to Store we have a great items for you ! ");
            System.out.println("PRESS 1 FOR WEAPON");
            System.out.println("PRESS 2 FOR ARMORS");
            System.out.println("PRESS 3 FOR QUIT");
            System.out.print("SELECT:");
            int selectGorA = scan.nextInt();
            while (control) {
                if ((selectGorA == 1) || (selectGorA == 2) || (selectGorA == 3)) {
                    switch (selectGorA) {
                        case 1:
                            printWeapon();
                            buyWeapon();
                            break;
                        case 2:
                            printArmor();
                            buyArmor();
                            break;
                        case 3:
                            isBackMainMenu = false;
                    }
                    control = false;
                } else {
                    System.out.print("Select carefully! :");
                    selectGorA = scan.nextInt();
                }
            }
            return true;

        }

        return false;
    }





    public void printWeapon(){
        System.out.println("=*=*=*=*=*WEAPON*=*=*=*=*=");
        for(int i = 0;i<Weapons.weapons().length;i++){
            System.out.println("WEAPON-->:\tID:"+Weapons.weapons()[i].getId()+
                     "\tNAME:"+Weapons.weapons()[i].getName()+
                    "\tDAMAGE:"+Weapons.weapons()[i].getDamage()+
                    "\tPRICE:"+Weapons.weapons()[i].getPrice());
        }
    }
    public void buyWeapon(){
        System.out.println("SELECT A WEAPON");
        System.out.println("QUIT FOR PRESS 0");
        System.out.print("SELECT:");
        int selectWeapon = scan.nextInt();
        boolean control =true;
        while (control){
            if ((selectWeapon<-1) || selectWeapon>Weapons.weapons().length){
                System.out.print("SELECT CAREFULLY! : ");
                selectWeapon = scan.nextInt();
            }else {
                control =false;
            }
        }
        if(selectWeapon==0){
            onLocation();
        }
        Weapons selectedWeapons = Weapons.getWeaponByID(selectWeapon);
        if(selectedWeapons != null){
            if(selectedWeapons.getPrice()>this.getPlayer().getMoney()){
                System.out.println("You don't have enough gold to buy this item !");
                System.out.println("Weapon Price : "+selectedWeapons.getPrice()+" Gold");
                System.out.println("Total: "+this.getPlayer().getMoney()+" Gold");
            }else{
                this.getPlayer().setMoney((this.getPlayer().getMoney())-selectedWeapons.getPrice());
                System.out.println("Total you have gold:"+this.getPlayer().getMoney());
                System.out.print("gun before purchase :");
                System.out.println(this.getPlayer().getInventory().getWeapons().getName());
                System.out.print("Your current weapon :");
                this.getPlayer().getInventory().setWeapons(selectedWeapons);
                System.out.println(getPlayer().getInventory().getWeapons().getName()+" now");

            }
        }


    }
    public void printArmor(){

        System.out.println("=*=*=*=*=*ARMOR*=*=*=*=*=");
        for(int i = 0 ; i<Armor.armors().length;i++){
            System.out.println("NAME:"+Armor.armors()[i].getName()+
                    "\tID:"+Armor.armors()[i].getId()+
                    "\tBLOCK:"+Armor.armors()[i].getBlock()+
                    "\tPRICE:"+Armor.armors()[i].getPrice()+" Gold");
        }
    }
    public void buyArmor(){
        System.out.println("SELECT A ARMOR");
        System.out.println("QUIT FOR PRESS 0 ");
        System.out.print("SELECT:");
        int selectArmor = scan.nextInt();
        boolean control1 = true;
        while (control1){
            if(selectArmor<-1 || selectArmor>Armor.armors().length){
                System.out.print("Select carefully !:");
                selectArmor = scan.nextInt();
            }else{
                control1 =false;
            }
        }
        if(selectArmor==0){
            onLocation();
        }
        Armor selectedArmor = Armor.getArmorByID(selectArmor);
        if(selectedArmor!=null){
            if(selectedArmor.getPrice()> getPlayer().getMoney()){
                System.out.println("You don't have enough money to buy this item ! ");
                System.out.println("ITEM PRICE : "+selectedArmor.getPrice());
                System.out.println("TOTAL GOLD: "+this.getPlayer().getMoney());

            }else{
                System.out.println("SELECTED ITEM IS : "+selectedArmor.getName());
                this.getPlayer().setMoney(this.getPlayer().getMoney()- selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Thanks for shopping ! ");
            }

        }


    }

}



