/**
 * 3/ It contains more than 5 words
 */
public class MoreThenFive {
  /**
   * Checking if the line
   * contains more than 5 words
   *
   * @param s - entered line
   * @return true, if the line
   * contains more than 5 words
   * otherwise false
   */
  public boolean moreThenFive(String s) {
    int a = 5;
    int more = s.split("[\\p{P} ]+").length;
    if (more > a) {
      return true;
    } else {
      return false;
    }
  }

}
