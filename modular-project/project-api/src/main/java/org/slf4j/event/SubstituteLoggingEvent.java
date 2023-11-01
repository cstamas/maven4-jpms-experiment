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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

public class SubstituteLoggingEvent implements LoggingEvent {

    Level level;
    List<Marker> markers;
    String loggerName;
    SubstituteLogger logger;
    String threadName;
    String message;
    Object[] argArray;
    List<KeyValuePair> keyValuePairList;

    long timeStamp;
    Throwable throwable;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void addMarker(Marker marker) {
        if (marker == null) return;

        if (markers == null) {
            markers = new ArrayList<>(2);
        }

        markers.add(marker);
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public SubstituteLogger getLogger() {
        return logger;
    }

    public void setLogger(SubstituteLogger logger) {
        this.logger = logger;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgumentArray() {
        return argArray;
    }

    public void setArgumentArray(Object[] argArray) {
        this.argArray = argArray;
    }

    @Override
    public List<Object> getArguments() {
        if (argArray == null) {
            return null;
        }
        return Arrays.asList(argArray);
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public List<KeyValuePair> getKeyValuePairs() {
        return keyValuePairList;
    }
}
