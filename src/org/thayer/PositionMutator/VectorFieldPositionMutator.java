package org.thayer.PositionMutator;

import org.thayer.Canvas;
import java.awt.geom.Point2D;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class VectorFieldPositionMutator implements PositionMutator{
    Canvas canvas;
    BiFunction<Double, Double, Double> xDifferential;
    BiFunction<Double, Double,Double> yDifferential;
    int counter;
    double stepSize;

    static int MAX_STEPS = 10000;

    public VectorFieldPositionMutator(Canvas canvas,
                                      BiFunction<Double, Double, Double> xDifferential,
                                      BiFunction<Double, Double, Double> yDifferential){
        this(canvas, xDifferential, yDifferential, .25);
    }

    public VectorFieldPositionMutator(Canvas canvas,
                                      BiFunction<Double, Double, Double> xDifferential,
                                      BiFunction<Double, Double, Double> yDifferential,
                                      double stepSize){
        this.canvas = canvas;
        this.xDifferential = xDifferential;
        this.yDifferential = yDifferential;
        counter = 0;
        this.stepSize = stepSize;
    }

    // Euler's method to to find next point
    @Override
    public Optional<Point2D> getNextPoint(Point2D pointIn) {
        if(pointIn.getX() < 0 || pointIn.getX() > canvas.getWidth() ||
                pointIn.getY() < 0 || pointIn.getY() > canvas.getHeight() ||
                counter >=MAX_STEPS){
            counter = 0;
            return Optional.empty();
        }
        counter+=1;

        double xPrime = xDifferential.apply(pointIn.getX(), pointIn.getY());
        double yPrime = yDifferential.apply(pointIn.getX(), pointIn.getY());
        double hypotenuse = Math.sqrt((xPrime*xPrime) + (yPrime*yPrime));

        if(hypotenuse == 0)
            return Optional.empty();

        double scaledX = (stepSize * xPrime) / hypotenuse;
        double scaledY = (stepSize * yPrime) / hypotenuse;

        return Optional.of(new Point2D.Double(pointIn.getX() + scaledX,
                pointIn.getY() + scaledY));
    }

    public void resetCounter(){
        counter = 0;
    }
}
