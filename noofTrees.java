/*
Count number of trees in a forest
Given n nodes of a forest (collection of trees), find the number of trees in the forest.

Examples :

Input :  edges[] = {0, 1}, {0, 2}, {3, 4}
Output : 2
Explanation : There are 2 trees
                   0       3
                  / \       \
                 1   2       4
Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Approach :
1. Apply DFS on every node.
2. Increment count by one if every connected node is visited from one source.
3. Again perform DFS traversal if some nodes yet not visited.
4. Count will give the number of trees in forest.
*/



import java.util.*;


class noofTrees {

    private int V; // For vertices in graph

    private LinkedList<Integer> graph[];

    noofTrees(int v){
        V=v;
        graph = new LinkedList[V];
        for(int i=0;i<v;i++){
            graph[i]=new LinkedList<>();
        }
    
    }      // Graph Initialization.

    void addEdge(int u,int v){
        graph[u].add(v);
    }

    void DFSUtil(int v,boolean visited[]){
        visited[v]= true;
        Iterator<Integer> i = graph[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(visited[n]==false){
                DFSUtil(n, visited);
            }
        }

    }

    int countTrees(){
        boolean visited[] = new boolean[V];    // Initilizing an array with no of vertices.
        int trees = 0; // Initializing no of trees as zero.
        // Now we will call DFS function to get DFS Traversal.
        for(int i =0; i<V;++i){
            if(visited[i]==false){
                DFSUtil(i,visited);
                trees++;
            }
        }
        return trees;
    }

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int vertices = read.nextInt();
        noofTrees graph = new noofTrees(vertices);
        int edges = read.nextInt();
        for(int i=0;i<edges;i++){
            graph.addEdge(read.nextInt(),read.nextInt());
        }
        System.out.println(graph.countTrees());
        read.close();

    }

}