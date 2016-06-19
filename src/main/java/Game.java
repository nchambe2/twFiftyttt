public class Game {
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void start() {
        board.draw();
        playerOne.prompt();
        playerOne.move();
        board.draw();
        playerTwo.prompt();
        playerTwo.move();
        board.draw();
    }
}

//repeat the board until it's full
//draw the board once it's full
//display the game is a draw
