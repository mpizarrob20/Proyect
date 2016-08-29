<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 27-06-16
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalle Pelicula</title>
</head>
<body>

<h1>Detalle Pelicula</h1>

    <form action="/reserva/viewReservarPelicula" method="post">
        <input type="hidden" name="idPelicula" value="${pelicula.id}"/>

        <p>${pelicula.nombre}</p>
        <p>${pelicula.descripcion}</p>
        <p>${pelicula.fecha}</p>
        <p>${pelicula.precio}</p>

        <p><input type="submit" value="Reservar"/></p>
    </form>


</body>
</html>
