package com.onaware.service;

/**
 * Class containing data for a object.
 *
 * @author John Kennedy
 */
public class Object {

 
    private String className;
    private String objName;
    private String objId;
    private String xml;

  
    public String getClassName() {
        return className;
    }

    /**
     * Gets the user id.
     *
     * @return The user id.
     */
    public String getObjName() {
        return objName;
    }
    
    /**
     * Gets the user id.
     *
     * @return The user id.
     */
    public String getObjId() {
        return objId;
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    public String getXml() {
        return xml;
    }

}
