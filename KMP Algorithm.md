
## Knuth–Morris–Pratt KMP 

## Scope / Agenda
* Understand KMP algo and use it to solve problems  

## References
* Video
    - [NeetCode](https://www.youtube.com/watch?v=JoF0Z7nVSrA)
    - [Scaler](https://www.scaler.com/topics/data-structures/kmp-algorithm/)
    - [GFG](https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/)
* [Wikipedia](https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm)
     
## Introdcution

> Prefix : Any substring that start with 0 and ends at any index before n-1th index

> Suffix : Any substring that start with n-1th index and end at any index


### Steps to calculate LPS array
> LPS array would be calculated for the given pattern.
* Steps to follow
    - Initialize all the required variables
    - Set lps[0] = 0, there wont be any commomn prefix  and suffix substring for single character
    - set start = 1 and lpsLength = 0
    - Iterate start = 1 till pattern.length -1
    - if(pattern[start] == pattern[lpsLength]) // Current character matches the character at the longestPrefixSuffixLength position
    - increment lpsLength by 1 and set lps[start] = lpsLength and incremenent start by 1
    - if not matches and lpsLength != 0 then keep shifting lpsLength = lps[lpsLength -1] // we are doing to check all prev char 
    - if not matches and lspLength == 0, it means current char did not match with any prev char
        set lps[start] = 0 and increment start by 1
```java
public static int[] computeLPSArray(String pattern) {
    int length = pattern.length(); // Length of the pattern
    int[] lps = new int[length]; // LPS array to hold the longest prefix suffix values
    int longestPrefixSuffixLength = 0; // Length of the previous longest prefix suffix
    int i = 1; // Start from the second character as lps[0] is always 0

    // Loop to fill the LPS array
    while (i < length) {
        if (pattern.charAt(i) == pattern.charAt(longestPrefixSuffixLength)) {
            // Case 1: Current character matches the character at the longestPrefixSuffixLength position
            longestPrefixSuffixLength++; // Increment the length of the current longest prefix suffix
            lps[i] = longestPrefixSuffixLength; // Set the LPS value for the current position
            i++; // Move to the next character
        } else if (longestPrefixSuffixLength != 0) {
            // Case 2: Mismatch after at least one matching character
            longestPrefixSuffixLength = lps[longestPrefixSuffixLength - 1];
            // Update longestPrefixSuffixLength to the LPS value of the previous position
        } else {
            // Case 3: Mismatch with no previous matching character
            lps[i] = 0; // Set the LPS value for the current position to 0
            i++; // Move to the next character
        }
    }
    return lps; // Return the computed LPS array
}
```

### Flow chart to understand above code and explanation
```plaintext
             +--------------------------+
             |          Start           |
             +--------------------------+
                        |
                        |
                        v
             +--------------------------+
             | Initialize variables:    |
             | length = pattern.length  |
             | lps = new int[length]    |
             | longestPrefixSuffixLength=0|
             | i = 1                    |
             +--------------------------+
                        |
                        v
             +--------------------------+
             |      While i < length    |
             +--------------------------+
                        |
                        v
            +-------------------------------+
            | pattern[i] == pattern[longest |
            | PrefixSuffixLength]?           |
            +-------------------------------+
                |                    |
              Yes                    No
                |                    |
                v                    v
+--------------------------------+  +-----------------------------------+
| Increment longestPrefixSuffix  |  | longestPrefixSuffixLength != 0?   |
| Length                        |  +-----------------------------------+
| lps[i] = longestPrefixSuffix  |         |                 |
| Length                        |       Yes                 No
| i++                           |         |                 |
+--------------------------------+         v                 v
                                         +--------------------------+
                                         | longestPrefixSuffixLength |
                                         | = lps[longestPrefixSuffix|
                                         | Length - 1]              |
                                         +--------------------------+
                                                 |
                                                 v
                                         +--------------------------+
                                         | Set lps[i] = 0           |
                                         | i++                      |
                                         +--------------------------+
                                                 |
                                                 v
                                         +--------------------------+
                                         | Continue loop            |
                                         +--------------------------+
                                                 |
                                                 v
                        +--------------------------+
                        |         Return lps       |
                        +--------------------------+
```
## Lets take example of below question of leet code
    28. Find the Index of the First Occurrence in a String
        Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

        Example 1:
            Input: haystack = "sadbutsad", needle = "sad"
            Output: 0
            Explanation: "sad" occurs at index 0 and 6.
            The first occurrence is at index 0, so we return 0.
        Example 2:
            Input: haystack = "leetcode", needle = "leeto"
            Output: -1
            Explanation: "leeto" did not occur in "leetcode", so we return -1.

        Constraints:
            1 <= haystack.length, needle.length <= 104
            haystack and needle consist of only lowercase English characters.

### Solution approach
    Brute force
        Look for all window of similar size of pattern and check if pattern is present or not
    TC : O(m*n) --> m -- size of text, n --> size of pattern

### Solution
```java
public static int strStr(String haystack, String needle) {
    if(haystack == null || haystack.isEmpty()) return -1;
    if(haystack.length() == needle.length() && haystack.equals(needle) ) return 0;
    int start = 0, nLen = needle.length();
    while (start < haystack.length() - nLen) {
        if (haystack.substring(start, start + needle.length()).equals(needle)) return start;
        start++;
    }
    return -1;
}
```

### KMP Solution approach
    Unlike above approach in KMP we will not reset start to next starting point
    ex: if window starting from i failed then we are shifting to window starting at i +1
    but in this approach, we will reset in bit complex way
    TC : O(n) --> O(2n) to calculate lps array and O(n) to find its index

### Solution
```java
```