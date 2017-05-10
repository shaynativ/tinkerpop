package org.apache.tinkerpop.gremlin.redigraph.api;

import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.util.SafeEncoder;

public class Commands {
    public enum Command implements ProtocolCommand {

        CREATENODE("graph.CREATENODE"),
        ADDEDGE("graph.ADDEDGE"),
        REMOVEEDGE("graph.REMOVEEDGE"),
        DELETEGRAPH("graph.DELETE"),
        QUERY("graph.QUERY"),
        ALLNODES("graph.ALLNODES");
        private final byte[] raw;

        Command(String alt) {
            raw = SafeEncoder.encode(alt);
        }

        public byte[] getRaw() {
            return raw;
        }
    }
}
