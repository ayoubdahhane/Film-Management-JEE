package com.orange.filmmanagenent.model;
import java.util.List;

public class Film {
    private int id;
    private String titre;
    private String description;
    private String genre;
    private int anneeSortie;
    private String poster;
    private Realisateur realisateur;
    private List<Acteur> acteurs; // Liste des acteurs du film

    public Film(){
    }

    public Film(int id, String titre, String description, String genre, int anneeSortie,String poster, Realisateur realisateur, List<Acteur> acteurs) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.genre = genre;
        this.anneeSortie = anneeSortie;
        this.poster=poster;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getAnneeSortie() { return anneeSortie; }
    public void setAnneeSortie(int anneeSortie) { this.anneeSortie = anneeSortie; }


    
    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }
    
    public Realisateur getRealisateur() { return realisateur; }
    public void setRealisateur(Realisateur realisateur) { this.realisateur = realisateur; }

    public List<Acteur> getActeurs() { return acteurs; }
    public void setActeurs(List<Acteur> acteurs) { this.acteurs = acteurs; }
}