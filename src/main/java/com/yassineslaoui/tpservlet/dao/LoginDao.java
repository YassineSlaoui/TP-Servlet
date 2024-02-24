package com.yassineslaoui.tpservlet.dao;

import java.sql.*;

/**
 * Login Data Access Object Class, helps us access data from databases for our objects.
 */
public class LoginDao {

    /**
    * The LoginDao class provides us with this static validate method.
    * We can use this method to check whether a username/password combination exists in out database.
    *
    * @param name The username to check
    * @param pass The password to check with the username
    *
    * @return Whether the combination exists in the database or not
    */
    public static boolean validate(String name, String pass) {
        boolean status = false;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");

            PreparedStatement ps = con.prepareStatement("select * from userreg where name=? and pass=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();


        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
