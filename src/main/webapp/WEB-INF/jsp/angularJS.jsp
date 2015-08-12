<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC AngularJS demo</title>
      <link href="<c:url value="/resources/theme001/css/main.css" />" rel="stylesheet">
      <script src="<c:url value="/resources/theme001/js/angular.min.js" />"></script>
      <script src="<c:url value="/resources/theme001/js/app.js" />"></script>
      
      

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
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});

		};
	};
</script>
</head>
<body>
	<div data-ng-app="myApp">
		<div data-ng-controller="MyController">
			<button data-ng-click="getPersonDataFromServer()">Get Person data from server</button>
			<p>First Name : {{person.firstName}}</p>
			<p>Last Name : {{person.lastName}}</p>
		</div>
	</div>
</body>
</html>