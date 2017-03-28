package com.onaware.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import sailpoint.plugin.PluginContext;
import sailpoint.tools.GeneralException;

 
public class ObjectService {
    private static final String iiqIP = "localhost";
    private static final int iiqPort = 8092;
    private static final String iiqUser = "spadmin";
    private static final String iiqPass = "admin";
    
	private static final Logger log = Logger.getLogger("com.onaware.plugin");  
    static List<String> objName = new ArrayList<>();

    /**
     * The plugin context.
     */
    private PluginContext pluginContext;
    
    /**
     * Constructor.
     *
     * @param pluginContext The plugin context.
     */
    public ObjectService(PluginContext pluginContext) {
        this.pluginContext = pluginContext;
    }
 
    public List<String> getObjects() throws GeneralException{
     
    try {
       //ensure the list is empty before adding objects.
    	objName.clear();
    	
        log.debug("Starting REST client");
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(iiqUser, iiqPass);
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
 
        
        //
        // Call to get Application Objects
        //
     
        String iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Application?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        HttpGet request = new HttpGet(iiqRequest);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nObjectList: " + objName);
     
        }
        
        //
        // Call to get Capability Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Capability?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get CorrelationConfig Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/CorrelationConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get Roles(Bundles) Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Bundle?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get Custom Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Custom?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get ObjectConfig Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/ObjectConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get Policy Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Policy?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get Rule Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Rule?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get UIConfig Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/UIConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        //
        // Call to get Workflow Objects
        //
     
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/clean/rest/debug/Workflow?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objName.add(objResponse.getJSONObject(i).getString("name"));
            }
            log.debug("\nUpdated ObjectList " + objName);
     
        }
        
        
        } catch (Exception e) {
        	log.debug("Exception:" + e.toString());
        }
		
    return objName;

    }
 
}

