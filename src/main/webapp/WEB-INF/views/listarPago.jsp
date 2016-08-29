<div class="w3-container" ng-app="cine" ng-controller="pagoCtrl" ng-init="getAllPago()">
    <h1>Listado Pago</h1>
    <table class="w3-table w3-bordered w3-striped">
        <tr>
            <th>ID</th>
            <th>Tipo pago</th>
        </tr>
        <tr ng-repeat="pago in pagos" ng-animate="'animate'">
            <td>{{ pago.id }}</td>
            <td>{{ pago.tipoPago }}</td>
            <td>
                <button class="w3-btn w3-ripple" ng-click="eliminarPago(pago.id)">&#9998; Eliminar</button>
            </td>
            <td>
                <button class="w3-btn w3-ripple" ng-click="editarPago(pago.id)">&#9998; Editar</button>
            </td>
        </tr>
    </table>

    <br>
    <button class="w3-btn w3-green w3-ripple" ng-click="addPago()">&#9998; Adicionar Pago</button>
    <br>
    <br>

    <form ng-hide="hideformpago" name="formulario" role="form">
        <div ng-show="formulario.idPago.$dirty">
            <div ng-show="formulario.idPago.$error.required" class="alert alert-danger" role="alert">
                Campo id obligatorio
            </div>
        </div>
        <div ng-show="formulario.tipoPago.$dirty">
            <div ng-show="formulario.tipoPago.$error.required" class="alert alert-danger" role="alert">
                Campo Tipo Pago obligatorio
            </div>
        </div>

        <div class="form-group"
             ng-class="{'has-error': formulario.idPago.$invalid, 'has-success': formulario.idPago.$valid}">
            <label class="control-label" for="idPago">ID:</label>
            <input class="w3-input w3-border form-control" id="idPago" name="idPago" ng-model="idPago" type="number"
                   placeholder="Id" ng-disabled="!edit" autofocus required>
        </div>

        <br>

        <div class="form-group"
             ng-class="{'has-error': formulario.tipoPago.$invalid, 'has-success': formulario.tipoPago.$valid}">
            <label  class="control-label" for="tipoPago">Tipo Pago:</label>
            <input class="w3-input w3-border form-control" id="tipoPago" name="tipoPago" ng-model="tipoPago" type="text"
                   placeholder="Pago" required>
        </div>

        <br>
        <button class="w3-btn w3-green w3-ripple sample-show-hide" ng-disable="formulario.$invalid" ng-click="adicionarPago()">&#10004; Guardar
        </button>

    </form>
</div>

