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
        return isOccupied(key);
    }

    private boolean isOccupied(Integer key) {
        return cells.get(key).equals("X") || cells.get(key).equals("O");
    }

    public Boolean isNotFull() {
        Collection<String> cellValues = cells.values();

        for(String value : cellValues) {
            if(isEmpty(value)) {
                return true;
            }
         }

        return false;
    }

    private boolean isEmpty(String value) {
        return !value.equals("X") && !value.equals("O");
    }

    public Boolean isThreeInARow() {
       if(cells.get(1).equals("X") && cells.get(2).equals("X") && cells.get(3).equals("X")) {
           return true;
       } else if(cells.get(1).equals("O") && cells.get(2).equals("O") && cells.get(3).equals("O")) {
           return true;
       } else if(cells.get(4).equals("O") && cells.get(5).equals("O") && cells.get(6).equals("O")) {
           return true;
       } else if(cells.get(4).equals("X") && cells.get(5).equals("X") && cells.get(6).equals("X")) {
           return true;
       } else if(cells.get(7).equals("O") && cells.get(8).equals("O") && cells.get(9).equals("O")) {
           return true;
       } else if(cells.get(7).equals("X") && cells.get(8).equals("X") && cells.get(9).equals("X")) {
           return true;
       }

        return false;
    }
}




