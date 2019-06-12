package org.thayer.Routines;

import org.thayer.Brush.OvalBrush;
import org.thayer.Canvas;
import org.thayer.ColorMutator.NoOpColorMutator;
import org.thayer.Layer.BackgroundLayer;
import org.thayer.Layer.GenericLayerWithStepNumber;
import org.thayer.Layer.Layer;
import org.thayer.PositionMutator.VectorFieldPositionMutator;
import org.thayer.Util;

import java.awt.geom.Point2D;
import java.util.Random;

public class WIP {
    public static void circlesWIP(Canvas canvas){
        Layer backgroundLayer = new BackgroundLayer(Util.hex2Rgb("#0c090d"));
        backgroundLayer.draw(canvas);
        int numSteps = 1000000;
        Random random = new Random();
        double xLoc = random.nextDouble();
        double yLoc = random.nextDouble();

        Layer thirdGenericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // Fawn brush
                new OvalBrush(Util.hex2Rgb("#e59f71"),
                        new Point2D.Double(100,100),15),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y - (canvas.getWidth() * xLoc),
                        (x, y) -> -3*(x - canvas.getWidth() * xLoc) +  y - (canvas.getHeight() * yLoc)
                ),
                numSteps);
        thirdGenericLayerWithStepNumber.draw(canvas);

        Layer secondGenericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // Forest green brush
                new OvalBrush(Util.hex2Rgb("#103900"),
                        new Point2D.Double(100,100), 30),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y - (canvas.getWidth() * xLoc),
                        (x, y) -> -3*(x - canvas.getWidth() * xLoc) +  y - (canvas.getHeight() * yLoc)
                ),
                numSteps);
        secondGenericLayerWithStepNumber.draw(canvas);

        Layer genericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // English Red brush
                new OvalBrush(Util.hex2Rgb("#f15946"),
                        new Point2D.Double(100,100),60),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y - (canvas.getWidth() * xLoc),
                        (x, y) -> -3*(x - canvas.getWidth() * xLoc) +  y - (canvas.getHeight() * yLoc)
                ),
                numSteps);
        genericLayerWithStepNumber.draw(canvas);
    }
}
