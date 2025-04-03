package com.orange.filmmanagenent.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import  com.orange.filmmanagenent.config.DatabaseConnection;
import  com.orange.filmmanagenent.dao.RealisateurDAO;
import  com.orange.filmmanagenent.model.Realisateur;


@WebServlet("/realisateurs")
public class RealisateurListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseConnection.getConnection()) { // Connexion temporaire
            RealisateurDAO realisateurDAO = new RealisateurDAO(connection);
            List<Realisateur> realisateurs = realisateurDAO.getTousLesRealisateurs();
            request.setAttribute("realisateurs", realisateurs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("views/realisateurs/list.jsp").forward(request, response);
    }
}