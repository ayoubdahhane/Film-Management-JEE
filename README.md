# Film Management System (JEE)

## 📌 Overview
This is a full-stack film management web application built using **Java EE (JEE)**. It allows users to manage films, directors, and actors by adding, updating, and deleting records. The project follows a **RESTful architecture** and utilizes **JSF for the frontend**.

## 🚀 Features
- ✅ Manage Films: Add, update, and delete films.
- ✅ Manage Directors: Add, update, and delete directors ("réalisateurs").
- ✅ Manage Actors: Add, update, and delete actors ("acteurs").
- ✅ REST API with **JAX-RS** endpoints.
- ✅ Data persistence using **JPA with MySQL**.
- ✅ JSF-based UI for easy interaction.
- ✅ Uses **Enterprise Java Beans (EJB)** for business logic.

## 🛠️ Technologies Used
- **Backend:** Java EE (JEE), Servlets, JSP
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Server:** Apache Tomcat

## 📂 Project Structure
- Film-Management-JEE/
- ├── src/
- │ ├── main/
- │ │ ├── java/
- │ │ │ ├── com/filmflow/entities/ # JPA entities
- │ │ │ ├── com/filmflow/ejb/ # Enterprise Java Beans
- │ │ │ ├── com/filmflow/rest/ # REST endpoints
- │ │ │ └── com/filmflow/utils/ # Utility classes
- │ │ ├── resources/
- │ │ │ └── META-INF/persistence.xml # JPA configuration
- │ │ └── webapp/
- │ │ ├── resources/ # CSS, JS, images
- │ │ ├── WEB-INF/
- │ │ │ ├── faces-config.xml # JSF configuration
- │ │ │ └── web.xml # Deplo
- │ │ └── *.xhtml # JSF viewsyment descriptor
- │ └── test/ # Test classes
- ├── pom.xml # Maven configuration
- └── README.md

## ⚡ Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/FilmFlowManager.git
