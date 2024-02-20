package lsn.example.graph;

import lsn.example.connection.Connection;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GraphService {

    private static GraphService instance;

    private GraphService() {
    }

    public static GraphService getInstance() {
        if (instance == null) {
            instance = new GraphService();
        }
        return instance;
    }

    public void connectToExistingGraphOrAddNewGraph(Connection connection, List<Graph> graphs) {
        Optional<Graph> graphA = graphs.stream().filter(graph -> graph.getVertexes().contains(connection.getVertexA())).findAny();
        Optional<Graph> graphB = graphs.stream().filter(graph -> graph.getVertexes().contains(connection.getVertexB())).findAny();
        if (graphA.isPresent() && graphB.isPresent()) {
            if (graphA.get().equals(graphB.get())) return;
            graphA.get().getVertexes().addAll(graphB.get().getVertexes());
            graphs.remove(graphB.get());
        } else if (graphA.isPresent()) {
            graphA.get().getVertexes().add(connection.getVertexB());
        } else if (graphB.isPresent()) {
            graphB.get().getVertexes().add(connection.getVertexA());
        } else addNewGraph(connection, graphs);
    }

    private void addNewGraph(Connection connection, List<Graph> graphs) {
        Set<Integer> vertexes = new HashSet<>();
        vertexes.add(connection.getVertexA());
        vertexes.add(connection.getVertexB());
        graphs.add(new Graph(vertexes));
    }
}
