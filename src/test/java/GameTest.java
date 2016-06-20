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
    public void shouldPromptPlayerOneToMakeAMoveWhenBoardIsNoTFullAndThereIsNoWinner() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerOne).prompt();
    }

    @Test
    public void shouldPromptPlayerTwoToMakeAMoveWhenBoardIsNoTFullAndThereIsNoWinner () {
        when(board.isNotFull()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerTwo).prompt();
    }

    @Test
    public void shouldMakeAMoveWhenPlayerOneHasBeenPrompted() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerOne).move();
    }

    @Test
    public void shouldMakeAMoveWhenPlayerTwoHasBeenPrompted() {
        when(board.isNotFull()).thenReturn(true).thenReturn(true).thenReturn(false);

        game.start();

        verify(playerTwo).move();
    }

    @Test
    public void shouldDisplayWinningMessageWhenPlayerOneHasWon() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);
        when(board.isThreeInARow("X")).thenReturn(true);
        when(playerOne.getSymbol()).thenReturn("X");

        game.start();

        verify(playerOne).winner();
    }

    @Test
    public void shouldDisplayWinningMessageWhenPlayerTwoHasWon() {
        when(board.isNotFull()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(board.isThreeInARow("O")).thenReturn(false).thenReturn(true);
        when(playerTwo.getSymbol()).thenReturn("O");

        game.start();

        verify(playerTwo).winner();
    }

    @Test
    public void shouldDisplayThreeByThreeBoardWhenTheBoardIsDrawn() {
        when(board.isNotFull()).thenReturn(true).thenReturn(false);
        when(board.isThreeInARow("X")).thenReturn(true);

        game.start();

        verify(board, atLeast(1)).draw();
    }

    @Test
    public void shouldDisplayGameIsADrawMessageWhenBoardIsFullAndThereIsNoWinner() {
        when(board.isNotFull()).thenReturn(false);
        when(!board.isNotFull()).thenReturn(false);

        game.start();

        verify(printStream).println(contains("Game is a draw!"));
    }
}