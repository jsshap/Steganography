import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;
public class Creation {

    public static BufferedImage convertBytesToImage(LinkedList<Integer> bytes, int height, int width, int[] colors){
        LinkedList<Integer> localBytes = new LinkedList<Integer>();
        for (Integer i : bytes){
            localBytes.add(i);
        }
        //now turn local bytes into a png
        BufferedImage image = new BufferedImage (width, height, 6);//just trust the constant
        WritableRaster raster = image.getRaster();
        for (int xx =0; xx< width; xx++) {
            for (int yy = 0; yy< height; yy++){
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                for (int l:colors){
                    int byte1 = localBytes.removeFirst();
                    pixels[l]=byte1;
                    pixels [3]=255; 
                }
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
    public static BufferedImage convertBytesToImage(LinkedList<Integer> bytes, int height, int width){
        return convertBytesToImage(bytes,height,width, new int[]{0,1,2});
    }
    public static String convertBytesToString(LinkedList<Integer> bytes){
        LinkedList<Integer> localBytes = new LinkedList<Integer>();
        for (Integer i : bytes){localBytes.add(i);}//Copies bytes into a local variable
        //This method should not modify the List called bytes, rather copy it and
        //modify the local version
        String toReturn = "";
        //insert code here to throwaway header/garbage bytes
        for (int i=0; i<100; i++){//change this line if you want to specify length
            toReturn += (char) localBytes.removeFirst().intValue();
        }

        return toReturn;
    }
}