<div class="w3-container" ng-app="cine" ng-controller="reservasCtrl" ng-init="getAllReservas()">
    <h1>Listado Reservacion</h1>
    <table class="w3-table w3-bordered w3-striped">
        <tr>
            <th>ID</th>
            <th>Nombre Comprador</th>
            <th>Asientos Reservados</th>
            <th>Pelicula</th>
            <th>Fecha de Pelicula</th>
        </tr>
        <tr ng-repeat="reserva in reservas">
            <td>{{ reserva.id}}</td>
            <td>{{ reserva.nombreComprador}}</td>
            <td>{{ reserva.asientosReservados}}</td>
            <td>{{ reserva.idPelicula}}</td>
            <td>{{ reserva.fechaPelicula}}</td>
            <td><button class="w3-btn w3-ripple" ng-click="eliminarReserva(reserva.id)">&#9998; Eliminar</button></td>
        </tr>
    </table>
</div>

