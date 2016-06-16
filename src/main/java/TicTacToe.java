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
        Player player = new Player(bufferedReader);
        Game game = new Game(board, printStream, player);

        game.start();
    }
}

//now I would change the structure of the board from a string to a hash map
//instead of replace
//you would just update the value