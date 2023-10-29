package com.learning.practise.scaler.self.array;

public class SubArrayWithGivenSumAndLength {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 3, 2, 6, 1}, 3, 11));
        System.out.println(solve(new int[]{4, 2, 2, 5, 1}, 4, 6));
    }

    public static int solve(int[] A, int B, int C) {
        int ans = 0;
        for (int i = 0; i < B; i++) {
            ans += A[i];
        }
        if(ans == C) return 1;
        int startIndex = 1, endIndex = B;
        while(endIndex < A.length){
            ans = ans - A[startIndex-1] + A[endIndex];
            if(ans == C) return 1;
            startIndex++;
            endIndex++;
        }
        return 0;
    }
}
