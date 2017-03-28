
package com.onaware.util;

import java.util.Date;

/**
 * Utility class for the plugin.
 *
 */
public class CompareUtil {

    /**
     * The plugin name.
     */
    public static final String PLUGIN_NAME = "EnvCom";

    /**
     * Timestamp for this moment in time.
     *
     * @return The timestamp.
     */
    public static long now() {
        return new Date().getTime();
    }

}

