package Database;

import java.sql.*;

/**
 * Connect to Wordpress's database for editor
 */
public class ConnectionToDatabaseEditor {
  private static final String URL = "jdbc:mysql://localhost:8889/wordpress";
  private static final String USER = "root";
  private static final String PASSWORD = "root";
  private static Connection CONNECTION;
  private static Statement STATEMENT;
  private static ResultSet RESULTSET;
  private String SELECT_USERS_TABLE = "SELECT user_login FROM wordpress.wp_users";
  private String SELECT_USERMETA_TABLE = "SELECT user_id FROM wordpress.wp_usermeta";
  private String SELECT_POSTS_TABLE = "SELECT post_author FROM wordpress.wp_posts";
  private String ADDING_EDITOR = "INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
      "user_email, display_name) " +
      "VALUES ('editor', MD5('1'), 'editor', 'ergh@sdf.sdf', 'editor');";
  private String ADDING_ROLE_TO_EDITOR = "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
      "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"editor\";b:1;}');";
  private String DELETE_EDITOR = "DELETE FROM wordpress.wp_users WHERE user_login = 'editor'";
  private String DELETE_ROLE_EDITOR = "DELETE FROM wordpress.wp_usermeta WHERE user_id = (SELECT ID FROM wp_users " +
      "WHERE user_login = 'editor')";
  private String DELETE_DRAFT = "DELETE FROM wordpress.wp_posts WHERE post_author = (SELECT ID FROM wp_users " +
      "WHERE user_login = 'editor')";
  private String DELETE_AUTODRAFT = "DELETE FROM wordpress.wp_posts WHERE post_author = (SELECT ID FROM wp_users " +
      "WHERE user_login = 'editor') AND post_title = 'Auto Draft'";

  /**
   * Open database CONNECTION to MySQL server,
   * get STATEMENT object to execute query,
   * execute SELECT and INSERT queries for
   * adding editor to database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void addUser() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_USERS_TABLE);
      RESULTSET = STATEMENT.executeQuery(SELECT_USERMETA_TABLE);
      STATEMENT.executeUpdate(ADDING_EDITOR);
      STATEMENT.executeUpdate(ADDING_ROLE_TO_EDITOR);
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
   * deleting editor from database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void deleteUser() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_USERS_TABLE);
      RESULTSET = STATEMENT.executeQuery(SELECT_USERMETA_TABLE);
      STATEMENT.executeUpdate(DELETE_ROLE_EDITOR);
      STATEMENT.executeUpdate(DELETE_EDITOR);
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
   * deleting draft from database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void deleteDraft() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_POSTS_TABLE);
      STATEMENT.executeUpdate(DELETE_DRAFT);
      STATEMENT.executeUpdate(DELETE_AUTODRAFT);
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
