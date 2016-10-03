public class Task2 {
  /**
   * Class Task2
   */
  public static void main(String[] args) {
    if(args.length !=0) {
      for (int i=0; i<args.length; i++) {
        System.out.println("Hello, " + args[i]); //Output
      }
    }
    else
      System.out.println("Wrong data!");
  }
}
