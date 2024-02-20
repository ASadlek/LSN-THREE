package lsn.example.io;

public class PrintService {

    private static PrintService instance;

    private PrintService() {
    }

    public static PrintService getInstance() {
        if (instance == null) {
            instance = new PrintService();
        }
        return instance;
    }

    public void printProvideNumberOfConnections() {
        System.out.println("Enter how many connections you want to provide or type 'exit' to quit:");
    }

    public void printProvidePairsOfVertexes() {
        System.out.println("Enter pairs of vertexes, each vertex has to be a positive integer. They have to be seperated by a space.");
        System.out.println("Sample pair of vertexes -> \"13 441\"");
    }

    public void printExceptionMessage(String message) {
        System.out.println("Wrong Input! " + message + "\n");
    }

    public void printExit() {
        System.out.println("Exiting... \n");
    }

    public void printAnswer(int size) {
        System.out.println(size);
    }

}
