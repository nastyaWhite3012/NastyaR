/**
 * 1/ It doesn't contain numbers
 */
public class NoNumbers {
  /**
   * Checking if the line contains numbers
   *
   * @param s - entered line
   * @return true, if the line doesn't
   * have numbers otherwise false
   */
  public boolean noNumbers(String s) {
    String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    int isNoNumbers = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (s.contains(numbers[i])) {
        isNoNumbers++;
      }
    }
    if (isNoNumbers != 0) {
      return false;
    } else {
      return true;
    }
  }
}
