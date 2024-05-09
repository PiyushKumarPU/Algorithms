## Advance DSA Day 47 Graphs 3: Graphs 3: MST (Prims Algo.) & Dijkstra Algo

## Scope / Agenda

- [Minimum spanning Tree](#minimum-spanning-tree)
- [Prim's Algorithm ](#prims-algorithm)
- [ Commutable Islands](#commutable-islands)
- [BFS](#bfs)
- [Dijkstra Algorithm](#dijkstra-algorithm)
- [Applications of DSU](#applications-of-dsu)
  

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
## Minimum spanning Tree
    A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected, undirected graph is a spanning tree with a weight less than or equal to the weight of every other spanning tree. 
    
>To learn more about Minimum Spanning Tree, refer to this [article](https://www.geeksforgeeks.org/what-is-minimum-spanning-tree-mst/).

## Prim's Algorithm 
    The algorithm starts with an empty spanning tree. The idea is to maintain two sets of vertices. The first set contains the vertices already included in the MST, and the other set contains the vertices not yet included. At every step, it considers all the edges that connect the two sets and picks the minimum weight edge from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST. 

>To learn more about Prim's Algo Minimum Spanning Tree, refer to this [article](https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/).

## Commutable Islands
    Problem Description
        There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
        We need to find bridges with minimal cost such that all islands are connected.
        It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
        
    Problem Constraints
        1 <= A, M <= 6*10^4
        1 <= B[i][0], B[i][1] <= A
        1 <= B[i][2] <= 10^3

    Input Format
        The first argument contains an integer, A, representing the number of islands.
        The second argument contains an 2-d integer matrix, B, of size M x 3 where Island
        B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].

    Output Format
        Return an integer representing the minimal cost required.

    Example
        Input 1:
            A = 4
            B = [  [1, 2, 1]
                    [2, 3, 4]
                    [1, 4, 3]
                    [4, 3, 2]
                    [1, 3, 10]  ]
        Input 2:
            A = 4
            B = [  [1, 2, 1]
                    [2, 3, 2]
                    [3, 4, 4]
                    [1, 4, 3]   ]

    Example Output
        Output 1:
            6
        Output 2:
            6

    Example Explanation
        Explanation 1:
            We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
        Explanation 2:
            We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
    
### Solution approach
    As per the proble statment we need to find min distance to connect all the island together.
    Step 1: Constrcut bidirectionla adj list along with cost of each bridge
    Step 2: Create a visited array which will maintain state of visited array
    Step 3: Create a min heap on weight on edges
    Step 4: Consider any node of your choice as source node and add that node to min heap with 0 weight associated to it
    Step 5: Iterate untill heap is not empty and all node is not visited
    Step 6: Extract min from heap and if respective ndoe is already visited skip it.
    Step 7: Mark node is visited and add its weight to answer variable
    step 8: Add all non visited neigbour of the current node back to heap

    TC : O(ElogE) --> E denotes number of edges
    SC : O(V+E)   --> Adj list  
### Solution
```java
public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    int ans = 0;
    boolean[] visited = new boolean[A + 1];
    List<List<Pair>> adjList = constructAdjList(B, A);
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
    minHeap.add(new Pair(1, 0));
    while (!minHeap.isEmpty()) {
        Pair current = minHeap.poll();
        if (visited[current.dest]) continue;
        ;
        visited[current.dest] = true;
        ans += current.weight;
        for (Pair nbr : adjList.get(current.dest)) {
            if (visited[nbr.dest]) continue;
            minHeap.add(nbr);
        }
    }
    return ans;
}

private List<List<Pair>> constructAdjList(ArrayList<ArrayList<Integer>> B, int nodeCount) {
    List<List<Pair>> result = new ArrayList<>(nodeCount + 1);
    for (int i = 0; i <= nodeCount; i++) {
        result.add(new ArrayList<>());
    }
    for (ArrayList<Integer> row : B) {
        result.get(row.get(0)).add(new Pair(row.get(1), row.get(2)));
        result.get(row.get(1)).add(new Pair(row.get(0), row.get(2)));
    }
    return result;
}
public class Pair {
    public Integer node;
    public Integer weight;

    public Pair(Integer node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }
}
```

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

### Solution approach:
    As per the problem statement we need to find minimum distance of each node from source node.
    We will start from source node and try all the possible option to reach node i and will choose
    minimum out of it and that would be the min distance to reach respective node from source
    Step 1: Constrcut bidirectionla adj list along with cost of each edge
    Step 2: Create a min heap on weight of edges and distance array to hold distance of each node
    Step 4: Add source node to min heap with 0 weight associated to it and Iterate untill heap is not empty
    Step 5: Extract min from heap and if current distance of respective node in less than current node weight the do nothing
    Step 6: otherwise update distance of node with the current value
    step 7: Add all neighbour of current node back to heap by adding current node weight to the nbr node weight.

    TC : O(ElogE)
    SC : O(V+E)

### Solution
```java
public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
    ArrayList<Integer> distance = new ArrayList<>();
    for (int i = 0; i < A; i++) {
        distance.add(Integer.MAX_VALUE);
    }
    List<List<Pair>> adjList = constructAdjList(B, A);
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
    minHeap.add(new Pair(C, 0));
    while (!minHeap.isEmpty()) {
        Pair current = minHeap.poll();
        if (distance.get(current.node) > current.weight) {
            distance.set(current.node, current.weight);
            for (Pair nbr : adjList.get(current.node)) {
                minHeap.add(new Pair(nbr.node, nbr.weight + current.weight));
            }
        }
    }
    // check if any node is unreachable
    for (int i = 0; i < A; i++) {
        if (distance.get(i) == Integer.MAX_VALUE) distance.set(i, -1);
    }
    return distance;
}

private List<List<Pair>> constructAdjList(ArrayList<ArrayList<Integer>> B, int A) {
    List<List<Pair>> result = new ArrayList<>(A);
    for (int i = 0; i <= A; i++) {
        result.add(new ArrayList<>());
    }
    for (ArrayList<Integer> row : B) {
        result.get(row.get(0)).add(new Pair(row.get(1), row.get(2)));
        result.get(row.get(1)).add(new Pair(row.get(0), row.get(2)));
    }
    return result;
}
public class Pair {
    public Integer node;
    public Integer weight;

    public Pair(Integer node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }
}
```

