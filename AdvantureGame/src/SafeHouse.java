public class SafeHouse extends NormalLoc {
    SafeHouse(Player player, String name) {
        super(player, name="SafeHouse");
    }
    public void setPlayerHealth(Player player){
        player.setHealth(player.getHealth());
    }
    @Override
    public boolean onLocation(){
        setPlayerHealth(getPlayer());
        System.out.println("You're in the safe house!");
        System.out.println("Your health will be full!");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalhealth());
       return true;
    }

}
