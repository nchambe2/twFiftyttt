import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
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
    public void shouldUpdateCellOneWithXWhenCellOneIsTheCellToBeMarked() {
        String updatedBoard = "X|2|3\n" +
                              "-----\n" +
                              "4|5|6\n" +
                              "-----\n" +
                              "7|8|9\n";

        board.mark("1");

        assertEquals(updatedBoard, board.cells);
    }
}