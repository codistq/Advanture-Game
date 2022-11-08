public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;
    Armor(String name,int id,int block,int price){
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }
    public static Armor[] armors(){
        Armor[] armors = new Armor[3];
        armors[0] =new Armor("Low",1,1,15);
        armors[1] =new Armor("Medium",2,3,25);
        armors[2] =new Armor("High",3,5,40);
        return armors;
    }
    public static Armor getArmorByID(int id){
        for(int i = 0;i< armors().length;i++){
            if(id == Armor.armors()[i].id){
                return Armor.armors()[i];
            }
        }
        return null;

    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name =name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getBlock(){
        return this.block;
    }
    public void setBlock(int block){
        this.block = block;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }


}
