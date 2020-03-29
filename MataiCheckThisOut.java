import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class MataiCheckThisOut{

    
    public static void main(String[] args) throws Exception {
        BufferedImage image = ImageIO.read(new File("hide_text.png"));
        for (int i=0; i<10000; i++){
            System.out.println(Helpers.getPixelTotalValues(image).get(i));
        }
        /*
        Basically, this prints out the sum of the RGB channels for the first 10,000
        pixels in the image. If you look at the image, the top row (the first several hundred pixels)
        appears to be all 0's (it's transparent so you see the background) but when we run this,
        it shows up as not all 0, which means that the LSBs are one's instead of the
        0's that it looks like they should be. That also happens to be where we know there's a message hidden

        Pretty cool
        Not 100% sure how to use this, but it will help



        */

        
    }
    




}