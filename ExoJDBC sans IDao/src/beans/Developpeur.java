/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Youness
 */
public class Developpeur {
    
    private String nomDeveloppeur;
    private String jour;
    private int nbrSript;

    public Developpeur() {
    }

    
    public Developpeur(String nomDeveloppeur, String jour, int nbrSript) {
        this.nomDeveloppeur = nomDeveloppeur;
        this.jour = jour;
        this.nbrSript = nbrSript;
    }

    public String getNomDeveloppeur() {
        return nomDeveloppeur;
    }

    public String getJour() {
        return jour;
    }

    public int getNbrSript() {
        return nbrSript;
    }

    public void setNomDeveloppeur(String nomDeveloppeur) {
        this.nomDeveloppeur = nomDeveloppeur;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setNbrSript(int nbrSript) {
        this.nbrSript = nbrSript;
    }

    
    @Override
    public String toString() {
        return " Le Developpeur : " + nomDeveloppeur + ", son jour est :" 
                + jour + ", le nombre des Sripts réalisés a ce jour est : " + nbrSript;
    }
    
    
    
}
