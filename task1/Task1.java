public class Task1 {
  /**
   * Class Task1
   */
  public static void main(String[] args) { //Output elements in reverse order
    for (int i = args.length-1; i>=0; i--) {
      System.out.println("Argument" + i + " = " + args[i]);
    }
  }
}
