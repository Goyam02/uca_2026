import java.util.*;


public class bitAnd{
    
    public int bitAnd(int x, int y){
        return(~(~x | ~y));
    }

}


class Main{
    public static void main(String[] args){
        bitAnd test1 = new bitAnd();

        System.out.println(test1.bitAnd(6,5));
    }
}

