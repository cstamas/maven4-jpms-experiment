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
 * <code>ILoggerFactory</code> instances manufacture {@link Logger}
 * instances by name.
 *
 * <p>Most users retrieve {@link Logger} instances through the static
 * {@link LoggerFactory#getLogger(String)} method. An instance of this
 * interface is bound internally with {@link LoggerFactory} class at
 * compile time.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public interface ILoggerFactory {

    /**
     * Return an appropriate {@link Logger} instance as specified by the
     * <code>name</code> parameter.
     *
     * <p>If the name parameter is equal to {@link Logger#ROOT_LOGGER_NAME}, that is
     * the string value "ROOT" (case insensitive), then the root logger of the
     * underlying logging system is returned.
     *
     * <p>Null-valued name arguments are considered invalid.
     *
     * <p>Certain extremely simple logging systems, e.g. NOP, may always
     * return the same logger instance regardless of the requested name.
     *
     * @param name the name of the Logger to return
     * @return a Logger instance
     */
    public Logger getLogger(String name);
}
