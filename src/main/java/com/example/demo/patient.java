package com.example.demo;

import java.util.Objects;

public class patient {
    private int numeroSecu;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String sexe;
    private String adresse;

    public patient(int numeroSecu, String nom, String prenom, String dateNaissance, String sexe, String adresse) {
        // TODO Auto-generated constructor stub
        this.numeroSecu = numeroSecu;
        this.nom=nom;
        this.prenom=prenom;
        this.dateNaissance = dateNaissance;
        this.adresse=adresse;
        this.sexe=sexe;

    }
    public int getNumeroSecu() {
        // TODO Auto-generated method stub
        return numeroSecu;
    }
    public void setNumeroSecu(int numeroSecu) {
        this.numeroSecu = numeroSecu;
    }
    public String getNom() {
        return nom;
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof patient patient)) return false;
        return Objects.equals(getNumeroSecu(), patient.getNumeroSecu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroSecu());
    }

    @Override
    public String toString() {
        return "patient{" +
                "numeroSecu=" + numeroSecu +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", sexe='" + sexe + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}

