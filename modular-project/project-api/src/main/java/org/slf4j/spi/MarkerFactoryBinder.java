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

import org.slf4j.IMarkerFactory;

/**
 * An internal interface which helps the static {@link org.slf4j.MarkerFactory}
 * class bind with the appropriate {@link IMarkerFactory} instance.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @deprecated
 */
public interface MarkerFactoryBinder {

    /**
     * Return the instance of {@link IMarkerFactory} that
     * {@link org.slf4j.MarkerFactory} class should bind to.
     *
     * @return the instance of {@link IMarkerFactory} that
     * {@link org.slf4j.MarkerFactory} class should bind to.
     */
    public IMarkerFactory getMarkerFactory();

    /**
     * The String form of the {@link IMarkerFactory} object that this
     * <code>MarkerFactoryBinder</code> instance is <em>intended</em> to return.
     *
     * <p>This method allows the developer to interrogate this binder's intention
     * which may be different from the {@link IMarkerFactory} instance it is able to
     * return. Such a discrepancy should only occur in case of errors.
     *
     * @return the class name of the intended {@link IMarkerFactory} instance
     */
    public String getMarkerFactoryClassStr();
}
