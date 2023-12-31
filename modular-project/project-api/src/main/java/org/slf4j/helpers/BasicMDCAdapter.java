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

import java.util.*;

import org.slf4j.spi.MDCAdapter;

/**
 * Basic MDC implementation, which can be used with logging systems that lack
 * out-of-the-box MDC support.
 *
 * This code was initially inspired by  logback's LogbackMDCAdapter. However,
 * LogbackMDCAdapter has evolved and is now considerably more sophisticated.
 *
 * @author Ceki Gulcu
 * @author Maarten Bosteels
 * @author Lukasz Cwik
 *
 * @since 1.5.0
 */
public class BasicMDCAdapter implements MDCAdapter {

    private final ThreadLocalMapOfStacks threadLocalMapOfDeques = new ThreadLocalMapOfStacks();

    private final InheritableThreadLocal<Map<String, String>> inheritableThreadLocalMap =
            new InheritableThreadLocal<Map<String, String>>() {
                @Override
                protected Map<String, String> childValue(Map<String, String> parentValue) {
                    if (parentValue == null) {
                        return null;
                    }
                    return new HashMap<>(parentValue);
                }
            };

    /**
     * Put a context value (the <code>val</code> parameter) as identified with
     * the <code>key</code> parameter into the current thread's context map.
     * Note that contrary to log4j, the <code>val</code> parameter can be null.
     *
     * <p>
     * If the current thread does not have a context map it is created as a side
     * effect of this call.
     *
     * @throws IllegalArgumentException
     *                 in case the "key" parameter is null
     */
    public void put(String key, String val) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> map = inheritableThreadLocalMap.get();
        if (map == null) {
            map = new HashMap<>();
            inheritableThreadLocalMap.set(map);
        }
        map.put(key, val);
    }

    /**
     * Get the context identified by the <code>key</code> parameter.
     */
    public String get(String key) {
        Map<String, String> map = inheritableThreadLocalMap.get();
        if ((map != null) && (key != null)) {
            return map.get(key);
        } else {
            return null;
        }
    }

    /**
     * Remove the context identified by the <code>key</code> parameter.
     */
    public void remove(String key) {
        Map<String, String> map = inheritableThreadLocalMap.get();
        if (map != null) {
            map.remove(key);
        }
    }

    /**
     * Clear all entries in the MDC.
     */
    public void clear() {
        Map<String, String> map = inheritableThreadLocalMap.get();
        if (map != null) {
            map.clear();
            inheritableThreadLocalMap.remove();
        }
    }

    /**
     * Returns the keys in the MDC as a {@link Set} of {@link String}s The
     * returned value can be null.
     *
     * @return the keys in the MDC
     */
    public Set<String> getKeys() {
        Map<String, String> map = inheritableThreadLocalMap.get();
        if (map != null) {
            return map.keySet();
        } else {
            return null;
        }
    }

    /**
     * Return a copy of the current thread's context map.
     * Returned value may be null.
     *
     */
    public Map<String, String> getCopyOfContextMap() {
        Map<String, String> oldMap = inheritableThreadLocalMap.get();
        if (oldMap != null) {
            return new HashMap<>(oldMap);
        } else {
            return null;
        }
    }

    public void setContextMap(Map<String, String> contextMap) {
        Map<String, String> copy = null;
        if (contextMap != null) {
            copy = new HashMap<>(contextMap);
        }
        inheritableThreadLocalMap.set(copy);
    }

    @Override
    public void pushByKey(String key, String value) {
        threadLocalMapOfDeques.pushByKey(key, value);
    }

    @Override
    public String popByKey(String key) {
        return threadLocalMapOfDeques.popByKey(key);
    }

    @Override
    public Deque<String> getCopyOfDequeByKey(String key) {
        return threadLocalMapOfDeques.getCopyOfDequeByKey(key);
    }

    @Override
    public void clearDequeByKey(String key) {
        threadLocalMapOfDeques.clearDequeByKey(key);
    }
}
