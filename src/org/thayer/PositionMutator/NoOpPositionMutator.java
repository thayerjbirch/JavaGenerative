package org.thayer.PositionMutator;

import java.awt.geom.Point2D;
import java.util.Optional;

public class NoOpPositionMutator implements PositionMutator {
    @Override
    public Optional<Point2D> getNextPoint(Point2D pointIn) {
        return Optional.empty();
    }
}
