<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC AngularJS demo</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"/>
<script>
	var app = angular.module('myApp', []);
	function MyController($scope, $http) {
		$scope.getPersonDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'springAngularJS.web'
			}).success(function(data, status, headers, config) {
				$scope.person = data;
			}).error(function(data, status, headers, config) {
				console.log('error in processing');
			});

		};
	};
</script>
</head>
<body>
	<div data-ng-app="myApp">
		<div data-ng-controller="MyController">
			<input type="text" name="login Name" ng-model>
			<p>Login Id : {{person.firstName}}</p>
			<p >password : {{person.lastName}}</p>
			
			<button data-ng-click="getPersonDataFromServer()">Get Person data from server</button>
		</div>
	</div>
</body>
</html>