/**
 * 2/ It contains only numbers
 */
public class Numbers extends Builder {
  /**
   * Checking if the line
   * only contains numbers
   *
   * @param s - entered line
   * @return true, if the contains
   * only numbers otherwise false
   */
  public boolean check(String s) {
    char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int isNumbers = 0;
    char[] newS = s.toCharArray();
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < newS.length; j++) {
        if (numbers[i] == newS[j]) {
          isNumbers++;
        }
      }
    }
    if (isNumbers == newS.length) {
      return true;
    } else {
      return false;
    }
  }
}
