public  class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int gold;
    private int award;
    private int orjinalHealth;
    public Obstacle(String name,int id, int damage,int health, int gold,int award){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.orjinalHealth = health;
        this.gold = gold;
        this.award = award;
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
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getGold(){
        return  this.gold;
    }
    public void setGold(int gold){
        this.gold = gold;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAward() {
        return award;
    }
    public void setAward(int award) {
        this.award = award;
    }
    public int getOrjinalHealth(){return this.orjinalHealth;}
    public void setOrjinalHealth(int orjinalHealth){this.orjinalHealth = orjinalHealth;}
}
