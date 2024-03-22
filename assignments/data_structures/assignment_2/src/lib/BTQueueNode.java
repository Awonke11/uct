package lib;

/**
 * Hussein's BTQueue Node
 * Author: Hussein Suleman
 * Edited: Awonke Mnotoza
 * Date: 26 March 2017
 */
public class BTQueueNode
{
   BinaryTreeNode node;
   BTQueueNode next;
   
   /**
    * Constructor
    * @param n the node to store data
    * @param nxt the next node
    */
   public BTQueueNode ( BinaryTreeNode n, BTQueueNode nxt )
   {
      node = n;
      next = nxt;
   }
}
