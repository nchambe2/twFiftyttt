import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board board;
    private PrintStream printStream;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, printStream, playerOne, playerTwo);
    }

    @Test
    public void shouldDisplayTicTacToeBoardWhenBoardIsDrawn() {
        game.start();

        verify(board, times(3)).draw();
    }

    @Test
    public void shouldPromptPlayersToSelectACellToMarkWhenTheBoardHasBeenDrawn() {
        game.start();

        verify(printStream, times(2)).println(contains("Choose a cell to mark"));
    }

    @Test
    public void shouldHavePlayerOneMoveWhenMessagePromptHasBeenDisplayed() {
        game.start();

        verify(playerOne).move();
    }


    @Test
    public void shouldHavePlayerTwoMoveWhenMessagePromptHasBeenDisplayed() {
        game.start();

        verify(playerTwo).move();
    }

    @Test
    public void shouldDisplayPlayerOnesNumberWhenPlayerIsPromptedToMakeAMove() {
        game.start();

        verify(playerOne).getNumber();
    }

    @Test
    public void shouldDisplayPlayerTwosNumberWhenPlayerIsPromptedToMakeAMove() {
        game.start();

        verify(playerTwo).getNumber();
    }


}