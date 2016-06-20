import java.io.PrintStream;
import java.util.Collection;
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

    public Boolean isThreeInARow(String playerSymbol) {
        return isSameSymbol(1,2,3, playerSymbol) ||
               isSameSymbol(4,5,6, playerSymbol) ||
               isSameSymbol(7,8,9, playerSymbol) ||
               isSameSymbol(1,4,7, playerSymbol) ||
               isSameSymbol(2,5,8, playerSymbol) ||
               isSameSymbol(3,6,9, playerSymbol) ||
               isSameSymbol(1,5,9, playerSymbol) ||
               isSameSymbol(7,5,3, playerSymbol);
    }

    private Boolean isSameSymbol(int cellOne, int cellTwo, int cellThree, String playerSymbol) {
        return cells.get(cellOne).equals(playerSymbol) &&
               cells.get(cellTwo).equals(playerSymbol) &&
               cells.get(cellThree).equals(playerSymbol);
    }

}




