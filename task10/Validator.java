import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/**
 * Validation IP-address
 */
public class Validator {
  /**
   * Check if the IP-address is valid
   *
   * @param args - console argument
   * @return true if IP-address is valid otherwise false
   */
  public static boolean isValidIPAddress(final String args) {
    try {
      Object res = InetAddress.getByName(args);
      return res instanceof Inet4Address || res instanceof Inet6Address;
    } catch (IOException e) {
      return false;
    }
  }
}
