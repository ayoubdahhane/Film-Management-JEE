package com.orange.filmmanagenent.dao;

import com.orange.filmmanagenent.model.Film;
import com.orange.filmmanagenent.model.Acteur;
import com.orange.filmmanagenent.model.Realisateur;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private Connection connection;

    public FilmDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterFilm(int id,String titre,String description,String genre,int anneeSortie,String fileName, Realisateur realisateur, List<Integer> idActeurs) throws SQLException {
        String sql = "INSERT INTO film (titre, description, genre, annee_sortie, poster, realisateur_id) VALUES ("+titre+", ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, titre);
        stmt.setString(2, description);
        stmt.setString(3, genre);
        stmt.setInt(4, anneeSortie);
        stmt.setString(5, fileName);
        stmt.setInt(6, realisateur.getId());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idFilm = rs.getInt(1);
            for (int idActeur : idActeurs) {
                String sqlActeur = "INSERT INTO film_acteur (film_id, acteur_id) VALUES (?, ?)";
                PreparedStatement stmtActeur = connection.prepareStatement(sqlActeur);
                stmtActeur.setInt(1, idFilm);
                stmtActeur.setInt(2, idActeur);
                stmtActeur.executeUpdate();
            }
        }
    }

    private void ajouterActeursAuFilm(int filmId, List<Acteur> acteurs) throws SQLException {
        if (acteurs == null || acteurs.isEmpty()) return;

        String sql = "INSERT INTO film_acteur (film_id, acteur_id) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        for (Acteur acteur : acteurs) {
            stmt.setInt(1, filmId);
            stmt.setInt(2, acteur.getId());
            stmt.executeUpdate();
        }
    }

    public List<Film> getTousLesFilms() throws SQLException {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT f.id, f.titre, f.description, f.poster, f.genre, f.annee_sortie, r.id as realisateur_id, r.nom, r.prenom, r.nationalite " +
                     "FROM film f JOIN realisateur r ON f.realisateur_id = r.id";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Realisateur realisateur = new Realisateur(
                rs.getInt("realisateur_id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("nationalite")
            );

            int filmId = rs.getInt("id");
            List<Acteur> acteurs = getActeursParFilm(filmId);

            Film film = new Film(
                filmId,
                rs.getString("titre"),
                rs.getString("description"),
                rs.getString("genre"),
                rs.getInt("annee_sortie"),
                rs.getString("poster"),
                realisateur,
                acteurs
            );
            films.add(film);
        }
        return films;
    }

    private List<Acteur> getActeursParFilm(int filmId) throws SQLException {
        List<Acteur> acteurs = new ArrayList<>();
        String sql = "SELECT a.id, a.nom, a.prenom, a.nationalite " +
                     "FROM acteur a JOIN film_acteur fa ON a.id = fa.acteur_id " +
                     "WHERE fa.film_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, filmId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Acteur acteur = new Acteur(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("nationalite")
            );
            acteurs.add(acteur);
            System.out.print(acteur.getNom()+"+=");

        }
        return acteurs;
    }
}