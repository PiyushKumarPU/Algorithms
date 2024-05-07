## Advance DSA Day 46 Graphs 2: BFS, Matrix Questions & Topological Sort

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [BFS](#bfs)
- [Multi Source BFS](#multi-source-bfs)
- [Rotten Oranges](#rotten-oranges)
- [Possibility of finishing course](#possibility-of-finishing-course)
- [Topological sort](#topological-sort)
- [Reverse Topological sort]()
- [Union Find](#union-find)
- [Knight On Chess Board](#knight-on-chess-board)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph2/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph2/additional)
3. [Self Practise Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph2/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/46.%20graph%202.pdf)
2. [Class/Lecture Video](https://youtu.be/yYlVP_1vkss)
3. [New Batch Notes](../../../new_batch_notes/Graph2.pdf)
4. [New Batch Video](https://youtu.be/RpCnBlqCw20)


## BFS
    The Breadth First Search (BFS) algorithm is used to search a graph data structure for a
    node that meets a set of criteria. It starts at the root of the graph and visits all 
    nodes at the current depth level before moving on to the nodes at the next depth level.

    Basically it is level order traversal, first we will trvaerse all the direct neighbour and then 
    we will traverse to next level neighbours.

![BFS](../../../images/bfs_1.png?raw=true)
![BFS](../../../images/bfs_2.png?raw=true)
![BFS](../../../images/bfs_3.png?raw=true)
![BFS](../../../images/bfs_4.png?raw=true)
![BFS](../../../images/bfs_5.png?raw=true)
![BFS](../../../images/bfs_6.png?raw=true)
![BFS](../../../images/bfs_7.png?raw=true)

### Solution approach
    We will start visiting from root node and one level at a time
    TC : O(V + E) --> No of vertices + max no of edges that can be 2* edged count
    SC : O(V + V)     --> Space taken by visited node array + space take by queue
 
### Solution
```java
public List<Integer> bfsSearch(List<List<Integer>> graphs, int root) {
    List<Integer> result = new ArrayList<>();
    boolean[] visitedNodes = new boolean[graphs.size()];
    Queue<Integer> paths = new LinkedList<>();
    paths.add(root);
    visitedNodes[root] = true;
    while (!paths.isEmpty()) {
        int current = paths.poll();
        result.add(current);
        List<Integer> nbrs = graphs.get(current);
        for (Integer nbr : nbrs) {
            if (!visitedNodes[nbr]) {
                paths.add(nbr);
                visitedNodes[nbr] = true;
            }
        }
    }
    return result;
}
```

## Multi Source BFS


## Rotten Oranges

## Possibility of finishing course

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
