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

import java.lang.annotation.*;

/**
 * <p>Used to annotate methods in the {@link org.slf4j.spi.LoggingEventBuilder} interface
 * which return an instance of LoggingEventBuilder (usually as <code>this</code>). Such
 * methods should be followed by one of the terminating <code>log()</code> methods returning
 * <code>void</code>.</p>
 * <p></p>
 * <p>IntelliJ IDEA supports a check for annotations named as <code>CheckReturnValue</code>
 * regardless of the containing package. For more information on this feature in IntelliJ IDEA,
 * select File &#8594; Setting &#8594; Editor &#8594; Inspections and then Java &#8594; Probable Bugs &#8594;
 * Result of method call ignored. </p>
 * <p></p>
 *
 * <p>As for Eclipse, this feature has been requested in
 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=572496">bug 572496</a></p>
 *
 * @author Ceki G&uuml;lc&uuml;
 * @since 2.0.0-beta1
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckReturnValue {}
