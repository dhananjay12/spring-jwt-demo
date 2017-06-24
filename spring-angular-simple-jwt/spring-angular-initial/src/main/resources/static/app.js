var app = angular.module('app', []);

app.controller('MainCtrl', function($scope, MainService) {
	
	$scope.randomAddress={};

	$scope.getRandomAddress = function() {
		MainService.getRandomAddress().then(function success(response) {
			$scope.randomAddress = response.data;
		});
	}
});

app.service('MainService', function($http) {

	return {

		getRandomAddress : function() {
			return $http.get('/fake/address');
		}

	}
});