var app = angular.module('app', []);

app.controller('MainCtrl', function($scope, MainService) {

	$scope.resData = {};
	$scope.resCode = '';
	$scope.isLoggedIn = false;
	$scope.authRequest = {};
	$scope.authRequest.username;
	$scope.authRequest.password;
	$scope.invalidLoginMessage = null;
	$scope.token = null;

	$scope.login = function() {

		MainService.login($scope.authRequest).then(function(response) {
			if (response.status === 200) {
				$scope.isLoggedIn = true;
				$scope.invalidLoginMessage = null;
				$scope.token=response.headers('Authorization');
			} else {
				$scope.invalidLoginMessage = response.data.message;
			}
		});
	}

	$scope.logout = function() {

		MainService.logout();
		$scope.isLoggedIn = false;
	}

	$scope.getRandomAddress = function() {
		MainService.getRandomAddress().then(function success(response) {
			$scope.resCode = response.status + response.statusText;
			$scope.resData = response.data;
		}, function error(response) {
			$scope.resCode = response.status;
			$scope.resData = response.data;
		});
	}
	$scope.getRandomCompany = function() {
		MainService.getRandomCompany().then(function success(response) {
			$scope.resCode = response.status + response.statusText;
			$scope.resData = response.data;
		}, function error(response) {
			$scope.resCode = response.status;
			$scope.resData = response.data;
		});
	}
});

app.service('MainService', function($http) {

	return {

		login : function(authRequest) {
			return $http.post('/login', authRequest).then(
					function successHandler(response) {
						$http.defaults.headers.common.Authorization = response
								.headers('Authorization');
						return response;
					}, function errorHandler(response) {
						return response;
					});
			;
		},

		logout : function() {
			$http.defaults.headers.common.Authorization = '';
		},

		getRandomAddress : function() {
			return $http.get('/fake/address');
		},
		getRandomCompany : function() {
			return $http.get('/fake/company');
		}

	}
});