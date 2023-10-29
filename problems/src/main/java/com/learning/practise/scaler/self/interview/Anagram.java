package com.learning.practise.scaler.self.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(solve("secure", "rescue"));
        System.out.println(solve("cat", "bat"));
        System.out.println(solve("trh", "htr"));
    }

    public static int solve(String A, String B) {
        if (A.length() == B.length()) {
            Map<Character, Integer> aMap = new HashMap<>();
            Map<Character, Integer> bMap = new HashMap<>();
            int start = 0, end = A.length() - 1;
            while (start <= end) {
                aMap.put(A.charAt(start), (aMap.getOrDefault(A.charAt(start), 0) + 1));
                bMap.put(B.charAt(start), (bMap.getOrDefault(B.charAt(start), 0) + 1));
                if (start != end) {
                    aMap.put(A.charAt(end), (aMap.getOrDefault(A.charAt(end), 0) + 1));
                    bMap.put(B.charAt(end), (bMap.getOrDefault(B.charAt(end), 0) + 1));
                }
                start++;
                end--;
            }

            for (Character key : aMap.keySet()) {
                if (!Objects.equals(aMap.get(key), bMap.get(key))) return 0;
            }
            return 1;
        }
        return 0;
    }
}
