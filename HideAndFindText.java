import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;
import java.util.Scanner;

public class HideAndFindText{

    public static Scanner input = new Scanner(System.in);
    public static void main (String[] args) throws Exception{
        String file = args[0];
        
        if (args[1].equals("Hide")){
            addText (file);
        }
        else if (args[1].equals("Reveal")){
            revealText(file);
        }

        

    }
    public static void revealText (String fileName) throws Exception {
        BufferedImage carrier = ImageIO.read(new File(fileName));
        LinkedList<Integer> bits = Helpers.pullSpecifiedBitsOfSpecificColors(carrier, new int[]{2}, new int[]{1});
        LinkedList<Integer> bytes = Helpers.convertBitsToBytes(bits);
        for (Integer i : bytes){
            if ((char) i.intValue()=='¥'){
                return;
            }
            System.out.print((char) i.intValue());
            System.out.println();
        }
    }

    public static void addText(String fileName) throws Exception{

        BufferedImage carrier = ImageIO.read(new File(fileName));

        String s = input.nextLine();

        LinkedList<Integer> chars = new LinkedList<Integer>();
        for (int i=0; i<s.length(); i++){
            chars.add((int)s.charAt(i));
        }

        LinkedList<Integer> bits = new LinkedList<Integer>();
        for (Integer i : chars){
            for (int j = 7; j >-1; j-- ){
                bits.add( i >> j & 1);
            }
        }
        int width = carrier.getWidth();
        int height = carrier.getHeight();
        WritableRaster raster = carrier.getRaster();
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                if (bits.isEmpty())
                    break;        
                int bit = bits.removeFirst();
                pixels[2] = pixels[2] & 254;
                pixels[2] = pixels[2] | bit;
                raster.setPixel(xx, yy, pixels);   
            }
            if (bits.isEmpty())
                break;
        }
        ImageIO.write(carrier, "png", new File("hiddenText.png"));

    }




}