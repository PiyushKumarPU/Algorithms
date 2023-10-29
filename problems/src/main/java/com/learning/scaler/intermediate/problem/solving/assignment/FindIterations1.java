package com.learning.scaler.intermediate.problem.solving.assignment;

public class FindIterations1 {

    public static void main(String[] args) {

    }

    /*
    * Count no of iterations for below code block and options are
    * 1. N 2. N/2 3. sqrt(N) 4. logN
    * */
    public int countIterations(int N){
        for(int i = 1; i <= N; i++){
            if(i * i == N) return i;
        }
        return 0;
    }
}
