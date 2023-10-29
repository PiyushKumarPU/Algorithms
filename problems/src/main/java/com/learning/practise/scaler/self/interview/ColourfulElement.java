package com.learning.practise.scaler.self.interview;

import java.util.HashMap;
import java.util.Map;

public class ColourfulElement {

    public static void main(String[] args) {
        System.out.println(colorful(0));
        System.out.println(colorful(236));
    }

    public static int colorful(int A) {
        String str = String.valueOf(A);
        if (str.length() == 1) return 1;
        long[] pfMul = new long[str.length()];
        Map<Long, Integer> frequencyMap = new HashMap<>();
        pfMul[0] = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            pfMul[i] = pfMul[i - 1] * (str.charAt(i) - '0');
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                long currentElement = (i == j) ? (pfMul[j] / (j > 0 ? pfMul[j - 1] : 1)) :
                        pfMul[j] / (i > 0 ? pfMul[i - 1] : 1);
                if (frequencyMap.containsKey(currentElement)) {
                    return 0;
                } else {
                    frequencyMap.put(currentElement, 1);
                }
            }
        }
        return 1;
    }
}
