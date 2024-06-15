package com.learning.leet.code;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(new PalindromePartitioning().partition(str));
    }

    List<String> currentPath;
    List<List<String>> result;
    String input;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        currentPath = new ArrayList<>();
        input = s;
        partitionFromIndex(0);
        return result;
    }

    private void partitionFromIndex(int start) {
        if (start == input.length()) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int end = start + 1; end <= input.length(); end++) {
            if (isPalindrome(start, end - 1)) {
                currentPath.add(input.substring(start, end));
                partitionFromIndex(end);
                // removing last path from path sequence to check other options
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}