package org.thayer.Routines;

import org.thayer.Brush.PencilLineBrush;
import org.thayer.Canvas;
import org.thayer.ColorMutator.NoOpColorMutator;
import org.thayer.Layer.BackgroundLayer;
import org.thayer.Layer.GenericLayerWithStepNumber;
import org.thayer.Layer.Layer;
import org.thayer.PositionMutator.VectorFieldPositionMutator;
import org.thayer.Util;

import java.awt.geom.Point2D;

public class VectorFieldTraces {
    public static void firstWork(Canvas canvas){
        Layer backgroundLayer = new BackgroundLayer(Util.hex2Rgb("#0c090d"));
        backgroundLayer.draw(canvas);

        Layer genericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // English Red brush
                new PencilLineBrush(Util.hex2Rgb("#f15946"), new Point2D.Double(100,100)),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y,
                        (x, y) -> x
                ),
                1000000);
        genericLayerWithStepNumber.draw(canvas);

        Layer secondGenericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // Forest green brush
                new PencilLineBrush(Util.hex2Rgb("#103900"), new Point2D.Double(100,100)),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y,
                        (x, y) -> x
                ),
                1000000);
        secondGenericLayerWithStepNumber.draw(canvas);

        Layer thirdGenericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // Fawn brush
                new PencilLineBrush(Util.hex2Rgb("#e59f71"), new Point2D.Double(100,100)),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y,
                        (x, y) -> x
                ),
                1000000);
        thirdGenericLayerWithStepNumber.draw(canvas);
    }

    public static void spiralWork(Canvas canvas){
        Layer backgroundLayer = new BackgroundLayer(Util.hex2Rgb("#0c090d"));
        backgroundLayer.draw(canvas);
        int numSteps = 8000000;

        Layer genericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // English Red brush
                new PencilLineBrush(Util.hex2Rgb("#f15946"), new Point2D.Double(100,100),6),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y - (canvas.getWidth() * .35),
                        (x, y) -> -3*(x - canvas.getWidth() * .35) +  y - (canvas.getWidth() * .35)
                ),
                numSteps);
        genericLayerWithStepNumber.draw(canvas);

        Layer secondGenericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // Forest green brush
                new PencilLineBrush(Util.hex2Rgb("#103900"), new Point2D.Double(100,100),6),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y - (canvas.getWidth() * .35),
                        (x, y) -> -3*(x - canvas.getWidth() * .35) +  y - (canvas.getWidth() * .35)
                ),
                numSteps);
        secondGenericLayerWithStepNumber.draw(canvas);

        Layer thirdGenericLayerWithStepNumber = new GenericLayerWithStepNumber(
                // Fawn brush
                new PencilLineBrush(Util.hex2Rgb("#e59f71"), new Point2D.Double(100,100),6),
                new NoOpColorMutator(),
                new VectorFieldPositionMutator(
                        canvas,
                        (x, y) -> y - (canvas.getWidth() * .35),
                        (x, y) -> -3*(x - canvas.getWidth() * .35) +  y - (canvas.getWidth() * .35)
                ),
                numSteps);
        thirdGenericLayerWithStepNumber.draw(canvas);
    }
}
