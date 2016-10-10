/**
 * 4/ It contains a word from a dictionary
 */
public class Dictionary extends Builder {
  /**
   * Checking if the line contains
   * the words from the dictionary
   *
   * @param s - entered line
   * @return true, if the line contains
   * the words from the dictionary
   * otherwise false
   */
  public boolean check(String s) {
    String[] dictionary = {"work", "hard", "anywhere", "everyday"};
    int isContain = 0;
    String[] d = s.split("[\\p{P} ]+");
    for (int i = 0; i < d.length; i++) {
      for (int j = 0; j < dictionary.length; j++) {
        if (d[i].equals(dictionary[j])) {
          isContain++;
        }
      }
//      if (s.contains(dictionary[i])) {

    }
    if (isContain != 0) {
      return true;
    } else {
      return false;
    }
  }
}
