import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TicTacToe {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Board board = new Board(printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player = new Player(bufferedReader);
        Game game = new Game(board, printStream, player);

        game.start();
    }
}

//prompt the user to make a move - done
//get the cell that the player wants to mark - done
//mark the board - done
//redraw the board - with the player's symbol in that location - done