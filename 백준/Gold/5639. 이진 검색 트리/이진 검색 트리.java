

import java.util.Scanner;

public class Main {
  static class Node {
    int val;
    Node left = null;
    Node right = null;
    Node(int v) {
      this.val = v;
    }
  }

  static Node root;

  static Node insert(Node node, int key) {
    if(node == null) return new Node(key);
    if(key < node.val) node.left = insert(node.left, key);
    else node.right = insert(node.right, key);
    return node;
  }

  static void postOrder(Node n, StringBuilder sb) {
    if(n == null) return;
    postOrder(n.left, sb);
    postOrder(n.right, sb);
    sb.append(n.val)
            .append("\n");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()) {
      int x = sc.nextInt();
      root = insert(root, x);
    }

    StringBuilder sb = new StringBuilder();
    postOrder(root, sb);
    System.out.println(sb);
  }
}
