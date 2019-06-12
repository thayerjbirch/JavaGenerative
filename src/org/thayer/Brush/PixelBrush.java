package org.thayer.Brush;

import org.thayer.Canvas;
import java.awt.*;
import java.awt.geom.Point2D;

public class PixelBrush implements Brush{
    Color color;
    Point2D position;

    public PixelBrush(Color color, Point2D position){
        this.color = color;
        this.position = position;
    }


    @Override
    public void stroke(Canvas canvas) {
        Graphics2D graphics = canvas.getGraphics();
        graphics.setPaint(color);
        graphics.drawLine((int)position.getX(), (int)position.getY(),
                          (int)position.getX(), (int)position.getY());
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
        this.position = position;
    }
}
