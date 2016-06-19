import java.io.PrintStream;

public class Player {
    private String symbol;
    private UserInput userInput;
    private Board board;
    private PrintStream printStream;

    public Player(String symbol, UserInput userInput, Board board, PrintStream printStream) {
        this.symbol = symbol;
        this.userInput = userInput;
        this.board = board;
        this.printStream = printStream;
    }

    public void move() {
        String cellToMark = userInput.get();

        if (board.isLocationTaken(cellToMark)) {
            printStream.println("Location is Taken");
        } else {
            board.mark(cellToMark, symbol);
        }
    }

    public String symbol() {
        return symbol;
    }
}

//while locationCheck.isLocationTaken == true
//prompt user for input
//else board .mark
//player.move
//while board.locationTaken = true
// print location taken message
//get user input
//if board.locationTaken isn't false mark