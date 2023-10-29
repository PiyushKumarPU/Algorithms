package com.learning.practise.scaler.self.bitmanipulation;

public class SumOfBinary {

    public static void main(String[] args) {
        System.out.println(addBinary3("110", "10"));
    }


    public static String addBinary3(String A, String B) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0) {
            int first = i >= 0 ? A.charAt(i) - '0' : 0;
            int second = j >= 0 ? B.charAt(j) - '0' : 0;
            int sum = first + second + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) result.insert(0, carry);
        return result.toString();
    }
}
