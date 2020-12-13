(function () {
	'use strict';
	angular
		.module('app')
		.controller('NursesController', NursesController);
	NursesController.$inject = ['$http'];
	function NursesController($http) {
		var vm = this;

		vm.nurses = [];
		vm.getAllNurses = getAllNurses;
		vm.updateNurse = updateNurse;
		vm.createNurse = createNurse;
		vm.removeNurse = removeNurse;

		init();

		function init() {
			getAllNurses();

		}

		function getAllNurses() {
			var url = "/nurses/all";
			var nursesPromise = $http.get(url);
			nursesPromise.then(function (response) {
				vm.nurses = response.data;
			});
		}
		function updateNurse(id) {
			var url = "nurses/update/" + id;
			var nursesPromise = $http.get(url);
			nursesPromise.then(function (response) {
				vm.nurses = response.data;
			});
		}
		function createNurse() {
			var url = "/nurses/create";
			var nursesPromise = $http.get(url);
			nursesPromise.then(function (response) {
				vm.nurses = response.data;
			});
		}
		function removeNurse(id) {
			var url = "/nurses/delete/" + id;
			$http.get(url).then(function (response) {
				vm.nurses = response.data;
			});
		}
	}
})();