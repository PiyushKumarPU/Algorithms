## Advance DSA Day 47 Graphs 3: Graphs 3: MST (Prims Algo.) & Dijkstra Algo

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda

- [Applications of DSU](#applications-of-dsu)
- [Minimum spanning Tree](#minimum-spanning-tree)
- [Prim's Algorithm ](#prims-algorithm)
- [BFS](#bfs)
- [Dijkstra Algorithm](#dijkstra-algorithm)
  

## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph3/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph3/additional)
3. [Lecture Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/graph3/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/47.%20graph3.pdf)
2. [Class/Lecture Video](https://youtu.be/SN0tiLJwU4k)
3. [New Batch Notes](../../../new_batch_notes/Graph3.pdf)
4. [New Batch Video](https://youtu.be/0MvAMl7hqnQ)

## Applications of DSU
* Checking if undirected graph is connected
* Cycle in an undirected graph
### Construct Bridges
    Given N islands and cost of construction of a bridge between 
    multiple pair of islands. Find min cost of construction set 
    it is possible to travel from any island to another island. 
    If not possible return -1 
## Minimum spanning Tree
    A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected, undirected graph is a spanning tree with a weight less than or equal to the weight of every other spanning tree. 
    
>To learn more about Minimum Spanning Tree, refer to this [article](https://www.geeksforgeeks.org/what-is-minimum-spanning-tree-mst/).
## Prim's Algorithm 
    The algorithm starts with an empty spanning tree. The idea is to maintain two sets of vertices. The first set contains the vertices already included in the MST, and the other set contains the vertices not yet included. At every step, it considers all the edges that connect the two sets and picks the minimum weight edge from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST. 

>To learn more about Prim's Algo Minimum Spanning Tree, refer to this [article](https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/).

## BFS
## Dijkstra Algorithm
    Problem Description
        Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
        You have to find an integer array D of size A such that:
        D[i]: Shortest distance from the C node to node i.
        If node i is not reachable from C then -1.
        Note:
            There are no self-loops in the graph.
            There are no multiple edges between two pairs of vertices.
            The graph may or may not be connected.
            Nodes are numbered from 0 to A-1.
            Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

    Problem Constraints
        1 <= A <= 10^5
        0 <= B[i][0],B[i][1] < A
        0 <= B[i][2] <= 10^3
        0 <= C < A


    Input Format
        The first argument is an integer A, representing the number of nodes in the graph.
        The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
        The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.

    Output Format
        Return the integer array D.

    Example Input
        Input 1:
            A = 6
            B = [   [0, 4, 9]
                    [3, 4, 6]
                    [1, 2, 1]
                    [2, 5, 1]
                    [2, 4, 5]
                    [0, 3, 7]
                    [0, 1, 1]
                    [4, 5, 7]
                    [0, 5, 1] ]
            C = 4
        Input 2:
            A = 5
            B = [   [0, 3, 4]
                    [2, 3, 3]
                    [0, 1, 9]
                    [3, 4, 10]
                    [1, 3, 8]  ]
            C = 4

    Example Output
        Output 1:
            D = [7, 6, 5, 6, 0, 6]
        Output 2:
            D = [14, 18, 13, 10, 0]

    Example Explanation
        Explanation 1:
            All Paths can be considered from the node C to get shortest path
        Explanation 2:
            All Paths can be considered from the node C to get shortest path
