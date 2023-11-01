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

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * A direct NOP (no operation) implementation of {@link Logger}.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public class NOPLogger extends NamedLoggerBase implements Logger {

    private static final long serialVersionUID = -517220405410904473L;

    /**
     * The unique instance of NOPLogger.
     */
    public static final NOPLogger NOP_LOGGER = new NOPLogger();

    /**
     * There is no point in creating multiple instances of NOPLogger.
     *
     * The present constructor should be "private" but we are leaving it as "protected" for compatibility.
     */
    protected NOPLogger() {}

    /**
     * Always returns the string value "NOP".
     */
    @Override
    public String getName() {
        return "NOP";
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    public final boolean isTraceEnabled() {
        return false;
    }

    /** A NOP implementation. */
    @Override
    public final void trace(String msg) {
        // NOP
    }

    /** A NOP implementation.  */
    @Override
    public final void trace(String format, Object arg) {
        // NOP
    }

    /** A NOP implementation.  */
    @Override
    public final void trace(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    @Override
    public final void trace(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void trace(String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    public final boolean isDebugEnabled() {
        return false;
    }

    /** A NOP implementation. */
    public final void debug(String msg) {
        // NOP
    }

    /** A NOP implementation.  */
    public final void debug(String format, Object arg) {
        // NOP
    }

    /** A NOP implementation.  */
    public final void debug(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    public final void debug(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    public final void debug(String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    public final boolean isInfoEnabled() {
        // NOP
        return false;
    }

    /** A NOP implementation. */
    public final void info(String msg) {
        // NOP
    }

    /** A NOP implementation. */
    public final void info(String format, Object arg1) {
        // NOP
    }

    /** A NOP implementation. */
    public final void info(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    public final void info(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    public final void info(String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    public final boolean isWarnEnabled() {
        return false;
    }

    /** A NOP implementation. */
    public final void warn(String msg) {
        // NOP
    }

    /** A NOP implementation. */
    public final void warn(String format, Object arg1) {
        // NOP
    }

    /** A NOP implementation. */
    public final void warn(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    public final void warn(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    public final void warn(String msg, Throwable t) {
        // NOP
    }

    /** A NOP implementation. */
    public final boolean isErrorEnabled() {
        return false;
    }

    /** A NOP implementation. */
    public final void error(String msg) {
        // NOP
    }

    /** A NOP implementation. */
    public final void error(String format, Object arg1) {
        // NOP
    }

    /** A NOP implementation. */
    public final void error(String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation.  */
    public final void error(String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    public final void error(String msg, Throwable t) {
        // NOP
    }

    // ============================================================
    // Added NOP methods since MarkerIgnoringBase is now deprecated
    // ============================================================
    /**
     * Always returns false.
     * @return always false
     */
    public final boolean isTraceEnabled(Marker marker) {
        // NOP
        return false;
    }

    /** A NOP implementation. */
    @Override
    public final void trace(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void trace(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void trace(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void trace(Marker marker, String format, Object... argArray) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void trace(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    public final boolean isDebugEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    public final void debug(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void debug(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void debug(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    @Override
    public final void debug(Marker marker, String format, Object... arguments) {
        // NOP
    }

    @Override
    public final void debug(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    public final void info(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void info(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void info(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void info(Marker marker, String format, Object... arguments) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void info(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    public final boolean isWarnEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    public final void warn(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void warn(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void warn(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void warn(Marker marker, String format, Object... arguments) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void warn(Marker marker, String msg, Throwable t) {
        // NOP
    }

    /**
     * Always returns false.
     * @return always false
     */
    @Override
    public final boolean isErrorEnabled(Marker marker) {
        return false;
    }

    /** A NOP implementation. */
    @Override
    public final void error(Marker marker, String msg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void error(Marker marker, String format, Object arg) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void error(Marker marker, String format, Object arg1, Object arg2) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void error(Marker marker, String format, Object... arguments) {
        // NOP
    }

    /** A NOP implementation. */
    @Override
    public final void error(Marker marker, String msg, Throwable t) {
        // NOP
    }
    // ===================================================================
    // End of added NOP methods since MarkerIgnoringBase is now deprecated
    // ===================================================================

}
