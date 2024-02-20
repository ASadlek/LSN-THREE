package lsn.example.graph;

import java.util.Set;

public class Graph {

    private final Set<Integer> vertexes;

    public Graph(Set<Integer> vertexes) {
        this.vertexes = vertexes;
    }

    public Set<Integer> getVertexes() {
        return vertexes;
    }
}
