import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Graph {

    int v;
    List<List<Integer>> adj; 
    int[] color; 
    int[] prev; 
    int[] d;
    int[] f; 
    int time; 

    Graph(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            v = scanner.nextInt();
            int edges = scanner.nextInt();
            adj = new ArrayList<>(v);
            
            // Initialize adjacency list
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }

            // Read the edges
            for (int i = 0; i < edges; i++) {
                int u = scanner.nextInt();
                int v_edge = scanner.nextInt();
                add_Edge(u, v_edge);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        // Initialize arrays
        color = new int[v];
        prev = new int[v];
        d = new int[v];
        f = new int[v];
        time = 0;
    }

    void add_Edge(int u, int v) {
        adj.get(u).add(v);
    }

    void DFS() {
        for (int i = 0; i < this.v; i++) {
            color[i] = 0; 
            prev[i] = -1;
            d[i] = Integer.MAX_VALUE;
            f[i] = Integer.MAX_VALUE;
        }
        time = 0;

        for (int i = 0; i < v; i++) {
            if (color[i] == 0) {
                DFS_Visit(i);
            }
        }
    }

    void DFS_Visit(int u) {
        System.out.print(u + " ");
        color[u] = 1;
        time++;
        d[u] = time;
        for (int v : adj.get(u)) {
            if (color[v] == 0) {
                prev[v] = u;
                DFS_Visit(v);
            }
        }
        color[u] = 2;
        time++;
        f[u] = time;
    }
}

public class lab22 {
    public static void main(String[] args) {

        Graph graph = new Graph("input2.txt");
        graph.DFS_Visit(5);  
    }
}
