/**
  * Square represent a square
  *
  * @author m27bay
  * @version 1.0
  */

public class Square extends Point2D {
  /* Attributs */
  private Point2D top_right;
  private Point2D down_left;

  private short size;

  /* Methods */

  /* Default builder */
  public Square() {
    this.top_right = new Point2D();
    this.down_left = new Point2D();
    this.size = 0;
  }

  /**
    * builder with arguments
    *
    * @param p1 the point top right
    * @param size the size of the square
    */
  public Square (Point2D p1, short size) {
    this.top_right = p1;
    this.size = size;

    // Calcul point down left
    this.down_left = new Point2D((short)(p1.get_coords_x()+this.size),
    (short)(p1.get_coords_y()+this.size));
  }

  /**
    * Getter point top right
    * @return the point top right
    */
  public Point2D get_top_right() {
    return this.top_right;
  }

  /**
    * Print informations about the square
    * @return string with information about square
    */
  public String to_string () {
    return "Square:\nPoint top right: "+this.top_right.to_string()
    +"\nPoint down left: "+this.down_left.to_string()+"\nSquare size: "+this.size;
  }

  /**
    * Print informations about the point top right
    * @return string with information about point top right
    */
  public String to_string_top_right() {
    return this.top_right.to_string();
  }

    /**
    * Print informations about the point down left
    * @return string with information about point down left
    */
  public String to_string_down_left() {
    return this.down_left.to_string();
  }
}
