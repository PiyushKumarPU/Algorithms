## Advance DSA Day 46 Graphs 2: BFS, Matrix Questions & Topological Sort

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [No of Islands](#no-of-islands)
- [Topological sort](#topological-sort)
- [Union Find](#union-find)
- [Knight On Chess Board](#knight-on-chess-board)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph2/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph2/additional)
3. [Self Practise Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph2/lecture)

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/46.%20graph%202.pdf)
2. [Class/Lecture Video](https://youtu.be/yYlVP_1vkss)


## No of Islands
    Problem Description
        Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island.
        From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j)
        and value in that cell is 1.
        More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
            (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
            (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
            (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
            (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
            (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
            (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
            (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
            (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
        Return the number of islands.
        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.


    Problem Constraints
        1 <= N, M <= 100
        0 <= A[i] <= 1

    Input Format
        The only argument given is the integer matrix A.

    Output Format
        Return the number of islands.

    Example Input
        Input 1:
        A = [
            [0, 1, 0]
            [0, 0, 1]
            [1, 0, 0]
            ]
        Input 2:
        A = [
            [1, 1, 0, 0, 0]
            [0, 1, 0, 0, 0]
            [1, 0, 0, 1, 1]
            [0, 0, 0, 0, 0]
            [1, 0, 1, 0, 1]
            ]


    Example Output
        Output 1:
        2
        Output 2:
        5

    Example Explanation
        Explanation 1:
        The 1's at position A[0][1] and A[1][2] forms one island.
        Other is formed by A[2][0].
        Explanation 2:
        There 5 island in total.
### Solution approach
    We will look for all the cell which has 1 as value and then we will keep finding all its neighbour with same value and we will change its value to something else so that same cell should not be counted again.
    Will do DFS for all the neighbours until we find water cell or boundary cell.

### Solution
```java
    public int solve(int[][] A) {
        int n = A.length, m = A[0].length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    count++;
                    DFS(A, i, j);
                }
            }
        }
        return count;
    }

    private void DFS(int[][] A, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1) return;
        A[i][j] = 2;
        DFS(A, i - 1, j);
        DFS(A, i, j - 1);
        DFS(A, i + 1, j);
        DFS(A, i, j + 1);
        DFS(A, i - 1, j - 1);
        DFS(A, i + 1, j + 1);
        DFS(A, i - 1, j + 1);
        DFS(A, i + 1, j - 1);
    }
```
## Topological sort
    Problem Description
        Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such 
        that there is a edge directed from node B[i][0] to node B[i][1]. Topological 
        sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such 
        that for every directed edge uv, vertex u comes before v in the ordering. 
        Topological Sorting for a graph is not possible if the graph is not a DAG.
        Return the topological ordering of the graph and if it doesn't exist 
        then return an empty array.
        If there is a solution return the correct ordering. If there are 
        multiple solutions print the lexographically smallest one.
        Ordering (a, b, c) is said to be lexographically smaller than 
        ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
        NOTE:
            There are no self-loops in the graph.
            The graph may or may not be connected.
            Nodes are numbered from 1 to A.
            Your solution will run on multiple test cases. If you are 
            using global variables make sure to clear them.

    Problem Constraints
        2 <= A <= 10^4
        1 <= M <= min(100000,A*(A-1))
        1 <= B[i][0], B[i][1] <= A

    Input Format
        The first argument given is an integer A representing the number of nodes 
        in the graph.
        The second argument given a matrix B of size M x 2 which represents 
        the M edges such that there is a edge directed from node B[i][0] 
        to node B[i][1].

    Output Format
        Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

    Example Input
        Input 1:
            A = 6
            B = [  [6, 3]
                    [6, 1]
                    [5, 1]
                    [5, 2]
                    [3, 4]
                    [4, 2] ]
        Input 2:
            A = 3
            B = [  [1, 2]
                    [2, 3]
                    [3, 1] ]

    Example Output
        Output 1:
            [5, 6, 1, 3, 4, 2]
        Output 2:
            []

    Example Explanation
        Explanation 1:
            The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
        Explanation 2:
            The given graph contain cycle so topological ordering not possible we will return empty array.
## Union Find
## Knight On Chess Board
    Problem Description
        Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
![Chess](../../../images/Chess_boards.jpeg?raw=true)

        The above figure details the movements for a knight ( 8 possibilities ).
        If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
            NOTE: A knight cannot go out of the board.

    Problem Constraints
        1 <= A, B <= 500

    Input Format
        The first argument of input contains an integer A.
        The second argument of input contains an integer B.
        The third argument of input contains an integer C.
        The fourth argument of input contains an integer D.
        The fifth argument of input contains an integer E.
        The sixth argument of input contains an integer F.

    Output Format
        If it is possible to reach the destination point, return the minimum number of moves.
        Else return -1.

    Example Input
        Input 1:
            A = 8
            B = 8
            C = 1
            D = 1
            E = 8
            F = 8
        Input 2:
            A = 2
            B = 4
            C = 2
            D = 1
            E = 4
            F = 4

    Example Output
        Output 1:
            6
        Output 2:
            -1

    Example Explanation
        Explanation 1:
            The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
            The minimum number of moves required for this is 6.
        Explanation 2:
            It is not possible to move knight to position (4, 4) from (2, 1)
