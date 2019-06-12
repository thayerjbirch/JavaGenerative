package org.thayer.Layer;


import org.thayer.Canvas;

import java.awt.*;

public class BackgroundLayer implements Layer{
    Color backgroundColor;

    public BackgroundLayer(Color color){
        backgroundColor = color;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.getGraphics().setBackground(backgroundColor);
        canvas.getGraphics().setPaint(backgroundColor);
        canvas.getGraphics().fill(new Rectangle(0, 0, canvas.getWidth(), canvas.getHeight()));
    }
}
