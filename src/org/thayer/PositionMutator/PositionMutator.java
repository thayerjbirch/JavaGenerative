package org.thayer.PositionMutator;

import java.awt.geom.Point2D;
import java.util.Optional;

public interface PositionMutator {
    Optional<Point2D> getNextPoint(Point2D pointIn);
}
