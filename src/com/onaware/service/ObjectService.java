package com.onaware.service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

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
    private static final int cleaniiqPort = 8092;
    private static final int iiqPort = 8073;
    private static final String iiqUser = "spadmin";
    private static final String iiqPass = "admin";
    
	private static final Logger log = Logger.getLogger("com.onaware.plugin");  
	
	static Collection<String> cleanObjects = new ArrayList<String>(); 
	static Collection<String> objects = new ArrayList<String>(); 


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
 
    public Collection<String> getCleanObjects() throws GeneralException{
     
    try {
       //ensure the list is empty before adding objects.
    	cleanObjects.clear();
    	
        log.debug("Starting REST client");
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(iiqUser, iiqPass);
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
 
        
        //
        // Call to get Application Objects
        //
        //List<String> application = new ArrayList<>();
        
        String iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Application?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        HttpGet request = new HttpGet(iiqRequest);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	//application.add(objResponse.getJSONObject(i).getString("name"));
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nApplications: " + application);
            //cleanObjects.add(application);
            
        }
        
        //
        // Call to get Capability Objects
        //
        //List<String> capability = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Capability?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nCapability: " + capability);
           // cleanObjects.add(capability);
        }
        
        //
        // Call to get CorrelationConfig Objects
        //
       // List<String> correlationConfig = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/CorrelationConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nCorrelationConfig: " + correlationConfig);
           // cleanObjects.add(correlationConfig);
        }
        
        //
        // Call to get Roles(Bundles) Objects
        //
        //List<String> bundle = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Bundle?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nBundle: " + bundle);
            //cleanObjects.add(bundle);
     
        }
        
        //
        // Call to get Custom Objects
        //
        //List<String> custom = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Custom?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nCustom: " + custom);
            //cleanObjects.add(custom);
     
        }
        
        //
        // Call to get ObjectConfig Objects
        //
        //List<String> objectConfig = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/ObjectConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nObjectConfig: " + objectConfig);
          //  cleanObjects.add(objectConfig);
        }
        
        //
        // Call to get Policy Objects
        //
       // List<String> policy = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Policy?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nPolicy: " + policy);
          //  cleanObjects.add(policy);
     
        }
        
        //
        // Call to get Rule Objects
        //
        //List<String> rule = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Rule?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nRule: " + rule);
          //  cleanObjects.add(rule);
     
        }
        
        //
        // Call to get UIConfig Objects
        //
     
        //List<String> uiConfig = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/UIConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");

            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
          //  log.debug("\nuiConfig: " + uiConfig);
         //   cleanObjects.add(uiConfig);
        }
        
        //
        // Call to get Workflow Objects
        //
        //List<String> workflow = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/Workflow?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nWorkflow: " + workflow);
          //  cleanObjects.add(workflow);
     
        }
        
        
        //
        // Call to get LifeCycle Events(IdentityTrigger) Objects
        //
        //List<String> identityTrigger = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(cleaniiqPort) + "/clean/rest/debug/IdentityTrigger?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	cleanObjects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nidentityTrigger: " + identityTrigger);
          //  cleanObjects.add(identityTrigger);
        }
        
        
        } catch (Exception e) {
        	log.debug("Exception:" + e.toString());
        }
    
    getObjects();
	compareObjects();	
	
    return cleanObjects;

    }
    
    public void getObjects() throws GeneralException{

        try {
    	//ensure the list is empty before adding objects.
    	objects.clear();
    	
        log.debug("Gettting Local objects");
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(iiqUser, iiqPass);
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
 
        
        //
        // Call to get Application Objects
        //
       // List<String> application = new ArrayList<>();
        String iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Application?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        HttpGet request = new HttpGet(iiqRequest);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nApplications: " + application);
           // objects.add(application);
            
        }
        
        //
        // Call to get Capability Objects
        //
       // List<String> capability = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Capability?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nCapability: " + capability);
           // objects.add(capability);
        }
        
        //
        // Call to get CorrelationConfig Objects
        //
        //List<String> correlationConfig = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/CorrelationConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nCorrelationConfig: " + correlationConfig);
         //   objects.add(correlationConfig);
        }
        
        //
        // Call to get Roles(Bundles) Objects
        //
        //List<String> bundle = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Bundle?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nBundle: " + bundle);
           // objects.add(bundle);
     
        }
        
        //
        // Call to get Custom Objects
        //
       // List<String> custom = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Custom?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nCustom: " + custom);
           // objects.add(custom);
     
        }
        
        //
        // Call to get ObjectConfig Objects
        //
       // List<String> objectConfig = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/ObjectConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nObjectConfig: " + objectConfig);
           // objects.add(objectConfig);
        }
        
        //
        // Call to get Policy Objects
        //
        //List<String> policy = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Policy?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nPolicy: " + policy);
           //objects.add(policy);
     
        }
        
        //
        // Call to get Rule Objects
        //
        //List<String> rule = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Rule?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nRule: " + rule);
          //  objects.add(rule);
     
        }
        
        //
        // Call to get UIConfig Objects
        //
     
        //List<String> uiConfig = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/UIConfig?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
         //   log.debug("\nuiConfig: " + uiConfig);
          //  objects.add(uiConfig);
        }
        
        //
        // Call to get Workflow Objects
        //
        //List<String> workflow = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/Workflow?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
            //log.debug("\nWorkflow: " + workflow);
          //  objects.add(workflow);
     
        }
        
        
        //
        // Call to get LifeCycle Events(IdentityTrigger) Objects
        //
        //List<String> identityTrigger = new ArrayList<>();
        iiqRequest = "http://" + iiqIP + ":" + String.valueOf(iiqPort) + "/diff/rest/debug/IdentityTrigger?listObjects";
        log.debug("\nRequest: " + iiqRequest);
        request = new HttpGet(iiqRequest);
        response = client.execute(request);
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        line = "";
        while ((line = rd.readLine()) != null) {
            JSONObject jsonObject = new JSONObject(line);
            JSONArray objResponse = (JSONArray) jsonObject.get("objects");
            

            for(int i=0; i<objResponse.length(); i++){
            	objects.add(objResponse.getJSONObject(i).getString("name"));
            }
           // log.debug("\nidentityTrigger: " + identityTrigger);
           // objects.add(identityTrigger);
        }
           
        } catch (Exception e) {
        	log.debug("Exception:" + e.toString());

    }

    
}
    
    public void compareObjects() {
    	log.debug("starting comparison test");
    	Collection<String> similar = new HashSet<String>( cleanObjects );
        Collection<String> different = new HashSet<String>();
        different.addAll( cleanObjects );
        different.addAll( objects );

        similar.retainAll( objects );
        different.removeAll( similar );

        log.debug("\nSimilar: " + similar +  "\nDifferent: " + different);
    	
    	
    }
}

