import java.util.*;


public class bitXor{
   
    public int bitXor(int x, int y){
        return ~(~(~x & y) & ~(x & ~y));
    }

}


class Main {

    public static void main(String[] args) {

        bitXor xor = new bitXor();
        System.out.println(xor.bitXor(4, 5));
    }
}
