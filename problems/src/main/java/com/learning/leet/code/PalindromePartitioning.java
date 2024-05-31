package com.learning.leet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(new PalindromePartitioning().partition1(str));
    }

    public List<List<String>> partition1(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String currentSub = s.substring(start, end);
            if (isPalindrome(currentSub)) {
                path.add(currentSub);
                backtrack(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String sub) {
        int left = 0, right = sub.length() - 1;
        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public List<String> partition(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // check for even length palindrome
            findMaxLengthPalindrome(i, i, s).ifPresent(result::add);
            findMaxLengthPalindrome(i, i + 1, s).ifPresent(result::add);
        }
        return result;
    }

    private Optional<String> findMaxLengthPalindrome(int left, int right, String A) {
        while (left >= 0 && right < A.length()) {
            if (A.charAt(left) != A.charAt(right))
                return Optional.empty();
            else {
                left--;
                right++;
            }
        }
        return Optional.of(A.substring(left + 1, right));
    }

}
