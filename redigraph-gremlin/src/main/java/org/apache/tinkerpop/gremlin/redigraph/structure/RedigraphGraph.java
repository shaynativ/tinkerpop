/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.redigraph.structure;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.tinkerpop.gremlin.process.computer.GraphComputer;
import org.apache.tinkerpop.gremlin.structure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.tinkerpop.gremlin.redigraph.api.*;

import java.util.*;

public final class RedigraphGraph implements Graph {

    public static final Logger LOGGER = LoggerFactory.getLogger(RedigraphGraph.class);

    private static final Configuration EMPTY_CONFIGURATION = new BaseConfiguration() {{
        this.setProperty(Graph.GRAPH, RedigraphGraph.class.getName());
    }};

    private final Configuration configuration;

    private final Client client;

    private RedigraphGraph(final Configuration configuration) {
        this.configuration = configuration;
        this.client = new Client("localhost", 6379);
    }

    public static RedigraphGraph open() {
        return open(EMPTY_CONFIGURATION);
    }

    public static RedigraphGraph open(final Configuration configuration) {
        return new RedigraphGraph(configuration);
    }

    @Override
    public Vertex addVertex(Object... keyValues) {
        LOGGER.warn("addVertex");
        Map<String, String> attributes = new HashMap<String, String>();

        for (int i = 0; i < keyValues.length; i = i + 2) {
            attributes.put(keyValues[i].toString(), keyValues[i+1].toString());
        }
        String id = client.createNode(attributes);
        LOGGER.warn("gotid: " + id);
        return null;
    }

    @Override
    public <C extends GraphComputer> C compute(Class<C> graphComputerClass) throws IllegalArgumentException {
        return null;
    }

    @Override
    public GraphComputer compute() throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterator<Vertex> vertices(Object... vertexIds) {
        return null;
    }

    @Override
    public Iterator<Edge> edges(Object... edgeIds) {
        return null;
    }

    @Override
    public Transaction tx() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public Variables variables() {
        return null;
    }

    @Override
    public Configuration configuration() {
        return null;
    }
}
