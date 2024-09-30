/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Developpeur;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Youness
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void créerTableDevData() {

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
            st.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void ajouterDeveloppeur(Developpeur dev) {

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
            st.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void maxScriptParJournée() {

        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "SELECT Developpeurs, Jour, max(NbScripts)"
                    + " from devdata"
                    + " group by Jour";
            //Etape 4 : Exécution de la requête
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.println("Il Y'a : " + new Developpeur(rs.getString("Developpeurs"), rs.getString("Jour"), rs.getInt("max(NbScripts)")));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void DevScriptDecroissant() {

        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "SELECT Developpeurs, sum(NbScripts) as c"
                    + " from devdata"
                    + " Group by Developpeurs"
                    + " order by c desc";
            //Etape 4 : Exécution de la requête
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.println("Il Y'a Le développeur : " + rs.getString("Developpeurs") + " avec un nombre de script égal a : " + rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void scriptsTotalParSemaine() {

        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "SELECT SUM(NbScripts) FROM `devdata`";
            //Etape 4 : Exécution de la requête
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.println("Le nombre des scripts réalisés pandant la semaine est " + rs.getInt("SUM(NbScripts)") + " scripts");
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void scriptsDansUneSemaine(String nomDev) {

        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            String req = "SELECT SUM(NbScripts) FROM `devdata` WHERE Developpeurs='" + nomDev + "'";
            //Etape 4 : Exécution de la requête
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.println("Le nombre des scripts réalisés pandant la semaine par " + nomDev + " est " + rs.getInt("SUM(NbScripts)") + " scripts");
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void LancerRequete() {

        Statement st = null;
        Connection cn = null;

        try {
            //Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
            //Etape 2 : Récupération de la connexion
            cn = Connexion.getConnexion();
            //Etape 3 : Création d'un statement
            st = cn.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez votre requête SQL :");
            String req = scanner.nextLine();
            scanner.close();
            //Etape 4 : Exécution de la requête
            boolean bool = st.execute(req);
            if (bool) {
                ResultSet rs = st.executeQuery(req);
                ResultSetMetaData metaData = rs.getMetaData();
                System.out.println("\n---------------------\nLe nombre de colonnes est : " + metaData.getColumnCount());
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.println("Colonne " + i + ": " + metaData.getColumnName(i) + " (Type: "
                            + metaData.getColumnTypeName(i) + ")");
                }
                System.out.println("\nContenu du résultat :");
                while (rs.next()) {
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.print("\n");
                }
            }else{
                // Si la requête modifie des lignes, afficher le nombre de lignes modifiées
                int rowsAffected = st.getUpdateCount();
                System.out.println("Nombre de lignes modifiées : " + rowsAffected);
            }

        } catch (SQLException e) {
            System.out.println("Erreur SQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        }
    }

    public static void main(String[] args) {

        
        //Test.LancerRequete();
        //Test.créerTableDevData();
        //Test.maxScriptParJournée();
        //Test.scriptsTotalParSemaine();
        //Test.DevScriptDecroissant();
        //Test.scriptsDansUneSemaine("ALAMI");
        
        
//                Test.ajouterDeveloppeur(new Developpeur("ALAMI","Lundi",1));
//                Test.ajouterDeveloppeur(new Developpeur("WAFI","Lundi",2));
//                Test.ajouterDeveloppeur(new Developpeur("SALAMI","Mardi",9));
//                Test.ajouterDeveloppeur(new Developpeur("SAFI","Mardi",2));
//                Test.ajouterDeveloppeur(new Developpeur("ALAMI","Mardi",2));
//                Test.ajouterDeveloppeur(new Developpeur("SEBIHI","Mercredi",2));
//                Test.ajouterDeveloppeur(new Developpeur("WAFI","Jeudi",3));
//                Test.ajouterDeveloppeur(new Developpeur("ALAOUI","Vendredi",9));
//                Test.ajouterDeveloppeur(new Developpeur("WAFI","Vendredi",3));
//                Test.ajouterDeveloppeur(new Developpeur("SEBIHI","Vendredi",4));
    }

}
