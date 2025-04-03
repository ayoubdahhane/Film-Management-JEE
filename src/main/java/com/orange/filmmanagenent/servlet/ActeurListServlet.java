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

import com.orange.filmmanagenent.config.DatabaseConnection;
import com.orange.filmmanagenent.dao.ActeurDAO;
import com.orange.filmmanagenent.model.Acteur;

 @WebServlet("/acteurs")
 public class ActeurListServlet extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         try (Connection connection = DatabaseConnection.getConnection()) {
             ActeurDAO acteurDAO = new ActeurDAO(connection);
             List<Acteur> acteurs = acteurDAO.getTousLesActeurs();
             request.setAttribute("acteurs", acteurs);
         } catch (SQLException e) {
             e.printStackTrace();
         }
         request.getRequestDispatcher("views/acteurs/list.jsp").forward(request, response);
     }
 }
