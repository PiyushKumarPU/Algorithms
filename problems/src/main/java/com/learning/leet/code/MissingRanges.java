package com.learning.leet.code;


/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
return its missing ranges.

Examples :
    Input: nums = [0, 1, 3, 50, 75], lower = 0, upper = 99
    Output: ["2", "4->49", "51->74", "76->99"]
    Explanation: The ranges are:
    [0,1], [2,2], [3,3], [4,49], [50,50], [51,74], [75,75], [76,99]

    Input: nums = [], lower = 1, upper = 1
    Output: ["1"]
    Explanation: The only range is [1,1], which is missing.

    Input: nums = [], lower = -3, upper = -1
    Output: ["-3->-1"]
    Explanation: The only range is [-3,-1], which is missing.

    Constraints
        -10^9 <= lower <= upper <= 10^9
        0 <= nums.length <= 100
        lower <= nums[i] <= upper
        All the values of nums are unique.
        nums is sorted in increasing order.


* */

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        System.out.println(missingRanges(new int[]{1, 2, 3, 6, 8}, 1, 9));
        // ["2", "4->49", "51->74", "76->99"]
        System.out.println(missingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        // ["1"]
        System.out.println(missingRanges(new int[]{}, 1, 1));
        // ["-3->-1"]
        System.out.println(missingRanges(new int[]{}, -3, -1));
    }

    /*
        Solution approcah
        Store all the available element in set to check its presence
        Start iterating from lower till upper bound
        if(map.contains(i)) i++; // keep increasing until we find element
        if(!map.contains(i)) make i as start of range assign end = i
        keep increasing end until we cant find element in hash, once find that would be value of end
        add start --> end in result range and assign start = end + 1 to continue loop

        TC : O(upper-lower + 1)
        SC : O(n)

    * */
    public static List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        //if (arr == null || arr.length == 0) return result;
        HashSet<Integer> availableNumbers = new HashSet<>();
        for (int i : arr) availableNumbers.add(i);
        int start = lower;
        while (start <= upper) {
            if (availableNumbers.contains(start)) start++;
            else {
                int j = start;
                while (j < upper && !availableNumbers.contains(j + 1)) j++;
                ArrayList<Integer> row = new ArrayList<>(2);
                row.add(start);
                if (start != j) row.add(j);
                result.add(row);
                start = j + 1;
            }
        }
        return result;
    }

    /*
    Solution approach:
        start iterating given and assign a variable called next == lower
        will keep iterating until array element is less than next
        once it is equal to next, increment next by 1 and continue
        if array element is greater than next add range from next till current array ele  -1
        assign next = num + 1 // start checking from next number as we already considered current number
        TC : O(n)
        SC : O(1)
    * */
    public static List<List<Integer>> missingRangesNoSpace(int[] arr, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int next = lower;

        for (int num : arr) {
            if (num <= next) {
                if (num == next) next++;
                continue;
            }
            result.add(getRange(next, num - 1));
            next = num + 1;
        }
        if (next <= upper) {
            result.add(getRange(next, upper));
        }
        return result;
    }

    // Especially application when given array has very less number and range between upper and lower bound is very large
    public static List<List<Integer>> missingRangesUsingBitSet(int[] arr, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        BitSet bitSet = new BitSet(upper - lower + 1);

        // Mark the positions in the BitSet
        for (int num : arr) {
            if (num >= lower && num <= upper) {
                bitSet.set(num - lower);
            }
        }

        int start = lower;
        while (start <= upper) {
            if (!bitSet.get(start - lower)) {
                int end = start;
                while (end <= upper && !bitSet.get(end - lower)) {
                    end++;
                }
                result.add(getRange(start, end - 1));
                start = end;
            } else {
                start++;
            }
        }

        return result;
    }

    private static List<Integer> getRange(int start, int end) {
        List<Integer> range = new ArrayList<>();
        range.add(start);
        if (start != end) {
            range.add(end);
        }
        return range;
    }

}
