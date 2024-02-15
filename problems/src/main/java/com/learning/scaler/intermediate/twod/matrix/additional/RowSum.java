package com.learning.scaler.intermediate.twod.matrix.additional;


import java.util.ArrayList;
import java.util.List;

/*
Problem Constraints
1 <= A.size() <= 103

1 <= A[i].size() <= 103

1 <= A[i][j] <= 103



Input Format
First argument A is a 2D array of integers.(2D matrix).



Output Format
Return an array containing row-wise sums of original matrix.



Example Input
Input 1:

[1,2,3,4]
[5,6,7,8]
[9,2,3,4]


Example Output
Output 1:

[10,26,18]


Example Explanation
Explanation 1

Row 1 = 1+2+3+4 = 10
Row 2 = 5+6+7+8 = 26
Row 3 = 9+2+3+4 = 18
* */
public class RowSum {

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>(A.size());
        for (List<Integer> input : A) {
            int currentRowSum = 0;
            for (Integer integer : input) {
                currentRowSum += integer;
            }
            result.add(currentRowSum);
        }
        return result;
    }
}
