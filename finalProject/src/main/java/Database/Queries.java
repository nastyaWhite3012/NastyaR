package Database;

import java.util.ArrayList;

/**
 * Created by HP on 16.12.2016.
 */
public class Queries {
  public ArrayList<String> isQuery() {
    ArrayList<String> query = new ArrayList<String>();
    query.add("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
        "user_email, display_name) VALUES ('subscriber', MD5('1'), 'subscriber', 'dfg@sdf.f', 'subscriber');");
    query.add("INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
        "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:10:\"subscriber\";b:1;}');");
    query.add("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
        "user_email, display_name) VALUES ('contributer', MD5('1'), 'contributer', 'sdfg@sdf.werf', 'contributer');");
    query.add("INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
        "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:11:\"contributer\";b:1;}');");
    query.add("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
        "user_email, display_name) VALUES ('author', MD5('1'), 'author', 'sdfgh@sdfg.sdf', 'author');");
    query.add("INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
        "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"author\";b:1;}');");
    query.add("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
        "user_email, display_name) VALUES ('editor', MD5('1'), 'editor', 'sdfgh@sdf.erfg', 'editor');");
    query.add("INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value) " +
        "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"editor\";b:1;}');");
    return query;
  }
}
