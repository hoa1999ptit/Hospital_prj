var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
  $scope.submitForm = function(){
    var url = $location.absUrl() + "postcustomer";
    
    var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
    var data = {
            id: $scope.id,
			name: $scope.name,
			cmt: $scope.cmt
        };
    
    $http.post(url, data, config).then(function (response) {
      $scope.postResultMessage = response.data;
    }, function error(response) {
      $scope.postResultMessage = "Error with status: " +  response.statusText;
    });
    
    $scope.id = "";
	$scope.name = "";
	$scope.cmt = "";
  }
});
 
app.controller('getcontroller', function($scope, $http, $location) {
  $scope.getfunction = function(){
    var url = $location.absUrl() +"getallcustomer";
    
    $http.get(url).then(function (response) {
      $scope.response = response.data
    }, function error(response) {
      $scope.postResultMessage = "Error with status: " +  response.statusText;
    });
  }
});