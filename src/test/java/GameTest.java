import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board board;
    private PrintStream printStream;
    private Player player;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        game = new Game(board, printStream, player);
    }

    @Test
    public void shouldDisplayTicTacToeBoardWhenBoardIsDrawn() {
        game.start();

        verify(board, times(2)).draw();
    }

    @Test
    public void shouldPromptPlayerToSelectACellToMarkWhenBoardHasBeenDrawn() {
        game.start();

        verify(printStream).println(contains("Choose a cell to mark"));
    }

    @Test
    public void shouldCaptureTheCellPlayerWantsToMarkWhenPlayerHasBeenPrompted() {
        game.start();

        verify(player).chooseCellToMark();
    }

    @Test
    public void shouldMarkBoardWhenPlayerHasChosenACellToMark() {
        when(player.chooseCellToMark()).thenReturn("1");

        game.start();

        verify(board).mark("1");
    }

}