package com.learning.scaler.advance.module4.dp4.assignment;

import java.util.Arrays;

/*
Problem Description
    You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount
    of each coin in the set.
    NOTE:
        Coins in set A will be unique. The Expected space complexity of this problem is O(B).
        The answer can overflow. So, return the answer % (10^6 + 7).

Problem Constraints
    1 <= A <= 500
    1 <= A[i] <= 1000
    1 <= B <= 50000

Input Format
    First argument is an integer array A representing the set.
    The Second argument is an integer B.

Output Format
    Returns an integer denoting the number of ways.

Example
    Input 1:
     A = [1, 2, 3]
     B = 4
    Input 2:
     A = [10]
     B = 10

Example
    Output 1:
        4
    Output 2:
        1

Example
    Explanation 1:
     The 4 possible ways are:
     {1, 1, 1, 1}
     {1, 1, 2}
     {2, 2}
     {1, 3}
    Explanation 2:
     There is only 1 way to make sum 10.
* */
public class CoinSumInfinite {

    public static void main(String[] args) {
        CoinSumInfinite infinite = new CoinSumInfinite();
        System.out.println(infinite.coinSumInfinite(
                new int[]{406, 3, 137, 244, 46, 74, 175, 32, 506, 324, 405, 395, 298, 333, 226, 425, 552, 134, 354, 125, 472, 368, 580, 202, 449, 400, 529, 159, 68, 409, 523, 494, 515, 281, 498, 209, 578, 140, 99, 436, 194, 371, 442, 482, 591, 84, 77, 382, 484, 510, 418, 284, 398, 229, 266, 152, 212, 572, 211, 314, 302, 492, 338, 217, 113, 594, 248, 181, 45, 389, 52, 191, 561, 434, 465, 470, 238, 127, 97, 257, 399, 516, 117, 318, 236, 34, 138, 185, 445, 307, 415, 282, 116, 256, 11, 186, 239, 131, 313, 299, 565, 363, 135, 120, 543, 75, 483, 213, 489, 67, 404, 272, 263, 193, 500, 370, 495, 443, 295, 73, 568, 51, 571, 367, 20, 522, 156, 597, 459, 80, 154, 224, 1, 360, 551, 432, 258, 130, 195, 584, 455, 190, 422, 93, 62, 544, 531, 532, 124, 2, 466, 112, 123, 550, 65, 496, 366, 502, 204, 504, 177, 262, 553, 163, 44, 71, 326, 109, 215, 323, 243, 207, 512, 345, 25, 23, 421, 469, 95, 63, 55, 365, 545, 31, 556, 317, 101, 573, 270, 133, 235, 457, 320, 268, 424, 206, 335, 115, 375, 536, 566, 145, 488, 301, 30, 583, 349, 479, 280, 222, 58, 170, 208, 376, 560, 435, 12, 372, 303, 316, 267, 567, 255, 528, 420, 485, 337, 233, 198, 66, 563, 119, 304, 199, 577, 241, 85, 564, 173, 487, 339, 96, 297, 184, 401, 315, 293, 160, 475, 242, 22, 330, 90, 526, 187, 416, 540, 331, 178, 446, 89, 499, 146, 387, 19, 491, 581, 396, 452, 530, 444, 539, 250, 582, 554, 228, 392, 579, 161, 525, 555, 13, 136, 105, 569, 254, 402, 219, 76, 527, 593, 520, 341, 393, 451, 54, 165, 471, 501, 269, 513, 162, 379, 549, 453, 600, 41, 537, 381, 18, 168, 40, 88, 348, 509, 412, 237, 189, 463, 277, 141, 279, 431, 275, 352, 94, 547, 514, 419, 575, 433, 426, 264, 410, 588, 587, 172, 386, 81, 29, 259, 305, 69, 359, 144, 273, 592, 148, 390, 430, 252, 203, 14, 166, 558, 467, 598, 447, 322, 288, 511, 414, 458, 118, 142, 533, 468, 329, 110, 214, 486, 100, 438, 589, 102, 464, 407, 477, 98, 53},
                39588));
    }

    int[][] coinCounts;

    // duplicate not allowed
    public int coinSumInfinite(int[] A, int B) {
        coinCounts = new int[A.length][B + 1];
        for (int[] arr : coinCounts) Arrays.fill(arr, -1);
        return coinSumInfinite(A, B, A.length - 1);
    }

    // not possible with recursion for larget input, as recursion stack will be full
    public int coinSumInfinite(int[] A, int target, int index) {
        if (target == 0) return 1;
        if (index < 0 || target < 0) return 0;
        if (coinCounts[index][target] != -1) return coinCounts[index][target];
        int dontTake = coinSumInfinite(A, target, index - 1);
        int take = coinSumInfinite(A, (target - A[index]), index);
        int ways = (take + dontTake) % 1000007;
        coinCounts[index][target] = ways;
        return ways;
    }

    public int coinSumInfiniteRec(int[] A, int B) {
        int mod = 1000007;
        int[] dp = new int[B + 1];
        dp[0] = 1;
        for (int coin : A) {
            for (int i = coin; i <= B; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }
        return dp[B];
    }
}
