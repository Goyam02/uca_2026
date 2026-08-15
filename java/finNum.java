import java.util.*;

public class finNum{

    public int finNum(int[] nums){

        int n = nums.length;

        for(int num : nums){
            int index = num % n;
            nums[index] += n;
        }

        for(int i = 0 ; i < n ; i++){
            int count = nums[i] /n;
            if(count == 4) return i;
        }
        return 0;

    }
}

class Main{

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 1, 2, 4, 1, 2, 3, 4, 3, 3};

        finNum test = new finNum();
        System.out.println(test.finNum(nums));
    }


}

