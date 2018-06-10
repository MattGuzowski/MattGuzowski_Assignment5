app.controller('appController',["$scope","$log","appService",
	function($scope, $log, appService){
		$scope.starship = null;
		$log.info("starship");
		$scope.loadStarships = function(){
			var promiseGet = appService.getStarship();
			promiseGet.then(function (result) {
				if (result && result.data){
					$log.info (result.data)
					$scope.starship = result.data;
				}
		}, function (reason) {
			$log.error("failure loading starship database information",reason);
		});
	};
	
	$scope.loadStarships();
}]);