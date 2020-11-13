/*
In a social networking site, people are connected with other people. The whole system appears as a giant connected graph.
 In this question, you are required to answer the total number of people connected at t nodes away from each other (t distance connectivity). 
For example: Two persons directly connected are at 1 distance connectivity. While the two persons having a common contact without having direct connectivity, 
are at 2 distance connectivity.
First line of input line contains, two integers n and e, where n is the nodes and e are the edges.
 Next e line will contain two integers u and v meaning that node u and node v are connected to each other in undirected fashion.
  Next line contains single integer, m, which is number of queries. Next m lines, each have two inputs,
   one as source node and other as a required t distance connectivity which should be used to process query.


Note: The index of nodes will be 0-based. The example and the test case shown is of 1-based index. For submitting the solution, use 0-based indexing.

SAMPLE INPUT 
9 10
1 2
2 3
1 7
2 4
3 4
4 7
7 8
9 7
7 6
5 6
3
4 2
5 3
2 14


SAMPLE OUTPUT 
4
4
3


Explanation
After creating the graph, there was 3 queries,

Source node: 4, and we have to find out total number of nodes at a distance of 2 from node 4.
1(4->2->1), 8(4->7->8), 9(4->7->9), 6(4->7->6) = 4

Similarly as above

Source node: 2, and we have to find out total number of nodes at a distance of 1 from node 2.
1(2->1), 4(2->4), 3(2->3) = 3


*/


import java.util.*;

public class SocialNetworkGraph {

    static private int V;
    static private LinkedList<Integer> graph[];

    SocialNetworkGraph(int v){
        V = v;
        graph = new LinkedList[V];
        for(int i = 0 ;i < v;i++){
            graph[i]=new LinkedList();
        }
    }

        void addEdge(int u,int v){
            graph[u].add(v);
            graph[v].add(u);
        }

        // Since the graph is an undirected graph


        static int[] BFS(int s){
            boolean visited[] = new boolean[V+1];
            LinkedList <Integer> queue =  new LinkedList<Integer>();
            visited[s]= true;
            int dist[] = new int[V];
            dist[s]=0;
            queue.add(s);
            while(queue.size()!=0){
                s = queue.poll();
                Iterator<Integer> i = graph[s].listIterator();
                while(i.hasNext()){
                    int n = i.next();
                    if(!visited[n]){
                        dist[n]=dist[s]+1; // We are using this variable to track distance and we can assume current distance +1 is the distance
                        visited[n]=true;
                        queue.add(n);
                    }
                }
            }
            return dist;
        }
        static int FindNodes(int a,int b){
            int count = 0;
            int dist[] = new int [V];
            dist=BFS(a);
            for(int i =0;i<dist.length;i++){
                if(dist[i]==b){
                    count++;
                }
            }
            System.out.println();
            return count;
        }

        public static void main(String[] args){
            try{
            Scanner read = new Scanner(System.in);
            int v = read.nextInt();
            int edges = read.nextInt();
            SocialNetworkGraph graph = new SocialNetworkGraph(v);
            for (int i =0;i<edges;i++){
                graph.addEdge(read.nextInt()-1, read.nextInt()-1);
            }
            int query = read.nextInt();
            for(int i =0;i<query;i++){
                System.out.println(FindNodes(read.nextInt()-1,read.nextInt()));
            }
            read.close();
        }   
    catch(Exception e){
        return;  
    }

    }
}