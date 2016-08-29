<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 22-07-16
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Subir archivo</title>

</head>
<body>
<div>
    <form method="post" action="/archivo/guardarArchivo" enctype="multipart/form-data">
        <label>Nombre:</label>
        <input name="nombre" type="text">
        <label>Descripcion:</label>
        <input name="descripcion" type="text">
        <label>Selecciona fichero:</label>
        <input type="file" name="subirFormulario" size="50">

        <input type="submit" value="Subir fichero"></td>

    </form>
</div>
</body>
</html>

