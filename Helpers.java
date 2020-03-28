import java.util.LinkedList;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Helpers{

    public static LinkedList<Integer> pullRGBLSBs(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
       // System.out.println("Height: " + height + " Width: " + width);
        
        LinkedList<Integer> bits = new LinkedList<Integer>();
        WritableRaster raster = image.getRaster();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int[] pixels = raster.getPixel(c, r, (int[]) null);
                for (int i=0; i<3; i++){
                    bits.add(pixels[i]&1);
                }
            }
        }
        return bits;
    }
    public static LinkedList<Integer> convertBitsToBytes(LinkedList<Integer> bits){
        //Make a copy of bits, so it is not modified outside this method. only alter the copy
        LinkedList<Integer> localBits = new LinkedList<Integer>();
        for(Integer i: bits){localBits.add(i);}

        LinkedList<Integer> bytes = new LinkedList<Integer>();
        //int size=bits.size();
        //System.out.println("Length of bits " + bits.size());
        /*for (int i =0; i<80; i++){
            if (i%8==0)System.out.println();
            System.out.print(bits.get(i));
        }*/
        

        while (!localBits.isEmpty()){
            int nextByte=0;
            for (int i=0; i<8; i++){
                
                nextByte+=localBits.removeFirst()*((int) Math.pow(2, 7-i));
                
            }
            bytes.add(nextByte);
        }

        /*for (int i=0; i< 10; i++){
            System.out.println(bytes.get(i));
        }

        System.out.println("length of bytes " + bytes.size());
        System.out.println(bytes.size()*8==size);*/
        return bytes;

    }
    public static String convertBytesToString(LinkedList<Integer> bytes){
        //TODO: test this
        LinkedList<Integer> localBytes = new LinkedList<Integer>();
        for (Integer i : bytes){localBytes.add(i);}//Copies bytes into a local variable
        //This method should not modify the List called bytes, rather copy it and
        //modify the local version
        String toReturn = "";
        //insert code here to throwaway header/garbage bytes
        for (int i=0; i<100; i++){//change this line if you want to specify length
            toReturn += (char) localBytes.removeFirst().intValue();
        }

        return toReturn;
    }
    public static LinkedList<Integer> pullRGBSecondLSBs(BufferedImage image){
        //TODO test this
        int width = image.getWidth();
        int height = image.getHeight();
       // System.out.println("Height: " + height + " Width: " + width);
        
        LinkedList<Integer> bits = new LinkedList<Integer>();
        WritableRaster raster = image.getRaster();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int[] pixels = raster.getPixel(c, r, (int[]) null);
                for (int i=0; i<3; i++){
                    bits.add(pixels[i]&2);
                }
            }
        }
        return bits;
    
    }
    public static LinkedList<Integer> pullLSBsOfSpecificColors(BufferedImage image, int[] colors){
        //TODO test this method
        //Pull LSBs of one color channel. R=0, G=1, B=2. Input array must be in increasing order
        int width = image.getWidth();
        int height = image.getHeight();
       // System.out.println("Height: " + height + " Width: " + width);
        
        LinkedList<Integer> bits = new LinkedList<Integer>();
        WritableRaster raster = image.getRaster();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int[] pixels = raster.getPixel(c, r, (int[]) null);
                for (int i : colors){
                    bits.add(pixels[i]&1); 
                }
            }
        }
        return bits;
    }
    public static void checkForHeader(LinkedList<Integer> bytes){
        //Print out the first three ints in big and little endian. as 32 bit ints
        int[] firstBytes = new int[12];
        for (int i =0; i < 12; i++){
            firstBytes[i]=bytes.get(i);
        }
        int intOneBigEndian= (firstBytes[0]<<24) + (firstBytes[1]<<16)+(firstBytes[2]<<8)+(firstBytes[3]);
        int intTwoBigEndian = (firstBytes[4]<<24) + (firstBytes[5]<<16)+(firstBytes[6]<<8)+(firstBytes[7]);
        int intThreeBigEndian = (firstBytes[8]<<24) + (firstBytes[9]<<16)+(firstBytes[10]<<8)+(firstBytes[11]);


        int intOneLittleEndian = (firstBytes[3]<<24) + (firstBytes[2]<<16)+(firstBytes[1]<<8)+(firstBytes[0]);
        int intTwoLittleEndian = (firstBytes[7]<<24) + (firstBytes[6]<<16)+(firstBytes[5]<<8)+(firstBytes[4]);
        int intThreeLittleEndian= (firstBytes[11]<<24) + (firstBytes[10]<<16)+(firstBytes[9]<<8)+(firstBytes[8]);

        System.out.println("Big Endian: " + intOneBigEndian + ", " + intTwoBigEndian+ ", " + intThreeBigEndian);
        System.out.println("Little Endian: " + intOneLittleEndian + ", " + intTwoLittleEndian+ ", " + intThreeLittleEndian);
    }
}
