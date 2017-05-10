package org.apache.tinkerpop.gremlin.redigraph.api;

import redis.clients.jedis.BuilderFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

public class Client {
    private JedisPool pool;

    Jedis _conn() {
        return pool.getResource();
    }

    public Client(String host, int port) {
        pool = new JedisPool(host, port);
    }

    public String createNode(Map<String, String> propertyKeyValues) {
        Jedis conn = _conn();
        String id = conn.getClient().sendCommand(Commands.Command.CREATENODE, "foo", "a", "1").getBulkReply();
        conn.close();
        return id;
    }

    public Map<String, String> getNodeById(String id) {
        Jedis conn = _conn();
        Map<String, String> properties = conn.hgetAll(id);
        conn.close();
        return properties;
    }

    public List<Object> allNodes(String graphID) {
        Jedis conn = _conn();
        List<Object> resp = conn.getClient().sendCommand(Commands.Command.ALLNODES, graphID).getObjectMultiBulkReply();
        conn.close();
        return resp;
    }

    public boolean connectNodes(String graphID, RedisNode src, RedisNode dest, String type) {
        Jedis conn = _conn();
        String rep = conn.getClient()
                .sendCommand(Commands.Command.ADDEDGE, graphID, src.id, type, dest.id)
                .getStatusCodeReply();
        conn.close();
        return rep.equals("OK");
    }

    public boolean disconnecttNodes(String graphID, RedisNode src, RedisNode dest, String type) {
        Jedis conn = _conn();
        String rep = conn.getClient()
                .sendCommand(Commands.Command.REMOVEEDGE, graphID, src.id, type, dest.id)
                .getStatusCodeReply();
        conn.close();
        return rep.equals("OK");
    }

    public ResultSet query(String graphID, String query) {
        Jedis conn = _conn();
        List<Object> resp = conn.getClient().sendCommand(Commands.Command.QUERY, graphID, query).getObjectMultiBulkReply();
        return new ResultSet(resp);
    }

    public boolean deleteGraph(String graphID) {
        Jedis conn = _conn();
        String rep = conn.getClient()
                .sendCommand(Commands.Command.DELETEGRAPH, graphID)
                .getStatusCodeReply();
        conn.close();
        return rep.equals("OK");
    }
}
