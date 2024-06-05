package com.learning.algo;

public class Example {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("zbab"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length(); // Get the length of the input string
        // Preprocess the string by inserting '#' between each character and at the boundaries
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append('#').append(c); // Append '#' and the character
        }
        sb.append('#'); // Append '#' at the end
        char[] newStr = sb.toString().toCharArray(); // Convert the StringBuilder to a char array

        int[] p = new int[newStr.length]; // Array to store the radius of the palindrome at each position
        int center = 0, right = 0; // Initialize the center and right boundary of the current rightmost palindrome
        int longestLength = 0, longestCenter = 0; // Variables to store the length and center of the longest palindrome found

        for (int i = 0; i < newStr.length; i++) { // Loop through each character in the newStr
            int mirror = 2 * center - i; // Calculate the mirror position of i with respect to the current center

            // If the current position is within the right boundary
            if (right > i) {
                p[i] = Math.min(p[mirror], right - i); // Set p[i] to the minimum value of p[mirror] and the distance to the right boundary
            }

            // Expand the palindrome centered at i
            int a = i + p[i] + 1; // Position to expand to the right
            int b = i - p[i] - 1; // Position to expand to the left
            while (a < newStr.length && b >= 0 && newStr[a] == newStr[b]) { // Expand while the characters on both sides are equal
                p[i]++; // Increment the radius of the palindrome
                a++; // Move to the next character on the right
                b--; // Move to the next character on the left
            }

            // Update the rightmost boundary and center if the palindrome centered at i expands beyond the current right boundary
            if (i + p[i] > right) {
                center = i; // Update the center
                right = i + p[i]; // Update the right boundary
            }

            // Update the longest palindrome found
            if (p[i] > longestLength) {
                longestLength = p[i]; // Update the length of the longest palindrome
                longestCenter = i; // Update the center of the longest palindrome
            }
        }

        // Extract the longest palindromic substring
        int start = longestCenter - longestLength; // Calculate the start index of the longest palindrome
        int end = longestCenter + longestLength; // Calculate the end index of the longest palindrome
        StringBuilder result = new StringBuilder(); // StringBuilder to construct the result
        for (int i = start; i <= end; i++) {
            if (newStr[i] != '#') { // Ignore the '#' characters
                result.append(newStr[i]); // Append the character to the result
            }
        }
        return result.toString(); // Return the longest palindromic substring
    }


}
