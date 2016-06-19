import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, playerOne, playerTwo);
    }

    @Test
    public void shouldDisplayTicTacToeBoardWhenBoardIsDrawn() {
        game.start();

        verify(board, times(3)).draw();
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
    public void shouldPromptPlayerOneToMoveWhenBoardIsFinishedDrawing() {
        game.start();

        verify(playerOne).prompt();
    }

    @Test
    public void shouldPromptPlayerTwoToMoveWhenBoardIsFinishedDrawing() {
        game.start();

        verify(playerTwo).prompt();
    }

}