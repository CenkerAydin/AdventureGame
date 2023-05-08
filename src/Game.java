import java.util.Scanner;

public class Game {
    private Scanner inp=new Scanner(System.in);
   public void start(){
       System.out.println("Welcome to advanture game.");

        Player player=new Player("Cenker");
        System.out.println("Welcome "+player.getName());
        System.out.print("Please choose the character: ");
        player.selectChar();
       Location location=null;
       while (true) {
           player.printInfo();
           System.out.println();
           System.out.println("-----------------");
           System.out.println("Location");
           System.out.println("1-Safe House");
           System.out.println("2-Shop");
           System.out.println("3-Cave");
           System.out.println("4-Forest");
           System.out.println("5-River");
           System.out.println("6-Mine");
           System.out.println("0- Exit");
           System.out.print("Please enter the location that you want to:");
           System.out.println("---------------");
           int selectLoc=inp.nextInt();
           switch (selectLoc){
               case 0:
                   location=null;
                   break;
               case 1:
                   location=new SafeHouse(player);
                   break;
               case 2:
                   location=new ToolStore(player);
                   break;
               case 3:
                   location=new Cave(player);
                   break;
               case 4:
                   location=new Forest(player);
                   break;
               case 5:
                   location=new River(player);
                   break;
               case 6:
                   location=new Mine(player);
               default:
                   location=new SafeHouse(player);
           }

           if (location==null){
               System.out.println("Game End");
               break;
           }
           if (!location.onLocation()){
               System.out.println("GAME OVER");
               break;
           }

       }



   }
}