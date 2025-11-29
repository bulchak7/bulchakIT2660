public class Main {
  public static void main(String[] args) {

    // vertices
    String[] vertices = {
      "Liberal Arts",              // 0
      "Student Services",          // 1
      "Health Careers & Sciences", // 2
      "Health Technologies Center",// 3
      "Recreation Center",         // 4
      "Technology Learning Center",// 5
      "Business & Technology",     // 6
      "Theatre"                    // 7
    };

    // edges based on the campus map
    int[][] edges = {
      {0,1}, {0,7}, {0,6},
      {1,2}, {1,5},
      {2,3}, {2,4},
      {3,4},
      {5,6},
      {6,7}
    };

    // graph
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);

    
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);

    // DFS search order
    System.out.println("DFS Search Order:");
    System.out.println(dfs.getSearchOrder());
    System.out.println();

  
    System.out.println("Parent Relationships:");
    for (int i = 0; i < vertices.length; i++) {
      System.out.println(vertices[i] + " parent = " + dfs.getParent(i));
    }
    System.out.println();

    // example paths
    System.out.println("Path to Health Technologies Center:");
    dfs.printPath(3);
    System.out.println("\n");

    System.out.println("Path to Student Services:");
    dfs.printPath(1);
    System.out.println("\n");

    System.out.println("Path to Recreation Center:");
    dfs.printPath(4);
    System.out.println("\n");

    // DFS tree
    System.out.println("DFS Tree:");
    dfs.printTree();
  }
}
