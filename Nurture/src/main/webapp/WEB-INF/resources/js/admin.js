angular.module('demo', [])
.factory('timeoutHttpInterceptor', function () {
    return {
      'request': function(config) {
        config.timeout = 98000;
        return config;
      }
    };
 })
.controller('svc', function($scope, $http) {
	 console.log("Angular.admin controller");
	var url ='http://postalpincode.in/api/pincode/804406';
    $http({
    	method:'JSONP',
    	url:url
    }).
        success(function(response) {
        	
            $scope.pincode = response.data;
            console.log("Output ="+response.data)
        }).
        error(function (error, status){
            $scope.pincode = { message: error, status: status};
            console.log($scope.pincode.status); 
      });
});

/*mysvc.value('http_defaults', {
    timeout: 1500
  });
*/
/*
 * 
 * http://postalpincode.in/api/pincode/804406
 
{
	"Message": "Number of Post office(s) found: 4",
	"Status": "Success",
	"PostOffice": [{
		"Name": "Ghosi  (Jehanabad)",
		"Description": "",
		"BranchType": "Sub Post Office",
		"DeliveryStatus": "Delivery",
		"Taluk": "Ghoshi",
		"Circle": "Ghoshi",
		"District": "Jehanabad",
		"Division": "Gaya",
		"Region": "Patna HQ",
		"State": "Bihar",
		"Country": "India"
	},*/