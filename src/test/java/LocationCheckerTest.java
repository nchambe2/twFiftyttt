import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LocationCheckerTest {
    private Map<Integer, String> cells;
    private LocationChecker locationChecker;
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() {
        cells = new HashMap<>();
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        for(int i = 1; i < 10; i++) {
            cells.put(i, Integer.toString(i));
        }
        locationChecker = new LocationChecker(cells, printStream, board);
    }

    @Test
    public void shouldDisplayLocationIsUnavailableMessageWhenLocationIsOccupiedByAnXOrAnO() {
        cells.put(1, "X");

        locationChecker.checkAvailability("1", "X");

        verify(printStream).println(contains("Location Already Taken"));
    }

    @Test
    public void shouldMarkBoardWithPlayerSymbolWhenLocationIsEmpty() {
        LocationChecker locationChecker = new LocationChecker(cells, printStream, board);

        locationChecker.checkAvailability("1", "X");

        verify(board).mark("1", "X");
    }
}