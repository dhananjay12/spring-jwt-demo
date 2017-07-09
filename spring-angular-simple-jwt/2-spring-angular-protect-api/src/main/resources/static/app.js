var app = angular.module('app', []);

app.controller('MainCtrl', function($scope, MainService) {
	
	$scope.resData={};
	$scope.resCode='';
	$scope.isLoggedIn=false;

	$scope.getRandomAddress = function() {
		MainService.getRandomAddress().then(function success(response) {
			$scope.resCode= response.status + response.statusText; 
			$scope.resData = response.data;
		});
	}
	$scope.getRandomCompany = function() {
		MainService.getRandomCompany().then(function success(response) {
			$scope.resCode= response.status + response.statusText; 
			$scope.resData = response.data;
		});
	}
});

app.service('MainService', function($http) {

	return {

		getRandomAddress : function() {
			return $http.get('/fake/address');
		},
		getRandomCompany : function() {
			return $http.get('/fake/company');
		}

	}
});