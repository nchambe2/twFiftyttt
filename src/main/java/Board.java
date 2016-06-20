import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
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

    public void mark(String cellToMark, String playerSymbol) {
        cells.put(Integer.parseInt(cellToMark), playerSymbol);

    }


    public Boolean isLocationTaken(String cellToMark) {
        Integer key = Integer.parseInt(cellToMark);
        return cells.get(key).equals("X") || cells.get(key).equals("O");
    }

    public Boolean isNotFull() {
        Collection<String> cellValues = cells.values();

        for(String value : cellValues) {
            if(!value.equals("X") && !value.equals("O")) {
                return true;
            }
         }

        return false;
    }
}




