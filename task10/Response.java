/**
 * Create random values for servers
 * in the range from 10 ms to 500 ms
 */
public class Response {
  /**
   * Create random values for servers
   * in the range from 10 ms to 500 ms
   *
   * @param arrayIP - IP-addresses' array
   * @return - random value of server's response
   */
  public int Random(IP[] arrayIP) {
    int random = 0;
    for (int i = 0; i < arrayIP.length; i++) {
      random = (int) (Math.random() * 491 + 10);
    }
    return random;
  }
}
