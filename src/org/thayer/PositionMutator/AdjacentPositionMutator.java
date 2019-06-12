package org.thayer.PositionMutator;

import java.awt.geom.Point2D;
import java.util.Optional;

import static org.thayer.Util.getRandomIntegerInRange;

public class AdjacentPositionMutator implements PositionMutator{
    @Override
    public Optional<Point2D> getNextPoint(Point2D pointIn) {
        pointIn.setLocation(pointIn.getX() + getRandomIntegerInRange(-1, 1),
                pointIn.getY() + getRandomIntegerInRange(-1, 1));
        return Optional.of(pointIn);
    }
}
