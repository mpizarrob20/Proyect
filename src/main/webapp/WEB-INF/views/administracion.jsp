<%--
  Created by IntelliJ IDEA.
  User: maydalis
  Date: 13-06-16
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="cine">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Buscar Pelicula</title>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-resource.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.js"></script>
    <script type="text/javascript" src="../../resources/js/app.js"></script>
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="jumbotron text-center row">
        <div class="col-sm-9"><h1>Panel de administracion</h1></div>
        <div class="col-sm-3" style="float: right"><a href="/">Buscar Pelicula</a></div>
    </div>

    <div class="row">
        <div class="col-md-2">
            <ul class="nav nav-pills nav-stacked" role="tablist">
                <li><a href="#/peliculas">Peliculas</a></li>
                <li><a href="#/reservas">Reservas</a></li>
                <li><a href="#/pago">Pagos</a></li>
            </ul>
        </div>
        <div class="col-md-10">
            <div ng-view></div>
        </div>

    </div>


</div>
</body>
</html>
