/**
 * 4/ It contains a word from a dictionary
 */
public class Dictionary {
  /**
   * Checking if the line contains
   * the words from the dictionary
   *
   * @param s - entered line
   * @return true, if the line contains
   * the words from the dictionary
   * otherwise false
   */
  public boolean dict(String s) {
    String[] dictionary = {"work", "hard", "anywhere", "everyday"};
    int isContain = 0;
    for (int i = 0; i < dictionary.length; i++) {
      if (s.contains(dictionary[i])) {
        isContain++;
      }
    }
    if (isContain != 0) {
      return true;
    } else {
      return false;
    }
  }
}
