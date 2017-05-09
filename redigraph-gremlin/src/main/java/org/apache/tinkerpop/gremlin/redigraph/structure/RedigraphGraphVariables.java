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

import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.util.GraphVariableHelper;
import org.apache.tinkerpop.gremlin.structure.util.StringFactory;
import org.neo4j.tinkerpop.api.Neo4jGraphAPI;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public final class RedigraphGraphVariables implements Graph.Variables {

    private final RedigraphGraph graph;

    protected RedigraphGraphVariables(final RedigraphGraph graph) {
        this.graph = graph;
    }


    @Override
    public String toString() {
        return StringFactory.graphVariablesString(this);
    }

    @Override
    public Set<String> keys() {
        return null;
    }

    @Override
    public <R> Optional<R> get(String key) {
        return null;
    }

    @Override
    public void set(String key, Object value) {

    }

    @Override
    public void remove(String key) {

    }

    public static class Neo4jVariableFeatures implements Graph.Features.VariableFeatures {
        @Override
        public boolean supportsBooleanValues() {
            return true;
        }

        @Override
        public boolean supportsDoubleValues() {
            return true;
        }

        @Override
        public boolean supportsFloatValues() {
            return true;
        }

        @Override
        public boolean supportsIntegerValues() {
            return true;
        }

        @Override
        public boolean supportsLongValues() {
            return true;
        }

        @Override
        public boolean supportsMapValues() {
            return false;
        }

        @Override
        public boolean supportsMixedListValues() {
            return false;
        }

        @Override
        public boolean supportsByteValues() {
            return false;
        }

        @Override
        public boolean supportsBooleanArrayValues() {
            return true;
        }

        @Override
        public boolean supportsByteArrayValues() {
            return false;
        }

        @Override
        public boolean supportsDoubleArrayValues() {
            return true;
        }

        @Override
        public boolean supportsFloatArrayValues() {
            return true;
        }

        @Override
        public boolean supportsIntegerArrayValues() {
            return true;
        }

        @Override
        public boolean supportsLongArrayValues() {
            return true;
        }

        @Override
        public boolean supportsStringArrayValues() {
            return true;
        }

        @Override
        public boolean supportsSerializableValues() {
            return false;
        }

        @Override
        public boolean supportsStringValues() {
            return true;
        }

        @Override
        public boolean supportsUniformListValues() {
            return false;
        }
    }
}