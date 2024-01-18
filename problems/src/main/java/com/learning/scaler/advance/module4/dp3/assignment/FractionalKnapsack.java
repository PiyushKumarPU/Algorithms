package com.learning.scaler.advance.module4.dp3.assignment;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given two integer arrays A and B of size N each which represent values and weights associated with N items
    respectively.
    Also given an integer C which represents knapsack capacity.
    Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans,
    then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
    NOTE:
        You can break an item for maximizing the total value of the knapsack

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i], B[i] <= 10^3
    1 <= C <= 10^3

Input Format
    First argument is an integer array A of size N denoting the values on N items.
    Second argument is an integer array B of size N denoting the weights on N items.
    Third argument is an integer C denoting the knapsack capacity.

Output Format
    Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.

Example Input
    Input 1:
         A = [60, 100, 120]
         B = [10, 20, 30]
         C = 50
    Input 2:
         A = [10, 20, 30, 40]
         B = [12, 13, 15, 19]
         C = 10
Example Output
    Output 1:
        24000
    Output 2:
        2105

Example Explanation
    Explanation 1:
        Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
        the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
    Explanation 2:
        Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
* */
public class FractionalKnapsack {

    public static void main(String[] args) {
        FractionalKnapsack knapsack = new FractionalKnapsack();

        System.out.println(knapsack.solve(new ArrayList<>(List.of(3)),
                new ArrayList<>(List.of(20)),
                17));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        double maxProfit = 0;
        List<Sack> sackList = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            sackList.add(new Sack(A.get(i), B.get(i)));
        }
        sackList.sort((a, b) -> b.unitPrice.compareTo(a.unitPrice));
        System.out.println(sackList);
        for (Sack sack : sackList) {
            if (C == 0) break;
            else if (sack.weight >= C) {
                maxProfit += sack.unitPrice * C;
                break;
            } else {
                maxProfit += sack.profit;
                C -= sack.weight;
            }
        }
        return (int) Double.parseDouble(String.format("%2f", maxProfit * 100));
    }
}

class Sack {
    public Integer profit;
    public Integer weight;
    public Double unitPrice;

    public Sack(Integer profit, Integer weight) {
        this.profit = profit;
        this.weight = weight;
        this.unitPrice = profit / (double) weight;
    }
}
