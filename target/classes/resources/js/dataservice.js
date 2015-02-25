(function(){
	var app = angular.module('main', ['ngTable']);
	app.controller('DataController', ['$http', function($http) {
		var data = this;
		data.json = [];
		$http.get("http://localhost:11555/data").success(function(json) {
			data.json = json;
		}).error(function(json) {
			data.json = json;
			data.errors = true;
		});
		
		this.serviceActiveText = function() {
			json = data.json;
			if(json.active) {
				return "Teenus aktiivne kuni " +getLocaleString(json.endDate);
			}
			return "Teenus mitteaktiivne";
		};
		
		this.xlServiceText = function() {
			json = data.json;
			if(json.xlService) {
				text = "XL-teenus aktiivne (" + json.xlStart + " - " + json.xlEnd + ") ";
				if(json.xlLanguage) {
					text+= json.xlLanguage.toLowerCase() + " keeles"
				}
				return  text;
			} else {
				return "XL-teenus mitteaktiivne";
			}
		};

	}]);
})();

function getLocaleString(endDate) {
	var date = new Date(endDate);
	return date.toLocaleString();
}