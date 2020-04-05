/**
  * Point2D represent a point in two dimension
  *
  * @author m27bay
  * @version 1.0
  */

public class Point2D {
  /* Attributs */
  private short coord_x;
  private short coord_y;

  /* Methods */

  /* Default builder */
  public Point2D() {
    this.coord_x = 0;
    this.coord_y = 0;
  }

  /**
    * Builder with arguments
    *
    * @param coord_x
    * @param coord_y
    */
  public Point2D(short coord_x, short coord_y) {
    this.coord_x = coord_x;
    this.coord_y = coord_y;
  }

  /**
    * Getter coords_x
    * @return coord_x
    */
  public short get_coords_x() {
    return this.coord_x;
  }

  /**
    * Getter coords_y
    * @return coord_y
    */
  public short get_coords_y() {
    return this.coord_y;
  }

  /**
    * Setter coords_x
    * @param coord_x
    */
  public void set_coords_x(short coord_x) {
    this.coord_x = coord_x;
  }

  /**
    * Setter coords_y
    * @param coord_y
    */
  public void set_coords_y(short coord_y) {
    this.coord_y = coord_y;
  }

  /**
    * Print informations of the point
    * @return String containt informations
    */
  public String to_string() {
    return "("+this.coord_x+" ; "+this.coord_y+").";
  }
}
