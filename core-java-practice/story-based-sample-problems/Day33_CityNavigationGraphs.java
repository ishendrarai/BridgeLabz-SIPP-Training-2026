import java.util.*;

public class Day33_CityNavigationGraphs {
    static class Graph {
        int V;
        List<List<Integer>> adj;
        
        Graph(int v) {
            V = v;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        }
        
        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }
        
        int shortestPathBFS(int src, int dest) {
            boolean[] visited = new boolean[V];
            int[] dist = new int[V];
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            visited[src] = true;
            
            while (!q.isEmpty()) {
                int u = q.poll();
                if (u == dest) return dist[u];
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        dist[v] = dist[u] + 1;
                        q.add(v);
                    }
                }
            }
            return -1;
        }
        
        boolean detectCycleDirected() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (detectCycleUtil(i, visited, recStack)) return true;
            }
            return false;
        }
        
        private boolean detectCycleUtil(int i, boolean[] visited, boolean[] recStack) {
            if (recStack[i]) return true;
            if (visited[i]) return false;
            visited[i] = true;
            recStack[i] = true;
            for (Integer c : adj.get(i)) {
                if (detectCycleUtil(c, visited, recStack)) return true;
            }
            recStack[i] = false;
            return false;
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        
        System.out.println("Shortest path from 0 to 4 (BFS hops): " + g.shortestPathBFS(0, 4));
        System.out.println("Has Cycle? " + g.detectCycleDirected());
        
        g.addEdge(4, 1); // create cycle
        System.out.println("Has Cycle after adding back edge? " + g.detectCycleDirected());
    }
}
