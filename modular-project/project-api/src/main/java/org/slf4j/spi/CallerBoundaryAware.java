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

import org.slf4j.event.LoggingEvent;

/**
 * Additional interface to {@link LoggingEventBuilder} and
 * {@link org.slf4j.event.LoggingEvent LoggingEvent}.
 *
 * Implementations of {@link LoggingEventBuilder} and  {@link LoggingEvent} may optionally
 * implement {@link CallerBoundaryAware} in order to support caller info extraction.
 *
 * This interface is intended for use by logging backends or logging bridges.
 *
 * @author Ceki Gulcu
 *
 */
public interface CallerBoundaryAware {

    /**
     * Add a fqcn (fully qualified class name) to this event, presumed to be the caller boundary.
     *
     * @param fqcn
     */
    void setCallerBoundary(String fqcn);
}
