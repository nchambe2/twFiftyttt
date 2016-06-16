import java.io.PrintStream;
import java.util.Map;

public class Board {
    private PrintStream printStream;
    private Map<Integer, String> cells;

    public Board(PrintStream printStream, Map<Integer, String> cells) {

        this.printStream = printStream;

        this.cells = cells;
    }

    public void draw() {
        printStream.println(String.format("%s|%s|%s\n-----\n" +
                                          "%s|%s|%s\n-----\n" +
                                          "%s|%s|%s\n",
                                          cells.get(1), cells.get(2), cells.get(3),
                                          cells.get(4), cells.get(5), cells.get(6),
                                          cells.get(7), cells.get(8), cells.get(9)));
    }

    public void mark(String cellToMark) {
        cells.put(Integer.parseInt(cellToMark), "X");
    }
}


