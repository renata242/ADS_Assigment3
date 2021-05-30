package com.company;

class BST {
    private Node root;
    private class Node {
        private int key;
        private Node left;
        private Node right;
        public Node(int data){
            key = data;
            left = null;
            right = null;
        }
    }
    void put(int key)  {
        root = put_recursive(root, key);
    }
    Node put_recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = put_recursive(root.left, key);
        else if (key > root.key)
            root.right = put_recursive(root.right, key);
        return root;
    }
    void out() {
        out_recursive(root);
    }
    void out_recursive(Node root) {
        if (root != null) {
            out_recursive(root.left);
            System.out.print(root.key + " ");
            out_recursive(root.right);
        }
    }
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }
    int getMin(Node root)  {
        int GetMin = root.key;
        while (root.left != null)  {
            GetMin = root.left.key;
            root = root.left;
        }
        return GetMin;
    }
    Node delete_Recursive(Node root, int key)  {
        if (root == null)  return root;
        if (key < root.key)
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)
            root.right = delete_Recursive(root.right, key);
        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = getMin(root.right);
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }
    boolean search(int key)  {
        root = search_recursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }
    Node search_recursive(Node root, int key)  {
        if (root==null || root.key==key)
            return root;
        if (root.key > key)
            return search_recursive(root.left, key);
        return search_recursive(root.right, key);
    }
}
class Main{
    public static void main(String[] args)  {
        BST bst = new BST();
        bst.put(3);
        bst.put(40);
        bst.put(2);
        bst.put(50);
        bst.put(48);
        bst.put(60);
        bst.put(71);
        System.out.println("\nOriginal Tree :");
        bst.out();
        boolean ex = bst.search (3);
        System.out.println("Check whether Node with value 3 exists: " + ex );
        System.out.println("\nDelete Node with two children (2): ");
        bst.deleteKey(3);
        bst.out();
        System.out.println("\nDelete leaf node (48): ");
        bst.deleteKey(48);
        bst.out();
        System.out.println("\nDelete Node with no children (60): ");
        bst.deleteKey(60);
        bst.out();
        ex = bst.search (3);
        System.out.println("\nCheck whether Node with value 3 exists: " + ex );
    }
}
