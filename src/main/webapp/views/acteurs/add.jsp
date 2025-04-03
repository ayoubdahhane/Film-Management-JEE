<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Acteur</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-10">
    <div class="max-w-md mx-auto bg-white p-6 rounded-lg shadow-md">
    <c:if test="${not empty erreur}">
    <div class="bg-red-500 text-white p-2 rounded-md mb-4">
        ${erreur}
    </div>
</c:if>
    
        <h2 class="text-2xl font-bold mb-4">Ajouter un Acteur</h2>

        <form action="<c:url value='/ActeurAddServlet'/>" method="post">
            <div class="mb-4">
                <label class="block text-gray-700">Nom :</label>
                <input type="text" name="nom" class="w-full px-3 py-2 border rounded-md" required>
            </div>
            <div class="mb-4">
                <label class="block text-gray-700">Prénom :</label>
                <input type="text" name="prenom" class="w-full px-3 py-2 border rounded-md" required>
            </div>
            <div class="mb-4">
                <label class="block text-gray-700">Nationalité :</label>
                <input type="text" name="nationalite" class="w-full px-3 py-2 border rounded-md" required>
            </div>
            <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded-md">Ajouter</button>
        </form>

        <a href="<c:url value='/acteurs'/>" class="block text-blue-500 mt-4">Voir la liste des acteurs</a>
    </div>
</body>
</html>
