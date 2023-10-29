package com.learning.practise.scaler.advance.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class Add1 {
    public static void main(String[] args) {
        System.out.println(plusOne(List.of(1, 0, 0, 0, 0, 0, 0)));
        System.out.println(plusOne(List.of(0, 0, 0, 0, 0, 0)));
        System.out.println(plusOne(List.of(3,0,6,4,0)));
        System.out.println(plusOne(List.of(2,3,4,5,6,7,8)));
    }

    public static ArrayList<Integer> plusOne(List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int size = A.size(), carry = 1;
        int index;
        for(index = 0; index < size;index++){
            int val = A.get(index);
            if(val > 0) {
                break;
            }
        }
        for(int i = size-1; i >= index; i--){
            int sum = A.get(i) + carry;
            if (sum > 9) {
                result.add(0, 0);
            } else {
                result.add(0, sum);
                carry = 0;
            }
        }
        if (carry > 0) result.add(0, carry);
        return result;
    }
}
