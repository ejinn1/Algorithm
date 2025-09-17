

import java.util.*;

public class Main {
  static class Node {
    char val;
    Node left;
    Node right;
    Node(char v) {
      this.val = v;
    }
  }

  static Map<Character, Node> map = new HashMap<>();
  static Node get(char c) {
    return map.computeIfAbsent(c, Node::new);
  }

  static StringBuilder sb = new StringBuilder();
  static void pre(Node n) {
    if(n == null) return;
    sb.append(n.val);
    pre(n.left);
    pre(n.right);
  }
  static void in(Node n) {
    if(n == null) return;
    in(n.left);
    sb.append(n.val);
    in(n.right);
  }
  static void post(Node n) {
    if(n == null) return;
    post(n.left);
    post(n.right);
    sb.append(n.val);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    Set<Character> children = new HashSet<>();
    for (int i = 0; i < N; i++) {
      char p = sc.next()
              .charAt(0);
      char l = sc.next()
              .charAt(0);
      char r = sc.next()
              .charAt(0);

      Node pn = get(p);
      if(l != '.') {
        pn.left = get(l);
        children.add(l);
      }
      if (r != '.') {
        pn.right = get(r);
        children.add(r);
      }
    }

    Node root = null;
    for(char key: map.keySet()){
      if(!children.contains(key)){
        root = map.get(key);
        break;
      }
    }

    pre(root);
    sb.append('\n');
    in(root);
    sb.append('\n');
    post(root);
    System.out.print(sb);
  }
}
