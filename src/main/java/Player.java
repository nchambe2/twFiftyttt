import java.io.PrintStream;

public class Player {
    private String symbol;
    private Integer number;
    private Board board;
    private PrintStream printStream;
    private UserInput userInput;

    public Player(String symbol, Integer number, Board board, PrintStream printStream, UserInput userInput) {
        this.symbol = symbol;
        this.number = number;
        this.board = board;
        this.printStream = printStream;
        this.userInput = userInput;
    }

    public void move() {
        String cellToMark = userInput.get();

        while(board.isLocationTaken(cellToMark)) {
            printStream.println("Location is Taken! Please select another location to mark.");
            cellToMark = userInput.get();
        }

        board.mark(cellToMark, symbol);
    }

    public void prompt() {
        printStream.println("Player " + number + ". Choose a cell to mark from 1 - 9:");
    }

    public void winner() {
        printStream.println("Player " + number + ". Wins!");
    }
}

