import java.io.PrintStream;
import java.util.Map;

public class LocationChecker {
    private Map<Integer, String> cells;
    private PrintStream printStream;
    private Board board;

    public LocationChecker(Map<Integer, String> cells, PrintStream printStream, Board board) {
        this.cells = cells;
        this.printStream = printStream;
        this.board = board;
    }

    public void checkAvailability(String cellToMark, String symbol) {
        if(isLocationAvailable(cellToMark)) {
            printStream.println("Location Already Taken");
        } else {
            board.mark(cellToMark, symbol);
        }
    }

    private boolean isLocationAvailable(String cellToMark) {
        return cells.get(Integer.parseInt(cellToMark)).equals("X") || cells.get(Integer.parseInt(cellToMark)).equals("O");
    }
}
