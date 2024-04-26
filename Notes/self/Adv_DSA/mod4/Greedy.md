## Advance DSA Day 39 Greedy Algorithm

## Scope / Agenda
- [What is Greedy](#what-is-greedy)
- [Free cars](#free-cars)
- [Flipkart's Challenge in Effective Inventory Management](#flipkarts-challenge-in-effective-inventory-management)
- [Candy Distribution](#candy-distribution)
- [Maximum Jobs](#maximum-jobs)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/greedy/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/greedy/additional)
3. [Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/greedy/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/39.%20Greedy%20Algorithm.pdf)
2. [Class/Lecture Video](https://youtu.be/99IaWptUDBE)
3. [New Batch Notes](../../../new_batch_notes/Greedy.pdf)
4. [New Batch lecture](https://youtu.be/sTd9JRdkbjg)


## What is Greedy 

#### Greedy : Maximize our profit and minimizing our loss.
>Greedy is an algorithmic paradigm that builds up a solution piece by piece, always choosing the next piece that offers the most obvious and immediate benefit. So the problems where choosing locally optimal also leads to global solution are the best fit for Greedy.

> It is an approach to solve optimisation problems by making locally optimal choices.

* [GFG](https://www.geeksforgeeks.org/greedy-algorithms/)
* [Interview Bit](https://www.interviewbit.com/courses/programming/greedy-algorithm/)
## Free cars 
#### Problem Description
    Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money. 
    B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the 
    ith car when the current time <= A[i] - 1.
    Your task is to find the maximum profit one can earn by buying cars considering that you can 
    only buy one car at a time.

    NOTE:
        * You can start buying from time = 0.
        * Return your answer modulo 10^9 + 7.


    Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^9
        0 <= B[i] <= 10^9


    Input Format
        The first argument is an integer array A represents the deadline for buying the cars.
        The second argument is an integer array B represents the profit obtained after buying the cars.

    Output Format
        Return an integer denoting the maximum profit you can earn.

    Example Input
        Input 1:
            A = [1, 3, 2, 3, 3]
            B = [5, 6, 1, 3, 9]
        Input 2:
            A = [3, 8, 7, 5]
            B = [3, 1, 7, 19]

    Example Output
        Output 1:
            20
        Output 2:
            30

    Example Explanation
        Explanation 1:
        At time 0, buy car with profit 5.
        At time 1, buy car with profit 6.
        At time 2, buy car with profit 9.
        At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
        So, total profit that one can earn is 20.
        Explanation 2:
        At time 0, buy car with profit 3.
        At time 1, buy car with profit 1.
        At time 2, buy car with profit 7.
        At time 3, buy car with profit 19.
        We are able to buy all cars within their deadline. So, total profit that one can earn is 30.

### Solution approach
    Using greedy approach
        Step 1 : Sort cars in ascneding order of expiry and start buying it one by one and maintain profilt
        in min heap to keep lowest profit on top.
        Step 2: Once we reach any expired product we will check if it is giving more profit then current
        lowest profit, if yes replace it with current lowest if not then proceed to next
        step 3: Return sum of all element of min heap and that would be the result.
    TC : O(nlogn) 
    SC : O(n)  --> Heap space
### Solution
```java
    class Toy {
        Integer expire, count;

        public Toy(int expire, int count) {
            this.expire = expire;
            this.count = count;
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Toy> toys = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            toys.add(new Toy(A.get(i), B.get(i)));
        }
        toys.sort(Comparator.comparing(a -> a.expire));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int time = 0;
        for (int i = 0; i < A.size(); i++) {
            if (time < toys.get(i).expire) {
                minHeap.add(toys.get(i).count);
                time++;
            } else {
                if (!minHeap.isEmpty() && toys.get(i).count > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(toys.get(i).count);
                }
            }
        }
        int result = 0;
        while (!minHeap.isEmpty()){
            result += minHeap.poll();
            result = result % 1000000007;
        }
        return result;
    }
```

## Flipkart's Challenge in Effective Inventory Management
    Problem Description
        In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management.
        Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays,
        A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit
        margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.
        The goal is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date,
        thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their
        grocery inventory and enhance profitability?
        Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery
        item at a time.
        NOTE:
            You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when
            the current time <= A[i] - 1.
            You can start buying from day = 0.
            Return your answer modulo 10^9 + 7.

    Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <= 10^9
        0 <= B[i] <= 10^9

    Input Format
        The first argument is an integer array A represents the deadline for buying the grocery items.
        The second argument is an integer array B represents the profit obtained after buying the grocery items.

    Output Format
        Returns an integer denoting the maximum profit you can earn.

    Example Input
        Input 1:
            A = [1, 3, 2, 3, 3]
            B = [5, 6, 1, 3, 9]
        Input 2:
            A = [3, 8, 7, 5]
            B = [3, 1, 7, 19]

    Example Output
        Output 1:
            20
        Output 2:
            30

    Example Explanation
        Explanation 1:
            At time 0, buy item with profit 5.
            At time 1, buy item with profit 6.
            At time 2, buy item with profit 9.
            At time = 3 or after , you can't buy any item, as there is no item with deadline >= 4.
            So, total profit that one can earn is 20.
        Explanation 2:
            At time 0, buy item with profit 3.
            At time 1, buy item with profit 1.
            At time 2, buy item with profit 7.
            At time 3, buy item with profit 19.
            We are able to buy all items within their deadline. So, the total profit that one can earn is 30.

### Solution 
    use the same approach as prev problem.

### Solution
```java
public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    if (A == null || B == null) return 0;
    ArrayList<Grocery> groceries = new ArrayList<>(A.size());
    for (int i = 0; i < A.size(); i++) {
        groceries.add(new Grocery(A.get(i), B.get(i)));
    }
    groceries.sort(Comparator.comparingInt(g -> g.expiration));
    PriorityQueue<Integer> minProfitHeap = new PriorityQueue<>();
    int time = 0;
    for (Grocery grocery : groceries) {
        if (grocery.expiration > time) {
            minProfitHeap.offer(grocery.profit);
            time++;
        } else if (!minProfitHeap.isEmpty() && grocery.profit > minProfitHeap.peek()) {
            minProfitHeap.poll();
            minProfitHeap.offer(grocery.profit);
        }
    }
    int totalSum = 0;
    while (!minProfitHeap.isEmpty()){
        totalSum += minProfitHeap.poll();
        totalSum %= 1000000007;
    }
    return totalSum;
}

class Grocery {
    int expiration;
    int profit;

    public Grocery(int expiration, int profit) {
        this.expiration = expiration;
        this.profit = profit;
    }
}
```

## [Candy Distribution](https://www.interviewbit.com/problems/distribute-candy/) 
#### Problem Description
    N children are standing in a line. Each child is assigned a rating value.
    
    You are giving candies to these children subjected to the following requirements:
        1. Each child must have at least one candy.
        2. Children with a higher rating get more candies than their neighbors.
    What is the minimum number of candies you must give?


    Problem Constraints
        1 <= N <= 10^5
        -10^9 <= A[i] <= 10^9


    Input Format
        The first and only argument is an integer array A representing the rating of children.

    Output Format
        Return an integer representing the minimum candies to be given.

    Example Input
        Input 1:
            A = [1, 2]
        Input 2:
            A = [1, 5, 2, 1]

    Example Output
        Output 1:
            3
        Output 2:
            7

    Example Explanation
        Explanation 1:
            The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
            So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
        Explanation 2:
            Candies given = [1, 3, 2, 1]

### Solution approach
    If we look at problem statement it say each candidate should have at least 1 candy and 
    candidate should have at least 1 extra candy if his score is more than any of the neighbours.

    We will follow below steps to assign candy to each candidate
    Step 1: Give 1 candy to each candidate
    Step 2: Iterate from left to right and check if current candidate has more score then its right neighbor,
    if yes assign one more candy than his right neighbour if it has lesser or equal candy than right neighbour.
    Step 3: Iterate from right to left and check if current candidate has more score then its left neighbour,
    if yes then assign one more candy than its left neighbour if it has lesser or equal candy than left neighbour.

    TC : O(n)
    SC : O(n)

#### Solution
```java
    public int candy(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(A.size(), 1));
        // check from left to right for higher rank
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) result.set(i, result.get(i - 1) + 1);
        }
        // check from right to left if left is greater than right
        for (int i = result.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1))
                result.set(i, (Math.max(result.get(i), result.get(i + 1) + 1)));
        }
        return result.stream().reduce(0, Integer::sum);
    }
```

## [Maximum Jobs](https://www.interviewbit.com/problems/meeting-rooms/)
#### Problem Description
    There are N jobs to be done, but you can do only one job at a time.
    Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
    Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

    Return the maximum number of jobs you can finish.

    Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] < B[i] <= 10^9


    Input Format
        The first argument is an integer array A of size N, denoting the start time of the jobs.
        The second argument is an integer array B of size N, denoting the finish time of the jobs.

    Output Format
        Return an integer denoting the maximum number of jobs you can finish.

    Example Input
        Input 1:
            A = [1, 5, 7, 1]
            B = [7, 8, 8, 8]
        Input 2:
            A = [3, 2, 6]
            B = [9, 8, 9]

    Example Output
        Output 1:
            2
        Output 2:
            1

    Example Explanation
        Explanation 1:
            We can finish the job in the period of time: (1, 7) and (7, 8).
        Explanation 2:
            Since all three jobs collide with each other. We can do only 1 job.

### Solution approach
    
### Solution
```java
    class Pair {
        public Integer start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int result = 1;
        // construct pair
        List<Pair> jobs = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            jobs.add(new Pair(A.get(i), B.get(i)));
        }

        jobs.sort(Comparator.comparing(Pair::getEnd));
        int currentJobEnd = jobs.get(0).end;
        for (int i = 1; i < jobs.size(); i++) {
            Pair nextJob = jobs.get(i);
            if (nextJob.start >= currentJobEnd) {
                result += 1;
                currentJobEnd = nextJob.end;
            }
        }
        return result;
    }
```
