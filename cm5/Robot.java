/**
  * Robot represent a robot
  *
  * @author m27bay
  * @version 1.0
  */
public class Robot extends Point2D{
  /* Attribut */
  private Point2D origine;
  private short pos_x, pos_y; // pos_x, pos_y is the list 'is_occuped'
  private boolean is_put;

  /* Methods */

  /* Default builder */
  public Robot() {
    this.origine = new Point2D();
    this.pos_x = -1;
    this.pos_y = -1;
    this.is_put = false;
  }

  /**
    * Print information of the robot
    * @return string
    */
  public String to_string() {
    return "Robot put on: ("+this.pos_x+" ; "+this.pos_y+")";
  }

  /**
    * Put a robot in the checkerboard
    * The first free place
    */
  public void put_damier(Damier d) {
    if(d.get_list_robot().size() <= 5) {
      System.out.println("Robot is put.");
      // Recove information about checherboard
      Square[][] list_coords = d.get_coords_damier();
      boolean[][] is_occuped = d.get_is_occuped();

      // Found the first free place in the checkerboard
      for(int i=0; i<d.get_num_square(); ++i) {
        for(int j=0; j<d.get_num_square(); ++j) {
          if((!is_occuped[i][j]) && (!this.is_put)) {
            this.origine = list_coords[i][j].get_top_right();
            is_occuped[i][j] = true;
            this.is_put = true;
            this.pos_x = (short)j; this.pos_y = (short)i;
          }
        }
      }
      d.set_is_occuped(is_occuped);
      d.add_robot(this);
    }
    else
      System.out.println("Can't append a new robot: number of max robots reached.");

  }

  /**
    * Put a robot int the checkerboard
    * The place selected

    * @param pos_x the line for place
    * @param pos_y the colunm for place
    */
  public void put_damier_select(Damier d, short pos_x, short pos_y) {
    System.out.println("Robot is put.");
    // Recove information about checherboard
    Square[][] list_coords = d.get_coords_damier();
    boolean[][] is_occuped = d.get_is_occuped();

    // deduct one because start at 0 in table
    if(!is_put)
      pos_x -= 1; pos_y -= 1;

    // Check if pos_x and pos_y are in the checkerboard
    if((0<=pos_x && pos_x<d.get_num_square()) &&
      (0<=pos_y && pos_y<d.get_num_square())) {

      if((!is_occuped[pos_y][pos_x]) && (!this.is_put)) {
        this.origine = list_coords[pos_y][pos_x].get_top_right();
        is_occuped[pos_y][pos_x] = true;
        this.is_put = true;
        this.pos_x = pos_x; this.pos_y = pos_y;

        d.set_is_occuped(is_occuped);
        d.add_robot(this);
      }
    }
    else {
      System.out.println("Position ("+pos_x+" ; "+pos_y+
        ") out of checkerboard (damier).\nPositon recalculate.");
      put_damier(d);
    }
  }

  /**
    * Switcher for know the direction
    *
    * @param direction    the direction entry by the user
    * @return dir         the object Direction
    */
  private Direction switch_direction(String direction) {
    Direction dir = new Direction();

    if(direction.equals("top") || direction.equals("Top"))
      dir.set_dir_y((short)-1);
    else if(direction.equals("down") || direction.equals("Down"))
      dir.set_dir_y((short)1);
    else if(direction.equals("left") || direction.equals("Left"))
      dir.set_dir_x((short)-1);
    else if(direction.equals("right") || direction.equals("Right"))
      dir.set_dir_x((short)1);

    return dir;
  }

  /**
    * Collision with the robots in the checkerboard
    * @param d            the checkerboard
    * @param dir          +/-1 on x or y
    * @param direction    the direction entry by the user
    * @return true/false  if have a collision
    */
  private boolean collision(Damier d, Direction dir, String direction) {
    boolean[][] is_occuped = d.get_is_occuped();

    if(direction.equals("top") || direction.equals("Top")) {
      if(is_occuped[this.pos_y+dir.get_dir_y()][this.pos_x]) {
        System.out.println("Can't moove the robot on the '"+direction+"': collision.");
        return true;
      }
    }
    else if(direction.equals("down") || direction.equals("Down")) {
      if(is_occuped[this.pos_y+dir.get_dir_y()][this.pos_x]) {
        System.out.println("Can't moove the robot on the '"+direction+"': collision.");
        return true;
      }
    }

    else if(direction.equals("left") || direction.equals("Left")) {
      if(is_occuped[this.pos_y][this.pos_x+dir.get_dir_x()]) {
        System.out.println("Can't moove the robot on the '"+direction+"': collision.");
        return true;
      }
    }

    else if(direction.equals("right") || direction.equals("Right")) {
      if(is_occuped[this.pos_y][this.pos_x+dir.get_dir_x()]) {
        System.out.println("Can't moove the robot on the '"+direction+"': collision.");
        return true;
      }
    }

    return false;
  }

  /**
    *
    *
    */
  public void moove(Damier d, String direction) {
    Direction dir = switch_direction(direction);

    if((0<=this.pos_x+dir.get_dir_x()) && (this.pos_x+dir.get_dir_x()<d.get_num_square())
      && (0<=this.pos_y+dir.get_dir_y()) && (this.pos_y+dir.get_dir_y()<d.get_num_square())) {

      if(!collision(d, dir, direction)) {
        System.out.println("Robot have moove.");
        boolean[][] list = d.get_is_occuped();
        list[this.pos_y][this.pos_x] = false;

        this.pos_x += dir.get_dir_x();
        this.pos_y += dir.get_dir_y();

        list[this.pos_y][this.pos_x] = true;
        d.set_is_occuped(list);

        this.origine.set_coords_x((short)(pos_x*d.get_size_square()));
        this.origine.set_coords_y((short)(pos_y*d.get_size_square()));
      }
    }
    else
      System.out.println("Can't moove the robot at the '"+direction+"' : out of checkerboard.");
  }
}
