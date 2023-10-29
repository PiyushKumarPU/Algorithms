package com.learning.practise.scaler.self;

public class MaxPathInTriangle {

    public static void main(String[] args) {


        int[][] inputs = {
                {3, 0, 0},
                {7, 4, 0},
                {2, 4, 6}
        };
        //System.out.println(calculateMaxPathInTriangle(inputs));
        printTriangle(4);


    }

    private static int calculateMaxPathInTriangle(int[][] inputs) {




        return 0;
    }

    private static void printTriangle(int size){
        int startElement =1 ;
        for(int i =0; i < size ;i++){
            for(int j = 0; j< size - (1+i); j++){
                System.out.println(startElement++ +"\t");
            }
            System.out.println("New Line");
        }
    }

}
