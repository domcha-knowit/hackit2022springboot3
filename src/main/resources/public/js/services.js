angular.module('app.services', []).factory('Beer', function($resource) {
  return $resource('/api/v1/beers/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
