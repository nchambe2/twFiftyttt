import java.io.PrintStream;

public class Game {
    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;

    public Game(Board board, PrintStream printStream, Player playerOne, Player playerTwo) {

        this.board = board;
        this.printStream = printStream;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        board.draw();
        printStream.println("Choose a cell to mark from 1 - 9:");
        String cellToBeMarked = playerOne.chooseCellToMark();
        board.mark(cellToBeMarked, playerOne.symbol());
        board.draw();
        cellToBeMarked = playerTwo.chooseCellToMark();
        board.mark(cellToBeMarked, playerTwo.symbol());
        board.draw();
    }
}

