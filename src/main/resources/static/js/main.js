var app = angular.module("springApp", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.phonebook = [];

    //Возращает данные
    $http.get('http://localhost:8080/api/clients').success(function (data) {
        console.log(data);
        $scope.phonebook = data;
    });

    //HTTP DELETE- delete client by Id
    $scope.removeClient = function(item) {
        $http({
            method : 'DELETE',
            url : 'http://localhost:8080/api/clients/' + item.id
        }).then(_success, _error);
    };
});
