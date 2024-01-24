
## Advance DSA Day 45 Graphs 1: Introduction, DFS & Cycle Detection

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda
- [What are Graphs?](#what-are-graphs)
- [Graph Representation](#graph-representation)
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
    A Graph is a non-linear data structure consisting of vertices and edges. The vertices are sometimes also referred to as nodes and the edges are lines or arcs that connect any two nodes in the graph. More formally a Graph is composed of a set of vertices( V ) and a set of edges( E ). The graph is denoted by G(E, V).
### Additional Link
* [GFG](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/)
* [InterviewBit](https://www.interviewbit.com/courses/programming/graph-data-structure-algorithms/)

## Components of Graph
* **Vertices**: Vertices are the fundamental units of the graph. Sometimes, vertices are also known as vertex or nodes. Every node/vertex can be labeled or unlabelled.
* **Edges**: Edges are drawn or used to connect two nodes of the graph. It can be ordered pair of nodes in a directed graph. Edges can connect any two nodes in any possible way. There are no rules. Sometimes, edges are also known as arcs. Every edge can be labeled/unlabelled.

![Graph](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/ee617487742018d81e9059e8fca5b75877596e65/Notes/images/graph_intro.jpg?raw=true)

## Graph Representation

## BFS
    The Breadth First Search (BFS) algorithm is used to search a graph data structure for a node that meets a set of criteria. It starts at the root of the graph and visits all nodes at the current depth level before moving on to the nodes at the next depth level.
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_1.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_2.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_3.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_4.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_5.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_6.png?raw=true)
![BFS](https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/78027316fd67b58b7d3a911c98aa421bdb7e94f7/Notes/images/bfs_7.png?raw=true)

## DFS
    Depth First Traversal (or DFS) for a graph is similar to Depth First Traversal of a tree. The only catch here is, that, unlike trees, graphs may contain cycles (a node may be visited twice). To avoid processing a node more than once, use a boolean visited array. A graph can have more than one DFS traversal.
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
    
    To find cycle in a directed graph we can use the Depth First Traversal (DFS) technique. It is based on the idea that there is a cycle in a graph only if there is a back edge [i.e., a node points to one of its ancestors] present in the graph.

    To detect a back edge, we need to keep track of the nodes visited till now and the nodes that are in the current recursion stack [i.e., the current path that we are visiting]. If during recursion, we reach a node that is already in the recursion stack, there is a cycle present in the graph.




