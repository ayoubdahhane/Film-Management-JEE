<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8">
    <title>Films Disponibles</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />

    <style>
      .glow {
        font-size: 50px;
        color: #fff;
        text-align: center;
        margin: 50px 0px 100px 0;
        animation: glow 1s ease-in-out infinite alternate;
      }

      @-webkit-keyframes glow {
        from {
          text-shadow: 0 0 10px #fff, 
                       0 0 20px #fff, 
                       0 0 30px #e600de, 
                       0 0 40px #e600de, 
                       0 0 50px #e600de, 
                       0 0 60px #e600de, 
                       0 0 70px #e600de;
        }
        to {
          text-shadow: 0 0 20px #fff, 
                       0 0 30px #ff4dff, 
                       0 0 40px #ff4dff, 
                       0 0 50px #ff4dff, 
                       0 0 60px #ff4dff, 
                       0 0 70px #ff4dff, 
                       0 0 80px #ff4dff;
        }
      }
    </style>
  </head>
  <body class="bg-gray-900">
    <div class="container mx-auto p-3 ">
<p class="glow mb-4 text-purple-500 text-xs">
  <i class="fas fa-clapperboard"></i>
  Films Disponibles
</p>

      <section class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
        <c:forEach var="film" items="${films}">
          <div class="bg-gray-800 rounded-lg shadow-lg overflow-hidden transform hover:scale-105 duration-300">
            <img 
              src="${pageContext.request.contextPath}/uploads/${film.poster}" 
              alt="${film.titre}" 
              class="h-64 w-full object-cover"
            />
            <div class="p-4">
              <h3 class="text-xl text-white font-bold mb-1">
                ${film.titre}
              </h3>
              <p class="text-gray-400 text-sm mb-2">
                Année : ${film.anneeSortie}
              </p>
              <p class="text-gray-300 text-sm mb-4">
                ${film.description}
              </p>
              <a 
                href="filmDetail.jsp?id=${film.id}" 
                class="text-purple-400 hover:text-purple-300 font-semibold"
              >
                Voir détails
              </a>
            </div>
          </div>
        </c:forEach>
      </section>
    </div>
  </body>
</html>
