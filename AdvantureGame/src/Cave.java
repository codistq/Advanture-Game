public class Cave extends BattleLoc  {
    private  Player player;

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food",3,"Food");
    }


}
