package org.thayer.ColorMutator;

import java.awt.*;

public class NoOpColorMutator implements ColorMutator{
    @Override
    public Color getNextColor(Color colorIn) {
        return colorIn;
    }
}
