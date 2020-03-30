import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FindMikki{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("GreenMikki.png"));
        System.out.println(Helpers.getBytesOfImage(orig));

        for (int i=2000; i< 4000; i++){
            System.out.println(Helpers.getBytesOfImage(orig).get(i));
        }

        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColors(orig, new int[]{0,1,2}, new int[]{5});
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);

        //System.out.println(Helpers.getNumberOfPixels(orig));

        BufferedImage img = Creation.convertBytesToImage(bytes, 80, 60);
        
        
        for (int i=1616; i<1624; i++)
            System.out.print(bits.get(i));
        System.out.println();
        System.out.println(bytes.get(202));
        //for (int i=0; i<1000; i++){
        //System.out.println(bytes.get(i));
        //}
        
        //System.out.println(bytes);
        //BufferedImage test = VisualInspection.amplifyLSBs(orig, new int[] {0,1,2}, 5);
        
        ImageIO.write(img, "png", new File("altered_java.png"));


    }


}