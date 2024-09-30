/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.service;

import beans.Developpeur;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import projet.dao.IDao;

/**
 *
 * @author Youness
 */

public class DevService implements IDao<Developpeur> {

    public DevService() {
    }
    

    @Override
    public boolean create(Developpeur dev) {
        
        boolean bool = false;
        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "insert into devdata values('" + dev.getNomDeveloppeur()
                    + "','" + dev.getJour() + "'," + dev.getNbrSript() + ")";
            //Etape 4 : Exécution de la requête
            int n = st.executeUpdate(req);
            if(n==1){
                bool = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
        return bool;
    }

    @Override
    public boolean update(Developpeur dev) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Developpeur dev) {
        
        boolean bool = false;
        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "DELETE * FROM `devdata` values('" + dev.getNomDeveloppeur()
                    + "','" + dev.getJour() + "'," + dev.getNbrSript() + ")";
            //Etape 4 : Exécution de la requête
            int n = st.executeUpdate(req);
            if(n==1){
                bool = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
        return bool;
        
    }

    @Override
    public boolean startDB() {
        
        boolean bool = false;
        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = " CREATE TABLE DevData ("
                    + " Developpeurs VARCHAR (32),"
                    + " Jour CHAR (11),"
                    + " NbScripts INTEGER)";
            //Etape 4 : Exécution de la requête
            int n = st.executeUpdate(req);
            if(n == 1){
                bool = true;
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
        return bool;
    }

    @Override
    public List<Developpeur> findbyname(String s) {
        
        List<Developpeur> devs = null;
        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "SELECT from devdata"
                    + " WHERE Developpeurs = '"+s+"';";
            //Etape 4 : Exécution de la requête
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                devs.add(new Developpeur(rs.getString("Developpeurs"), rs.getString("Jour"), rs.getInt("NbScripts"))); 
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
        return devs;
    }

    @Override
    public List<Developpeur> findAll() {
        
        List<Developpeur> devs = null;
        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "SELECT * from devdata";
            //Etape 4 : Exécution de la requête
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                devs.add(new Developpeur(rs.getString("Developpeurs"), rs.getString("Jour"), rs.getInt("NbScripts")));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
        return devs;
    }
    
}
