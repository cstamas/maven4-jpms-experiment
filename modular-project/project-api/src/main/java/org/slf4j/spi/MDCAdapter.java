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
package org.slf4j.spi;

import java.util.Deque;
import java.util.Map;

/**
 * This interface abstracts the service offered by various MDC
 * implementations.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.4.1
 */
public interface MDCAdapter {

    /**
     * Put a context value (the <code>val</code> parameter) as identified with
     * the <code>key</code> parameter into the current thread's context map.
     * The <code>key</code> parameter cannot be null. The <code>val</code> parameter
     * can be null only if the underlying implementation supports it.
     *
     * <p>If the current thread does not have a context map it is created as a side
     * effect of this call.
     */
    public void put(String key, String val);

    /**
     * Get the context identified by the <code>key</code> parameter.
     * The <code>key</code> parameter cannot be null.
     *
     * @return the string value identified by the <code>key</code> parameter.
     */
    public String get(String key);

    /**
     * Remove the context identified by the <code>key</code> parameter.
     * The <code>key</code> parameter cannot be null.
     *
     * <p>
     * This method does nothing if there is no previous value
     * associated with <code>key</code>.
     */
    public void remove(String key);

    /**
     * Clear all entries in the MDC.
     */
    public void clear();

    /**
     * Return a copy of the current thread's context map, with keys and
     * values of type String. Returned value may be null.
     *
     * @return A copy of the current thread's context map. May be null.
     * @since 1.5.1
     */
    public Map<String, String> getCopyOfContextMap();

    /**
     * Set the current thread's context map by first clearing any existing
     * map and then copying the map passed as parameter. The context map
     * parameter must only contain keys and values of type String.
     *
     * Implementations must support null valued map passed as parameter.
     *
     * @param contextMap must contain only keys and values of type String
     *
     * @since 1.5.1
     */
    public void setContextMap(Map<String, String> contextMap);

    /**
     * Push a value into the deque(stack) referenced by 'key'.
     *
     * @param key identifies the appropriate stack
     * @param value the value to push into the stack
     * @since 2.0.0
     */
    public void pushByKey(String key, String value);

    /**
     * Pop the stack referenced by 'key' and return the value possibly null.
     *
     * @param key identifies the deque(stack)
     * @return the value just popped. May be null/
     * @since 2.0.0
     */
    public String popByKey(String key);

    /**
     * Returns a copy of the deque(stack) referenced by 'key'. May be null.
     *
     * @param key identifies the  stack
     * @return copy of stack referenced by 'key'. May be null.
     *
     * @since 2.0.0
     */
    public Deque<String> getCopyOfDequeByKey(String key);

    /**
     * Clear the deque(stack) referenced by 'key'.
     *
     * @param key identifies the  stack
     *
     * @since 2.0.0
     */
    public void clearDequeByKey(String key);
}
