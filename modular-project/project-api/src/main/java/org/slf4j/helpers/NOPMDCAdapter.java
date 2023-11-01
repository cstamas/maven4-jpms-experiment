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

import java.util.Deque;
import java.util.Map;

import org.slf4j.spi.MDCAdapter;

/**
 * This adapter is an empty implementation of the {@link MDCAdapter} interface.
 * It is used for all logging systems which do not support mapped
 * diagnostic contexts such as JDK14, simple and NOP.
 *
 * @author Ceki G&uuml;lc&uuml;
 *
 * @since 1.4.1
 */
public class NOPMDCAdapter implements MDCAdapter {

    public void clear() {}

    public String get(String key) {
        return null;
    }

    public void put(String key, String val) {}

    public void remove(String key) {}

    public Map<String, String> getCopyOfContextMap() {
        return null;
    }

    public void setContextMap(Map<String, String> contextMap) {
        // NOP
    }

    @Override
    public void pushByKey(String key, String value) {}

    @Override
    public String popByKey(String key) {
        return null;
    }

    @Override
    public Deque<String> getCopyOfDequeByKey(String key) {
        return null;
    }

    public void clearDequeByKey(String key) {}
}
