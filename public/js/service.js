app.service('appService', ["$http", function($http){
	
	this.getPlanet = function(){
		return $http.get("planet");
	};
}]);