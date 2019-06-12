package org.thayer.Layer;

import org.thayer.Brush.Brush;
import org.thayer.Canvas;
import org.thayer.ColorMutator.ColorMutator;
import org.thayer.PositionMutator.PositionMutator;
import org.thayer.Util;

import java.awt.geom.Point2D;
import java.util.Optional;

public class GenericLayerWithStepNumber implements Layer{
    Brush brush;
    ColorMutator colorMutator;
    PositionMutator positionMutator;
    int numSteps;

    public GenericLayerWithStepNumber(Brush brush, ColorMutator colorMutator,
                                      PositionMutator positionMutator,
                                      int numSteps){
        this.brush = brush;
        this.colorMutator = colorMutator;
        this.positionMutator = positionMutator;
        this.numSteps = numSteps;
    }

    @Override
    public void draw(Canvas canvas) {
        for(int i = 0; i < numSteps; i++){
            brush.stroke(canvas);
            Optional<Point2D> newPoint = positionMutator.getNextPoint(brush.getPosition());
            if(newPoint.isPresent()) {
                brush.setPosition(newPoint.get());
            }
            else {
                brush.setPosition(Util.getRandomPosition(canvas));
                // set the position twice without painting to not draw
                // a line when the brush resets
                brush.setPosition(brush.getPosition());
            }
            brush.setColor(colorMutator.getNextColor(brush.getColor()));
        }
    }
}
