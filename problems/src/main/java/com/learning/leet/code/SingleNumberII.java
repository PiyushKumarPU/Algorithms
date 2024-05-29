package com.learning.leet.code;

public class SingleNumberII {

    public static void main(String[] args) {
        int[] A = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        SingleNumberII numberII = new SingleNumberII();
        System.out.println(numberII.singleNumber(A));
    }

    public int singleNumber(final int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int setBitCount = 0, posBit = 1 << i;
            for (int ele : A) {
                if ((ele & posBit) > 0) {
                    setBitCount++;
                }
            }
            if (setBitCount % 3 > 0) {
                result += (int) Math.pow(2, i);
            }
        }
        return result;
    }

    // https://leetcode.com/problems/single-number-ii/solutions/3714928/bit-manipulation-c-java-python-beginner-friendly/?envType=study-plan-v2&envId=top-interview-150
    public int singleNumber2(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (final int num : nums)
                sum += num >> i & 1;
            sum %= 3;
            ans |= sum << i;
        }

        return ans;
    }

    public int singleNumber3(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (final int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }

        return ones;
    }
}
