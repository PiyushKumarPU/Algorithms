## Advance DSA Day 45 Graphs 1: Introduction, DFS & Cycle Detection

## Scope / Agenda
- [What are Graphs?](#what-are-graphs)
- [Components of Graph](#components-of-graph)
- [Classification of Graphs](#classification-of-graphs)
- [Graph Representation](#graph-representation)
- [Dest node can be visited from source](#dest-node-can-be-visited-from-source)
- [BFS](#bfs)
- [DFS](#dfs)
- [Find cycle in directed graph](#find-cycle-in-directed-graph)
- [No of Islands](#no-of-islands)


## Problems and solutions

1. [Assignments](../../../../problems/src/main/java/com/learning/scaler/advance/module4/graph1/assignment/)
2. [Additional Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module4/graph1/additional/)
3. [Class/Lecture Problems](../../../../problems/src/main/java/com/learning/scaler/advance/module4/graph1/lecture)

## Class Notes and Videos

1. [Class Notes](https://github.com/rajpiyush220/Algorithms/blob/master/Notes/class_Notes/Advance%20DSA%20Notes/45.%20Graphs%201%20Introduction%2C%20DFS%20%26%20Cycle%20Detection.pdf)
2. [Class/Lecture Video](https://youtu.be/xYF6ZFMD2R0)
3. [New Batch Notes](../../../new_batch_notes/Graph1.pdf)
4. [New Batch Video](https://youtu.be/H1gDtb3Z8i8)

## What are Graphs
    A Graph is a non-linear data structure consisting of vertices and edges. The vertices are 
    sometimes also referred to as nodes and the edges are lines or arcs that connect any two 
    nodes in the graph. More formally a Graph is composed of a set of vertices( V ) and a 
    set of edges( E ). The graph is denoted by G(E, V).

### Additional Link
* [GFG](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
* [InterviewBit](https://www.interviewbit.com/courses/programming/graph-data-structure-algorithms/)

---
## Components of Graph
* **Vertices**: Vertices are the fundamental units of the graph. Sometimes, vertices are also known as vertex or nodes. Every node/vertex can be labeled or unlabelled.
* **Edges**: Edges are drawn or used to connect two nodes of the graph. It can be ordered pair of nodes in a directed graph. Edges can connect any two nodes in any possible way. There are no rules. Sometimes, edges are also known as arcs. Every edge can be labeled/unlabelled.

![Graph](../../../images/graph_intro.jpg?raw=true)

---

### Classification of Graphs
* **Undirected Graphs:** A graph in which edges have no direction, i.e., the edges do not have arrows indicating the direction of traversal. Example: A social network graph where friendships are not directional.
* **Directed Graphs:** A graph in which edges have a direction, i.e., the edges have arrows indicating the direction of traversal. Example: A web page graph where links between pages are directional.

* **Weighted Graphs:** A graph in which edges have weights or costs associated with them. Example: A road network graph where the weights can represent the distance between two cities.
* **Unweighted Graphs:** A graph in which edges have no weights or costs associated with them. Example: A social network graph where the edges represent friendships.

* **Complete Graphs:** A graph in which each vertex is connected to every other vertex. Example: A tournament graph where every player plays against every other player.
* **Bipartite Graphs:** A graph in which the vertices can be divided into two disjoint sets such that every edge connects a vertex in one set to a vertex in the other set. Example: A job applicant graph where the vertices can be divided into job applicants and job openings.
* **Trees:** A connected graph with no cycles. Example: A family tree where each person is connected to their parents.
* **Cycles:** A graph with at least one cycle. Example: A bike-sharing graph where the cycles represent the routes that the bikes take.
* **Sparse Graphs:** A graph with relatively few edges compared to the number of vertices. Example: A chemical reaction graph where each vertex represents a chemical compound and each edge represents a reaction between two compounds.
* **Dense Graphs:** A graph with many edges compared to the number of vertices. Example: A social network graph where each vertex represents a person and each edge represents a friendship.

![Dir](../../../images/directed_undirected_graph.png?raw=true)
![Wei](../../../images/weighted_unweighted_graph.png?raw=true)
![exm2](../../../images/dir_cyclic_acyclic.png?raw=true)
![Exm4](../../../images/und_cyclic_acyclic.png?raw=true)

---
## Indegree and outdegree of a graph
#### **Indegree** of a vertex is defined as the number of incoming edges incident on a vertex in a directed graph.
    
### Significance Of Indegree:
* Indegree of nodes in a tree is equal to 1 in most of the cases if it becomes more than one then the data structure changes to graph.
* If the Indegree of a node is equal to zero, then the node/vertex does not have any parent vertex and it is either the root of the graph or an isolated vertex.

![Indegree](../../../images/indegree_grapgh.png?raw=true)


### **Outdegree** of a vertex is defined as the number of outgoing edges from a vertex in a directed graph.

### Significance of Outdegree:
* The outdegree of a directed graph vertex, which reflects the total number of edges emanating from that node, is always positive and never negative.
* If a directed graph’s vertex does not have any edges leading to other vertices, then its outdegree will be 0.
* The total number of edges in a graph is equal to the sum of all outdegrees because in a directed graph, there is precisely one vertex at each end of each edge.
* Vertices with an outdegree of zero are known as sink vertices.


![Outgedree](../../../images/indegree_grapgh.png?raw=true)

### Consider the above directed graph. To determine a vertex’s outdegree in a directed graph, one must count the number of directed edges that leave from that vertex.

>How to determine a vertex’s outdegree in a directed graph is as follows:

* Choose to pick the vertices whose outdegrees you wish to know about.
* Check how many outgoing directed edges there are from that vertex by going along the edges of the graph.
* Keep track of how many directed edges in total come from that node.
* The vertex’s outdegree is equal to this number.

### Answer
* Outdegree (V1) = 1 as there is only one outgoing edge e1.
* Outdegree (V2) = 2 as there are two outgoing edges e2 and e4.
* Outdegree (V3) = 1 as there is only one outgoing edge e3.
* Outdegree (V4) = 1 as there is only one outgoing edge e5.
* Outdegree (V5) = 2 as there are two outgoing edges e6 and e7.

---

## Graph Representation
    How can we store graph information i.e. internal datastructre to store graph inforamtion
    Input format:
     * 1st line represent no of node and no of edged  (N and M)
     * Next M line represent node information which are connected to each other
        i.e.
            N   M
            6   6
            2   3
            4   5
            0   5
            4   1
            1   3
            3   4
### Storing a graph

#### Adjacency Matrix
>An adjacency matrix is a square matrix of N x N size where N is the number of nodes in the graph and it is used to represent the connections between the edges of a graph.
    
    Input :
        3  3
        0  1
        1  2
        2  0
Follwing is the adjacency matrix for above input. 

![Adj_matrix](../../../images/adjacency_matrix.png?raw=true)

### Characteristics of the adjacency matrix are:
* The size of the matrix is determined by the number of vertices in the graph.
* The number of nodes in the graph determines the size of the matrix.
* The number of edges in the graph is simply calculated.
* If the graph has few edges, the matrix will be sparse.

### How to build an Adjacency Matrix:
>**It is very easy and simple to construct an adjacency matrix for a graph there are certain steps given below that you need to follow:**

* **Create an n x n matrix where n is the number of vertices in the graph.**
* **Initialize all elements to 0.**
* **For each edge (u, v) in the graph, if the graph is undirected mark a[u][v] and a[v][u] as 1, and if the edge is directed from u to v, mark a[u][v] as the 1. (Cells are filled with edge weight if the graph is weighted)**

### Advantages of using Adjacency Matrix:
* An adjacency matrix is simple and easy to understand.
* Adding or removing edges from a graph is quick and easy.
* It allows constant time access to any edge in the graph.

### Disadvantages of using Adjacency Matrix:
* It is inefficient in terms of space utilisation for sparse graphs because it takes up O(N2) space.
* Computing all neighbors of a vertex takes O(N) time.

#### Adjacency List
>An adjacency list is a data structure used to represent a graph where each node in the graph stores a list of its neighboring vertices.

    Input :
            3  3
            1  0
            1  2
            2  0
Follwing is the adjacency list for above input. 

![Adj_list](../../../images/adjacency_list.png?raw=true)

### Characteristics of the Adjacency List:
* The size of the matrix is determined by the number of nodes in the network.
* The number of graph edges is easily computed.
* The adjacency list is a jagged array.

### How to build an Adjacency List?
>It is very easy and simple to construct an adjacency list for a graph there are certain steps given below that you need to follow:

* Create an array of linked lists of size N, where N is the number of vertices in the graph.
* Create a linked list of adjacent vertices for each vertex in the graph.
* For each edge (u, v) in the graph, add v to the linked list of u, and add u to the linked list of v if the graph is undirected otherwise add v to the list of u if it is directed from u to v. (In case of weighted graphs store the weight along with the connections).

### Advantages of using an Adjacency list:
* An adjacency list is simple and easy to understand.
* Adding or removing edges from a graph is quick and easy.

### Disadvantages of using an Adjacency list:
* In adjacency lists accessing the edges can take longer than the adjacency matrix.
* It requires more memory than the adjacency matrix for dense graphs.


## Dest node can be visited from source
    Problem Description
        Given and undirected graph, source node and destination node. Check if destination node 
        can be visited from source node.

### Solution approach :
    1. We will start by putting source node in queue and we will maintain a visited array of 
    type boolean which will store information of visited array.
    2. We will iterate untill queue is empty
    3. pop element from queue and before adding its neighbour to the queue, we will check whether
    neighbour is already visited or not. If not then only we will add neighbour into the queue.
    4. At last we will check in visited array whether dest node is visited or not and return respective value.

### Solution
```java
    public boolean solve(List<List<Integer>> graphs, int source, int dest) {
        boolean[] visitedNodes = new boolean[graphs.size()];
        Queue<Integer> paths = new LinkedList<>();
        paths.add(source);
        visitedNodes[source] = true;
        while (!paths.isEmpty() && !visitedNodes[dest]) {
            int current = paths.poll();
            List<Integer> nbrs = graphs.get(current);
            for (Integer nbr : nbrs) {
                if (!visitedNodes[nbr]) {
                    paths.add(nbr);
                    visitedNodes[nbr] = true;
                }
            }
        }
        return visitedNodes[dest];
    }
```

## BFS
    The Breadth First Search (BFS) algorithm is used to search a graph data structure for a
    node that meets a set of criteria. It starts at the root of the graph and visits all 
    nodes at the current depth level before moving on to the nodes at the next depth level.

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

## DFS
    Depth First Traversal (or DFS) for a graph is similar to Depth First Traversal of 
    a tree. The only catch here is, that, unlike trees, graphs may contain cycles 
    a node may be visited twice). To avoid processing a node more than once, 
    use a boolean visited array. A graph can have more than one DFS traversal.
![DFS](../../../images/graph_dfs.gif?raw=true)

### [DFS Implementation](https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)
    Problem Description
        You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
        Note: Use the recursive approach to find the DFS traversal of the graph starting from the
        0th vertex from left to right according to the graph.

    Example 1:
        Input:
            V = 5 , adj = [[2,3,1] , [0], [0,4], [0], [2]]
        Output:
            0 2 4 3 1
        Explanation:
            0 is connected to 2, 3, 1.
            1 is connected to 0.
            2 is connected to 0 and 4.
            3 is connected to 0.
            4 is connected to 2.
            so starting from 0, it will go to 2 then 4,
            and then 3 and 1.
            Thus dfs will be 0 2 4 3 1.
    Example 2:
        Input: V = 4, adj = [[1,3], [2,0], [1], [0]]
        Output: 0 1 2 3
        Explanation:
            0 is connected to 1 , 3.
            1 is connected to 0, 2.
            2 is connected to 1.
            3 is connected to 0.
            so starting from 0, it will go to 1 then 2
            then back to 0 then 0 to 3
            thus dfs will be 0 1 2 3.

### Solution
```java
    List<Integer> result;
    boolean[] visited;
    public void dfs(List<List<Integer>> adjList, int root) {
        if (result == null) {
            result = new ArrayList<>(adjList.size());
            visited = new boolean[adjList.size()];
        }
        Queue<Integer> paths = new LinkedList<>();
        paths.add(root);
        visited[root] = true;
        while (!paths.isEmpty()) {
            int current = paths.poll();
            result.add(current);
            for (int nbr : adjList.get(current)) {
                if (!visited[nbr]) dfs(adjList, nbr);
            }
        }
    }
```

### Time and space complexity
    TC : O(V + E)
    SC : O(V)

## Find cycle in directed graph
    Given the root of a Directed graph, The task is to check whether the graph contains a cycle or not.

### Examples
#### Example 1
    Input: N = 4, E = 6
![Exp1](../../../images/detect_cycle_exm_1.png?raw=true)

    Output: Yes
    Explanation: The diagram clearly shows a cycle 0 -> 2 -> 0

#### Example 2
    Input: N = 4, E = 4
![Exp1](../../../images/detect_cycle_exm_2.png?raw=true)

    Output: No
    Explanation: The diagram clearly shows no cycle

### Solution approach
    We will use DFS to travese to each available path in graph and will see if any node is getting
    traverse more than once in a path.
    Steps to follow:
        1. Start DFS from any arbitary node called root node.
        2. Use hashmap or any key based datastructure to keep track of all the visited node
        3. once we start processing the node, will add them in path hashmap and start processing 
        its neighbour.
        4. if any of the neighbour present in the hashmap return true because same node is 
        already visited for the same path.
        5. Once we done processing all the neighbour of respected node then remove it from hashmap
        6. if none of the node is having cycle then return false at last.
    TC : O(V+E)
    SC : O(N) --> we are storing paths in hashmap so max space would be same as number of node in the graph.

## Solution
```java
    public boolean hasCycle(int node, List<List<Integer>> inputs, HashSet<Integer> currentPaths) {
        currentPaths.add(node);
        for (int current : inputs.get(node)) {
            if (currentPaths.contains(current)) return true;
            else if (hasCycle(current, inputs, currentPaths)) {
                return true;
            }
        }
        currentPaths.remove(node);
        return false;
    }
```

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




