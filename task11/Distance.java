import java.util.ArrayList;

/**
 * Count the distance which the object
 * has gone
 */
public class Distance {
  /**
   * Transfer points from the ArrayList
   * to the two-dimensional array
   * and count the distance
   *
   * @param Point - input data
   * @return distance if the points from
   * file is valid
   */
  public double distance(ArrayList<String> Point) {
    String[] arrayPoint = new String[Point.size()];
    double[][] coordinate = new double[arrayPoint.length][2];
    double distance = 0.0;
    for (int i = 0; i < Point.size(); i++) {
      String[] xyString;
      double[] xy = new double[2];
      arrayPoint[i] = Point.get(i);
      xyString = arrayPoint[i].split(" ");
      for (int a = 0; a < 2; a++) {
        xy[a] = Double.parseDouble(xyString[a]);
      }
      for (int j = 0; j < xyString.length; j++) {
        coordinate[i][j] = xy[j];
      }
    }
    for (int i = 1; i < Point.size(); i++) {
      for (int j = 0; j < 2; j++) {
        distance += coordinate[i][j] * coordinate[i][j] - coordinate[i - 1][j] * coordinate[i - 1][j];
      }
    }
    if (!validateDistance(coordinate)) {
      System.out.println("Not valid data!");
      System.exit(0);
    }
    distance = Math.sqrt(distance);
    return distance;
  }

  /**
   * Check validity of the coordinates
   * taken from file
   *
   * @param coordinate - array of coordinates
   * @return true if the first and the last
   * coordinate isn't equal otherwise false
   */
  public boolean validateDistance(double[][] coordinate) {
    double ruleOne = 1 / (coordinate[0][0] - coordinate[coordinate.length - 1][0]);
    double ruleTwo = 1 / (coordinate[0][1] - coordinate[coordinate.length - 1][1]);
    if (Double.isInfinite(ruleOne) && Double.isInfinite(ruleTwo)) {
      return false;
    } else {
      return true;
    }
  }
}
