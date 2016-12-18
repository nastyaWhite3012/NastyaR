package Database;

import java.sql.*;

/**
 * Created by HP on 18.12.2016.
 */
public class ConnectionToDatabaseAuthor {
  // JDBC URL, username and password of MySQL server
  private static final String url = "jdbc:mysql://localhost:8889/wordpress";
  private static final String user = "root";
  private static final String password = "root";

  // JDBC variables for opening and managing connection
  private static Connection con;
  private static Statement stmt;
  private static ResultSet rs;

  private String selectUsersTable = "select user_login from wordpress.wp_users";
  private String selectUsermetaTable = "select user_id from wordpress.wp_usermeta";
  String addingAuthor = "INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
      "user_email, display_name) VALUES ('author', MD5('1'), 'author', 'sdfgh@sdfg.sdf', 'author');";
  String addingRoleToAuthor = "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
      "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"author\";b:1;}');";
  String deleteRoleAuthor = "DELETE FROM wordpress.wp_usermeta WHERE user_id = (SELECT ID FROM wp_users WHERE " +
      "user_login = 'author')";
  String deleteAuthor = "DELETE FROM wordpress.wp_users WHERE user_login = 'author'";

  String addingAuthor2 = "INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
      "user_email, display_name) VALUES ('author', MD5('1'), 'author2', 'sdfgh@sdfg.sdf', 'author2');";
  String deleteRoleAuthor2 = "DELETE FROM wordpress.wp_usermeta WHERE user_id = (SELECT ID FROM wp_users WHERE " +
      "user_login = 'author2')";
  String deleteAuthor2 = "DELETE FROM wordpress.wp_users WHERE user_login = 'author'";

  public void addUser() {
    try {
      // opening database connection to MySQL server
      con = DriverManager.getConnection(url, user, password);
      // getting Statement object to execute query
      stmt = con.createStatement();
      // executing SELECT query
      rs = stmt.executeQuery(selectUsersTable);
      rs = stmt.executeQuery(selectUsermetaTable);
      // executing SELECT query
      stmt.executeUpdate(addingAuthor);
      stmt.executeUpdate(addingRoleToAuthor);
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    } finally {
      //close connection ,stmt and resultset here
      try {
        con.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        stmt.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        rs.close();
      } catch (SQLException se) { /*can't do anything */ }
    }
  }

  public void deleteUser() {
    try {
      // opening database connection to MySQL server
      con = DriverManager.getConnection(url, user, password);
      // getting Statement object to execute query
      stmt = con.createStatement();
      // executing SELECT query
      rs = stmt.executeQuery(selectUsersTable);
      rs = stmt.executeQuery(selectUsermetaTable);
      // executing SELECT query
      stmt.executeUpdate(deleteRoleAuthor);
      stmt.executeUpdate(deleteAuthor);
    } catch (SQLException sqlEx) {
      sqlEx.printStackTrace();
    } finally {
      //close connection ,stmt and resultset here
      try {
        con.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        stmt.close();
      } catch (SQLException se) { /*can't do anything */ }
      try {
        rs.close();
      } catch (SQLException se) { /*can't do anything */ }
    }
  }
}
