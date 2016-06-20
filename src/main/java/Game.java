import java.io.PrintStream;

public class Game {
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private PrintStream printStream;

    public Game(Board board, Player playerOne, Player playerTwo, PrintStream printStream) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.printStream = printStream;
    }

    public void start() {
        board.draw();

        while(board.isNotFull()) {
            playerOne.prompt();
            playerOne.move();
            board.draw();
            if(board.isNotFull()) {
                playerTwo.prompt();
                playerTwo.move();
                board.draw();
            }
        }

      printStream.println("Game is a draw!");
      board.draw();
    }
}


