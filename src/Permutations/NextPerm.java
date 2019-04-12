package Permutations;

import java.util.Arrays;

public class NextPerm {

    public NextPerm(int[] nums){
        int temp;
        int beginning = 0;
        int current = nums[0];
        int length = nums.length;
        if(nums.length < 2) return;
        for(int i = 1; i < length; i++){
            if(current < nums[i]) beginning = i;
            current = nums[i];
        }

        if(beginning < length-1){
            if(beginning == 0){
                //reverse all
                for(int i = 0; i < length/2; i++){
                    temp = nums[i];
                    nums[i] = nums[length-1-i];
                    nums[length-1-i] = temp;
                }
                System.out.print("[reverse all]");
                System.out.print(Arrays.toString(nums));
                return;
            }
            // swap root to closest root = b-1
            int root = beginning-1;
            for(int i = length-1; i >= beginning; i--) {
                if (nums[i] > nums[root]) {
                    // Swapping
                    temp = nums[i];
                    nums[i] = nums[root];
                    nums[root] = temp;
                    break;
                }
            }
            // reverse sequence
            for( int j =0; j < (length-beginning)/2; j++){
                temp = nums[beginning+j];
                nums[beginning+j] = nums[length - 1 -j];
                nums[length-1-j] = temp;
            }
            System.out.print("[Swap root and reverse]");
            System.out.print(Arrays.toString(nums));
        }else {
            // swap last two
            temp = nums[length-1];
            nums[length-1] = nums[length-2];
            nums[length-2] = temp;
            System.out.print("[Swap last two]");
            System.out.print(Arrays.toString(nums));
        }
    }



}
