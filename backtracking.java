
/*
Count all possible paths between two vertices
Count the total number of ways or paths that exist between two vertices in a directed graph. These paths don’t contain a cycle, 
the simple enough reason is that a cycle contains an infinite number of paths and hence they create a problem.

Examples:
Input: Count paths between A and E
Output : Total paths between A and E are 4
Explanation: The 4 paths between A and E are:
                      A -> E
                      A -> B -> E
                      A -> C -> E
                      A -> B -> D -> C -> E 

Input : Count paths between A and C
Output : Total paths between A and C are 2
Explanation: The 2 paths between A and C are:
                      A -> C
                      A -> B -> D -> C

Approach:
The problem can be solved using backtracking, that says take a path and start walking on it and check if it leads us to the destination vertex then count the path and backtrack to take another path. If the path doesn’t lead to the destination vertex, discard the path.
This type of graph traversal is called Backtracking.


This solution will not work for a graph which contains cycles

Algorithm:

1) Create a recursive function that takes index of node of a graph and the destination index. Keep a global or a static variable count to store the count.
2) If the current nodes is the destination increase the count.
3) Else for all the adjacent nodes, i.e. nodes that are accessible from the current node, call the recursive function with the index of adjacent node and the destination.
4) Print the Count.

*/


// Java program to count all paths from source to destination in a graph using backtracking.
import java.util.*;

class backtracking {
    private int V;   // No of Vertices in graph;

    static LinkedList<Integer> graph[];   // Linked List for creating graph

    backtracking(int v){
        V=v;
        graph = new LinkedList[V];  
        for (int i=0 ; i< V;i++){
            graph[i]=new LinkedList<>();
        }
    }
        //  Constructor For initializing the graph according to vertices

        void addEdge(int u,int v){            // Function to add edge to the graph.

            graph[u].add(v);
        }

         int countPaths(int source , int destination) {
            int pathCount = 0;
            pathCount = pathCountUtil(source,destination,pathCount);
            return pathCount;

        }

         int pathCountUtil(int source,int destination,int pathCount){
            if (source == destination){
                pathCount++;
            }

            else {
                Iterator<Integer> i = graph[source].listIterator();  // We start Iterating the graph from the given source vertex.
                while(i.hasNext()){
                    int n = i.next();
                    pathCount = pathCountUtil(n, destination, pathCount);
                }
            }
            return pathCount;

            // In the above recursive function pathCountUtil is called again and again which continiously updates the source vertex and mathces it with destination
            // to find the no of paths .

        }


        





        public static void main (String[] args){
            Scanner read = new Scanner(System.in);
            int vertex = read.nextInt();
            backtracking graph = new backtracking(vertex);
            int edges = read.nextInt();
            for (int i = 0 ; i < edges ; i++){
                graph.addEdge(read.nextInt(),read.nextInt());
            }
            int result = graph.countPaths(read.nextInt(),read.nextInt());

            System.out.println("Total no of paths between source and destination are : "+result);

        }
    }
