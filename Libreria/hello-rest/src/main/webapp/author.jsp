<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
    <title>Autore</title>
</head>
<body>
    <h1>Informazioni sull'autore</h1>
    <p>Nome: Leonardo</p>
    <p>Cognome: Lapolla</p>
    <p>Classe: 5BI</p>
	<p><%= LocalDate.now() %></p>
    <a href="index.jsp">Torna alla Home</a>
</body>
</html>
