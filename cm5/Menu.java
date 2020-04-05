import java.util.Scanner;
import java.util.ArrayList;

public class Menu{

  public Menu() {}

  private Game add_robot(Game game) {
    game.list_robot[game.num_robot] = new Robot();
    game.num_robot+=1;

    String choice;
    do {
      Scanner scan2 = new Scanner(System.in);

      System.out.println("Do you want to put the robot at a precis position\n\t\t"+
        "in the checkerboard ? Y:yes or N:no");

       choice = scan2.nextLine();


      if((!choice.equals("Y")) && (!choice.equals("N")))
        System.out.println("Choice unknown.");

    }while((!choice.equals("Y")) && (!choice.equals("N")));

    if(choice.equals("N")) {
      game.list_robot[game.num_robot-1].put_damier(game.damier);
      System.out.println("Back to the menu...");
    }

    else if(choice.equals("Y")) {

      short column, line;
      Scanner scan1, scan2;

      scan1 = new Scanner(System.in);
      scan2 = new Scanner(System.in);

      System.out.println("Give me the column");
      column = (short)(scan1.nextInt());
      System.out.println("Give me the line");
      line = (short)(scan2.nextInt());

      game.list_robot[game.num_robot-1].put_damier_select(game.damier, column, line);
      System.out.println("Back to the menu...");
    }

    return game;
  }

  private void print_man() {
    System.out.println(
      "User manual:\n"+
      "'add': for add a new rebot in the checkerboard.\n"+
      "'show': for show the checkerboard, and the robot within.\n"+
      "'moove': for moove the robot.\n"+
      "'quit': for quit the game.\n");
  }

  private void print_menu_pp() {
    System.out.println("\n"+
      "Welcome in the robot game !\n"+
      "First we initialize the checkerboard...\n"+
      "Cherckerboard ready !\n"+
      "What do you wan't do to ?\n"+
      "Tape 'man' for view the manual.\n");
  }

  private boolean test_direction(String dir) {
    if(dir.equals("top") || dir.equals("Top"))
      return true;
    else if(dir.equals("down") || dir.equals("Down"))
      return true;
    else if(dir.equals("left") || dir.equals("Left"))
      return true;
    else if(dir.equals("right") || dir.equals("Right"))
      return true;

    return false;
  }

  private Game moove_robot(Game game) {
    if(game.num_robot  !=  0) {
      int robot = 0;

      do {
        System.out.println("Which robot do you want to moove ?");
        Scanner scan2 = new Scanner(System.in);
        robot = scan2.nextInt();
      }while(robot  >  game.num_robot);

      String direction = "top";
      do {
        System.out.println("Where do you want to moove the robot ?");
        Scanner scan3 = new Scanner(System.in);
        direction = scan3.nextLine();
      }while(!test_direction(direction));

      game.list_robot[robot-1].moove(game.damier, direction);
      System.out.println("Back to the menu...");
    }
    else {
      System.out.println("None robot is put: can't moove");
      System.out.println("Back to the menu...");
    }

    return game;
  }

  public void principale() {
    String choice;
    print_menu_pp();

    Game game = new Game(new Damier((short)500, (short)5), new Robot[25], (short)0);
    /*
    Damier damier = new Damier((short)500, (short)5);
    Robot[] list_robot = new Robot[25];
    short num_robot = 0;
    */

    do {
      Scanner scan = new Scanner(System.in);
      choice = scan.nextLine();

      if(choice.equals("man"))
        print_man();

      else if(choice.equals("add")) {
        game = add_robot(game);
      }

      else if(choice.equals("show")) {
        System.out.println("");
        game.damier.draw_is_occuped();
      }

      else if(choice.equals("moove")) {
        game = moove_robot(game);
      }

      else if(choice.equals("quit"))
        return;

      else
        System.out.println("\nChoice unknown.");

      if(!choice.equals("quit"))
        System.out.println("What do you wan't do to ?");

    }while(!choice.equals("quit"));
  }
}
