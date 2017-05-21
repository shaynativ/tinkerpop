package org.apache.tinkerpop.gremlin.redigraph.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RedisGraphAPI {

    Client client;
    String graphID;

    public RedisGraphAPI(String graphID) {
        this.graphID = graphID;
        client = new Client("localhost", 6379);
    }

    public RedisNode createNode(Object... propertyKeyValues) {
        String id = client.createNode(propertyKeyValues);
        String label = null;
        if (propertyKeyValues.length%2 == 1){
            label = propertyKeyValues[0].toString();
        }
        return new RedisNode(id, label, propertyKeyValues);
    }

    public RedisNode getNodeById(String id) {
//        Map<String, String> properties = client.getNodeById(id);
        return new RedisNode(id, "", null);
    }

    public Iterable<RedisNode> allNodes() {
        ArrayList<RedisNode> nodes = new ArrayList<RedisNode>();
        List<Object> nodeIDs = client.allNodes(graphID);

        for(int i = 0; i < nodeIDs.size(); i++) {
            String nodeID = nodeIDs.get(i).toString();
            RedisNode node = getNodeById(nodeID);
            nodes.add(node);
        }

        return nodes;
    }

    public void connectNodes(RedisNode src, RedisNode dest, String type) {
        client.connectNodes(graphID, src, dest, type);
    }

    public void disConnectNodes(RedisNode src, RedisNode dest, String type) {
        client.disconnecttNodes(graphID, src, dest, type);
    }

    public ResultSet query(String query) {
        return client.query(graphID, query);
    }
}
