public class Game{

  public Robot[] list_robot;
  public short num_robot;
  public Damier damier;

  public Game(Damier damier, Robot[] list_robot, short num_robot) {
    this.list_robot = list_robot;
    this.num_robot = num_robot;
    this.damier = damier;
  }
}
