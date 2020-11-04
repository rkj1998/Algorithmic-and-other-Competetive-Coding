/*

Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. Some pairs of islands are connected to each other by Bidirectional bridges running over water.
Monk hates to cross these bridges as they require a lot of efforts. He is standing at Island #1 and wants to reach the Island #N. Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.

Input:
First line contains T. T testcases follow.
First line of each test case contains two space-separated integers N, M.
Each of the next M lines contains two space-separated integers X and Y , denoting that there is a bridge between Island X and Island Y.

Output:
Print the answer to each test case in a new line.

Constraints:
1 ≤ T ≤ 10
1 ≤ N ≤ 104
1 ≤ M ≤ 105
1 ≤ X, Y ≤ N

SAMPLE INPUT 
2
3 2
1 2
2 3
4 4
1 2
2 3
3 4
4 2
SAMPLE OUTPUT 
2
2

*/

import java.util.*;

public class MonkAndIslands{

    private int V;
    private LinkedList<Integer> graph[];

    MonkAndIslands(int v){
        V=v;
        graph = new LinkedList[V];
        for(int i = 0 ; i<v;i++){
            graph[i]=new LinkedList();
        }
    }
    // Initilizing the graph


    void addEdge(int u,int v){
        graph[u].add(v);
        graph[v].add(u);
    
    }

    // Since according to the question bridges are bi- directional

    int shortesPath(){
        int pred[] = new int[V]; // Stores the predecessor of i
        int dist[] = new int[V]; // Stores the distance from s

        if(BFS(pred,dist)==false){
            return 0;
        }

        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = V-1;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
 
        // Print distance
        return dist[V-1];
 
    }

    boolean BFS(int pred[], int dist[]){
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
 
        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[0] = true;
        dist[0] = 0;
        queue.add(0);
 
        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < graph[u].size(); i++) {
                if (visited[graph[u].get(i)] == false) {
                    visited[graph[u].get(i)] = true;
                    dist[graph[u].get(i)] = dist[u] + 1;
                    pred[graph[u].get(i)] = u;
                    queue.add(graph[u].get(i));
 
                    // stopping condition (when we find
                    // our destination)
                    if (graph[u].get(i) == V-1)
                        return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args){
        Scanner read =new Scanner(System.in);
    
        int t = read.nextInt();
        for(int i =0;i<t;i++){
            int vertex = read.nextInt();
            MonkAndIslands graph = new MonkAndIslands(vertex);
            int edges = read.nextInt();
            for (int j = 0 ; j < edges; j ++){
                graph.addEdge(read.nextInt()-1,read.nextInt()-1);
         }
         System.out.println(graph.shortesPath());
        }
        read.close();
    }
}