package org.apache.tinkerpop.gremlin.redigraph.api;


import java.util.Map;

public class RedisNode {
    String id;
    Map<String, String> properties;

    public RedisNode(String id, Map<String, String> properties) {
        this.id = id;
        this.properties = properties;
    }
}
