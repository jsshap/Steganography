
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FilterFromClass {

    //THIS CLASS IS OBSOLETE NOW. colorImage is now encapsulated in VisualInspection
    //just run using [0,1,2]

    public static void main(String[] args) throws Exception {
    String imageName = args [0];
    int[] colors = {0,1,2};
        BufferedImage img = VisualInspection.amplifyLSBs(ImageIO.read(new File(imageName)), colors, 1);
        //BufferedImage img2 = colorImage(ImageIO.read(new File(imageName)));
        ImageIO.write(img, "png", new File("altered_java.png"));
        //ImageIO.write(img2, "png", new File("altered_java1.png"));
    }
    /*
    private static BufferedImage colorImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = (pixels[0] & 1)*255;
                pixels[1] = (pixels[1] & 1)*255;
                pixels[2] = (pixels[2] & 1)*255;
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }*/
}
