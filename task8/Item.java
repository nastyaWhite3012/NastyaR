/**
 * Describes architecture of an item
 */
public class Item {
  private String type;
  private String name;
  private int quantity;
  private double price;

  /**
   * Constructor enter data for the
   * fields of the object item
   *
   * @param type     - item's type
   * @param name     - name's type
   * @param quantity - quantity's type
   * @param price    - item's type
   */
  public Item(String type, String name, int quantity, double price) {
    this.type = type;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  /**
   * Getter for item's type
   *
   * @return item's type
   */
  public String getType() {
    return type;
  }

  /**
   * Getter for item's quantity
   *
   * @return item's quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Getter for item's price
   *
   * @return item's price
   */
  public double getPrice() {
    return price;
  }
}
