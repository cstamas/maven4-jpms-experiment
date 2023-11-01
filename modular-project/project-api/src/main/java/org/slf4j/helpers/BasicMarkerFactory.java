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
package org.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

/**
 * An almost trivial implementation of the {@link IMarkerFactory}
 * interface which creates {@link BasicMarker} instances.
 *
 * <p>Simple logging systems can conform to the SLF4J API by binding
 * {@link org.slf4j.MarkerFactory} with an instance of this class.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public class BasicMarkerFactory implements IMarkerFactory {

    private final ConcurrentMap<String, Marker> markerMap = new ConcurrentHashMap<>();

    /**
     * Regular users should <em>not</em> create
     * <code>BasicMarkerFactory</code> instances. <code>Marker</code>
     * instances can be obtained using the static {@link
     * org.slf4j.MarkerFactory#getMarker} method.
     */
    public BasicMarkerFactory() {}

    /**
     * Manufacture a {@link BasicMarker} instance by name. If the instance has been
     * created earlier, return the previously created instance.
     *
     * @param name the name of the marker to be created
     * @return a Marker instance
     */
    public Marker getMarker(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }

        Marker marker = markerMap.get(name);
        if (marker == null) {
            marker = new BasicMarker(name);
            Marker oldMarker = markerMap.putIfAbsent(name, marker);
            if (oldMarker != null) {
                marker = oldMarker;
            }
        }
        return marker;
    }

    /**
     * Does the name marked already exist?
     */
    public boolean exists(String name) {
        if (name == null) {
            return false;
        }
        return markerMap.containsKey(name);
    }

    public boolean detachMarker(String name) {
        if (name == null) {
            return false;
        }
        return (markerMap.remove(name) != null);
    }

    public Marker getDetachedMarker(String name) {
        return new BasicMarker(name);
    }
}
