<div class="w3-container" ng-app="cine" ng-controller="peliculaCtrl">
    <form>
        <p>Fecha<input class="w3-input w3-border" type="datetime" ng-model="fecha" name="fecha"/></p>
        <br>
        <button class="w3-btn w3-ripple" ng-click="buscarPelicula(fecha)" name="buscar">&#9998; Buscar</button>
    </form>
    <br>
    <div>
        <form ng-hide="hideform">
            <ol class="list-group" name="pelis">
                <li ng-repeat="pelicula in peliculas" class="list-group-item">
                    {{ pelicula.nombre }}
                    <input class="w3-btn w3-ripple" type="submit" value="Detalle"
                           ng-click="detallePelicula(pelicula.id)"/>
                    <input type="hidden" name="id" value="${pelicula.id}"/>
                    <input type="hidden" name="nombre" value="${pelicula.nombre}"/>
                    <input type="hidden" name="fecha" value="${fecha}"/>
                    <input type="hidden" name="precio" value="${pelicula.precio}"/>
                    <input type="hidden" name="descripcion" value="${pelicula.descripcion}"/>
                </li>
            </ol>
        </form>
        <div ng-hide="hideformdetalle">
            <form>
                <input type="hidden" name="id" ng-model="id" value="${pelicula.id}"/>
                <p ng-model="nombre">{{ pelicula.nombre }}</p>
                <p ng-model="descripcion">{{pelicula.descripcion}}</p>
                <p ng-model="fecha">{{pelicula.fecha}}</p>
                <p ng-model="precio">{{pelicula.precio}}</p>

                <p><input class="w3-btn w3-ripple" type="submit" value="Reservar" ng-click="addReserva()"/></p>
            </form>
        </div>
        <div>
            <form class="formulario" role="form" ng-hide="formreservar">
                <div ng-show="formulario.nombreComprador.$dirty">
                    <div ng-show="formulario.nombreComprador.$error.required" class="alert alert-danger" role="alert">
                        Campo nombre del comprado es obligatorio.
                    </div>
                </div>
                <div ng-show="formulario.idPago.$dirty">
                    <div ng-show="formulario.idPago.$error.required" class="alert alert-danger" role="alert">
                        Campo Tipo Pago obligatorio
                    </div>
                </div>
                <div ng-show="formulario.asientosReservados.$dirty">
                    <div ng-show="formulario.asientosReservados.$error.required" class="alert alert-danger"
                         role="alert">
                        Campo asientos obligatorio
                    </div>
                </div>

                <input type="hidden" name="idPelicula" value="${pelicula.id}"/>

                <div class="form-group"
                     ng-class="{'has-error': formulario.nombreComprador.$invalid, 'has-success': formulario.nombreComprador.$valid}">
                    <label class="control-label" for="nombreComprador">Nombre Comprador</label>
                    <input class="w3-input w3-border form-control" type="text" ng-model="nombreComprador" id="nombreComprador"
                           name="nombreComprador" autofocus required/>
                </div>

                <div class="form-group"
                     ng-class="{'has-error': formulario.idPago.$invalid, 'has-success': formulario.idPago.$valid}">
                    <label class="control-label">Tipo Pago </label>
                    <select ng-options="pag.id as pag.tipoPago for pag in pagos" ng-model="idPago">
                    </select>
                    <input type="hidden" name="idPago" value="{{ $scope.idPago }}"/>
               </div>

                <div class="form-group"
                     ng-class="{'has-error': formulario.asientosReservados.$invalid, 'has-success': formulario.asientosReservados.$valid}">
                    <label class="control-label" for="asientosReservados">Asientos a Reservar</label>
                    <input class="w3-input w3-border form-control" type="text" ng-model="asientosReservados"
                           id="asientosReservados" name="asientosReservados" required/>
                </div>

                <p><input class="w3-btn w3-green w3-ripple sample-show-hide" ng-disable="formulario.$invalid"
                          type="submit" value="Guardar reserva" ng-click="reservaPelicula()"/>
                </p>
            </form>

        </div>


    </div>
</div>


