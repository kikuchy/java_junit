package tddbc;

import java.util.Objects;

/**
 * Created by kikuchy on 2016/02/27.
 */
public class GridPoint {
    private int x;
    private int y;

    public GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getNotation() {
        return String.format("(%d,%d)", x, y);
    }

    public boolean hasSameCoordinateWith(GridPoint gridPoint) {
        return x == gridPoint.getX() && y == gridPoint.getY();
    }

    public boolean isNeighborOf(GridPoint gridPoint) {
        return Math.abs(x  - gridPoint.getX() + y - gridPoint.getY()) == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridPoint gridPoint = (GridPoint) o;

        if (x != gridPoint.x) return false;
        return y == gridPoint.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
