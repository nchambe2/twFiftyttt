import java.io.BufferedReader;
import java.io.IOException;

public class Player {
    private BufferedReader bufferedReader;
    private String symbol;

    public Player(BufferedReader bufferedReader, String symbol) {

        this.bufferedReader = bufferedReader;
        this.symbol = symbol;
    }

    public String chooseCellToMark() {
        return getUserInput();
    }

    private String getUserInput() {
        String cellToMark = "";

        try {
            cellToMark = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellToMark;
    }

    public String symbol() {
        return symbol;
    }
}
