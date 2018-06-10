app.controller('appController',["$scope","$log","appService",
	function($scope, $log, appService){
		$scope.planet = null;
		$log.info("planet");
		$scope.loadPlanets = function(){
			var promiseGet = appService.getPlanet();
			promiseGet.then(function (result) {
				if (result && result.data){
					$log.info (result.data)
					$scope.planet = result.data;
				}
		}, function (reason) {
			$log.error("failure loading planet database information",reason);
		});
	};
	
	$scope.loadPlanets();
}]);