package lsn.example;

import lsn.example.connection.Connection;
import lsn.example.connection.ConnectionService;
import lsn.example.graph.Graph;
import lsn.example.graph.GraphService;
import lsn.example.io.InputValidator;
import lsn.example.io.PrintService;
import lsn.example.io.ReadService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //init singleton instances
        PrintService printService = PrintService.getInstance();
        ReadService readService = ReadService.getInstance();
        GraphService graphService = GraphService.getInstance();
        ConnectionService connectionService = ConnectionService.getInstance();
        InputValidator inputValidator = InputValidator.getInstance();

        //run app in a loop
        while (true) {
            try {
                //ask for number of connections
                printService.printProvideNumberOfConnections();
                String numberOfConnectionsDO = readService.readInput();
                if (numberOfConnectionsDO.equalsIgnoreCase("exit")) {
                    printService.printExit();
                    break;
                }
                inputValidator.validateNumberOfConnectionsDO(numberOfConnectionsDO);
                int numberOfConnections = connectionService.getNumberFromString(numberOfConnectionsDO);

                //ask for pairs of vertexes
                printService.printProvidePairsOfVertexes();
                List<Graph> graphs = new ArrayList<>();
                for (int i = 0; i < numberOfConnections; i++) {
                    String pairOfVertexesDO = readService.readInput();
                    inputValidator.validateConnectionDO(pairOfVertexesDO);
                    Connection connection = connectionService.createConnection(pairOfVertexesDO);
                    graphService.connectToExistingGraphOrAddNewGraph(connection, graphs);
                }
                printService.printAnswer(graphs.size());

            } catch (Exception exception) {
                printService.printExceptionMessage(exception.getMessage());
            }
        }

    }

}
