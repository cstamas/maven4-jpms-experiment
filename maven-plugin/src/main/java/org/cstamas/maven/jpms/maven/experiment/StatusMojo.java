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
        System.out.println("Dependencies BEGIN");
        for (DependencyCoordinate dependencyCoordinate : project.getDependencies()) {
            dumpDependency(dependencyCoordinate);
        }
        System.out.println("Dependencies END");
    }

    private void dumpDependency(DependencyCoordinate d) {
        String info = "* " + d.getGroupId() + ":" + d.getArtifactId() + ":" + d.getVersion() + " ";
        ArrayList<String> flags = new ArrayList<>();
        if (d.getType().getTypeProperties().checkFlag(DependencyProperties.FLAG_INCLUDES_DEPENDENCIES)) {
            flags.add("ID");
        }
        if (d.getType().getTypeProperties().checkFlag(DependencyProperties.FLAG_CLASS_PATH_CONSTITUENT)) {
            flags.add("CP");
        }
        if (d.getType().getTypeProperties().checkFlag(DependencyProperties.FLAG_MODULE_PATH_CONSTITUENT)) {
            flags.add("MP");
        }
        if (d.getType().getTypeProperties().checkFlag(DependencyProperties.FLAG_IS_JAVA_AGENT)) {
            flags.add("AG");
        }
        if (d.getType().getTypeProperties().checkFlag(DependencyProperties.FLAG_IS_JAVA_ANNOTATION_PROCESSOR)) {
            flags.add("AP");
        }
        if (d.getType().getTypeProperties().checkFlag(DependencyProperties.FLAG_IS_JAVA_DOCLET)) {
            flags.add("DOC");
        }
        System.out.println(info + flags);
    }
}
