/**
 * Describes architecture of an IP
 */
public class IP {
  private String server;

  /**
   * Constructor entered data or
   * taken from the file
   *
   * @param server - string according to the ip-address from the console or from the file
   */
  public IP(String server) {
    this.server = server;
  }

  /**
   * Getter for IP's server
   *
   * @return - IP's server
   */
  public String getServer() {
    return server;
  }
}
