import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class AlbumCover{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("Images/Grooming.png"));

        
        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColorsVertical(orig, new int[]{0}, new int[] {1});
        
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);
        Helpers.checkForHeader(bytes);
        //for (int i=0; i<30; i++)
           // System.out.println(bytes.removeFirst());
        //bits= Helpers.pullSpecifiedBitsOfSpecificColors(orig, new int[]{0,1,2}, new int[] {1});
        //bytes = Helpers.convertBitsToBytes(bits);
        //System.out.println(Creation.convertBytesToStringOriginal(bytes,300));
        
        
        //BufferedImage toWrite = Creation.convertBytesToImage(bytes, 292, 300);
        //BufferedImage toWrite= VisualInspection.amplifyLSBs(orig, new int[]{0}, 1);

        //ImageIO.write(toWrite, "png", new File("ModifiedJake/MaybeImageFromGrooming.png"));


    }

}