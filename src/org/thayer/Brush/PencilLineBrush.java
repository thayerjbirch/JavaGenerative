package org.thayer.Brush;

import org.thayer.Canvas;

import java.awt.*;
import java.awt.geom.Point2D;

public class PencilLineBrush implements Brush{
    Color color;
    Point2D position;
    Point2D lastPosition;
    int width;

    public PencilLineBrush(Color color, Point2D position) {
        this(color, position, 1);
    }

    public PencilLineBrush(Color color, Point2D position, int width){
        this.color = color;
        this.position = position;
        this.lastPosition = position;
        this.width = width;
    }

    @Override
    public void stroke(Canvas canvas) {
        Graphics2D graphics = canvas.getGraphics();
        graphics.setPaint(color);
        graphics.setStroke(new BasicStroke(width));
        graphics.drawLine((int)lastPosition.getX(), (int)lastPosition.getY(),
                (int)position.getX(), (int)position.getY());
        // reset stroke size to not interfere with other brushes
        graphics.setStroke(new BasicStroke(1));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.lastPosition = this.position;
        this.position = position;
    }
}
