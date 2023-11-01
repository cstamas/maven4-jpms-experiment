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
package org.cstamas.maven.jpms.maven.experiment;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.api.DependencyCoordinate;
import org.apache.maven.api.DependencyProperties;
import org.apache.maven.api.Project;
import org.apache.maven.api.Session;
import org.apache.maven.api.plugin.Mojo;
import org.apache.maven.api.plugin.annotations.Component;

@org.apache.maven.api.plugin.annotations.Mojo(name = "status", requiresProject = true)
public class StatusMojo implements Mojo {
    @Component
    private Session session;

    @Component
    private Project project;

    @Override
    public void execute() {
        List<DependencyCoordinate> flagged;
        flagged = collectFlagged(DependencyProperties.FLAG_CLASS_PATH_CONSTITUENT, project.getDependencies());
        if (!flagged.isEmpty()) {
            System.out.println("CP:");
            flagged.forEach(d -> System.out.println(d.getArtifactId()));
        }
        flagged = collectFlagged(DependencyProperties.FLAG_MODULE_PATH_CONSTITUENT, project.getDependencies());
        if (!flagged.isEmpty()) {
            System.out.println("MP:");
            flagged.forEach(d -> System.out.println(d.getArtifactId()));
        }
        flagged = collectFlagged(DependencyProperties.FLAG_INCLUDES_DEPENDENCIES, project.getDependencies());
        if (!flagged.isEmpty()) {
            System.out.println("ID:");
            flagged.forEach(d -> System.out.println(d.getArtifactId()));
        }
        flagged = collectFlagged(DependencyProperties.FLAG_INCLUDES_DEPENDENCIES, project.getDependencies());
        if (!flagged.isEmpty()) {
            System.out.println("ID:");
            flagged.forEach(d -> System.out.println(d.getArtifactId()));
        }
    }

    private List<DependencyCoordinate> collectFlagged(String flag, List<DependencyCoordinate> dependencyCoordinates) {
        ArrayList<DependencyCoordinate> flagged = new ArrayList<>();
        for (DependencyCoordinate dependencyCoordinate : dependencyCoordinates) {
            if (dependencyCoordinate.getType().getTypeProperties().checkFlag(flag)) {
                flagged.add(dependencyCoordinate);
            }
        }
        return flagged;
    }
}
