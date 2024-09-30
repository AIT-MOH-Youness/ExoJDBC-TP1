/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Youness
 */
public class Connexion {
    
    private static String login ="root";
    private static String password = "";
    private static String url="jdbc:mysql://localhost/scriptDev";
    private static Connection connexion = null;
    
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introvable");
        } catch (SQLException ex) {
            System.out.println("Impossible de se connecter");
        }
    }

    public static Connection getConnexion() {
        return connexion;
    }
    
}
