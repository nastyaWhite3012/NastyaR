import java.util.Scanner;

/**
 * Check line corresponds to one
 * of the following rules:
 * 1/ It doesn't contain numbers
 * 2/ It contains only numbers
 * 3/ It contains more than 5 words
 * 4/ It contains a word from a dictionary
 */
public class Main {
  /**
   * input line and output
   * corresponding rule
   *
   * @param args - console argument
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your line");
    String s = scanner.nextLine();
    Check ch = new Check();

    ch.check(s);
  }
}
