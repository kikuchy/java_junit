package tddbc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kikuchy on 2016/02/27.
 */
@RunWith(Enclosed.class)
public class GridPointSetTest {

    public static class 要素が2個の場合 {
        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        GridPoint p4_7, p11_8;
        GridPointSet sut;

        @Before
        public void setUp() throws Exception {
            p4_7 = new GridPoint(4, 7);
            p11_8 = new GridPoint(11, 8);
            sut = new GridPointSet(p4_7, p11_8);
        }

        @Test
        public void 格子点集合は同じ格子点をもたない_2つの場合() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("同じ格子点を集合に含めることはできません");
            GridPointSet gridPointSet = new GridPointSet(p4_7, p4_7);
        }

        @Test
        public void 格子点集合が指定した格子点を含む() throws Exception {
            assertTrue(sut.contains(new GridPoint(4, 7)));
            assertTrue(sut.contains(new GridPoint(11, 8)));
        }

        @Test
        public void 格子点集合が指定した格子点を含まない() throws Exception {
            assertFalse(sut.contains(new GridPoint(23, 37)));
        }

        @Test
        public void 格子点集合が連結している() throws Exception {
            GridPointSet gridPointSet = new GridPointSet(new GridPoint(10, 8), p11_8);
            assertTrue(gridPointSet.isConnected());
        }

        @Test
        public void 格子点集合が連結していない() throws Exception {
            assertFalse(sut.isConnected());
        }

    }

    public static class 要素が3個の場合 {
        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        GridPoint p4_7, p11_8,p27_50;
        GridPointSet sut;

        @Before
        public void setUp() throws Exception {
            p4_7 = new GridPoint(4, 7);
            p11_8 = new GridPoint(11, 8);
            p27_50 = new GridPoint(27, 50);
            sut = new GridPointSet(p4_7, p11_8, p27_50);
        }

        @Test
        public void 格子点集合は同じ格子点を持たない_1個目と2個目() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("同じ格子点を集合に含めることはできません");
            GridPointSet gridPointSet = new GridPointSet(p4_7, new GridPoint(4, 7), p11_8);
        }

        @Test
        public void 格子点集合は同じ格子点を持たない_2個目と3個目() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("同じ格子点を集合に含めることはできません");
            GridPointSet gridPointSet = new GridPointSet(p11_8, p4_7, new GridPoint(4, 7));
        }

        @Test
        public void 格子点集合は同じ格子点を持たない_1個目と3個目() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("同じ格子点を集合に含めることはできません");
            GridPointSet gridPointSet = new GridPointSet(p4_7, p11_8, new GridPoint(4, 7));
        }
        @Test
        public void 格子点集合が指定した格子点を含む() throws Exception {
            assertTrue(sut.contains(new GridPoint(4, 7)));
            assertTrue(sut.contains(new GridPoint(11, 8)));
        }

        @Test
        public void 格子点集合が指定した格子点を含まない() throws Exception {
            assertFalse(sut.contains(new GridPoint(23, 37)));
        }

        @Test
        public void 格子点集合が連結している_初めの2個が連結している場合() throws Exception {
            GridPointSet gridPointSet = new GridPointSet(new GridPoint(10, 8), p11_8, new GridPoint(11, 9));
            assertTrue(gridPointSet.isConnected());
        }

        @Test
        public void 格子点集合が連結している_初めの2個が連結していない場合() throws Exception {
            GridPointSet gridPointSet = new GridPointSet(new GridPoint(10, 8), new GridPoint(11, 9),p11_8 );
            assertTrue(gridPointSet.isConnected());
        }

        @Test
        public void 格子点集合が連結していない() throws Exception {
            assertFalse(sut.isConnected());
        }
    }


}