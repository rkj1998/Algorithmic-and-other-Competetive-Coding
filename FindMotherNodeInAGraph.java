/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


/**
 *
 * @author RAHUL KUMAR JHA
 */
// Mother Node FInd in graph program 
// Mother node is a node in graph from which one can reach all possible vertices in graph.
//There are 2 approches 
//One is a naive approach which means we can basically travesrse the every node once using DFSUtil and find if its a mother node
//THis however incrases time complexity and is not at all feasable for large graph
//Below algorithm implementation does it in a less complicted way.

// Program to find mother vertices in a graph

public class JavaApplication5 {
    
    private int V;// No of vertices in Graph
    private LinkedList<Integer> adj[]; // For Graph respresentation
    
    JavaApplication5(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i = 0 ; i< v ; i++){
            adj[i]= new LinkedList();
        }
    }
            // Constructor to feed in graph values

    
    void addEdge(int u,int v){
        adj[u].add(v);
    }
    
    void DFSUtil(int v,boolean visited[]){       //For DFS Search
        visited[v]=true;
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
        
    }
    
    
    
    int findMother(){
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,Boolean.FALSE);
        // Initializing visited array as false as whole
        int v=0;
        for(int i = 0 ; i< V;i++){
            if (visited[i]==false){
                DFSUtil(i,visited);
               v=i;
            }
        }
            
            Arrays.fill(visited,Boolean.FALSE);
            DFSUtil(v,visited);
            for( int i = 0 ; i< V;i++){
                if(visited[i]==false){
                    System.out.println("YE bana rha hai "+i);
                    v = -1;
                }
            }
                
                
               // Here first we are initailizing the value with 0 and then indexing whole boolean array if any eleemt is found to be false DFS Util is run
               //From that particulat element if becuase if whole graph is visited all indexes are supposed to be true.
               //Once this is done we reset the boolean array to find customly if all vertices are reachable or not if they are not we return -1 
               //and if they are we return value of the v we gained while traversing
            return  v;
            }

        
    // Feeding vertice value of graph

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Scanner read = new Scanner(System.in);
       int vertices = read.nextInt();
       int edges = read . nextInt();
       JavaApplication5 graph = new JavaApplication5(vertices);
       for (int i = 0 ;i< edges ; i++){
           graph.addEdge(read.nextInt(),read.nextInt());
       }
       
       
       System.out.println("Mother Vertex is :"+graph.findMother());
	
        // TODO code application logic here
        
    }
    
}
