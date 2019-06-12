package org.thayer.Brush;

import org.thayer.Canvas;

import java.awt.*;
import java.awt.geom.Point2D;

public interface Brush {
    void stroke(Canvas canvas);
    Color getColor();

    void setColor(Color color);

    Point2D getPosition();

    void setPosition(Point2D position);
}
