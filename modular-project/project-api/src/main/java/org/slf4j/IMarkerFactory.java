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

/**
 * Implementations of this interface are used to manufacture {@link Marker}
 * instances.
 *
 * <p>See the section <a href="http://slf4j.org/faq.html#3">Implementing
 * the SLF4J API</a> in the FAQ for details on how to make your logging
 * system conform to SLF4J.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public interface IMarkerFactory {

    /**
     * Manufacture a {@link Marker} instance by name. If the instance has been
     * created earlier, return the previously created instance.
     *
     * <p>Null name values are not allowed.
     *
     * @param name the name of the marker to be created, null value is
     * not allowed.
     *
     * @return a Marker instance
     */
    Marker getMarker(String name);

    /**
     * Checks if the marker with the name already exists. If name is null, then false
     * is returned.
     *
     * @param name logger name to check for
     * @return true id the marker exists, false otherwise.
     */
    boolean exists(String name);

    /**
     * Detach an existing marker.
     * <p>
     * Note that after a marker is detached, there might still be "dangling" references
     * to the detached marker.
     *
     *
     * @param name The name of the marker to detach
     * @return whether the marker  could be detached or not
     */
    boolean detachMarker(String name);

    /**
     * Create a marker which is detached (even at birth) from this IMarkerFactory.
     *
     * @param name marker name
     * @return a dangling marker
     * @since 1.5.1
     */
    Marker getDetachedMarker(String name);
}
