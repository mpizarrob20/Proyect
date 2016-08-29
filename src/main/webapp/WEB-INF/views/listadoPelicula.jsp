<div class="w3-container" ng-app="cine" ng-controller="peliculaCtrl" ng-init="getAllPelicula()">
    <h1>Listado Pelicula</h1>
    <table class="w3-table w3-bordered w3-striped">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Fecha</th>
            <th>Precio</th>
            <th>Descripcion</th>
            <th>Asientos</th>
            <th>Asientos a Ocupar</th>

        </tr>
        <tr ng-repeat="pelicula in peliculas">
            <td>{{ pelicula.id }}</td>
            <td>{{ pelicula.nombre }}</td>
            <td>{{ pelicula.fecha }}</td>
            <td>{{ pelicula.precio }}</td>
            <td>{{ pelicula.descripcion }}</td>
            <td>{{ pelicula.asientosStr }}</td>
            <td>{{ pelicula.asientosAOcupadarStr }}</td>
            <td>
                <button class="w3-btn w3-ripple" name="eliminar" ng-click="eliminarPelicula(pelicula.id)">&#9998; Eliminar</button>
            </td>
            <td>
                <button class="w3-btn w3-ripple" name="editar" ng-click="editarPelicula(pelicula.id)">&#9998; Editar</button>
            </td>
        </tr>
    </table>

    <br>
    <button class="w3-btn w3-green w3-ripple" ng-click="addPelicula()">&#9998; Adicionar Pelicula</button>
    <br>
    <br>
    <form ng-hide="hideform" name="formulario" role="form">

        <div ng-show="formulario.id.$dirty">
            <div ng-show="formulario.id.$error.required" class="alert alert-danger" role="alert">
                Campo id obligatorio.
            </div>
        </div>
        <div ng-show="formulario.nombre.$dirty">
            <div ng-show="formulario.nombre.$error.required" class="alert alert-danger" role="alert">
                Campo nombre obligatorio.
            </div>
        </div>
        <div ng-show="formulario.fecha.$dirty">
            <div ng-show="formulario.fecha.$error.required" class="alert alert-danger" role="alert">
                Campo fecha obligatorio.
            </div>
        </div>
        <div ng-show="formulario.precio.$dirty">
            <div ng-show="formulario.precio.$error.required" class="alert alert-danger" role="alert">
                Campo precio obligatorio.
            </div>
        </div>
        <div ng-show="formulario.descripcion.$dirty">
            <div ng-show="formulario.descripcion.$error.required" class="alert alert-danger" role="alert">
                Campo descripcion obligatorio.
            </div>
        </div>
        <div ng-show="formulario.asientosLibres.$dirty">
            <div ng-show="formulario.asientosLibres.$error.required" class="alert alert-danger" role="alert">
                Campo asientos obligatorio.
            </div>
        </div>

        <div class="form-group"
             ng-class="{'has-error': formulario.id.$invalid, 'has-success': formulario.id.$valid}">
            <label class="control-label" for="id">ID:</label>
            <input class="w3-input w3-border form-control" id="id" name="id" ng-model="id" type="number"
                   placeholder="Id" ng-disabled="!editpelicula" autofocus required>
        </div>
        <br>

        <div class="form-group"
             ng-class="{'has-error': formulario.nombre.$invalid, 'has-success': formulario.nombre.$valid}">
            <label class="control-label" for="nombre">Nombre:</label>
            <input class="w3-input w3-border form-control" id="nombre" name="nombre" ng-model="nombre" type="text"
                   placeholder="Nombre" required>
        </div>
        <br>
        <div class="form-group"
             ng-class="{'has-error': formulario.fecha.$invalid, 'has-success': formulario.fecha.$valid}">
            <label class="control-label" for="fecha">Fecha:</label>
            <input class="w3-input w3-border form-control" id="fecha" name="fecha" ng-model="fecha" type="datetime"
                   placeholder="Id" required>
        </div>
        <br>
        <div class="form-group"
             ng-class="{'has-error': formulario.precio.$invalid, 'has-success': formulario.precio.$valid}">
            <label class="control-label" for="precio">Precio:</label>
            <input class="w3-input w3-border form-control" id="precio" name="precio" ng-model="precio" type="number"
                   placeholder="Precio" required>
        </div>
        <br>
        <div class="form-group"
             ng-class="{'has-error': formulario.descripcion.$invalid, 'has-success': formulario.descripcion.$valid}">
            <label class="control-label" for="descripcion">Descripcion:</label>
            <input class="w3-input w3-border form-control" id="descripcion" name="descripcion" ng-model="descripcion"
                   type="text" placeholder="Descripcion" required>
        </div>
        <br>
        <div class="form-group"
             ng-class="{'has-error': formulario.asientosLibres.$invalid, 'has-success': formulario.asientosLibres.$valid}">
            <label class="control-label" for="asientosLibres">Asientos:</label>
            <input class="w3-input w3-border form-control" id="asientosLibres" name="asientosLibres"
                   ng-model="asientosLibres" type="text"
                   placeholder="Asientos" required>
        </div>
        <br>

        <button class="w3-btn w3-green w3-ripple" ng-click="adicionarPelicula()">&#10004; Guardar</button>

    </form>

</div>
