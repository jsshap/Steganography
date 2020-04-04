import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class AlbumCover{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("Images/Brothers.png"));

        
        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColorsShort(orig, new int[]{0}, new int[] {1});
        
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);
        Helpers.checkForHeader(bytes);
        //for (int i=0; i<30; i++)
           // System.out.println(bytes.removeFirst());
        //System.out.println(Creation.convertBytesToStringOriginal(bytes,160));
        
        
        BufferedImage toWrite = Creation.convertBytesToImage(bytes, 400, 512);
        //BufferedImage toWrite2= VisualInspection.amplifyLSBs(toWrite, new int[]{0,1,2}, 2);
        //LinkedList<Integer> bits2 = Helpers.pullSpecifiedBitsOfSpecificColorsShort(toWrite, new int[]{0,1,2}, new int[] {2,1});
        //LinkedList<Integer> bytes2 = Helpers.convertBitsToBytes(bits2);
        //Helpers.checkForHeader(bytes2);
        ImageIO.write(toWrite, "png", new File("ModifiedJake/ImageOutOfBrotherRedLSBsWithLSBSAMPLIFIED.png"));


    }

}