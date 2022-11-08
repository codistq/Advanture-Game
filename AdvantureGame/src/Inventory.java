public class Inventory {
    private Weapons weapons;
    private Armor armor;
    private String slots;


    Inventory(){

        this.weapons = new Weapons("Fist",0,0,0);
        this.armor = new Armor("Rag shirt",0,0,0);
    }


    public Weapons getWeapons() {
        return weapons;
    }
    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }
    public Armor getArmor(){
        return this.armor;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    public String getSlots() {
        return slots;
    }
    public void setSlots(String slots) {
        this.slots = slots;
    }
}
