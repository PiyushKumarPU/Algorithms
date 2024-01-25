## Advance DSA Day 45 Graphs 1: Introduction, DFS & Cycle Detection

## Scope / Agenda
- [What are Graphs?](#what-are-graphs)
- [Components of Graph](#components-of-graph)
- [Classification of Graphs](#classification-of-graphs)
- [Graph Representation](#graph-representation)
- [Dest node can be visited from source]()
- [BFS](#bfs)
- [DFS](#dfs)
- [Find cycle in directed graph](#find-cycle-in-directed-graph)


## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/45.%20Graphs%201%20Introduction,%20DFS%20&%20Cycle%20Detection.pdf)
2. [Class/Lecture Video](https://youtu.be/YSYiZzdGEkA)

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

![Graph](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/ee617487742018d81e9059e8fca5b75877596e65/Notes/images/graph_intro.jpg?raw=true)

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

![Dir](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/75813624a95d141261cb993d032bb217fb89f86c/Notes/images/directed_undirected_graph.png?raw=true)
![Wei](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/75813624a95d141261cb993d032bb217fb89f86c/Notes/images/weighted_unweighted_graph.png?raw=true)
![exm2](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/75813624a95d141261cb993d032bb217fb89f86c/Notes/images/dir_cyclic_acyclic.png?raw=true)
![Exm4](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/75813624a95d141261cb993d032bb217fb89f86c/Notes/images/und_cyclic_acyclic.png?raw=true)

---
## Indegree and outdegree of a graph
#### **Indegree** of a vertex is defined as the number of incoming edges incident on a vertex in a directed graph.
    
### Significance Of Indegree:
* Indegree of nodes in a tree is equal to 1 in most of the cases if it becomes more than one then the data structure changes to graph.
* If the Indegree of a node is equal to zero, then the node/vertex does not have any parent vertex and it is either the root of the graph or an isolated vertex.

![Indegree](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/0579fbe551d05f6ba58e56ad4e4745a6da7b3d81/Notes/images/indegree_grapgh.png?raw=true)


### **Outdegree** of a vertex is defined as the number of outgoing edges from a vertex in a directed graph.

### Significance of Outdegree:
* The outdegree of a directed graph vertex, which reflects the total number of edges emanating from that node, is always positive and never negative.
* If a directed graph’s vertex does not have any edges leading to other vertices, then its outdegree will be 0.
* The total number of edges in a graph is equal to the sum of all outdegrees because in a directed graph, there is precisely one vertex at each end of each edge.
* Vertices with an outdegree of zero are known as sink vertices.


![Outgedree](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/0579fbe551d05f6ba58e56ad4e4745a6da7b3d81/Notes/images/indegree_grapgh.png?raw=true)

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

![Adj_matrix](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/c0ba14b9cc72270bbab98d23ac58e3711797bad4/Notes/images/adjacency_matrix.png?raw=true)

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

![Adj_list](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/c0ba14b9cc72270bbab98d23ac58e3711797bad4/Notes/images/adjacency_list.png?raw=true)

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
    never is already visited or not. If not then only we will add neighbour into the queue.
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

![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_1.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_2.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_3.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_4.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_5.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_6.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_7.png?raw=true)

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
![DFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/graph_dfs.gif?raw=true)
## Find cycle in directed graph
    Given the root of a Directed graph, The task is to check whether the graph contains a cycle or not.

### Examples
#### Example 1
    Input: N = 4, E = 6
![Exp1](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/86c6b9415b84aab8dc58b6242a9639f7ab36726c/Notes/images/detect_cycle_exm_1.png?raw=true)

    Output: Yes
    Explanation: The diagram clearly shows a cycle 0 -> 2 -> 0

#### Example 2
    Input: N = 4, E = 4
![Exp1](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/86c6b9415b84aab8dc58b6242a9639f7ab36726c/Notes/images/detect_cycle_exm_2.png?raw=true)

    Output: No
    Explanation: The diagram clearly shows no cycle

### Solution approach
    
    To find cycle in a directed graph we can use the Depth First Traversal (DFS) technique. 
    It is based on the idea that there is a cycle in a graph only if there is a back edge 
    [i.e., a node points to one of its ancestors] present in the graph.

    To detect a back edge, we need to keep track of the nodes visited till now and 
    the nodes that are in the current recursion stack [i.e., the current path that 
    we are visiting]. If during recursion, we reach a node that is already in the 
    recursion stack, there is a cycle present in the graph.




