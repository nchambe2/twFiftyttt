import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
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
    public void shouldPromptPlayerToSelectACellToMarkWhenBoardHasBeenDrawn() {
        game.start();

        verify(printStream).println(contains("Choose a cell to mark"));
    }

    @Test
    public void shouldCaptureTheCellPlayerOneWantsToMarkWhenTheyHaveBeenPrompted() {
        game.start();

        verify(playerOne).chooseCellToMark();
    }

    @Test
    public void shouldMarkBoardWhenPlayerOneHasChosenACellToMark() {
        when(playerOne.symbol()).thenReturn("X");
        when(playerOne.chooseCellToMark()).thenReturn("1");

        game.start();

        verify(board).mark("1", "X");
    }

    @Test
    public void shouldCaptureTheCellPlayerTwoWantsToMarkWhenTheyHaveBeenPrompted() {
        game.start();

        verify(playerTwo).chooseCellToMark();
    }

    @Test
    public void shouldMarkBoardWhenPlayerTwoHasChosenACellToMark() {
        when(playerTwo.symbol()).thenReturn("O");
        when(playerTwo.chooseCellToMark()).thenReturn("2");

        game.start();

        verify(board).mark("2", "O");
    }

}