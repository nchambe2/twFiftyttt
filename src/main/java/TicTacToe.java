import java.io.PrintStream;

public class TicTacToe {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        Game game = new Game(board);

        game.start();
    }
}
