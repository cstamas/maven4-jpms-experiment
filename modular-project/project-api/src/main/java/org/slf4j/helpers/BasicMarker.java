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

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Marker;

/**
 * A simple implementation of the {@link Marker} interface.
 *
 * @author Ceki G&uuml;lc&uuml;
 * @author Joern Huxhorn
 */
public class BasicMarker implements Marker {

    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private final List<Marker> referenceList = new CopyOnWriteArrayList<>();

    BasicMarker(String name) {
        if (name == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Marker reference) {
        if (reference == null) {
            throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
        }

        // no point in adding the reference multiple times
        if (this.contains(reference)) {
            return;

        } else if (reference.contains(this)) { // avoid recursion
            // a potential reference should not hold its future "parent" as a reference
            return;
        } else {
            referenceList.add(reference);
        }
    }

    public boolean hasReferences() {
        return (referenceList.size() > 0);
    }

    @Deprecated
    public boolean hasChildren() {
        return hasReferences();
    }

    public Iterator<Marker> iterator() {
        return referenceList.iterator();
    }

    public boolean remove(Marker referenceToRemove) {
        return referenceList.remove(referenceToRemove);
    }

    public boolean contains(Marker other) {
        if (other == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }

        if (this.equals(other)) {
            return true;
        }

        if (hasReferences()) {
            for (Marker ref : referenceList) {
                if (ref.contains(other)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is mainly used with Expression Evaluators.
     */
    public boolean contains(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }

        if (this.name.equals(name)) {
            return true;
        }

        if (hasReferences()) {
            for (Marker ref : referenceList) {
                if (ref.contains(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final String OPEN = "[ ";
    private static final String CLOSE = " ]";
    private static final String SEP = ", ";

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Marker)) return false;

        final Marker other = (Marker) obj;
        return name.equals(other.getName());
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        if (!this.hasReferences()) {
            return this.getName();
        }
        Iterator<Marker> it = this.iterator();
        Marker reference;
        StringBuilder sb = new StringBuilder(this.getName());
        sb.append(' ').append(OPEN);
        while (it.hasNext()) {
            reference = it.next();
            sb.append(reference.getName());
            if (it.hasNext()) {
                sb.append(SEP);
            }
        }
        sb.append(CLOSE);

        return sb.toString();
    }
}
