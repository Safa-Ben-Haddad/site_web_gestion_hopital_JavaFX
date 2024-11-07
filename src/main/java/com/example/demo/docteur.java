package com.example.demo;

import java.util.Objects;

public class docteur {
    private int id;
    private String nom;

    private String prenom;
    private String spécialité;
    private String numTele;
    private String email;

    private boolean StatutDispo;

    public docteur(int id, String nom, String prenom, String spécialité, String numTele, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.spécialité = spécialité;
        this.numTele = numTele;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getSpécialité() {
        return spécialité;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpécialité(String spécialité) {
        this.spécialité = spécialité;
    }

    public String getNumTele() {
        return numTele;
    }

    public void setNumTele(String numTele) {
        this.numTele = numTele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatutDispo() {
        return StatutDispo;
    }

    public void setStatutDispo(boolean statutDispo) {
        StatutDispo = statutDispo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof docteur docteur)) return false;
        return getId() == docteur.getId();
    }
    public void changerEtat() {
        if (this.StatutDispo==true)
            StatutDispo=false;
        else
            StatutDispo=true;}

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "docteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", spécialité='" + spécialité + '\'' +
                '}';
    }

}
