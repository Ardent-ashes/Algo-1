import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors 

class bfs{
    int v;
    List<List<Integer>>adj;
    bfs(int v){
       this.v=v;
       this.adj= new ArrayList<>();
       for(int i=0;i<v;i++){
        adj.add(new ArrayList<>());
       }
    }

    void addEdge(int u, int v){
        adj.get(u-1).add(v-1);
        adj.get(v-1).add(u-1);
    }
    public int vertex(){
        return v;
    }

    public void adj_vertex(int v){
        for(int neigh:adj.get(v)){
          System.out.print(neigh+1+" ");  
        }
    }
    void path(int vertex){
        boolean[] visited= new boolean[v];
        Queue<Integer> qu= new LinkedList<>();
        visited[vertex]=true;
        System.out.print(vertex+1+" ");
        qu.add(vertex);
        while(!qu.isEmpty()){
            int ver= qu.poll();
           
            for(int neigh: adj.get(ver)){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    System.out.print(neigh+1+" ");
                    qu.add(neigh);

                }
            }
        }
       
    }

    void distance(int start, int end){
        boolean[] visited= new boolean[v];
        int[] dist=new int[v];
        Arrays.fill(dist,-1);
        Queue<Integer> qu= new LinkedList<>();
        visited[start-1]=true;
        dist[start-1]=0;
        qu.add(start-1);
        while(!qu.isEmpty()){
            int ver= qu.poll();
           
            for(int neigh: adj.get(ver)){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    dist[neigh]=dist[ver]+1;
                    if(neigh==end-1){
                        System.out.print(dist[neigh]);
                    }
                    qu.add(neigh);

                }
            }
        }
       
    }

  
    void add_ver(int ver){
        int x=this.v;
        this.v+=ver;
        for(int i=x;i<ver;i++){
            adj.add(new ArrayList<>());
        }
    }


}
public class lab1{
    public static void main(String args[]){
        try{
            File file= new File("filename.txt");
            Scanner scanner= new Scanner(file);
            int v= scanner.nextInt();
            int edges= scanner.nextInt();
            bfs BFS= new bfs(v);
            for(int i=0;i<edges;i++){
                int u=scanner.nextInt();
                int v_edge=scanner.nextInt();
                BFS.addEdge(u, v_edge);
               
            }
            //BFS.adj_vertex(0);
            BFS.distance(1,2);
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.print("file not found");
            e.printStackTrace();
        }
        // int v=5;
        // bfs BFS= new bfs(v);
        // BFS.addEdge( 0, 1);
        // BFS.addEdge( 0, 2);
        // BFS.addEdge( 1, 3);
        // BFS.addEdge( 2, 4);
       
        

    }
}