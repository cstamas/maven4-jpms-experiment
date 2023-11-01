/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.spi.SLF4JServiceProvider;

/**
 * MarkerFactory is a utility class producing {@link Marker} instances as
 * appropriate for the logging system currently in use.
 *
 * <p>
 * This class is essentially implemented as a wrapper around an
 * {@link IMarkerFactory} instance bound at compile time.
 *
 * <p>
 * Please note that all methods in this class are static.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public class MarkerFactory {
    static IMarkerFactory MARKER_FACTORY;

    private MarkerFactory() {}

    // this is where the binding happens
    static {
        SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            MARKER_FACTORY = provider.getMarkerFactory();
        } else {
            Util.report("Failed to find provider");
            Util.report("Defaulting to BasicMarkerFactory.");
            MARKER_FACTORY = new BasicMarkerFactory();
        }
    }

    /**
     * Return a Marker instance as specified by the name parameter using the
     * previously bound {@link IMarkerFactory}instance.
     *
     * @param name
     *          The name of the {@link Marker} object to return.
     * @return marker
     */
    public static Marker getMarker(String name) {
        return MARKER_FACTORY.getMarker(name);
    }

    /**
     * Create a marker which is detached (even at birth) from the MarkerFactory.
     *
     * @param name the name of the marker
     * @return a dangling marker
     * @since 1.5.1
     */
    public static Marker getDetachedMarker(String name) {
        return MARKER_FACTORY.getDetachedMarker(name);
    }

    /**
     * Return the {@link IMarkerFactory}instance in use.
     *
     * <p>The IMarkerFactory instance is usually bound with this class at
     * compile time.
     *
     * @return the IMarkerFactory instance in use
     */
    public static IMarkerFactory getIMarkerFactory() {
        return MARKER_FACTORY;
    }
}
