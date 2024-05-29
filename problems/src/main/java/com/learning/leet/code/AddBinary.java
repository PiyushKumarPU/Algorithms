package com.learning.leet.code;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary binary = new AddBinary();
        System.out.println(binary.addBinary("1111", "1111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int first = a.length() - 1, second = b.length() - 1, carry = 0;
        while (first >= 0 || second >= 0) {
            int firstChar = first >= 0 ? a.charAt(first) - '0' : 0;
            int secondChar = second >= 0 ? b.charAt(second) - '0' : 0;
            int sum = carry + firstChar + secondChar;
            carry = (sum >= 2) ? 1 : 0;
            sum = sum % 2;
            str.append(sum);
            first--;
            second--;
        }
        if (carry > 0) str.append(carry);
        str.reverse();
        return str.toString();
    }
}
