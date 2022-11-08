import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private boolean charSelect = true;
    public void start() {
        System.out.print("Welcome to Adventure Game Please Enter a name : ");
        String PlayerName =scan.next();
        Player player = new Player(PlayerName);
        System.out.println("Be careful on this island MR. " + PlayerName + " Always keep watch ! ");
        player.selectChar();
        Location location = null;
        while (true) {
            player.getInfo();
            System.out.println("=====AREAS=====");
            System.out.println("1-Safe House");
            System.out.println("2-Store");
            System.out.println("3-Forest !!");
            System.out.println("4-Cave !!");
            System.out.println("5-River !!");
            System.out.println("6-Coal !!");
            System.out.println("0-Exit GAME");
            System.out.print("Select : ");
            String selectArea = scan.next();
            switch (selectArea) {
                case "0" -> location = null;
                case "1" -> location = new SafeHouse(player, "SafeHouse");
                case "2" -> location = new Toolstore(player, "ToolStore");
                case "3" -> {
                        System.out.println("Dangerous !");
                        location = new Forest(player);
                }
                case "4" -> {
                        System.out.println("Dangerous !");
                        location = new Cave(player);
                }
                case "5" -> {
                        System.out.println("Dangerous !");
                        location = new River(player);
                }
                case "6" -> {
                    System.out.println("Dangerous !");
                    location = new Coal(player);
                }
                default -> {
                    System.out.print("Select carefully! : ");
                    selectArea = scan.next();
                }
            }
            if(location==null){
                System.out.println("BY BY COWARD ! ");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER ! ");
                break;
            }

        }


    }


}