package lsn.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadService {

    private static ReadService instance;

    private ReadService() {
    }

    public static ReadService getInstance() {
        if (instance == null) {
            instance = new ReadService();
        }
        return instance;
    }

    public String readInput() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
    }

}
