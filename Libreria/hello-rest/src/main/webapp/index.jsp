<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
    <title>Benvenuto</title>
</head>
<body>
    <h1>Benvenuto Utente Curioso, questa è la mia prima JSP.</h1>
    <p>Oggi è il giorno <%= LocalDate.now() %></p>
    <p>Autore: <a href="author.jsp">Clicca qui</a></p>
</body>
</html>
