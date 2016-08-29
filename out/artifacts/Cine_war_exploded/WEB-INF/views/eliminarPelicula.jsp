<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 28-06-16
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Eliminar Pelicula</title>
</head>
<body>
<h1>Eliminar Pelicula</h1>
<form action="/pelicula/deletePelicula" method="post" name="formulario">

    <p>Id
        <select name="id">
            <c:forEach var="p" items="${peliculas}">
                <option value="${p.id}">${p.nombre}</option>
            </c:forEach>
        </select>
    </p>

    <p><input type="submit" id="Eliminar" value="Eliminar"/></p>
</form>

</body>
</html>
