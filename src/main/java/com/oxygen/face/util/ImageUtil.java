package com.oxygen.face.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtil {
    // BufferedImage转流
    public static ByteArrayOutputStream image2Stream(BufferedImage image) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out;
    }

    // BufferedImage转byte[]
    public static byte[] image2byte(BufferedImage image) {
        ByteArrayOutputStream out = image2Stream(image);
        return out.toByteArray();
    }

}