import java.util.ArrayList;
/**
  * Damier represent a checkerboard
  *
  * @author m27bay
  * @version 1.0
  */
public class Damier extends Square {
  /* Attributs */
  private short size; // Size of the checkerboard
  private short num_square; // Number of square

  private Square[][] list_square; // Save the coords of all squares
  private boolean[][] is_occuped; // Save if something is on the square
  private ArrayList <Robot> list_robot;

  /* Methods */

  /* Default builder */
  public Damier() {
    this.size = 0;
    this.num_square = 0;

    list_square = new Square[this.num_square][this.num_square];
    is_occuped = new boolean[this.num_square][this.num_square];
    list_robot = new ArrayList <Robot>(5);
  }

  /**
    * Builder with arguments
    *
    * @param size the size of the checkerboard
    * @param num_square the number of square for the checkerboard
    */
  public Damier (short size, short num_square) {
    this.num_square = num_square;
    this.size = size;

    // Init the table of coords
    list_square = new Square[this.num_square][this.num_square];
    for(int i=0; i<this.num_square; ++i)
      for(int j=0; j<this.num_square; ++j)
        list_square[i][j] = new Square(new Point2D((short)(50*i), (short)(50*j)),
          (short)(this.size/this.num_square));

      // Init the table 'is_occuped'
    is_occuped = new boolean[this.num_square][this.num_square];
    for(boolean[] sub_list_bool: is_occuped)
      for(boolean elem_bool: sub_list_bool)
        elem_bool = false;

    list_robot = new ArrayList <Robot>();
  }

  /**
    * Getter list coords
    * @return the list of coords
    */
  public Square[][] get_coords_damier() {
    return this.list_square;
  }

  /**
    * Getter list 'is_occuped'
    * @return the list 'is_occuped'
    */
  public boolean[][] get_is_occuped() {
    return this.is_occuped;
  }

  /**
    * Getter number of square
    * @return the number of square
    */
  public short get_num_square() {
    return this.num_square;
  }

  /**
    * Getter size of checkerboard
    * @return the size of checkerboard
    */
  public short get_size_square() {
    return (short)(this.size/this.num_square);
  }

  /**
    * Getter the list of robots
    * @return the list of robots
    */
  public ArrayList <Robot> get_list_robot() {
    return this.list_robot;
  }


  /**
    * Setter list 'is_occuped'
    * @param new_is_occuped for change the list 'is_occuped'
    */
  public void set_is_occuped(boolean[][] new_is_occuped) {
    this.is_occuped = new_is_occuped;
  }

  /* Print all coords of the checkerbord */
  public void draw_coords_damier() {
    for(Square[] sub_list_square: list_square) {
      for(Square square: sub_list_square) {
        System.out.print(square.to_string_top_right()+"  ");
      }
      System.out.println("\n");
    }
  }

  /**
    *
    */
  public void add_robot(Robot new_robot) {
    this.list_robot.add(new_robot);
  }

  /** Print the table 'is_occuped'
    * X     is the square is occuped
    * -     isn't
    */
  public void draw_is_occuped() {
    for(boolean[] sub_bool: is_occuped) {
      for(boolean bool: sub_bool) {
        if(bool)
          System.out.print("X  ");
        else
          System.out.print("-  ");
      }
      System.out.println("");
    }
  }
}
