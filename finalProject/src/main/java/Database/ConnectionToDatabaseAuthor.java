package Database;

import java.sql.*;

/**
 * Connect to Wordpress's database for author
 */
public class ConnectionToDatabaseAuthor {
  private static final String URL = "jdbc:mysql://localhost:8889/wordpress";
  private static final String USER = "root";
  private static final String PASSWORD = "root";
  private static Connection CONNECTION;
  private static Statement STATEMENT;
  private static ResultSet RESULTSET;
  private String SELECT_USERS_TABLE = "SELECT user_login FROM wordpress.wp_users";
  private String SELECT_USERMETA_TABLE = "SELECT user_id FROM wordpress.wp_usermeta";
  private String SELECT_POSTS_TABLE = "SELECT post_author FROM wordpress.wp_posts";
  private String ADDING_AUTHOR = "INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
      "user_email, display_name) " +
      "VALUES ('author', MD5('1'), 'author', 'sdfgh@sdfg.sdf', 'author');";
  private String ADDING_ROLE_AUTHOR = "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
      "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"author\";b:1;}');";
  private String DELETE_ROLE_AUTHOR = "DELETE FROM wordpress.wp_usermeta " +
      "WHERE user_id = (SELECT ID FROM wp_users WHERE user_login = 'author')";
  private String DELETE_AUTHOR = "DELETE FROM wordpress.wp_users " +
      "WHERE user_login = 'author'";
  private String DELETE_DRAFT = "DELETE FROM wordpress.wp_posts WHERE post_author = (SELECT ID FROM wp_users " +
      "WHERE user_login = 'author')";
  private String DELETE_AUTODRAFT = "DELETE FROM wordpress.wp_posts WHERE post_author = (SELECT ID FROM wp_users " +
      "WHERE user_login = 'author') AND post_title = 'Auto Draft'";

  /**
   * Open database CONNECTION to MySQL server,
   * get STATEMENT object to execute query,
   * execute SELECT and INSERT queries for
   * adding author to database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void addUser() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_USERS_TABLE);
      RESULTSET = STATEMENT.executeQuery(SELECT_USERMETA_TABLE);
      STATEMENT.executeUpdate(ADDING_AUTHOR);
      STATEMENT.executeUpdate(ADDING_ROLE_AUTHOR);
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    } finally {
      //close connection ,stmt and resultset here
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
   * deleting author from database,
   * close CONNECTION, STATEMENT and RESULTSET
   */
  public void deleteUser() {
    try {
      CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
      STATEMENT = CONNECTION.createStatement();
      RESULTSET = STATEMENT.executeQuery(SELECT_USERS_TABLE);
      RESULTSET = STATEMENT.executeQuery(SELECT_USERMETA_TABLE);
      STATEMENT.executeUpdate(DELETE_ROLE_AUTHOR);
      STATEMENT.executeUpdate(DELETE_AUTHOR);
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
