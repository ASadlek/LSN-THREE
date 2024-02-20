package lsn.example.connection;

public class ConnectionService {

    private static ConnectionService instance;

    private ConnectionService() {
    }

    public static ConnectionService getInstance() {
        if (instance == null) {
            instance = new ConnectionService();
        }
        return instance;
    }

    public int getNumberFromString(String firstInput) {
        try {
            return Integer.parseInt(firstInput);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Input contains a number that is too large!");
        }
    }

    public Connection createConnection(String pairOfVertexesDO) {
        String[] vertexesArray = pairOfVertexesDO.split(" ");
        return new Connection(getNumberFromString(vertexesArray[0]), getNumberFromString(vertexesArray[1]));
    }
}
