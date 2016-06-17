import java.io.PrintStream;

public class Game {
    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;
    private LocationChecker locationChecker;

    public Game(Board board, PrintStream printStream, Player playerOne, Player playerTwo, LocationChecker locationChecker) {

        this.board = board;
        this.printStream = printStream;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.locationChecker = locationChecker;
    }

    public void start() {
        board.draw();
        printStream.println("Choose a cell to mark from 1 - 9:");
        String cellToBeMarked = playerOne.chooseCellToMark();
        locationChecker.checkAvailability(cellToBeMarked, playerOne.symbol());
        board.draw();
        cellToBeMarked = playerTwo.chooseCellToMark();
        locationChecker.checkAvailability(cellToBeMarked, playerOne.symbol());
        board.draw();
    }
}

