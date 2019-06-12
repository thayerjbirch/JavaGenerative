package org.thayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas {
    private int width;
    private int height;
    private Graphics2D graphics;
    private BufferedImage bufferedImage;

    public Canvas(int width, int height){
        this.width = width;
        this.height = height;

        // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
        // into integer pixels
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        graphics = bufferedImage.createGraphics();
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void toFile(File file) throws IOException {
        ImageIO.write(bufferedImage, "PNG", file);
    }
}
