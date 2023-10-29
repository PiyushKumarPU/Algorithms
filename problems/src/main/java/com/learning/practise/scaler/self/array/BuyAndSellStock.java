package com.learning.practise.scaler.self.array;

public class BuyAndSellStock {

    public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{}));
    }

    public static int maxProfit(final int[] A) {
        int maxProfit = Integer.MIN_VALUE;
        int arraySize = A.length;
        int[] PFMax = new int[arraySize];
        PFMax[arraySize-1] = A[arraySize-1];
        for(int index = arraySize-2; index >=0; index--){
            PFMax[index] = Math.max(PFMax[index+1],A[index]);
        }
        for(int index = 0; index < arraySize; index++){
            maxProfit = Math.max(maxProfit, (PFMax[index] - A[index]));
        }
        return maxProfit;
    }
}
