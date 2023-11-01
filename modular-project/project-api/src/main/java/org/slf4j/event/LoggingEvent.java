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
package org.slf4j.event;

import java.util.List;

import org.slf4j.Marker;

/**
 * The minimal interface sufficient for the restitution of data passed
 * by the user to the SLF4J API.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.7.15
 */
public interface LoggingEvent {

    Level getLevel();

    String getLoggerName();

    String getMessage();

    List<Object> getArguments();

    Object[] getArgumentArray();

    List<Marker> getMarkers();

    List<KeyValuePair> getKeyValuePairs();

    Throwable getThrowable();

    long getTimeStamp();

    String getThreadName();

    /**
     * Returns the presumed caller boundary provided by the logging library (not the user of the library).
     * Null by default.
     *
     * @return presumed caller, null by default.
     */
    default String getCallerBoundary() {
        return null;
    }
}
