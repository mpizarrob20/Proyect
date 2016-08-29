var app = angular.module("cine", ["ngRoute", "ngResource"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when("/buscar", {
            templateUrl: "listaPeliculaEncontrada",
            controller: "peliculaCtrl"
        })
        .when("/peliculas", {
            templateUrl: "listadoPelicula",
            controller: "peliculaCtrl"

        })
        .when("/pago", {
            templateUrl: "listarPago",
            controller: "pagoCtrl"
        })
        .when("/reservas", {
            templateUrl: "listadoReservas",
            controller: "reservasCtrl"
        });

});

app.controller('peliculaCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.id = "";
    $scope.nombre = "";
    $scope.nombreComprador = "";
    $scope.fecha = "";
    $scope.precio = "";
    $scope.descripcion = "";
    $scope.asientosLibres = "";
    $scope.asientosReservados = "";
    $scope.asientosOcupados = "";
    $scope.hideform = true;
    $scope.hideformedit = true;
    $scope.fecha = "";
    $scope.tipoPago = "";
    $scope.idPelicula = "";
    $scope.idPago = "";
    $scope.hideformdetalle = true;
    $scope.formreservar = true;
    $scope.editpelicula = true;

    $scope.getAllPelicula = function () {
        $http.get('/pelicula/listPelicula').success(function (response) {
            $scope.peliculas = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });
    }

    $scope.eliminarPelicula = function (id) {
        var config = {
            params: {id: id}
        }
        $http.get('/pelicula/deletePelicula', config).success(function (response) {
            $scope.peliculas = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });
    }

    $scope.adicionarPelicula = function () {
        var config = {
            params: {
                id: $scope.id,
                nombre: $scope.nombre,
                fecha: $scope.fecha,
                precio: $scope.precio,
                descripcion: $scope.descripcion,
                asientosLibres: $scope.asientosLibres,
                asientosOcupados: $scope.asientosOcupados

            }
        }
        $http.get('/pelicula/adicionarpelicula', config).success(function (response) {
            $scope.peliculas = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });

    }

    $scope.editarPelicula = function (id) {
        $scope.hideform = false;
        $scope.editpelicula = false;
        for (var i = 0; i < $scope.peliculas.length; i++) {
            if ($scope.peliculas[i].id == id) {
                $scope.pelicula = $scope.peliculas[i];
            }
        }
        $scope.id = $scope.pelicula.id;
        $scope.nombre = $scope.pelicula.nombre;
        $scope.fecha = $scope.pelicula.fecha;
        $scope.precio = $scope.pelicula.precio;
        $scope.descripcion = $scope.pelicula.descripcion;
        $scope.asientosLibres = $scope.pelicula.asientosLibres;
        $scope.asientosOcupados = $scope.pelicula.asientosOcupados;

    }

    $scope.buscarPelicula = function (fecha) {
        $scope.hideform = false;
        var config = {
            params: {fecha: $scope.fecha}
        }
        $http.get('/pelicula/peliculasEncontrados', config).success(function (response) {
            $scope.peliculas = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });
    }

    $scope.detallePelicula = function (id) {
        $scope.hideformdetalle = false;
        $scope.hideform = true;
        for (var j = 0; j < $scope.peliculas.length; j++) {
            if ($scope.peliculas[j].id == id) {
                $scope.pelicula = $scope.peliculas[j];
            }
        }

        $scope.nombre = $scope.pelicula.nombre;
        $scope.fecha = $scope.pelicula.fecha;
        $scope.precio = $scope.pelicula.precio;
        $scope.descripcion = $scope.pelicula.descripcion;

    }

    $scope.listapagos = function () {
        $http.get('/pago/listPago').success(function (response) {
            $scope.pagos = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });

    }

    $scope.addReserva = function () {
        $scope.formreservar = false;
        $scope.hideformdetalle = true;
        $scope.hideform = true;
        $http.get('/pago/listPago').success(function (response) {
            $scope.pagos = response;
        })
        $scope.items = $scope.pagos;

    }

    $scope.reservaPelicula = function () {
        var config = {
            params: {
                nombreComprador: $scope.nombreComprador,
                asientosReservados: $scope.asientosReservados,
                idPelicula: $scope.pelicula.id,
                idPago: $scope.idPago,

            }
        }
        $http.get('/reserva/reservaPelicula', config).success(function (response) {
            $scope.reserva = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });

    }

    $scope.addPelicula = function () {
        $scope.hideform = false;
    }

}]);

app.controller('pagoCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.hideformpago = true;
    $scope.edit = true;
    $scope.getAllPago = function () {
        $http.get('/pago/listPago').success(function (response) {
            $scope.pagos = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });
    }

    $scope.eliminarPago = function (id) {
        var config = {
            params: {id: id}
        }
        $http.get('/pago/deletePago', config).success(function (response) {
            $scope.pagos = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });
    }

    $scope.adicionarPago = function () {
        var config = {
            params: {
                tipoPago: $scope.tipoPago,
                id: $scope.idPago,

            }
        }

        $http.get('/pago/adicionarPago', config).success(function (response) {
            $scope.pagos = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });

    }

    $scope.editarPago = function (id) {
        $scope.hideformpago = false;
        $scope.edit = false;
        for (var i = 0; i < $scope.pagos.length; i++) {
            if ($scope.pagos[i].id == id) {
                $scope.pagoModificar = $scope.pagos[i];
            }
        }
        $scope.tipoPago = $scope.pagoModificar.tipoPago;
        $scope.idPago = $scope.pagoModificar.id;
    }

    $scope.addPago = function () {
        $scope.hideformpago = false;
    }


}]);

app.controller('reservasCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.getAllReservas = function () {
        $http.get('/reserva/list').success(function (response) {
            $scope.reservas = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });
    }

    $scope.eliminarReserva = function (id) {
        var config = {
            params: {id: id}
        }
        $http.get('/reserva/eliminarReserva', config).success(function (response) {
            $scope.reservas = response;
        }).error(function () {
            console.log("No se puede mostrarrr");
        });

    }

}]);





