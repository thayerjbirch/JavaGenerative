package org.thayer;

import org.thayer.Routines.VectorFieldTraces;
import org.thayer.Routines.WIP;

import java.io.File;
import java.io.IOException;

public class Main {
    static public void main(String args[]) throws Exception {
        try {
            for (int i = 0; i < 25; i++) {
                Canvas canvas = new Canvas(12000, 8000);
                //VectorFieldTraces.spiralWork(canvas);
                WIP.circlesWIP(canvas);


                // Layer randomWalkLayer = new RandomWalkLayer(
                //         new PixelBrush(Util.hex2Rgb("#2d5917"), new Point2D.Double(10,10)),
                //         new NoOpColorMutator());
                // randomWalkLayer.draw(canvas);


                //Stereonet asdf = new Stereonet(100, 100, 75, Color.GREEN);
                //asdf.draw(canvas.getGraphics());

                canvas.toFile(new File("C:\\generated\\" + i + ".png"));
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}
