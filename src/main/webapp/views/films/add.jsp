<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Ajouter un Film</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  </head>
  <body class="bg-gray-100">
    <div class="max-w-2xl mx-auto p-6">
      <h2 class="text-3xl font-bold mb-6 text-center">Ajouter un Film</h2>
      <form action="${pageContext.request.contextPath}/FilmAddServlet" method="post" enctype="multipart/form-data" class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
        
        <div class="mb-4">
          <label for="titre" class="block text-gray-700 text-sm font-bold mb-2">Titre :</label>
          <input type="text" name="titre" id="titre" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"/>
        </div>
        
        <div class="mb-4">
          <label for="description" class="block text-gray-700 text-sm font-bold mb-2">Description :</label>
          <textarea name="description" id="description" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"></textarea>
        </div>
        
        <div class="mb-4">
          <label for="genre" class="block text-gray-700 text-sm font-bold mb-2">Genre :</label>
          <input type="text" name="genre" id="genre" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"/>
        </div>
        
        <div class="mb-4">
          <label for="annee_sortie" class="block text-gray-700 text-sm font-bold mb-2">Année de sortie :</label>
          <input type="number" name="annee_sortie" id="annee_sortie" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"/>
        </div>
        
        <div class="mb-4">
          <label for="poster" class="block text-gray-700 text-sm font-bold mb-2">Poster :</label>
          <input type="file" name="poster" id="poster" required class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 focus:outline-none"/>
        </div>
        
        <div class="mb-4">
          <label for="id_realisateur" class="block text-gray-700 text-sm font-bold mb-2">Réalisateur :</label>
          <select name="id_realisateur" id="id_realisateur" required class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
            <c:forEach var="realisateur" items="${realisateurs}">
              <option value="${realisateur.id}">${realisateur.nom} ${realisateur.prenom}</option>
            </c:forEach>
          </select>
        </div>
        
        <div class="mb-4">
          <span class="block text-gray-700 text-sm font-bold mb-2">Acteurs :</span>
          <c:forEach var="acteur" items="${acteurs}">
            <div class="flex items-center mb-2">
              <input type="checkbox" name="id_acteurs" value="${acteur.id}" class="mr-2"/>
              <label class="text-gray-700">${acteur.nom} ${acteur.prenom}</label>
            </div>
          </c:forEach>
        </div>
        
        <div class="flex items-center justify-between">
          <input type="submit" value="Ajouter Film" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"/>
        </div>
      </form>
    </div>
  </body>
</html>
