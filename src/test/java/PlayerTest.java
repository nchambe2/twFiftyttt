import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private UserInput userInput;
    private Player player;
    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() {
        userInput = mock(UserInput.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        player = new Player("X", userInput, board, printStream);
    }

    @Test
    public void getPlayerSymbol() {
        assertThat(player.symbol(), is("X"));
    }

    @Test
    public void shouldGetUserInputWhenPlayerMakesAMove() {
        player.move();

        verify(userInput).get();
    }

    @Test
    public void shouldDisplayLocationTakenMessageWhenPlayerAttemptsToMarkACellThatIsTaken() {
        when(userInput.get()).thenReturn("1");
        when(board.isLocationTaken("1")).thenReturn(true);

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