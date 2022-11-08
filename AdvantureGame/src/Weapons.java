public class Weapons {
    private String name;
    private int id;
    private int damage;
    private int price;

    Weapons(String name , int id, int damage, int price){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons(){
        Weapons[] weapons = new Weapons[3];
        weapons[0] = new Weapons("Pistol",1,2,25);
        weapons[1] = new Weapons("Sword",2,3,35);
        weapons[2] = new Weapons("Gun",3,7,45);
        return weapons;
    }
    public static Weapons getWeaponByID(int id){
        for(int i = 0;i<Weapons.weapons().length;i++){
            if(id ==Weapons.weapons()[i].id){
                return Weapons.weapons()[i];
            }
        }
        return null;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price =price;
    }






}
