import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;
public class Helpers{

    public static LinkedList<Integer> pullRGBLSBs(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
       // System.out.println("Height: " + height + " Width: " + width);
        
        LinkedList<Integer> bits = new LinkedList<Integer>();
        WritableRaster raster = image.getRaster();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int[] pixels = raster.getPixel(c, r, (int[]) null);
                for (int i=0; i<3; i++){
                    bits.add(pixels[i]&1);
                }
            }
        }
        return bits;
    }
    public static LinkedList<Integer> convertBitsToBytes(LinkedList<Integer> bits){
        LinkedList<Integer> bytes = new LinkedList<Integer>();

        while (!bits.isEmpty()){
            for (int i=0; i<8; i++){
                int nextByte=0;
                nextByte+=bits.removeFirst()*((int) Math.pow(2, 7-i));
                bytes.add(nextByte);
            }
        }
        return bytes;
    }

}