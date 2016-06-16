import java.io.BufferedReader;
import java.io.IOException;

public class Player {
    private BufferedReader bufferedReader;

    public Player(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
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
}
