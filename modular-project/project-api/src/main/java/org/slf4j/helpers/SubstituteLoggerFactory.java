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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

/**
 * SubstituteLoggerFactory manages instances of {@link SubstituteLogger}.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @author Chetan Mehrotra
 */
public class SubstituteLoggerFactory implements ILoggerFactory {

    volatile boolean postInitialization = false;

    final Map<String, SubstituteLogger> loggers = new ConcurrentHashMap<>();

    final LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = new LinkedBlockingQueue<>();

    public synchronized Logger getLogger(String name) {
        SubstituteLogger logger = loggers.get(name);
        if (logger == null) {
            logger = new SubstituteLogger(name, eventQueue, postInitialization);
            loggers.put(name, logger);
        }
        return logger;
    }

    public List<String> getLoggerNames() {
        return new ArrayList<>(loggers.keySet());
    }

    public List<SubstituteLogger> getLoggers() {
        return new ArrayList<>(loggers.values());
    }

    public LinkedBlockingQueue<SubstituteLoggingEvent> getEventQueue() {
        return eventQueue;
    }

    public void postInitialization() {
        postInitialization = true;
    }

    public void clear() {
        loggers.clear();
        eventQueue.clear();
    }
}
