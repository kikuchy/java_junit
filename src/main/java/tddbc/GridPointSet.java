package tddbc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kikuchy on 2016/02/27.
 */
public class GridPointSet {
    private List<GridPoint> gridPointList = new ArrayList<>();


    public GridPointSet(GridPoint first, GridPoint second) {
        gridPointList.add(first);
        gridPointList.add(second);
        if (isDuplicated(gridPointList)) {
            throw new IllegalArgumentException("同じ格子点を集合に含めることはできません");
        }
    }

    public GridPointSet(GridPoint first, GridPoint second, GridPoint third) {
        gridPointList.add(first);
        gridPointList.add(second);
        gridPointList.add(third);
        if (isDuplicated(gridPointList)) {
            throw new IllegalArgumentException("同じ格子点を集合に含めることはできません");
        }

    }

    private boolean isDuplicated(List<GridPoint> gridPointList) {
        Set<GridPoint> pointSet = new HashSet<>();
        pointSet.addAll(gridPointList);

        return gridPointList.size() != pointSet.size();
    }


    public boolean contains(GridPoint gridPoint) {
        return gridPointList.stream()
                .anyMatch(gridPoint1 -> gridPoint1.hasSameCoordinateWith(gridPoint));

    }

    public boolean isConnected() {
        GridPoint firstPoint = gridPointList.get(0);
        GridPoint secondPoint = gridPointList.get(1);
        if (gridPointList.size() == 2) {
            return firstPoint.isNeighborOf(secondPoint);
        }

        GridPoint thirdPoint = gridPointList.get(2);


        if (firstPoint.isNeighborOf(secondPoint)) {
            return firstPoint.isNeighborOf(thirdPoint) ||
                    secondPoint.isNeighborOf(thirdPoint);
        }
        return firstPoint.isNeighborOf(thirdPoint) &&
                secondPoint.isNeighborOf(thirdPoint);


    }
}
