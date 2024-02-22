package lsn.example.io;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static InputValidator instance;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    public void validateNumberOfConnectionsDO(String input) throws IOException {
        String pattern = "^[1-9]\\d*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        if (!matcher.matches()) {
            throw new IOException("Enter ONLY one positive integer! No other symbols are permitted!");
        }
    }

    public void validateConnectionDO(String input) throws IOException {
        String pattern = "^[1-9]\\d*\\s[1-9]\\d*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        if (!matcher.matches()) {
            throw new IOException("Enter ONLY pairs of vertexes, each vertex has to be a positive integer! They have to be seperated by a single space!");
        }
    }
}
