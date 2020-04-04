import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class AlbumCover{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("Images/WinkyFace.png"));

        
        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColors(orig, new int[]{0,1,2}, new int[] {1});
        
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);
        Helpers.checkForHeader(bytes);
        for (int i=0; i<30; i++)
            System.out.println(bytes.removeFirst());
        //System.out.println(Creation.convertBytesToString(bytes));
        
        
        //BufferedImage toWrite = Creation.convertBytesToImage(bytes, 400, 256);
        //VisualInspection.amplifyLSBs(orig, new int[]{1,2}, 1);

        //ImageIO.write(toWrite, "png", new File("ModifiedJake/GroomingAll2ndLSBsAmplified.png"));


    }

}