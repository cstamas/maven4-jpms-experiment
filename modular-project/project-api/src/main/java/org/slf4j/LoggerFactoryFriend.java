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
 * All methods in this class are reserved for internal use, for testing purposes.
 *
 * <p>They can be modified, renamed or removed at any time without notice.
 *
 * <p>You are strongly discouraged calling any of the methods of this class.
 *
 * @since 1.8.0
 *
 *  @author Ceki G&uuml;lc&uuml;
 */
public class LoggerFactoryFriend {

    /*
     * Force LoggerFactory to consider itself uninitialized.
     */
    public static void reset() {
        LoggerFactory.reset();
    }

    /**
     * Set LoggerFactory.DETECT_LOGGER_NAME_MISMATCH variable.
     *
     * @param enabled a boolean
     */
    public static void setDetectLoggerNameMismatch(boolean enabled) {
        LoggerFactory.DETECT_LOGGER_NAME_MISMATCH = enabled;
    }
}
