/**
 * Builder is the super class
 */
public abstract class Builder {
  /**
   * abstract method for rules
   *
   * @param s - entered line
   * @return rules' results
   */
  public abstract boolean check(String s);
}
