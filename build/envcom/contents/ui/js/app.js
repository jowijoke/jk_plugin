/**
 * Create the module.
 */
var compareModule = angular.module('EnvCom', ['ui.bootstrap']);

/**
 * Controller for the EnvCom plugin.
 */
compareModule.controller('EnvComController', function(objectService, $uibModal) {

    var me = this;
    
    me.getObjs = function() {
        return objectService.getObjects();
         
    };
    
    /**
     * Gets the objects from the server and sets them on the controller.
     */
    me.getTodos = function() {
        getObjs().then(function(objects) {
            me.obj = objects;
        });
    };
    
    me.listObjClean = function() {
        
        objectService.getObjectsClean();
         
    };
    
    me.hello = function(){
    	$uibModal.open({
            animation: false,
            templateUrl: PluginHelper.getPluginFileUrl('EnvCom', 'ui/html/hello.html')
        });
    	
    };
});

/**
 * Service that handles functionality around iiq objects.
 */
compareModule.service('objectService', function($http) {

    var config = {
        headers: {
            'X-XSRF-TOKEN': PluginHelper.getCsrfToken()
        }
    };
    
    var config2 ={
    	headers: {
    		'Authorization' :'Basic c3BhZG1pbjphZG1pbg=='
    	}	
    		
    };
 

    return {

        /**
         * Gets objects
         *
         * @return Promise A promise that resolves with an array of objects.
         */
        getObjects: function() {
            var OBJECTS_URL = PluginHelper.getPluginRestUrl('envcom/applications');
            return $http.get(OBJECTS_URL, config).then(function(response) {
                return response;
            });
        },
        
        getObjectsClean: function() {
            var OBJECTS_URL = ('http://localhost:8092/clean/rest/debug/Application?listobjects');
            return $http.get(OBJECTS_URL, config2).then(function(response) {
                return response;
            });
        },

    };

});

