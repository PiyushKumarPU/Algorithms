package com.learning.scaler.advance.module2.two.pointers.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given an sorted array of integer A without duplicates and an integer k,
find all the pair such that A[i] + A[j] = k and (i != j).
Note : TC should be O(N) and with constant space.
Example:
    arr1 = {2, 4, 4, 4, 5, 5, 7, 10, 10, 10, 15}
    k = 14
    ans = 9
* */
public class PairCountDuplicateElemWithGivenSum {

    public static void main(String[] args) {
      //  System.out.println(countPairApproach1(List.of(2, 4, 4, 4, 5, 5, 7, 10, 10, 10, 15), 14));
       // System.out.println(countPairApproach2(List.of(2, 4, 4, 4, 5, 5, 7, 10, 10, 10, 15), 14));
        System.out.println(countPairApproach2(List.of(1,1,1,2,2,3,4,5,6,7,8,9), 2));
    }


    public static int countPairApproach1(List<Integer> arr, int target) {
        Map<Integer, Long> freqMap = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> uniqueValues = new ArrayList<>(freqMap.keySet());
        int start = 0, end = uniqueValues.size() - 1, count = 0;
        while (start < end) {
            int sum = uniqueValues.get(start) + uniqueValues.get(end);
            if (sum == target) {
                count += (int) (freqMap.get(uniqueValues.get(start)) * freqMap.get(uniqueValues.get(end)));
                start++;
                end--;
            } else if (sum < target) start++;
            else end--;
        }
        return count;
    }

    public static int countPairApproach2(List<Integer> A, int B) {
        int start = 0, end = A.size() - 1, count = 0;
        while (start < end) {
            int currentSum = A.get(start) + A.get(end);
            if (currentSum == B) {
                // count freq of start and end element if duplicate present
                int iCopy = start, jCopy = end;
                while (Objects.equals(A.get(start), A.get(iCopy))) {
                    iCopy++;
                }
                while (Objects.equals(A.get(end), A.get(jCopy))) {
                    jCopy--;
                }
                count += ((iCopy - start) * (end - jCopy)) % 1000000007;
                start = iCopy;
                end = jCopy;
            } else if (currentSum < B) start++;
            else end--;
        }
        return count;
    }
}
