## Advance DSA Day 47 Graphs 3: Graphs 3: MST (Prims Algo.) & Dijkstra Algo

## ![#f03c15](https://placehold.co/15x15/f03c15/f03c15.png) Document is Under constructions

## Scope / Agenda

- [Applications of DSU](#applications-of-dsu)
- [Minimum spanning Tree](#minimum-spanning-tree)
- [Prim's Algorithm ](#prims-algorithm)
- [BFS](#bfs)
- [Dijkstra Algorithm](#dijkstra-algorithm)
  

## Problems and solutions

1. [Assignments]()
2. [Additional Problems]()
3. [Self Practise Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/47.%20graph3.pdf)
2. [Class/Lecture Video](https://youtu.be/2n-3ZIXwe3M)

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
