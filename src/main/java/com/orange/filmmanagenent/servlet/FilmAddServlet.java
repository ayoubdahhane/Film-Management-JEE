package com.orange.filmmanagenent.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.orange.filmmanagenent.config.DatabaseConnection;
import com.orange.filmmanagenent.dao.ActeurDAO;
import com.orange.filmmanagenent.dao.FilmDAO;
import com.orange.filmmanagenent.dao.RealisateurDAO;
import com.orange.filmmanagenent.model.Acteur;
import com.orange.filmmanagenent.model.Realisateur;



@WebServlet("/FilmAddServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
                 maxFileSize = 10 * 1024 * 1024, 
                 maxRequestSize = 20 * 1024 * 1024)
public class FilmAddServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String genre = request.getParameter("genre");
        String description = request.getParameter("description");
        int anneeSortie = Integer.parseInt(request.getParameter("annee_sortie"));
        int idRealisateur = Integer.parseInt(request.getParameter("id_realisateur"));
        String[] idActeursStr = request.getParameterValues("id_acteurs");
        
        List<Integer> idActeurs = new ArrayList<>();
        if (idActeursStr != null) {
            for (String idStr : idActeursStr) {
                idActeurs.add(Integer.parseInt(idStr));
            }
        }

        Part filePart = request.getPart("poster");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Sauvegarde du fichier
        String uploadPath = getServletContext().getRealPath("/uploads"); 
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);
        System.out.print("location :" +uploadPath + File.separator + fileName);
        try (Connection connection = DatabaseConnection.getConnection()) {
            RealisateurDAO realisateurDAO = new RealisateurDAO(connection);
            Realisateur realisateur = realisateurDAO.getRealisateurById(idRealisateur);
            FilmDAO filmDAO = new FilmDAO(connection);
            
            filmDAO.ajouterFilm(0, titre, description,genre, anneeSortie, fileName, realisateur, idActeurs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("films");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            RealisateurDAO realisateurDAO = new RealisateurDAO(connection);
            ActeurDAO acteurDAO = new ActeurDAO(connection);

            List<Realisateur> realisateurs = realisateurDAO.getTousLesRealisateurs();
            List<Acteur> acteurs = acteurDAO.getTousLesActeurs();

            request.setAttribute("realisateurs", realisateurs);
            request.setAttribute("acteurs", acteurs);
            request.getRequestDispatcher("views/films/add.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
