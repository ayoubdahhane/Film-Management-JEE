
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Réalisateur</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-10">
<div class="max-w-lg mx-auto mt-10 p-6 bg-white shadow-lg rounded-lg">
    <h2 class="text-2xl font-bold mb-4 text-gray-800 text-center">Modifier un Réalisateur</h2>
    <form action="${pageContext.request.contextPath}/ActeurEditServlet" method="post" class="space-y-4">
        <input type="hidden" name="id" value="${acteur.id}">

        <div>
            <label class="block text-gray-700 font-semibold">Nom:</label>
            <input type="text" name="nom" value="${acteur.nom}" required
                   class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
        </div>

        <div>
            <label class="block text-gray-700 font-semibold">Prénom:</label>
            <input type="text" name="prenom" value="${acteur.prenom}" required
                   class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
        </div>

        <div>
            <label class="block text-gray-700 font-semibold">Nationalité:</label>
            <input type="text" name="nationalite" value="${acteur.nationalite}" required
                   class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
        </div>

        <div class="flex justify-between mt-4">
            <a href="${pageContext.request.contextPath}/acteurs"
               class="px-4 py-2 bg-gray-500 text-white rounded-lg shadow hover:bg-gray-600">Annuler</a>
            
            <button type="submit"
                    class="px-6 py-2 bg-blue-600 text-white rounded-lg shadow hover:bg-blue-700">
                Modifier
            </button>
        </div>
    </form>
</div>

</body>
</html>