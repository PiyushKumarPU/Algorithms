package com.learning.leet.code;

public class SortColors {

    public void sortColors(int[] nums) {

        // first count 0,1 and 2
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int i : nums) {
            if (i == 0) zeroCount++;
            else if (i == 1) oneCount++;
            else twoCount++;
        }
        int zeroStarIndex = 0, firstStartIndex = zeroCount, secondStartIndex = zeroCount + oneCount - 1;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            switch (current) {
                case 0:
                    int temp = nums[zeroStarIndex];
                    nums[zeroStarIndex] = 0;
                    zeroStarIndex++;
                    if (temp != 0) {
                        if (temp == 1) {
                            temp = nums[firstStartIndex];
                            nums[firstStartIndex] = 1;
                            firstStartIndex++;
                        }else{

                        }
                    }
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }


    }
}
