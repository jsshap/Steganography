import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class AlbumCover{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("Images/Gadget_medium.png"));

        
        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColorsVertical(orig, new int[]{1,2}, new int[] {1});
        //bits = Helpers.flipBits(bits);
        for (int i = 0; i<1000; i++){
            bits.removeFirst();
        }
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);

        Helpers.checkForHeader(bytes);
        //Helpers.findStringOfZeroBytes(bytes);
        //for (Integer i: bytes){System.out.print(i);}
        Creation.convertBytesToStringOriginal(bytes,60);
        
        //Helpers.findStringOfZeroPixels(Helpers.getPixelTotalValuesVertical(orig));
        //Helpers.findHeader(bytes);

        //for (int i=0; i<8; i++){
          //bytes.removeFirst();
        //}
        //    Stats.computeOffByOnes(orig);
        //System.out.println(Helpers.getPixelTotalValues(orig));
        //BufferedImage toWrite = Creation.convertBytesToImage(bytes, 247,276);
        //BufferedImage toWrite= VisualInspection.amplifyLSBs(orig, new int[]{0,1,2}, 1);
        /*LinkedList<Integer> bits2 = Helpers.pullSpecifiedBitsOfSpecificColorsShort(toWrite, new int[]{1}, new int[] {1});
        LinkedList<Integer> bytes2 = Helpers.convertBitsToBytes(bits2);
        Helpers.checkForHeader(bytes2);
        */
        //ImageIO.write(toWrite, "png", new File("ModifiedJake/Wide2AllLSBsamped.png"));
        

    }

}