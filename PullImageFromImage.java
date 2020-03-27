
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.LinkedList;

//original example from
// w w w  . jav  a 2s  . com
//example change
//another change
import javax.imageio.ImageIO;

public class PullImageFromImage {

    public static void main(String[] args) throws Exception {
	String imageName = args [0];
        BufferedImage img = colorImage(ImageIO.read(new File(imageName)));
        ImageIO.write(img, "png", new File("altered_java.png"));
    }

    private static BufferedImage colorImage(BufferedImage image) {
        int newHeight=0;
        int newWidth=0;
        int[] bitsForNewHeight = new int[32];
        int[] bitsforNewWidth = new int[32];

        WritableRaster raster = image.getRaster();
        int count=0;
        int i=0;
        while (count < 64){
            int[] pixels = raster.getPixel(i, 0, (int[]) null);
            for (int k = 0; k<3; k++){
                if (count<32){
                    bitsForNewHeight[count]= pixels[k]&1;
                    count++;
                }
                else {
                    if (count ==64){break;}
                    bitsforNewWidth[count-32]=pixels[k]&1;
                    count++;
                }

            }
            i++;
        }

        /*
        for (int bit : bitsForNewHeight){System.out.print(bit);}
        System.out.println();
  
        for (int bit : bitsforNewWidth){System.out.print(bit);}
        System.out.println();
*/
        for (int bit =1; bit< 32; bit++){
            newHeight += bitsForNewHeight[bit] * (int) Math.pow(2,32-bit);
            newWidth += bitsforNewWidth[bit] * (int) Math.pow(2,32-bit);
        }

       System.out.println(newHeight);
       System.out.println(newWidth);

        


        int width = image.getWidth();
        int height = image.getHeight();

        LinkedList<Integer> LSBs = new LinkedList<>();
        


        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                LSBs.add(pixels[0]&1);
                LSBs.add(pixels[1]&1);
                LSBs.add(pixels[2]&1);

            }

        }

        

        //for (Integer bit : LSBs){System.out.print(bit);}
        for (int m = 0; m <64; m++){LSBs.removeFirst();}
        
        LinkedList<Integer> bytes = BitsToBytes.convertBitsToBytes(LSBs);

        for (int xx =0; xx< newWidth; xx++) {
            for (int yy = 0; yy< newHeight; yy++){
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                for (int l=0; l<3; l++){
                    pixels[l]=bytes.removeFirst();
                    raster.setPixel(xx, yy, pixels);
                }
            }
        }



        return image;
    }
}
