package org.thayer.Brush;

import org.thayer.Canvas;
import org.thayer.Main;
import org.thayer.QuadTree;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class OvalBrush implements Brush{
    Color color;
    Point2D position;
    boolean fill;
    double xWidth;
    double yWidth;
    CollisionBehavior collisionBehavior;
    QuadTree quadTree;

    enum CollisionBehavior{
        SKIP_STROKE, PAINT_OVER
    }

    public OvalBrush(Color color, Point2D position, double width){
        this(color, position, width, width, true,
                CollisionBehavior.SKIP_STROKE, null);
    }

    public OvalBrush(Color color, Point2D position, double xWidth,
                     double yWidth, boolean fillOval,
                     CollisionBehavior collisionBehavior,
                     QuadTree quadTree){
        this.color = color;
        this.position = position;
        this.xWidth = xWidth;
        this.yWidth = yWidth;
        this.fill = fillOval;
        this.collisionBehavior = collisionBehavior;

        if(quadTree == null){
            this.quadTree = new QuadTree(0, new Rectangle(Main.WIDTH, Main.HEIGHT));
        }
        else
            this.quadTree = quadTree;
    }

    @Override
    public void stroke(Canvas canvas) {
        Ellipse2D ellipse = new Ellipse2D.Double(position.getX(),
                position.getY(), xWidth, yWidth);

        if (collisionBehavior == CollisionBehavior.SKIP_STROKE){
            if(quadTree.collides(ellipse)){
                return;
            }
            quadTree.insert(ellipse);
        }

        Graphics2D graphics = canvas.getGraphics();
        graphics.setColor(color);
        graphics.fill(ellipse);
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
