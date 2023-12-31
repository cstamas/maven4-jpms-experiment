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

import org.slf4j.spi.LocationAwareLogger;

public class EventConstants {
    public static final int ERROR_INT = LocationAwareLogger.ERROR_INT;
    public static final int WARN_INT = LocationAwareLogger.WARN_INT;
    public static final int INFO_INT = LocationAwareLogger.INFO_INT;
    public static final int DEBUG_INT = LocationAwareLogger.DEBUG_INT;
    public static final int TRACE_INT = LocationAwareLogger.TRACE_INT;
    public static final String NA_SUBST = "NA/SubstituteLogger";
}
