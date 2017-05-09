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
package org.apache.tinkerpop.gremlin.redigraph.jsr223;

import org.apache.tinkerpop.gremlin.jsr223.AbstractGremlinPlugin;
import org.apache.tinkerpop.gremlin.jsr223.DefaultImportCustomizer;
import org.apache.tinkerpop.gremlin.jsr223.ImportCustomizer;
import org.apache.tinkerpop.gremlin.redigraph.structure.*;
import org.apache.tinkerpop.gremlin.redigraph.structure.RedigraphElement;

/**
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public final class RedigraphGremlinPlugin extends AbstractGremlinPlugin {

    private static final String NAME = "tinkerpop.redigraph";

    private static final ImportCustomizer imports;

    static {
        try {
            imports = DefaultImportCustomizer.build()
                    .addClassImports(RedigraphEdge.class,
                            RedigraphElement.class,
                            RedigraphGraph.class,
                            RedigraphGraphVariables.class,
                            RedigraphHelper.class,
                            RedigraphProperty.class,
                            RedigraphVertex.class,
                            RedigraphVertexProperty.class)
                    .create();
//                    .addMethodImports(LabelP.class.getMethod("of", String.class)).create();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static final RedigraphGremlinPlugin instance = new RedigraphGremlinPlugin();

    public RedigraphGremlinPlugin() {
        super(NAME, imports);
    }

    public static RedigraphGremlinPlugin instance() {
        return instance;
    }

    @Override
    public boolean requireRestart() {
        return true;
    }
}