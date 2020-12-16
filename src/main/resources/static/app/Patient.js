var app = angular.module("PatientManagement", []);

// Controller Part
app.controller("PatientController", function ($scope, $http) {
  $scope.patients = [];
  $scope.pat = {
    name: "",
    idcard: "",
    birthday: "",
    address: "",
    phone: ""
  };
  _refreshPatientData();
$scope.create = function() {
        $http({
            method: "POST",
            url: '/api/patients/create',
            data: JSON.stringify($scope.pat),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

  $scope.delete = function (pat) {
    $http({
      method: 'DELETE',
      url: '/api/patients/delete/' + pat.id
    }).then(_success, _error);
  };

  // In case of edit
  $scope.edit = function (acc) {
    $scope.acc.id = acc.id;
    $scope.acc.name = acc.name;
    $scope.acc.phone = acc.phone;
    $scope.acc.position = acc.position;

  };

  // Private Method  
  // HTTP GET- get all employees collection
  // Call: http://localhost:8080/employees
  function _refreshPatientData() {
    $http({
      method: 'GET',
      url: '/api/patients/getAll'
    }).then(
      function (res) { // success
        $scope.patients = res.data;
      },
      function (res) { // error
        console.log("Error: " + res.status + " : " + res.data);
      }
    );
  }

  function _success(res) {
        _refreshPatientData();
    }

  function _error(res) {
    var data = res.data;
    var status = res.status;
    var header = res.header;
    var config = res.config;
    alert("Error: " + status + ":" + data);
  }
  function _clearFormData() {
        $scope.pat.id = null;
        $scope.pat.name = "";
        $scope.pat.idcard = "";
        $scope.pat.address = "";
        $scope.pat.birthday = "";
        $scope.pat.phone = "";
    };
});