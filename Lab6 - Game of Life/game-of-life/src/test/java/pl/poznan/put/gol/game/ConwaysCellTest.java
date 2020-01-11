package pl.poznan.put.gol.game;

import org.junit.Test;
import static org.junit.Assert.*;


public class ConwaysCellTest {

    @Test
    public void testEquals() {

        ConwaysCell cell_1 = new ConwaysCell(1,1);
        ConwaysCell cell_2 = new ConwaysCell(1,1);

        assertTrue(cell_1.equals(cell_2));
    }

    @Test
    public void neighbors() {

        ConwaysCell cell = new ConwaysCell(3,3);

        Cells cells = new Cells();
        cells.add(new ConwaysCell(2,2));
        cells.add(new ConwaysCell(2,3));
        cells.add(new ConwaysCell(2,4));
        cells.add(new ConwaysCell(3,2));
        cells.add(new ConwaysCell(3,4));
        cells.add(new ConwaysCell(4,2));
        cells.add(new ConwaysCell(4,3));
        cells.add(new ConwaysCell(4,4));

        assertEquals(cell.neighbors(), cells);
    }

}