import java.util.LinkedList;
public class bitsToBytes{

    public static LinkedList<Integer> convertBitsToBytes(LinkedList<Integer> bits){
        LinkedList<Integer> bytes = new LinkedList<Integer>();

        while (!bits.isEmpty()){
            for (int i=1; i<8; i++){
                int nextByte=0;
                nextByte+=bits.removeFirst()*((int) Math.pow(2, 7-i));
                bytes.add(nextByte);
            }
        }
        return bytes;
    }
}