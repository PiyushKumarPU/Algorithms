## Advance DSA Day 17 Searching : Binary Search on Answers

## Scope / Agenda
- [Painters Partition](#painters-partiton)
- [Aggressive Cows](#aggressive-cows)

## Problems and solutions
1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/bs_answers/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/bs_answers/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/bs_answers/lecture/)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/17.%20Searching%20Binary%20Search%20on%20Answers.pdf)
2. [Class/Lecture Video](https://youtu.be/r2U83yA6viM)

## Painters Partition
    Problem Description
        Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
        You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B
        units of time to paint 1 unit of the board.
        Calculate and return the minimum time required to paint all boards under the constraints that any painter will
        only paint contiguous sections of the board.
        NOTE:
        1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter,
        and partially by another.
        2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3
        but not 2 is invalid.

        Return the ans % 10000003.

    Problem Constraints
        1 <= A <= 1000
        1 <= B <= 10^6
        1 <= N <= 10^5
        1 <= C[i] <= 10^6

    Input Format
        The first argument given is the integer A.
        The second argument given is the integer B.
        The third argument given is the integer array C.

    Output Format
        Return minimum time required to paint all boards under the constraints that any painter will only paint
        contiguous sections of board % 10000003.

    Example Input
        Input 1:
            A = 2
            B = 5
            C = [1, 10]
        Input 2:
            A = 10
            B = 1
            C = [1, 8, 11, 3]

    Example Output
        Output 1:
            50
        Output 2:
            11

    Example Explanation
        Explanation 1:
            Possibility 1:- One painter paints both blocks, time taken = 55 units.
            Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
            There are no other distinct ways to paint boards.
            ans = 50 % 10000003
        Explanation 2:
            Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
            and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
            ans = 11 % 10000003
### Solution Appoach
    Our target is to find the minimun time required to paint all the boards using all the given painters.
    Lets think about best case
        No of boards is equal to number of painter: in this case time required would be max(boards)
    Lets think about worst case when we have only one painter to paint all the boards
        In this case time required would be sum(boards)
    Consider this as min limit and max limit
        Now we will start checking all the time span between these limits
            If we are able to paint all the board in time x min_limit <=x <= max_limit, then we will try to paint 
            it in < x time because we need to minimise the time

    Steps to follow:
        1. find min_limit and max_limit of required time
        2. Now apply binary search on time limit and check if all the boards can be painted in given time
        3. If yes, then try with lower time limit
        4. If no, then try to increase the time limit and see the result.
### Solution
```java
   public static int paint(int A, int B, int[] C) {
    long start = 0, end = 0, ans = 0;
    for (int ele : C) {
        start = Math.max(start, ele);
        end += ele;
    }
    while (start <= end) {
        long mid = start + (end - start) / 2;
        boolean isValidTime = isValidTime(mid, A, C);
        if (isValidTime) {
            ans = mid;
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    ans = (ans * B) % 10000003;
    return (int) ans;
}

private static boolean isValidTime(long givenTime, int painterCount, int[] boards) {
    int count = 1, work = 0;
    for (int board : boards) {

        if (work + board <= givenTime) {
            work += board;
        } else {
            count++;
            work = board;
        }
        if (count > painterCount) return false;
    }
    return count <= painterCount;
}
```
## Aggressive Cows
    Problem Description
        Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of
        the array represents the location of the stall and an integer B which represents the number of cows.
        His cows don't like this barn layout and become aggressive towards each other once put into a stall.
        To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
        such that the minimum distance between any two of them is as large as possible.
        What is the largest minimum distance?

    Problem Constraints
        2 <= N <= 100000
        0 <= A[i] <= 10^9
        2 <= B <= N

    Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

    Output Format
        Return the largest minimum distance possible among the cows.

    Example Input
        Input 1:
            A = [1, 2, 3, 4, 5]
            B = 3
        Input 2:
            A = [1, 2]
            B = 2

    Example Output
        Output 1:
            2
        Output 2:
            1

    Example Explanation
        Explanation 1:
            John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively.
            So the minimum distance will be 2.
        Explanation 2:
            The minimum distance will be 1.

### Solution Approach
    We need to have similar approach like painters partition problem
    Steps to follow:
        1. Find min distance between any stall (for worst case number of stall == number of cows)
        2. Find max distance between first and last stall (for best case if number of cows is 2)
        3. Now apply binary search between min distance and max distance
        4. find mid distance and check if all the cows can be placed with mid distance apart
        5. If yes, we will increase the min distance to find the maximun closest distance between cows
        6. If no, then try to decrease the min distance and try it
### Solution
```java
public int solve(int[] A, int B) {
    if (B <= 0) return 0;
    Arrays.sort(A);
    int minDistance = Integer.MAX_VALUE, maxDistance = A[A.length - 1] - A[0], result = 0;
    for (int i = 1; i < A.length; i++) {
        minDistance = Math.min(minDistance, (A[i] - A[i - 1]));
    }

    while (minDistance <= maxDistance) {
        int checkDistance = minDistance + (maxDistance - minDistance) / 2;
        if (isValidDistance(checkDistance, B, A)) {
            minDistance = checkDistance + 1;
            result = checkDistance;
        } else maxDistance = checkDistance - 1;
    }
    return result;
}

private static boolean isValidDistance(int givenDistance, int cowCount, int[] stalls) {
    int count = 1, currentPosition = stalls[0];
    for (int i = 1; i < stalls.length; i++) {
        if (stalls[i] - currentPosition >= givenDistance) {
            count++;
            currentPosition = stalls[i];
            if (cowCount == count) return true;
        }
    }
    return false;
}
```

### Exaplanation of check fucntion
```java
private boolean isValidDistance(int givenDistance, int cowCount, int[] stalls) {
    int count = 1, currentPosition = stalls[0];
    for (int i = 1; i < stalls.length; i++) {
        // here we keep moving till the next stall untill we find the distance between these
        // stall as givenDistance or bigger
        if (stalls[i] - currentPosition >= givenDistance) {
            count++;
            currentPosition = stalls[i];
            if (cowCount == count) return true;
        }
    }
    return false;
}
```