import java.util.*;

public class graphs2 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    //Shortest Paths from Source to all Vertices using Dijkstra’s Algorithm
    static class Pair implements Comparable<Pair>{
        int n; //vertex
        int path; //cost associated with n

        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int dist[] = new int[graph.length];

        //make initial distance as infinity
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                //visit for all its neighbours
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;

                    if(dist[u]+wt < dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]+" ");
        }
        System.out.println();
    }

    //dijkstra algo does not work well for -ve weighted graph
    //in that case Bellman Ford Algorithm is used
    //Also Bellman Ford algo does not work for -ve weight cycles
    static void createGraph2(ArrayList<Edge> graph){
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }
    
    public static void bellmanFord(ArrayList<Edge> graph, int src, int V){
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.size();j++){
                Edge e = graph.get(j);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }

        //print
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    } 

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src=0;
        dijkstra(graph, src);
        
        // int V=5;
        // ArrayList<Edge> graph = new ArrayList<>();
        // createGraph2(graph);
        // bellmanFord(graph, 0, V);
        
    }
}
  