package Database;

import java.sql.*;

/**
 * Connect to Wordpress's database for contributer
 */
public class ConnectionToDatabaseContributer {
  private static final String URL = "jdbc:mysql://localhost:8889/wordpress";
  private static final String USER = "root";
  private static final String PASSWORD = "root";
  private static Connection CONNECTION;
  private static Statement STATEMENT;
  private static ResultSet RESULTSET;

  private String SELECT_USERS_TABLE = "SELECT user_login FROM wordpress.wp_users";
  private String SELECT_USERMETA_TABLE = "SELECT user_id FROM wordpress.wp_usermeta";
  private String ADDING_CONTRIBUTER = "INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
      "user_email, display_name) " +
      "VALUES ('contributer', MD5('1'), 'contributer', 'ergh@dfg.dfg', 'contributer');";
  private String ADDING_ROLE_TO_CONTRIBUTER = "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
      "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:11:\"contributer\";b:1;}');";
  private String DELETE_CONTRIBUTER = "DELETE FROM wordpress.wp_users WHERE user_login = 'contributer'";
  private String DELETE_ROLE_CONTRIBUTER = "DELETE FROM wordpress.wp_usermeta WHERE user_id = (SELECT ID FROM wp_users " +
      "WHERE user_login = 'contributer')";

  /**
   * Open database CONNECTION to MySQL server,
   * get STATEMENT object to execute query,
   * execute SELECT and INSERT queries for
   * adding contributer to database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void addUser() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_USERS_TABLE);
      RESULTSET = STATEMENT.executeQuery(SELECT_USERMETA_TABLE);
      STATEMENT.executeUpdate(ADDING_CONTRIBUTER);
      STATEMENT.executeUpdate(ADDING_ROLE_TO_CONTRIBUTER);
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    } finally {
      try {
        CONNECTION.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        STATEMENT.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        RESULTSET.close();
      } catch (SQLException se) { /*can't do anything */ }
    }
  }

  /**
   * Open database CONNECTION to MySQL server,
   * get STATEMENT object to execute query,
   * execute SELECT and INSERT queries for
   * deleting contributer from database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void deleteUser() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_USERS_TABLE);
      RESULTSET = STATEMENT.executeQuery(SELECT_USERMETA_TABLE);
      STATEMENT.executeUpdate(DELETE_ROLE_CONTRIBUTER);
      STATEMENT.executeUpdate(DELETE_CONTRIBUTER);
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    } finally {
      try {
        CONNECTION.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        STATEMENT.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        RESULTSET.close();
      } catch (SQLException se) { /*can't do anything */ }
    }
  }
}
