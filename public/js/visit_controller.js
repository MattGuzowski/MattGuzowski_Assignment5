app.controller('appController',["$scope","$log","appService",
	function($scope, $log, appService){
		$scope.visit = null;
		$log.info("visit");
		$scope.loadVisits = function(){
			var promiseGet = appService.getVisit();
			promiseGet.then(function (result) {
				if (result && result.data){
					$log.info (result.data)
					$scope.visit = result.data;
				}
		}, function (reason) {
			$log.error("failure loading visit database information",reason);
		});
	};
	$scope.loadVisits();
	
	$scope.planetId = this.visit;
	$scope.getPlanetId = function(visit){
		var promiseGet = appService.getPlanetById(visit);
		promiseGet.then(function (result) { 
			if (result && result.data){
				$log.info(result.data)
				$scope.planetId = result.data;
			}
		}, function (reason) {
			$log.error("failure loading planetId data from table", reason);
		});
	};
	$scope.getPlanetId();
	
}]);