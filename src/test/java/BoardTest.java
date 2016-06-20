import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
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
    public void shouldUpdateCellOneWithXWhenCellOneIsTheCellToBeMarked() {
        board.mark("1", "X");

        assertEquals("X", cells.get(1));
    }

    @Test
    public void shouldReturnFalseWhenLocationIsEmpty() {
        assertThat(board.isLocationTaken("1"), is(false));
    }

    @Test
    public void shouldReturnTrueWhenLocationIsFilledWithAnX() {
        cells.put(1, "X");

        assertThat(board.isLocationTaken("1"), is(true));
    }

    @Test
    public void shouldReturnTrueWhenLocationIsFilledWithAnO() {
        cells.put(1, "O");

        assertThat(board.isLocationTaken("1"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsFull() {
        for(int i = 1; i < 10; i++) {
            cells.put(i, "X");
        }

        assertThat(board.isNotFull(), is(false));
    }

    @Test
    public void shouldReturnTrueWhenBoardIsNotFull() {
        assertThat(board.isNotFull(), is(true));
    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeXsInAHorizontalRow() {
        for(int i = 1; i < 4; i++) {
            cells.put(i, "X");
        }

        assertThat(board.isThreeInARow("X"), is(true));
    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeOsInAHorizontalRow() {
        for(int i = 4; i < 7; i++) {
            cells.put(i, "O");
        }

        assertThat(board.isThreeInARow("O"), is(true));
    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeXsInAVerticalRow() {
        cells.put(1, "X");
        cells.put(4, "X");
        cells.put(7, "X");

        assertThat(board.isThreeInARow("X"), is(true));
    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeOsInAVerticalRow() {
        cells.put(2, "O");
        cells.put(5, "O");
        cells.put(8, "O");

        assertThat(board.isThreeInARow("O"), is(true));
    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeXsInADiagonal() {
        cells.put(1, "X");
        cells.put(5, "X");
        cells.put(9, "X");

        assertThat(board.isThreeInARow("X"), is(true));
    }

    @Test
    public void shouldReturnTrueWhenThereAreThreeOsInADiagonal() {
        cells.put(7, "O");
        cells.put(5, "O");
        cells.put(3, "O");

        assertThat(board.isThreeInARow("O"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenThereAreNotThreeXsInARow() {
        assertThat(board.isThreeInARow("X"), is(false));
    }

    @Test
    public void shouldReturnFalseWhenThereAreNotThreeOsInARow() {
        assertThat(board.isThreeInARow("O"), is(false));
    }

}