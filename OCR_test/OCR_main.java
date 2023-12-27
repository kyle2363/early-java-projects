package OCR_test;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class OCR_main {
    public static void main(String[] args) throws IOException {
        OCR_Processor pro = new OCR_Processor();
        String img5 = "C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\OCR_test\\real_test\\block2.jpg";//"C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\OCR_test\\real_test\\the1.jpg";
        BufferedImage pic5 = ImageIO.read(new File(img5));
        double scale=1;
        if(pic5.getWidth()<2000)
        {
            scale=1.5;
        }
        String s3 = pro.processArray(imgToArray(scaleBI(pic5, scale), 25));
        System.out.println("Output: " + s3.toLowerCase());
    }

    public static BufferedImage scaleBI(BufferedImage pic, double scale) {
        if(scale==1.0)
            return pic;
        int w = pic.getWidth();
        int h = pic.getHeight();
        BufferedImage after = new BufferedImage((int) (w * scale), (int) (h * scale), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        return scaleOp.filter(pic, after);
    }

    public static int[][] imgToArray(BufferedImage pic, int t) {
        int h = pic.getHeight(), w = pic.getWidth();
        Color avgWhite = getAvgColor(pic);
        int[][] a = new int[h + 2][w + 2];
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                Color c = new Color(pic.getRGB(j, i));
                if (c.getRed() < avgWhite.getRed()/2 && c.getGreen() < avgWhite.getGreen()/2
                        && c.getBlue() < avgWhite.getBlue()/2) {
                    a[i][j] = 1;
                }
            }
        }
        /*
         * boolean go = true;
         * int coloum = 0;
         * while (go) {
         * for (int i = 0; i < a.length; i++) {
         * if (a[i][coloum] == 1) {
         * go = false;
         * coloum--;
         * }
         * }
         * coloum++;
         * }
         * int[][] a2 = new int[h][w - coloum + 2];
         * for (int i = 0; i < h; i++) {
         * for (int j = coloum; j < h + 2; j++) {
         * a2[i][j - coloum] = a[i][j];
         * }
         * }
         */

        return a;
    }

    public static Color getAvgColor(BufferedImage img) {
        double avgR = 0, avgG = 0, avgB = 0;
        int total = 1;
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color c = new Color(img.getRGB(j, i));
                avgR = (avgR * (total-1) + c.getRed()) / total;
                avgG = (avgG * (total-1) + c.getBlue()) / total;
                avgB = (avgB * (total-1) + c.getGreen()) / total;
                total++;
            }
        }
        Color avgC = new Color((int) avgR, (int) avgG, (int) avgB);
        return avgC;
    }

    public static void print2DArray(int[][] a) {
        for (int[] n : a) {
            System.out.print("[");
            for (int i : n) {
                if (i == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(i + "");
                }
            }
            System.out.println("]");
        }
    }
}
