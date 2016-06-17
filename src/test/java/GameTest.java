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
    private LocationChecker locationChecker;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        locationChecker = mock(LocationChecker.class);
        game = new Game(board, printStream, playerOne, playerTwo, locationChecker);
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
    public void shouldCaptureTheCellPlayerTwoWantsToMarkWhenTheyHaveBeenPrompted() {
        game.start();

        verify(playerTwo).chooseCellToMark();
    }


    @Test
    public void shouldCheckToSeeIfLocationIsAvaliableWhenPlayerOneHasChosenACellToMark() {
        when(playerOne.symbol()).thenReturn("X");
        when(playerOne.chooseCellToMark()).thenReturn("1");
        game.start();

        verify(locationChecker).checkAvailability("1", "X");
    }
}