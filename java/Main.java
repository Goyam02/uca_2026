import java.util.*;

class Main{

    public static int longestConsecutive(int[] nums){

        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int longestSeq = 0;

        for(int num : set){
            if(!set.contains(num-1)){

                int sequence = 1;

                while(set.contains(num+1)){
                    sequence++;
                    num++;
                }

                longestSeq = Math.max(longestSeq, sequence);
            }
        }

        return longestSeq;

    }
    
    public static void main(String[] args){
        int[] nums = {101,103,105,107,109,111,112};
        int[] nums1 = {};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums1));

    }


}
