## Advance DSA Day 17 Searching : Binary Search on Answers


## Scope / Agenda
- [Painters Partition](#painters-partiton)
- [Aggressive Cows](#aggressive-cows)

## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/bs_answers/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/bs_answers/additional/)
3. [Self Practise Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module2/binary_search/bs_answers/lecture/)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/17.%20Searching%20Binary%20Search%20on%20Answers.pdf)
2. [Class/Lecture Video](https://youtu.be/gw_jadeMFA8)

## Painters Partition
    Problem Statement:
        Given N tasks and k workers. Time taken to complete ith task --> A[i],
        Find minimum time to complete all tasks:
        Notes:
            a. One task can be done by only one worker
            b. A worker can only do continuos task
            c. Worker works parallely

Psuedo Code:
    
```java
    int totalTime(int boards[], int k){
    // find max element and sum of boards
    start = max(boards)
    end = sum(boards)
        while(start <= end){
            int mid = (s + e)/2;
            // checking if all jobs can be completed in <= mid time
            if(check(mid, boards,k)){
                ans = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
    return ans;
    }
    boolean check(int mid, int[] boards, int k){
        int cur = 1, work = 0;
        for(int i = 0; i < boards.length; i++){
            if(work + boards[i] <= mid){
                work += boards[i];
            }else{
                cur++;	
            }
        }
        return cur <= k;
    }
```
## Aggressive Cows
    Problem Statement:
        Given N stalls and M cows. N >= M Position of each stall is given in A[N] in ascending order. 
        Maximise the closest distance between cows.
        Further explanation: We need to place cow in a stall so that minimum distance between the cows will be maximum i.e. Each cow will be placed at maximum possible distance to each other.

Psuedo Code:
```java
    int maxDistance(int[] dist, int M){
	// find min distance between 2 consecutive element of array
	start = min(dist[i+1] - dist[i])
	end = dist[dist.length-1] - dist[0]
	
        while(start <= end){
            int mid = s + (e-s)/2;
            // check if we can place cows at least mid distance apart
            if(check(mid,dist,m)){
                ans = mid;
                start = mid+1; // move right as we need to find max value
            }else{
                end = mid -1;
            }
        }
        return ans
    }

    boolean check(int mid, int[] dist, int m){
        int curr = 1, position = dist[0];
        for(int index = 1; index < dist.length; index++){
            if(dist[index] - position <= mid){
                curr++;
                position = dist[index];
                if(curr == m) return true;
            }
        }
        return false;
    }
```