public class Main {
  public static void main(String[] args) {

    // Step 1 - Create a BST tree object called lab5Tree
    BST<Integer> lab5Tree = new BST<>();

    // Step 2 - Insert the following values: 13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10
    int[] values = {13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10};
    for (int v : values) {
      lab5Tree.insert(v);
    }

    // Step 3 - Delete the value 17
    lab5Tree.delete(17);

    // Step 4 - Traverse and output the values using inorder (sorted)
    System.out.print("Inorder traversal: ");
    lab5Tree.inorder();
    System.out.println();

    // Step 5 - Traverse and output the values using postorder
    System.out.print("Postorder traversal: ");
    lab5Tree.postorder();
    System.out.println();

    // Step 6 - Traverse and output the values using preorder
    System.out.print("Preorder traversal: ");
    lab5Tree.preorder();
    System.out.println();

    // Step 7 - Display the result of a search for the value 36
    System.out.println("Search for 36: " + lab5Tree.search(36));

    // Step 8 - Display the result of a search for the value 37
    System.out.println("Search for 37: " + lab5Tree.search(37));

    // Step 9 - Using the path() method, display the path from the root to 2
    System.out.println("Path to 2: " + lab5Tree.path(2));

    // Step 10 - Display the path from the root to 34
    System.out.println("Path to 34: " + lab5Tree.path(34));
  }
}

