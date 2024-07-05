## Advance DSA Day 42 DP 3 Knapsack

## Scope / Agenda
- [Fractional Knapsack](#fractional-knapsack)
- [0-1 Knapsack](#0-1-knapsack)
- [Unbounded Knapsack](#unbounded-knapsack)
- [Flip Array](#flip-array)
  

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp3/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp3/additional)
3. [Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp3/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/42%20DP%203%20Knapsack.pdf)
2. [Class/Lecture Video](https://youtu.be/msGIIQSJ5bw)
3. [new Batch Notes](../../../new_batch_notes/Dp%203.pdf)
4. [New Batch Video](https://youtu.be/pZb_8tC7XpU)

## Fractional Knapsack
    Problem Description
        Given two integer arrays A and B of size N each which represent values and weights associated with N items
        respectively.
        Also given an integer C which represents knapsack capacity.
        Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans,
        then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
        NOTE:
            You can break an item for maximizing the total value of the knapsack

    Problem Constraints
        1 <= N <= 10^5
        1 <= A[i], B[i] <= 10^3
        1 <= C <= 10^3

    Input Format
        First argument is an integer array A of size N denoting the values on N items.
        Second argument is an integer array B of size N denoting the weights on N items.
        Third argument is an integer C denoting the knapsack capacity.

    Output Format
        Return a single integer denoting the maximum total value of A such that sum of the weights of this 
        subset is smaller than or equal to C.

    Example Input
        Input 1:
            A = [60, 100, 120]
            B = [10, 20, 30]
            C = 50
        Input 2:
            A = [10, 20, 30, 40]
            B = [12, 13, 15, 19]
            C = 10
    Example Output
        Output 1:
            24000
        Output 2:
            2105

    Example Explanation
        Explanation 1:
            Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
            the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
        Explanation 2:
            Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
### Solution Approach
    Idea 1:
        Try all possible options and find max profit.
    Idea 2: Greedy Approach
        Start taking item with max profit and min weight and keep adding in sack.
        Steps:
            1. Sort given item in ascending order with max unit price i.e. item which add
                more profit with less weight
            2. Iterate throught sorted item array
            3. if current item weight is greater than sack weight then add unit price * sack weight 
                in max profit and 
            break the loop.
            4. If current item weight is less that sack weight then add complete profit of that item 
                in max weight and reduce sack weight with item weight.

### Solution
```java
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        double maxProfit = 0;
        List<Sack> sackList = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            sackList.add(new Sack(A.get(i), B.get(i)));
        }
        sackList.sort((a, b) -> b.unitPrice.compareTo(a.unitPrice));
        System.out.println(sackList);
        for (Sack sack : sackList) {
            if (C == 0) break;
            else if (sack.weight >= C) {
                maxProfit += sack.unitPrice * C;
                break;
            } else {
                maxProfit += sack.profit;
                C -= sack.weight;
            }
        }
        return (int) Double.parseDouble(String.format("%2f", maxProfit * 100));
    }
    class Sack {
        public Integer profit;
        public Integer weight;
        public Double unitPrice;

        public Sack(Integer profit, Integer weight) {
            this.profit = profit;
            this.weight = weight;
            this.unitPrice = profit / (double) weight;
        }
    }
```
    
## 0-1 Knapsack
    Problem Description
        Given two integer arrays A and B of size N each which represent values and weights associated 
        with N items respectively. Also given an integer C which represents knapsack capacity.
        Find out the maximum value subset of A such that sum of the weights of this subset is smaller 
        than or equal to C.
        NOTE:
            You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

    Problem Constraints
        1 <= N <= 10^3
        1 <= C <= 10^3
        1 <= A[i], B[i] <= 10^3

    Input Format
        First argument is an integer array A of size N denoting the values on N items.
        Second argument is an integer array B of size N denoting the weights on N items.
        Third argument is an integer C denoting the knapsack capacity.

    Output Format
        Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is
        smaller than or equal to C.

    Example Input
        Input 1:
            A = [60, 100, 120]
            B = [10, 20, 30]
            C = 50
        Input 2:
            A = [10, 20, 30, 40]
            B = [12, 13, 15, 19]
            C = 10
    Example Output
        Output 1:
            220
        Output 2:
            0

    Example Explanation
        Explanation 1:
            Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
        Explanation 2:
            Knapsack capacity is 10 but each item has weight greater than 10 so no items can be 
            considered in the knapsack therefore answer is 0.

### Solution Approach
    Approach 1: brute force
        Generate all possible subset and check which one gives max profit.
        Total no of subset : 2^n
    Approach 2: Choose or dont choose
        As we can not break the item while choosing so we can use another approach, something 
        like contribution technique.
        We will choose max values between element is contributing or not contributing.
            Step 1: Calculate total profit if element is contributing
            step 2: Calculate total profit if element is not contributing
            step 3: Choose max value out of it.
        TC : O(N) --> N is the length of weight array
        SC : O(N*C) --> N is the length of weight and profit array and C is the value of capacity.
### Solution
```java
int[][] indexWeightPair;
public int solve(int[] A, int[] B, int C) {
    indexWeightPair = new int[A.length + 1][C + 1];
    for (int[] arr : indexWeightPair) Arrays.fill(arr, -1);
    return solve(A, B, C, A.length - 1);
}

private int solve(int[] A, int[] B, int C, int index) {
    if (index < 0) return 0;
    if (indexWeightPair[index][C] != -1) return indexWeightPair[index][C];
    int dontTake = solve(A, B, C, index - 1);
    int take = (C >= B[index]) ? (A[index] + solve(A, B, C - B[index], index - 1)) : 0;
    indexWeightPair[index][C] = Math.max(take, dontTake);
    return indexWeightPair[index][C];
}
``` 

## Unbounded Knapsack
    Problem Description
    Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate
    maximum amount that could fit in this quantity.
    This is different from classical Knapsack problem, here we are allowed to use unlimited number of
    instances of an item.

    Problem Constraints
        1 <= A <= 1000
        1 <= |B| <= 1000
        1 <= B[i] <= 1000
        1 <= C[i] <= 1000

    Input Format
        First argument is the Weight of knapsack A
        Second argument is the vector of values B
        Third argument is the vector of weights C

    Output Format
        Return the maximum value that fills the knapsack completely

    Example Input
        Input 1:
            A = 10
            B = [5]
            C = [10]
        Input 2:
            A = 10
            B = [6, 7]
            C = [5, 5]

    Example Output
        Output 1:
            5
        Output 2:
            4

    Example Explanation
        Explanation 1:
            Only valid possibility is to take the given item.
        Explanation 2:
            Take the second item twice.
### Solution approach
    Approach 1: Use all subset multiple times until we calculate for all the capacity.
        Total no of subset 2^n
    Approach 2: Using dynamic programming
        As problem statement says, we can choose an item as many times until we have capacity in sack,
        so we can use another approach, something like keep choosing element
            Step 1: For each capacity iterate over the all options and choose which one gives more profit
        TC : O(N*C) --> N is the length of weight and profit array and C is the value of capacity.
        SC : O(N*C) --> N is the length of weight and profit array and C is the value of capacity.
### Solution
```java
int[] weighValues;
public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
    if (A <= 0 || B.isEmpty() || C.isEmpty()) return 0;
    weighValues = new int[A + 1];
    Arrays.fill(weighValues, -1);
    return solveRec(A, B, C);
}

private int solveRec(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
    if (A < 0) return 0;
    if (weighValues[A] != -1) return weighValues[A];
    int currentMax = Integer.MIN_VALUE;
    for (int i = 0; i < B.size(); i++) {
        int take = (A >= C.get(i)) ? (B.get(i) + solveRec((A - C.get(i)), B, C)) : 0;
        currentMax = Math.max(currentMax, take);
    }
    weighValues[A] = currentMax;
    return weighValues[A];
}
```
## Flip array
    Problem Description
        Given an array A of positive elements, you have to flip the sign of some of its elements such that the
        resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
        Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is
        minimum non-negative.

    Problem Constraints
        1 <= length of(A) <= 100
        Sum of all the elements will not exceed 10,000.

    Input Format
        First and only argument is an integer array A.

    Output Format
        Return an integer denoting the minimum number of elements whose sign needs to be flipped.

    Example Input
        Input 1:
            A = [15, 10, 6]
        Input 2:
            A = [14, 10, 4]

    Example Output
        Output 1:
            1
        Output 2:
            1

    Example Explanation
        Explanation 1:
            Here, we will flip the sign of 15 and the resultant sum will be 1.
        Explanation 2:
            Here, we will flip the sign of 14 and the resultant sum will be 0.
        Note that flipping the sign of 10 and 4 also gives the resultant sum 0, but flipping their 
            sign are not minimum.
### Solution Approach
    in progress