/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreePractice;

/**
 *
 * @author Pranjal
 */

class MyNode {
    int data;
    MyNode lNode;
    MyNode rNode;
    
    public MyNode(int x) {
        data = x;
    }
}

public class BSTBasic {
    MyNode root;
    
    public void insert(int data) {
        insertHelper(data, root, null);
    }
    
    public void printInOrder() {
        System.out.print("inorder: ");
        printInOrderHelper(root);
        System.out.println();
    }
    
    public void printPreOrder() {
        System.out.print("preorder: ");
        printPreOrderHelper(root);
        System.out.println();
    }
    
    public void printPostOrder() {
        System.out.print("postorder: ");
        printPostOrderHelper(root);
        System.out.println();
    }
    
    public void printLevelOrder() {
        System.out.println("level order: ");
        int height = calculateHeight();
        for(int i=0; i<height; i++) {
            printLevel(root, 0, i);
            System.out.println();
        }
    }
    
    private void insertHelper(int data, MyNode current, MyNode prev) {
        if(current == null) {
            MyNode node = new MyNode(data);
            if(prev == null) root = new MyNode(data);
            else if(data < prev.data) prev.lNode = node;
            else prev.rNode = node;
            return;
        }
        if(data < current.data) insertHelper(data, current.lNode, current);
        else insertHelper(data, current.rNode, current);
    }
    
    private void printInOrderHelper(MyNode node) {
        if(node == null) return;
        printInOrderHelper(node.lNode);
        System.out.print(node.data + "\t");
        printInOrderHelper(node.rNode);
    }
    
    private void printPreOrderHelper(MyNode node) {
        if(node == null) return;
        System.out.print(node.data + "\t");
        printPreOrderHelper(node.lNode);
        printPreOrderHelper(node.rNode);
    }
    
    private void printPostOrderHelper(MyNode node) {
        if(node == null) return;
        printPostOrderHelper(node.lNode);
        printPostOrderHelper(node.rNode);
        System.out.print(node.data + "\t");
    }
    
    public int calculateHeight() {
        return calculateHeightHelper(root);
    }
    
    private int calculateHeightHelper(MyNode node) {
        if(node == null) return 0;
        return Math.max(calculateHeightHelper(node.lNode), calculateHeightHelper(node.rNode))+1;
    }
    
    private void printLevel(MyNode node, int currentLevel, int level) {
        if(node == null) return;
        if(currentLevel == level) {
            System.out.print(node.data + "\t");
            return;
        }
        printLevel(node.lNode, currentLevel+1, level);
        printLevel(node.rNode, currentLevel+1, level);
    }
    
    public static void main(String a[]) {
        int[] values = { 5, 3, 7, 2, 9, 1, 6, 4, 8, 10 };
        BSTBasic myBST = new BSTBasic();
        for(int val : values) myBST.insert(val);
        myBST.printInOrder();
        myBST.printPreOrder();
        myBST.printPostOrder();
        System.out.println("height: " + myBST.calculateHeight());
        myBST.printLevelOrder();
    }
}
