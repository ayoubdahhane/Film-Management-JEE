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
import com.orange.filmmanagenent.dao.FilmDAO;
import com.orange.filmmanagenent.model.Film;




@WebServlet("/films")
public class FilmListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            FilmDAO filmDAO = new FilmDAO(connection);
            List<Film> films = filmDAO.getTousLesFilms();
            request.setAttribute("films", films);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/films/list.jsp").forward(request, response);
    }
}