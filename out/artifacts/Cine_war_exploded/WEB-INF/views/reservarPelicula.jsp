<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 27-06-16
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reservar</title>
</head>
<body>
<h1>Reservar</h1>
<form action="/reserva/reserva" method="post" name="formulario">

    <input type="hidden" name="idpelicula" value="${peli.id}"/>

    <p>Nombre Comprador<input type="text" name="nombreComprador" id="nombreComprador" required/></p>

    <p>Tipo Pago
        <select name="idPago">

            <c:forEach var="pag" items="${pago}">
                <option value="${pag.id}">${pag.tipoPago}</option>
            </c:forEach>
        </select>
    </p>
    <p>Asientos a Reservar<input type="text" name="asientosReservados" id="asientoReservado" required/></p>

    <p><input type="submit" id="Adicionar" value="Adicionar"/></p>
</form>
</body>
</html>
