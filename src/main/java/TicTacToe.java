public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);

        game.start();
    }
}
