import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private Map<Integer, String> cells;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        cells = new HashMap<>();
        for(int i = 1; i < 10; i++) {
            cells.put(i, Integer.toString(i));
        }
        board = new Board(printStream, cells);
    }

    @Test
    public void shouldPrintThreeByThreeBoardWhenBoardIsDrawn() {
        board.draw();

        verify(printStream).println("1|2|3\n" +
                                    "-----\n" +
                                    "4|5|6\n" +
                                    "-----\n" +
                                    "7|8|9\n");
    }


    @Test
    public void shouldUpdateCellOneWithXWhenCellOneIsTheCellToBeMarkedX() {
        board.mark("1");

        assertEquals("X", cells.get(1));
    }
}