import java.io.PrintStream;

public class Board {
    private PrintStream printStream;
    public String cells = "1|2|3\n" +
                          "-----\n" +
                          "4|5|6\n" +
                          "-----\n" +
                          "7|8|9\n";

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void draw() {
        printStream.println(cells);
    }

    public void mark(String cellToMark) {
        cells = cells.replace(cellToMark, "X");
    }
}
