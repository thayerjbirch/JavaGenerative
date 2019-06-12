package org.thayer.Layer;

import org.thayer.Brush.Brush;
import org.thayer.Canvas;
import org.thayer.ColorMutator.ColorMutator;
import org.thayer.PositionMutator.AdjacentPositionMutator;
import org.thayer.PositionMutator.PositionMutator;

import java.awt.geom.Point2D;
import java.util.Optional;

public class RandomWalkLayer implements Layer{
    Brush brush;
    ColorMutator colorMutator;
    PositionMutator positionMutator;

    public RandomWalkLayer(Brush brush, ColorMutator colorMutator){
        this.brush = brush;
        this.colorMutator = colorMutator;
        positionMutator = new AdjacentPositionMutator();
    }

    @Override
    public void draw(Canvas canvas) {
        for(int i = 0; i < 100; i++){
            brush.stroke(canvas);
            Optional<Point2D> newPoint = positionMutator.getNextPoint(brush.getPosition());
            if(newPoint.isPresent())
                brush.setPosition(newPoint.get());
            brush.setColor(colorMutator.getNextColor(brush.getColor()));
        }
    }
}
