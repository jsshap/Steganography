import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class AlbumCover{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("Images/Gadget_medium.png"));

        
        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColors(orig, new int[]{0,1}, new int[] {2,1});
        Helpers.checkForHeader(bits);
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);
        System.out.println(Creation.convertBytesToString(bytes));

        //BufferedImage toWrite = VisualInspection.amplifyLSBs(orig, new int[]{0,1}, 1);

        //ImageIO.write(toWrite, "png", new File("AlbumCover'''''.png"));


    }

}