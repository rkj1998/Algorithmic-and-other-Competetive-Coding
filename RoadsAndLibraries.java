
// https://www.hackerrank.com/challenges/torque-and-development/problem


import java.util.*;

 class RoadsAndLibraries {

    static private int V;
    static private LinkedList<Integer> graph[];

    //Declaring The Graph Class

    RoadsAndLibraries(int v){
        V=v;
        graph = new LinkedList[V];
        for (int i = 0 ; i < v ; i ++ ){
            graph[i] = new LinkedList();
        }
    }

    void addEdge(int u,int v){
        graph[u].add(v);
        graph[v].add(u);
    }


//Our Recursive DFS Function Which Will Run DFS To find No. of Connected Components

    static void DFSUtil(int i,boolean[] visited){
        visited[i] = true ;
        Iterator<Integer> iterator = graph[i].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }


    //Our CostToBuild Function 
    //Total No. of Components are calculated then to find no of Connected Nodes Componets are reduced from total edges
    /*
        For Example

        We have a graph with 5 vertices and they are connected in following way

        1 -----> 2 ----- > 3
        \
         \
          \ 
           \
            \>4

            5


            Here our connected componets variable will be set as 2

            To find cost value will be 5 -2 which will give us a total of 3 edges for which we have to build bi directional roads 
             
            And since there are 2 connected components two libraries will be built

            */

    static long CostToBuild(long clib,long croad){
        long cost=0;
        long connectedComponents =0;
        boolean[] visited = new boolean[V];
        for(int i =0 ; i < V; i++){
            if(!visited[i]){
                DFSUtil(i,visited);
                ++connectedComponents;
            }
        }
        cost = (long)( croad *(V - connectedComponents )+ (clib * connectedComponents));
        return cost;
    }


     public static void main(String[] args){
         Scanner read = new Scanner(System.in);
         int queries = read.nextInt();
         for(int i = 0 ; i < queries ; i++){
            int n = read.nextInt();
            int m = read.nextInt();
            long clib = read.nextLong();
            long croad = read.nextLong();
            long cost = 0;
            RoadsAndLibraries graph = new RoadsAndLibraries(n);
            for(int j = 0;j < m; j++){
                graph.addEdge(read.nextInt()-1, read.nextInt()-1);
            }
            if(clib<=croad){
                cost = clib * n;
            }
            else {
                cost = CostToBuild(clib,croad);
            }
            System.out.println(cost);
            

         }
         
         read.close();
     }
 }
