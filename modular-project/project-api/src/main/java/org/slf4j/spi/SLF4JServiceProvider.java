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

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * This interface based on {@link java.util.ServiceLoader} paradigm.
 *
 * <p>It replaces the old static-binding mechanism used in SLF4J versions 1.0.x to 1.7.x.
 *
 * @author Ceki G&uml;lc&uml;
 * @since 1.8
 */
public interface SLF4JServiceProvider {

    /**
     * Return the instance of {@link ILoggerFactory} that
     * {@link org.slf4j.LoggerFactory} class should bind to.
     *
     * @return instance of {@link ILoggerFactory}
     */
    public ILoggerFactory getLoggerFactory();

    /**
     * Return the instance of {@link IMarkerFactory} that
     * {@link org.slf4j.MarkerFactory} class should bind to.
     *
     * @return instance of {@link IMarkerFactory}
     */
    public IMarkerFactory getMarkerFactory();

    /**
     * Return the instance of {@link MDCAdapter} that
     * {@link MDC} should bind to.
     *
     * @return instance of {@link MDCAdapter}
     */
    public MDCAdapter getMDCAdapter();

    /**
     * Return the maximum API version for SLF4J that the logging
     * implementation supports.
     *
     * <p>For example: {@code "2.0.1"}.
     *
     * @return the string API version.
     */
    public String getRequestedApiVersion();

    /**
     * Initialize the logging back-end.
     *
     * <p><b>WARNING:</b> This method is intended to be called once by
     * {@link LoggerFactory} class and from nowhere else.
     *
     */
    public void initialize();
}
