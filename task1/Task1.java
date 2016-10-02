package task1;

/**
 * Created by HP on 02.10.2016.
 */
public class Task1 {
  public static void main(String[] args) {
    for (int i = args.length; i>=0; i--) {
      System.out.println("Argument" + i + " = " + args[i]); //Output elements in reverse order
    }
  }
}
