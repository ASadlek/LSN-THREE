package lsn.example.connection;

public class Connection {

    private final int vertexA;
    private final int vertexB;

    public Connection(int vertexA, int vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public int getVertexA() {
        return vertexA;
    }

    public int getVertexB() {
        return vertexB;
    }
}
