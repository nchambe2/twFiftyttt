import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private PrintStream printStream;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, playerOne, playerTwo, printStream);
    }

    @Test
    public void shouldHaveEachPlayerTakeAtleastOneTurnWhenBoardIsNotFull() {
        when(board.isNotFull()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(board, times(3)).isNotFull();
    }

    @Test
    public void shouldNotHavePlayersTakeTurnsWhenBoardIsFull() {
        when(board.isNotFull()).thenReturn(false);

        game.start();

        verify(board, times(1)).isNotFull();
    }

    @Test
    public void shouldDisplayTicTacToeBoardWhenBoardIsDrawn() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);

        game.start();

        verify(board, atLeast(1)).draw();
    }

    @Test
    public void shouldPromptPlayerOneToMoveWhenBoardIsNotFull() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerOne).prompt();
    }

    @Test
    public void shouldPromptPlayerTwoToMoveWhenBoardIsNotFull() {
        when(board.isNotFull()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerTwo).prompt();
    }

    @Test
    public void shouldHavePlayerOneMoveWhenMessagePromptHasBeenDisplayed() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerOne).move();
    }

    @Test
    public void shouldHavePlayerTwoMoveWhenMessagePromptHasBeenDisplayed() {
        when(board.isNotFull()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerTwo).move();
    }

    @Test
    public void shouldDisplayGameIsADrawMessageWhenBoardIsFull() {
        when(board.isNotFull()).thenReturn(false);

        game.start();

        verify(printStream).println(contains("Game is a draw"));
    }

}