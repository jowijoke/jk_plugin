
package com.onaware.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.onaware.service.ObjectService;
import com.onaware.util.CompareUtil;

import sailpoint.integration.ListResult;
import sailpoint.rest.plugin.AllowAll;
import sailpoint.rest.plugin.BasePluginResource;
import sailpoint.tools.GeneralException;

/**
 * The REST resource for CRUD operations on objects.
 *
 *
 */
@Path("envcom")
@Produces("application/json")
@Consumes("application/json")
public class ObjectResource extends BasePluginResource {
	
	private static final Logger log = Logger.getLogger("com.onaware");  


	 /**
     * {@inheritDoc}
     */
    @Override
    public String getPluginName() {
        return CompareUtil.PLUGIN_NAME;
    }
    
    /**
     * Gets all objects for the currently logged in user.
     * @return The ListResult containing the objects.
     * @throws GeneralException
     */
    @GET
    @Path("jk")
    @AllowAll
    public String getObjects2() throws GeneralException {
    	ObjectService objService = getObjectService();
    	log.debug("Object Resource: saying hello");  
        String log = new String("hi jk");
        
        return log;
        
    }



    /**
     * Gets all objects for the currently logged in user.
     * @return The ListResult containing the objects.
     * @throws GeneralException
     */
    @GET
    @Path("applications")
    @AllowAll
    public ListResult getObjects() throws GeneralException {
    	log.debug("Object Resource: getting objects");  
    	ObjectService objService = getObjectService();
        List<String> objs = objService.getObjects();

        return new ListResult(objs, objs.size());
        
    }


    /**
     * Gets an instance of the ObjectService.
     *
     * @return The service.
     */
    private ObjectService getObjectService() {
        return new ObjectService(this);
    }

}

