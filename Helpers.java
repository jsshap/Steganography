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
        //int size=bits.size();
        //System.out.println("Length of bits " + bits.size());
        /*for (int i =0; i<80; i++){
            if (i%8==0)System.out.println();
            System.out.print(bits.get(i));
        }*/
        

        while (!bits.isEmpty()){
            int nextByte=0;
            for (int i=0; i<8; i++){
                
                nextByte+=bits.removeFirst()*((int) Math.pow(2, 7-i));
                
            }
            bytes.add(nextByte);
        }

        /*for (int i=0; i< 10; i++){
            System.out.println(bytes.get(i));
        }

        System.out.println("length of bytes " + bytes.size());
        System.out.println(bytes.size()*8==size);*/
        return bytes;

    }
    public static String convertBytesToString(LinkedList<Integer> bytes){
        //WRITE THIS
        return null;
    }
    public static LinkedList<Integer> pullRGBSecondLSBs(BufferedImage image){
        //TODO
        return null;
    }

}