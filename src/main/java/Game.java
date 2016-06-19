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
        printStream.println("Player " + playerOne.getNumber() + " Choose a cell to mark from 1 - 9:");
        playerOne.move();
        board.draw();
        printStream.println("Player " + playerTwo.getNumber() + " Choose a cell to mark from 1 - 9:");
        playerTwo.move();
        board.draw();
    }
}

//Display the player number in the print stream
//player has to have a player number assocaited with it
