package org.apache.tinkerpop.gremlin.redigraph.api;


import java.util.Map;

public class RedisNode {
    String id;
    String label;
    Object[] properties;

    public RedisNode(String id, String label, Object... properties) {
        this.id = id;
        this.label = label;
        this.properties = properties;
    }

    public String getId(){
        return this.id;
    }
}
