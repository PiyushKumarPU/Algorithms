package com.learning.scaler.intermediate.hashing.assignment;

import java.util.HashSet;

public class FindTimeComplexity {



    /*
    * What is the time complexity of the following:
    *
    * Options are : O(n), O(logn), O(nlogn), O(n^2), None of the above
    * */
    public void calculateTC(int n) {
        HashSet<Integer> s = new HashSet<>();
        for (int j = 0; j < n; j++)
            s.add(j);
    }

}
