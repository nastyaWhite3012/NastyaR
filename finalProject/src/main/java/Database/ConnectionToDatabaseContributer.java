package Database;

import java.sql.*;

/**
 * Created by HP on 18.12.2016.
 */
public class ConnectionToDatabaseContributer {
  // JDBC URL, username and password of MySQL server
  private static final String url = "jdbc:mysql://localhost:8889/wordpress";
  private static final String user = "root";
  private static final String password = "root";

  // JDBC variables for opening and managing connection
  private static Connection con;
  private static Statement stmt;
  private static ResultSet rs;

  //  Queries queries = new Queries();
  private String selectUsersTable = "select user_login from wordpress.wp_users";
  private String selectUsermetaTable = "select user_id from wordpress.wp_usermeta";
  String addingContributer = "INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
      "user_email, display_name) VALUES ('contributer', MD5('1'), 'contributer', 'ergh@dfg.dfg', 'contributer');";
  String addingRoleToContributer = "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
      "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:11:\"contributer\";b:1;}');";
  String deleteContributer = "DELETE FROM wordpress.wp_users WHERE user_login = 'contributer'";
  String deleteRoleContributer = "DELETE FROM wordpress.wp_usermeta WHERE user_id = (SELECT ID FROM wp_users WHERE " +
      "user_login = 'contributer')";

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
      stmt.executeUpdate(addingContributer);
      stmt.executeUpdate(addingRoleToContributer);
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
      stmt.executeUpdate(deleteRoleContributer);
      stmt.executeUpdate(deleteContributer);
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
