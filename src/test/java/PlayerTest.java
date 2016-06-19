import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Player player;
    private Board board;
    private PrintStream printStream;
    private UserInput userInput;

    @Before
    public void setUp() {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        player = new Player("X", board, printStream, userInput);
    }

    @Test
    public void shouldDisplayLocationTakenMessageWhenPlayerAttemptsToMarkACellThatIsTaken() {
        when(userInput.get()).thenReturn("1");
        when(board.isLocationTaken("1")).thenReturn(true).thenReturn(false);

        player.move();

        verify(printStream).println(contains("Location is Taken"));
    }

    @Test
    public void shouldMarkBoardWhenLocationIsAvailable() {
        when(userInput.get()).thenReturn("1");
        when(board.isLocationTaken("1")).thenReturn(false);

        player.move();

        verify(board).mark("1", "X");
    }
}