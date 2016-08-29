<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 28-06-16
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Pago</title>
</head>
<body>
<h1>Adicionar Pago</h1>
<form action="/pago/addPago" method="post" name="formulario">

    <p>Tipo Pago<input type="text" name="tipoPago" id="tipoPago" required/></p>

    <p><input type="submit" id="Adicionar" value="Adicionar"/></p>
</form>
</body>
</html>
