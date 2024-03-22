package lib;

import performance.Performance;

/**
 * Hussein's Binary AVL Tree
 * Author: Hussein Suleman
 * Edited: Awonke Mnotoza
 * Date: 26 March 2017
 * Reference: kukuruku.co/post/avl-trees/
 */
public class AVLTree extends BinaryTree
{

   /**
    * Constructor
    */
   public AVLTree () {}

   /**
    * Get the height of the tree
    * @param node the root of the tree to get the height
    * @return the height
    */
   public int height ( BinaryTreeNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**
    * Get the balance factor
    * @param node the root of the tree to get the balance factor
    * @return the balance factor
    */
   public int balanceFactor ( BinaryTreeNode node ) {
      return height (node.right) - height (node.left);
   }
   
   /**
    * Fix the height
    * @param node the root of the tree to fix the height
    */
   public void fixHeight ( BinaryTreeNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**
    * Rotate the tree
    * @param p the root of the tree to rotate
    * @param performance the performance object
    * @return the new root
    */
   public BinaryTreeNode rotateRight ( BinaryTreeNode p, Performance performance )
   {
      BinaryTreeNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      performance.incrementExecutionCount();
      return q;
   }

   /**
    * Rotate the tree
    * @param q the root of the tree to rotate
    * @param performance the performance object
    * @return the new root
    */
   public BinaryTreeNode rotateLeft ( BinaryTreeNode q, Performance performance )
   {
      BinaryTreeNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      performance.incrementExecutionCount();
      return p;
   }
   
   /**
    * Balance the tree
    * @param p the root of the tree to balance
    * @param performance the performance object
    * @return the new root
    */
   public BinaryTreeNode balance ( BinaryTreeNode p, Performance performance ) {
      fixHeight (p);
      if (balanceFactor (p) == 2) {
         if (balanceFactor (p.right) < 0) {
            p.right = rotateRight (p.right, performance);
         }
         return rotateLeft (p, performance);
      }
      if (balanceFactor (p) == -2) {
         if (balanceFactor (p.left) > 0) {
            p.left = rotateLeft (p.left, performance);
         }
         return rotateRight (p, performance);
      }
      return p;
   }

   /** 
    * Insert the node
    * @param d the data
    * @param performance the performance object
   */
   public void insert ( DataType d, Performance performance )
   {
      root = insert (d, root, performance);
   }

   /**
    * Insert the node
    * @param d the data
    * @param node the root of the tree
    * @param performance the performance object
    * @return the new root
    */
   public BinaryTreeNode insert ( DataType d, BinaryTreeNode node, Performance performance ) {
      if (node == null) {
         performance.incrementExecutionCount();
         return new BinaryTreeNode (d, null, null);
      }
      if (d.getTerm().compareTo(node.data.getTerm()) <= 0) {
         performance.incrementExecutionCount();
         node.left = insert (d, node.left, performance);
      }
      else {
         performance.incrementExecutionCount();
         node.right = insert (d, node.right, performance);
      }
      return balance (node, performance);
   }
   
   /**
    * Delete the node
    * @param d the data
    * @param performance the performance object
    */
   public void delete ( DataType d, Performance performance )
   {
      root = delete (d, root, performance);
   }   

   /**
    * Delete the node
    * @param d the data 
    * @param node the root of the tree
    * @param performance the performance object
    * @return the new root
    */
   public BinaryTreeNode delete ( DataType d, BinaryTreeNode node, Performance performance )
   {
      if (node == null) {
         // No need to increment execution count
         return null;
      }
      if (d.getTerm().compareTo(node.data.getTerm()) < 0) {
         performance.incrementExecutionCount();
         node.left = delete (d, node.left, performance);
      }
      else if (d.getTerm().compareTo(node.data.getTerm()) > 0) {
         performance.incrementExecutionCount();
         node.right = delete (d, node.right, performance);
      }
      else
      {
         BinaryTreeNode q = node.left;
         BinaryTreeNode r = node.right;
         if (r == null) {
            // No need to increment execution count
            return q;
         }
         performance.incrementExecutionCount();
         BinaryTreeNode min = findMin (r);
         min.right = removeMin (r, performance);
         min.left = q;
         return balance (min, performance);
      }
      return balance (node, performance);
   }
   
   /**
    * Find the minimum
    * @param node the root of the tree
    * @return the minimum
    */
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   /**
    * Remove the minimum
    * @param node the root of the tree
    * @param performance the performance object
    * @return the new root
    */
   public BinaryTreeNode removeMin ( BinaryTreeNode node, Performance performance )
   {
      if (node.left == null) {
         performance.incrementExecutionCount();
         return node.right;
      }
      node.left = removeMin (node.left, performance);
      return balance (node, performance);
   }

   /**
    * Find the node
    * @param d the data to find
    * @param performance the performance object
    * @return the node or null
    */
   public BinaryTreeNode find ( String d, Performance performance )
   {
      if (root == null)
         return null;
      else
         return find (d, root, performance);
   }

   /**
    * Find the node
    * @param d the data to find
    * @param node the root of the tree
    * @param performance the performance object
    * @return the node or null
    */
   public BinaryTreeNode find ( String d, BinaryTreeNode node, Performance performance ) {
      if (d.compareTo(node.data.getTerm()) == 0) {
         performance.incrementExecutionCount();
         return node;
      }
      else if (d.compareTo(node.data.getTerm()) < 0) {
         if (node.left == null) {
            // No need to increment execution count
            return null;
         }
         performance.incrementExecutionCount();
         return find (d, node.left, performance);
      }
      else {
         if (node.right == null) {
            // No need to increment execution count
            return null;
         } 
         performance.incrementExecutionCount();
         return find (d, node.right, performance);
      }
   }
   
   /** 
    * In-order traversal
   */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }

   /**
    * In-order traversal
    * @param node the root of the tree
    * @param level the level
    */
   public void treeOrder ( BinaryTreeNode node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

