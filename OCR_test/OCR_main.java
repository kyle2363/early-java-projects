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
        /*String imagePath = "C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\OCR_test\\Word_The.png";
        String img2 = "C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\OCR_test\\10_degree.png";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        BufferedImage myPicture2 = ImageIO.read(new File(img2));
        int[][] a = imgToArray(myPicture, 15);
        String s = pro.processArray(a);*/

        /*String img3 = "C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\OCR_test\\test text.png";
        BufferedImage pic3 = ImageIO.read(new File(img3));
        String s2 = pro.processArray(imgToArray(scaleBI(pic3,2), 25));
        System.out.println(s2.toLowerCase());
        System.out.println();*/
        String img4 = "C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\OCR_test\\Screenshot (65).png";
        BufferedImage pic4 = ImageIO.read(new File(img4));
        //print2DArray(imgToArray(scaleBI(pic4,2),25));
        String s3 = pro.processArray(imgToArray(scaleBI(pic4,2), 25));
        System.out.println(s3.toLowerCase());
    }
    public static BufferedImage scaleBI(BufferedImage pic,int scale)
    {
        int w = pic.getWidth();
        int h = pic.getHeight();
        BufferedImage after = new BufferedImage(w * scale, h * scale, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        return scaleOp.filter(pic, after);
    }

    public static int[][] imgToArray(BufferedImage pic, int t) {
        int h = pic.getHeight(), w = pic.getWidth();
        int[][] a = new int[h + 2][w + 2];
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                Color c = new Color(pic.getRGB(j, i));
                if (c.getRed() < t && c.getGreen() < t && c.getBlue() < t) {
                    a[i][j] = 1;
                }
            }
        }
        boolean go = true;
        int coloum = 0;
        while (go) {
            for (int i = 0; i < a.length; i++) {
                if (a[i][coloum] == 1) {
                    go = false;
                    coloum--;
                }
            }
            coloum++;
        }
        int[][] a2 = new int[h][w - coloum + 2];
        for (int i = 0; i < h; i++) {
            for (int j = coloum; j < h + 2; j++) {
                a2[i][j - coloum] = a[i][j];
            }
        }

        return a;
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
