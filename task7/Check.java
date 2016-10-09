/**
 * Class for checking for what
 * rule the line is suitable
 */
public class Check {
  /**
   * Check all possible
   * conditions
   *
   * @param s - entered line
   */
  public void check(String s) {
    MoreThenFive m = new MoreThenFive();
    Dictionary d = new Dictionary();
    NoNumbers nN = new NoNumbers();
    Numbers n = new Numbers();

    if (s.length() == 0) {
      // condition if the user entered empty line
      System.out.println("Empty line!");
      System.exit(0);
    }
    if (nN.noNumbers(s)) {
      System.out.println("This line doesn't contain numbers.");
    }
    if (n.isNumber(s)) {
      System.out.println("This line contains only numbers.");
    }
    if (m.moreThenFive(s)) {
      System.out.println("This line contains more than 5 words. ");
    }
    if (d.dict(s)) {
      System.out.println("This line contains words from dictionary.");
    }
    if (!n.isNumber(s) && !nN.noNumbers(s) && !m.moreThenFive(s) && !d.dict(s)) {
      // condition if the line doesn't contain any rule
      System.out.println("The line doesn't contain any rule!");
    }
  }
}
