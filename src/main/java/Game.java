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
        playerOne.move();
        board.draw();
        printStream.println("Choose a cell to mark from 1 - 9:");
        playerTwo.move();
        board.draw();
    }
}

//keep prompting a user for input until it's valid
//has to be a loop
//locationchecker has to return a boolean
//only place currently I can place while loop is in game
//don't have to send parameters
//you have the cells
//iterate through the cells

//Getting a user's input should be the job of someone else
//a player should know about a board
//a player should call board.mark
//a
