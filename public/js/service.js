app.service('appService', ["$http", function($http){
	
	this.getPlanet = function(){
		return $http.get("planet");
	};
	
	this.getStarship = function(){
		return $http.get("starship");
	}
	
	this.getVisit = function(){
		return $http.get("visit");
	}	

	this.getPlanetById = function(planetId){
		var str1 = "planet/"
		var qry = str1+ planetId;
		return $http.get(qry);
	}
}]);