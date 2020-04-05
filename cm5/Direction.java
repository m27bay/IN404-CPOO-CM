/**
  * Robot represent a robot
  *
  * @author m27bay
  * @version 1.0
  */

public class Direction {
  /* Attribtus */
  private short dir_x;
  private short dir_y;

  /* Methods */

  /* Default builder */
  public Direction() {
    this.dir_x = 0;
    this.dir_y = 0;
  }

  /**
    * Builder with arguments
    *
    * @param dir_x    for the direction follow abscissa axis
    * @param dir_y    for the direction follow ordinate axis
    */
  public Direction(short dir_x, short dir_y) {
    this.dir_x = dir_x;
    this.dir_y = dir_y;
  }

  /** Getter dir_x
    * @return dir_x
    */
  public short get_dir_x() {
    return this.dir_x;
  }

  /** Getter dir_y
    * @return dir_y
    */
  public short get_dir_y() {
    return this.dir_y;
  }

  /** Setter dir_x
    * @param dir_x
    */
  public void set_dir_x(short dir_x) {
    this.dir_x = dir_x;
  }

  /** Setter dir_y
    * @param dir_y
    */
  public void set_dir_y(short dir_y) {
    this.dir_y = dir_y;
  }

  /** Print information of the Direction
    * @return string
    */
  public String to_string() {
    return "("+this.dir_x+" ; "+this.dir_y+")";
  }
}
