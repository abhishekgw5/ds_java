import java.util.*;

public class graphs1 {
    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int s, int d, int w){
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    public static void createUnDirectedGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        //0 vertex
        graph[0].add(new Edge(0, 1, 5));

        //1st vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        //2nd vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,4));

        //3rd vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        //4th vertex
        graph[4].add(new Edge(4,2,2));
    }

    public static void createDirectedGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 0, 1));
    }

    public static void createDirectedGraphNoCycle(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,3,1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3,1,1));

        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));

        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));
    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); //index
        
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]){
        System.out.println(curr + " ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.destination]){
                dfs(graph,e.destination,vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);

            if(!vis[e.destination] && hasPath(graph, e.destination, dest, vis)){
                return true;
            }
        }
        return false;
    }

    public static void printAllPath(ArrayList<Edge> graph[],boolean vis[], int curr, String path,int tar){
        if(curr==tar){
            System.out.println(path);
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.destination]){
                vis[e.destination]=true;
                printAllPath(graph, vis, e.destination, path+e.destination, tar);
                vis[e.destination]=false;
            }
        }
    }

    public static void printAllPathDirected(ArrayList<Edge> graph[],int curr,int dest,String path){
        if(curr==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            printAllPathDirected(graph, e.destination, dest, path+curr);
        }
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
        vis[curr]=true;
        rec[curr]=true; //current recursion stack

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.destination]){
                return true;
            }else if(!vis[e.destination]){
                if(isCycleDirected(graph, vis, e.destination, rec)){
                    return true;
                }
                
            }
        }

        rec[curr]=false;
        return false;
    }

    
    //Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices 
    //such that for every directed edge u-v, vertex u comes before v in the ordering.
    //topological sort using bfs
    public static void calcIndegree(ArrayList<Edge> graph[], int indegree[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                indegree[e.destination]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge> graph[]){
        int indegree[] = new int[graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indegree[e.destination]--;
                if(indegree[e.destination]==0){
                    q.add(e.destination);
                }
            }
        }
        System.out.println();
    }


    //topological sort using dfs
       public static void topSortDFSUtil(ArrayList<Edge> graph[],int curr, boolean vis[],Stack<Integer> stack){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.destination]){
                topSortDFSUtil(graph, e.destination, vis, stack);
            }
        }

        stack.push(curr); //additional in dfs
    }

    public static void topSortDFS(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
                topSortDFSUtil(graph, i, vis, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    
    public static boolean isCycleUndirected(ArrayList<Edge> graph[],boolean vis[], int curr, int parent){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.destination] && e.destination!=parent){
                return true;
            }
            else if(!vis[e.destination]){
                if(isCycleUndirected(graph, vis, e.destination, curr)){
                    return true;
                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createUnDirectedGraph(graph);
        

        // for(int i=0; i<graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.destination);
        // }

        //bfs(graph);
        //dfs(graph, 0, new boolean[V]);
        
        //System.out.println(hasPath(graph, 0, 3, new boolean[V]));
        //printAllPath(graph, new boolean[V], 0, "0", 2);
        //it is possible that in directed graph any node cannot be visited so use this==
        //createDirectedGraph(graph);
        // boolean vis[] = new boolean[V];
        // boolean rec[] = new boolean[V];
        // for(int i=0;i<V;i++){
        //     if(!vis[i]){
        //         boolean isCycle = isCycleDirected(graph, vis, 0, rec);
        //         if(isCycle){
        //             System.out.println(isCycle);
        //             break; //beacuse we have to find only one cycle
        //         }
        //     }
        // }


        //topological sort 
        // int V=6;
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createDirectedGraphNoCycle(graph); //topsort will need DAG(Directed Acyclic Graph)
        // topSortDFS(graph, V); 
        // topSortBFS(graph);
        // printAllPath(graph, new boolean[V], 5, "5", 1);
        // printAllPathDirected(graph, 5, 1, "");
        
        createUnDirectedGraph(graph);
        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));

    }
}
