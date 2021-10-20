package com.greatlearning.main;

import java.util.*;
 
public class Skewedtreeascorder{
     
    /* A binary tree node structure */
    static class Node {
        int data;
        Node left;
        Node right;
    };
 
    // index pointer to pointer to the array index
    static int index;
 
 
    /* A helper function that inorder traversal of a tree rooted
    with node */
    static void traverseRightSkewed(Node node, int inorder[])
    {
        // Base Case
        if (node == null)
            return;
 
        /* first store the left subtree */
        traverseRightSkewed(node.left, inorder);
 
        /* Copy the root's data */
        inorder[index] = node.data;
        index++; // increase index for next entry
 
        /* finally store the right subtree */
        traverseRightSkewed(node.right, inorder);
    }
 
    /* A helper function to count nodes in a Binary Tree */
    static int countNodes(Node root)
    {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
 
   
    static void flattenBTToSkewed(int[] arr, Node root)
    {
        // Base Case
        if (root == null)
            return;
 
        /* first update the left subtree */
        flattenBTToSkewed(arr, root.left);
 
        /* Now update root's data and increment index */
        root.data = arr[index];
        index++;
 
        /* finally update the right subtree */
        flattenBTToSkewed(arr, root.right);
    }
 
    // This function converts a given Binary Tree to Skewed tree
    static void binaryTreeToSkewedTree(Node root)
    {
        // base case: tree is empty
        if (root == null)
            return;
 
        /* Count the number of nodes in Binary Tree so that
        we know the size of temporary array to be created */
        int n = countNodes(root);
 
        // Create a temp array arr[] and store inorder traversal of tree in arr[]
        int arr[] = new int[n];
 
        traverseRightSkewed(root, arr);
 
        // Sort the array using library function for quick sort
        Arrays.sort(arr);
         
         
        // Copy array elements back to Binary Tree
        index = 0;
        flattenBTToSkewed(arr, root);
    }
 
    /* Utility function to create a new Binary Tree node */
    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }
 
    /* Utility function to print inorder traversal of Binary Tree */
    static void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.data + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
    /* Driver function to test above functions */
    public static void main(String args[])
    {
        Node root = null;
        root = newNode(50);
        root.left = newNode(30);
        root.right = newNode(60);
        root.left.left = newNode(10);
        root.right.left = newNode(40);
 
        // convert Binary Tree to Skewed tree
        binaryTreeToSkewedTree(root);
 
        System.out.println("Converting to Skewedtree ");
        printInorder(root);
        
 
    }
}