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

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * An <b>optional</b> interface helping integration with logging systems capable of
 * extracting location information. This interface is mainly used by SLF4J bridges
 * such as jcl-over-slf4j, jul-to-slf4j and log4j-over-slf4j or {@link Logger} wrappers
 * which need to provide hints so that the underlying logging system can extract
 * the correct location information (method name, line number).
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 1.3
 */
public interface LocationAwareLogger extends Logger {

    // these constants should be in EventConstants. However, in order to preserve binary backward compatibility
    // we keep these constants here. {@link EventConstants} redefines these constants using the values  below.
    public final int TRACE_INT = 00;
    public final int DEBUG_INT = 10;
    public final int INFO_INT = 20;
    public final int WARN_INT = 30;
    public final int ERROR_INT = 40;

    /**
     * Printing method with support for location information.
     *
     * @param marker The marker to be used for this event, may be null.
     *
     * @param fqcn The fully qualified class name of the <b>logger instance</b>,
     * typically the logger class, logger bridge or a logger wrapper.
     *
     * @param level One of the level integers defined in this interface
     *
     * @param message The message for the log event
     * @param t Throwable associated with the log event, may be null.
     */
    public void log(Marker marker, String fqcn, int level, String message, Object[] argArray, Throwable t);
}
