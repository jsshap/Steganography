import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.ArrayList;
public class Stats{
    /*This class should consist of various algorithms we can
    * run on images/lists of bits or bytes 
    * to determine if/where an image is hidden
    */

    public static void computeOffByOnes(BufferedImage image, int messageLength){
        //Prints out the number of times where two pixels differ by amounts that are achievable
        //by chaning the LSB of color channels. (When total of RGB is >0 and <=3)
        //For example, if a pixel 145,130,120 borders 146,131,120, the pixel sums would be  
        //395 and 397 respectively. This would count that
        //If you run this method on the pixels of hide_text with message length 3*(572*8)
        //it outputs 468, 134, 161 which shows there are more offByOnes when there is a message
        //if you do it with length 1000, you can clearly see where the image is


        LinkedList<Integer> pixels = Helpers.getPixelTotalValues(image);
        ArrayList<Integer> pixelsArray = new ArrayList<Integer>();
        for (Integer i: pixels){
            pixelsArray.add(i);
        }//I totally used data structures knowledge and switched from a LL to an Array
        // because I wanted O(1) indexing later and I think that's cool lol

        int[] offByOnes = new int[10];
        int pixelDiff;
        for (int i = 0; i<10; i++){
            for (int j = messageLength*i; j<messageLength*(i+1); j++){
                pixelDiff = pixelsArray.get(j)-pixelsArray.get(j+1);
                if (pixelDiff<=3 && pixelDiff >0 ){
                    offByOnes[i]++;
                }
            }
        }
        for (int i : offByOnes){
            System.out.println(i);}

    }
    public static void computeOffByOnes(BufferedImage image){
        //if no message length specifed, do it with 1000
        computeOffByOnes(image, 1000);
    }


}