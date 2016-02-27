package tddbc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SampleTest {
    GridPoint p4_7, p11_8;

    @Before
    public void setUp() throws Exception {
        p4_7 = new GridPoint(4, 7);
        p11_8 = new GridPoint(11, 8);
    }

    @Test
    public void x座標を取得できる(){
        assertThat(p4_7.getX(), is(4));

        assertThat(p11_8.getX(), is(11));
    }

    @Test
    public void y座標を取得できる(){
        assertThat(p4_7.getY(), is(7));

        assertThat(p11_8.getY(), is(8));
    }

    @Test
    public void 文字列表記を取得できる() throws Exception {
        assertThat(p4_7.getNotation(), is("(4,7)"));

        assertThat(p11_8.getNotation(), is("(11,8)"));
    }

    @Test
    public void 同じ座標を持つ() throws Exception {
        assertTrue(p4_7.hasSameCoordinateWith(new GridPoint(4, 7)));
        assertTrue(p11_8.hasSameCoordinateWith(new GridPoint(11, 8)));
    }

    @Test
    public void 異なる座標を持つ() throws Exception {
        assertFalse(p4_7.hasSameCoordinateWith(new GridPoint(11, 8)));
        assertFalse(p11_8.hasSameCoordinateWith(new GridPoint(4, 7)));
    }

    @Test
    public void 格子点同士が隣り合っている() throws Exception {
        assertTrue(p4_7.isNeighborOf(new GridPoint(3, 7)));
        assertTrue(p4_7.isNeighborOf(new GridPoint(5, 7)));
        assertTrue(p4_7.isNeighborOf(new GridPoint(4, 6)));
        assertTrue(p4_7.isNeighborOf(new GridPoint(4, 8)));
    }

    @Test
    public void 格子点同士が隣合わない() throws Exception {
        assertFalse(p4_7.isNeighborOf(new GridPoint(7463, 275)));
        assertFalse(p11_8.isNeighborOf(new GridPoint(9472, 9)));
    }

    @Test
    public void 同じ座標は隣合わない() throws Exception {
        assertFalse(p4_7.isNeighborOf(p4_7));
        assertFalse(p4_7.isNeighborOf(new GridPoint(4, 7)));
    }
}
