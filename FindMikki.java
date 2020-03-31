import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class FindMikki{

    public static void main (String[] args) throws Exception{
        BufferedImage orig = ImageIO.read(new File("GreenMikki.png"));
        BufferedImage mikki = ImageIO.read(new File("kittenbowlMikki_recovered.png"));
        BufferedImage green = ImageIO.read(new File("green.png"));
        BufferedImage test = ImageIO.read(new File("hide_image.png"));
        BufferedImage bigGreen = ImageIO.read(new File("bigGreen.png"));

        //LinkedList<Integer> testBits = Helpers.pullSpecifiedBitsOfSpecificColors(test, new int[]{0,1,2}, new int[]{1});
        //LinkedList<Integer> testBytes = Helpers.convertBitsToBytes(testBits);
        //for (int i=0; i<8; i++)
        //    testBytes.removeFirst();
        //BufferedImage toWrite= Creation.convertBytesToImage(testBytes, 80, 60);

        //addImage (bigGreen, mikki);
        //ImageIO.write(bigGreen, "png", new File("bigGreenWithMikkiInBlue.png"));
        BufferedImage carrier = ImageIO.read(new File("bigGreenWithMikkiInBlue.png"));
        

        //AFTER HERE
        VisualInspection.amplifyLSBs(carrier, new int[]{2}, 8);
        LinkedList<Integer> blueBytes=(Helpers.getBytesOfImage(carrier, new int[]{2}));
        for (Integer i : blueBytes)
            if (i!=255 && i !=0){
                System.out.println("FUCK");
            }
        LinkedList<Integer> bits = Helpers.bitify(blueBytes);
        for (Integer i : bits)
            if (i!=1 && i !=0){
                System.out.println("FUCK2");
            }


        LinkedList<Integer> a = Helpers.convertBitsToBytes(bits);
        

        //BEFORE HERE, something is wrong

        BufferedImage toWrite = Creation.convertBytesToImage(a, 594, 133);
        //ImageIO.write(carrier, "png", new File("jakematai.png"));

       //LinkedList<Integer> MSBs = Helpers.pullSpecifiedBitsOfSpecificColors(carrier, new int[]{2}, new int[]{8});
       //LinkedList<Integer> bytes = Helpers.convertBitsToBytes(MSBs);
       //System.out.println(bytes);
       //BufferedImage toWrite = Creation.convertBytesToImage(bytes, 594, 133);




        ImageIO.write(toWrite, "png", new File("mikkiOutOfBlueDifferent?.png"));


    }

    public static void addImage(BufferedImage image, BufferedImage message){
        LinkedList<Integer> mikkiBits = Helpers.pullSpecifiedBitsOfSpecificColors(message, new int[]{0,1,2}, new int[]{8,7,6,5,4,3,2,1});
        int mikkiSize=mikkiBits.size();
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();
        int bitsAdded=0;

        for (int xx = 0; xx < height; xx++) {
            for (int yy = 0; yy < width; yy++) {
                int[] pixels = raster.getPixel(yy, xx, (int[]) null);
                if (mikkiBits.isEmpty())
                    return;
                
                int bit = mikkiBits.removeFirst();

                   // System.out.println("i="+pixels[i]);
                   // System.out.println("Bit = "+ bit);
                pixels[2] = pixels[2] & 127;
                pixels[2] = pixels[2] | bit*128;
                   // System.out.println("now i = "+pixels[i]);
                
                raster.setPixel(yy, xx, pixels);
                bitsAdded++;
                if (bitsAdded+1==mikkiSize)
                    return;
            }
        }

    }


}