public class Task1 {
  /**
   * Class Task1
   */
  public static void main(String[] args) {
    for (int i = args.length-1; i>=0; i--) {
      System.out.println("Argument" + i + " = " + args[i]); //Output elements in reverse order
    }
  }
}
