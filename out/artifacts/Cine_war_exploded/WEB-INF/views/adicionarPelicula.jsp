<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 28-06-16
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Adicionar Pelicula</h1>
<form action="/pelicula/adicionarpelicula" method="post" name="formulario">

    <p>Nombre Pelicula<input type="text" name="nombre" id="nombre" required/></p>
    <p>Fecha<input type="datetime" name="fecha" id="fecha" required/></p>
    <p>Precio Pelicula<input type="text" name="precio" id="precio" required/></p>
    <p>Asientos<input type="text" name="asientosLibres" id="asientosLibres" required/></p>
    <p>Descripcion<input type="text" name="descripcion" id="descripcion" required/></p>

    <p><input type="submit" id="Adicionar" value="Adicionar"/></p>
</form>

</body>
</html>
