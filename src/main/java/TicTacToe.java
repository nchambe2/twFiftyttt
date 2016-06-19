import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Map<Integer, String> cells = new HashMap<>();
        Board board = new Board(printStream, cells);
        for(int i = 1; i < 10; i++) {
            cells.put(i, Integer.toString(i));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserInput userInput = new UserInput(bufferedReader);
        Player playerOne = new Player("X", 1, board, printStream, userInput);
        Player playerTwo = new Player("O", 2, board, printStream, userInput);
        Game game = new Game(board, printStream, playerOne, playerTwo);

        game.start();
    }
}


