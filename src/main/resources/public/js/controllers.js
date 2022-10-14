angular.module('app.controllers', []).controller('BeerListController', function($scope, $state, popupService, $window, Beer) {
  $scope.beers = Beer.query(); //fetch all beers. Issues a GET to /api/vi/beers

  $scope.deleteBeer = function(beer) { // Delete a Beer. Issues a DELETE to /api/v1/beers/:id
    if (popupService.showPopup('Really delete this?')) {
      beer.$delete(function() {
        $scope.beers = Beer.query();
        $state.go('beers');
      });
    }
  };
}).controller('BeerViewController', function($scope, $stateParams, Beer) {
  $scope.beer = Beer.get({ id: $stateParams.id }); //Get a single beer. Issues a GET to /api/v1/beers/:id
}).controller('BeerCreateController', function($scope, $state, $stateParams, Beer) {
  $scope.beer = new Beer();  //create new beer instance. Properties will be set via ng-model on UI

  $scope.addBeer = function() { //create a new beer. Issues a POST to /api/v1/beers
    $scope.beer.$save(function() {
      $state.go('beers'); // on success go back to the list i.e. beers state.
    });
  };
}).controller('BeerEditController', function($scope, $state, $stateParams, Beer) {
  $scope.updateBeer = function() { //Update the edited beer. Issues a PUT to /api/v1/beers/:id
    $scope.beer.$update(function() {
      $state.go('beers'); // on success go back to the list i.e. beers state.
    });
  };

  $scope.loadBeer = function() { //Issues a GET request to /api/v1/beers/:id to get a beer to update
    $scope.beer = Beer.get({ id: $stateParams.id });
  };

  $scope.loadBeer(); // Load a beer which can be edited on UI
});
